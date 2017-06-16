package com.borax.myapp.activity.sainti.scan;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.borax.myapp.R;
import com.borax.myapp.activity.BaseActivity;
import com.borax.myapp.activity.sainti.scan.zxing.camera.CameraManager;
import com.borax.myapp.activity.sainti.scan.zxing.decode.DecodeThread;
import com.borax.myapp.activity.sainti.scan.zxing.utils.BeepManager;
import com.borax.myapp.activity.sainti.scan.zxing.utils.CaptureActivityHandler;
import com.borax.myapp.activity.sainti.scan.zxing.utils.InactivityTimer;
import com.google.zxing.Result;

import java.io.IOException;
import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScanActivity extends BaseActivity implements SurfaceHolder.Callback {

    @BindView(R.id.preview)
    SurfaceView preview;
    @BindView(R.id.scanner)
    ImageView scanner;

    private boolean isHasSurface = false;

    private CameraManager cameraManager;
    private CaptureActivityHandler handler;
    private InactivityTimer inactivityTimer;
    private BeepManager beepManager;

    private Rect mCropRect = null;

    public Handler getHandler() {
        return handler;
    }

    public CameraManager getCameraManager() {
        return cameraManager;
    }

    public Rect getCropRect() {
        return mCropRect;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_scan);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();

        cameraManager = new CameraManager(getApplication());

        handler = null;

        if (isHasSurface) {
            initCamera(preview.getHolder());
        } else {
            preview.getHolder().addCallback(this);
        }

        inactivityTimer.onResume();

    }

    @Override
    protected void onPause() {
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        inactivityTimer.onPause();
        beepManager.close();
        cameraManager.closeDriver();
        if (!isHasSurface) {
            preview.getHolder().removeCallback(this);
        }
        super.onPause();
    }

    private void initView() {

        inactivityTimer = new InactivityTimer(this);
        beepManager = new BeepManager(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (holder == null) {
        }
        if (!isHasSurface) {
            isHasSurface = true;
            initCamera(holder);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (cameraManager.isOpen()) {
            return;
        }
        try {
            cameraManager.openDriver(surfaceHolder);
            // Creating the handler starts the preview, which can also throw a
            // RuntimeException.
            if (handler == null) {
                handler = new CaptureActivityHandler(ScanActivity.this, cameraManager,
                        DecodeThread.ALL_MODE);
            }

            initCrop();
        } catch (IOException ioe) {
            displayFrameworkBugMessageAndExit();
        } catch (RuntimeException e) {
            // Barcode Scanner has seen crashes in the wild of this variety:
            // java.?lang.?RuntimeException: Fail to connect to camera service
            displayFrameworkBugMessageAndExit();
        }
    }

    public void handleDecode(Result rawResult, Bundle bundle) {
        System.out.println("222===");
        inactivityTimer.onActivity();
        beepManager.playBeepSoundAndVibrate();

        bundle.putInt("width", mCropRect.width());
        bundle.putInt("height", mCropRect.height());
        bundle.putString("result", rawResult.getText());

        showToast(rawResult.getText());
        onBackPressed();

        // Toast.makeText(mContext, rawResult.getText(), Toast.LENGTH_SHORT)
        // .show();

    }

    /**
     * 初始化截取的矩形区域
     */
    private void initCrop() {
        int cameraWidth = cameraManager.getCameraResolution().y;
        int cameraHeight = cameraManager.getCameraResolution().x;

        /** 获取布局中扫描框的位置信息 */
        int[] location = new int[2];
        preview.getLocationInWindow(location);

        int cropLeft = location[0];
        int cropTop = location[1] - getStatusBarHeight();

        int cropWidth = preview.getWidth();
        int cropHeight = preview.getHeight();

        /** 获取布局容器的宽高 */
        int containerWidth = preview.getWidth();
        int containerHeight = preview.getHeight();

        /** 计算最终截取的矩形的左上角顶点x坐标 */
        int x = cropLeft * cameraWidth / containerWidth;
        /** 计算最终截取的矩形的左上角顶点y坐标 */
        int y = cropTop * cameraHeight / containerHeight;

        /** 计算最终截取的矩形的宽度 */
        int width = cropWidth * cameraWidth / containerWidth;
        /** 计算最终截取的矩形的高度 */
        int height = cropHeight * cameraHeight / containerHeight;

        /** 生成最终的截取的矩形 */
        mCropRect = new Rect(x, y, width + x, height + y);
    }

    private int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void displayFrameworkBugMessageAndExit() {
        // showDilogtwo("订单验证", "相机打开出错，请稍后重试", "取消", "重试");
        showToast("相机打开出错，请稍后重试");
        finish();
    }
}
