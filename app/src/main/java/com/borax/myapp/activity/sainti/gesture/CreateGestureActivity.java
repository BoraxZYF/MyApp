package com.borax.myapp.activity.sainti.gesture;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.borax.myapp.R;
import com.borax.myapp.activity.sainti.gesture.widget.LockPatternViewEx;

public class CreateGestureActivity extends Activity {

    private LockPatternViewEx lockview;
    private TextView text;

    private String currentPwd;
    private String newPwd;

    private ImageView back;

    private int type;//1:无密码，新建密码。2：有密码，判定后新建密码  3:请再次输入

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creategesture_activity);

        currentPwd = loadData(this);

        initView();

    }

    private void initView() {

        text = (TextView) findViewById(R.id.text);
        lockview = (LockPatternViewEx) findViewById(R.id.lockview);


        if (TextUtils.isEmpty(currentPwd)) {
            text.setText("请输入手势密码");
            type = 1;
        } else {
            text.setText("请输入原密码");
            type = 2;
        }

        lockview.setOnPatternListener(new LockPatternViewEx.OnPatternListener() {

            @Override
            public void onPatternStart() {

            }

            @Override
            public void onPatternDetected(List<LockPatternViewEx.Cell> pattern) {

                String str = "";
                for (LockPatternViewEx.Cell cell : pattern) {
                    str = str + cell.getRow() + "" + cell.getColumn();
                }

                //无密码 新建密码
                if (type == 1) {
                    text.setText("请再次输入手势密码");
                    type = 3;
                    currentPwd = str;
                    dismissLock();
                    return;
                }

                //再次输入
                if (type == 3) {
                    if (str.equals(currentPwd)) {
                        saveData(CreateGestureActivity.this, currentPwd);
                        Toast.makeText(CreateGestureActivity.this, "手势密码创建成功", Toast.LENGTH_SHORT).show();
                        text.setText("手势密码创建成功");
                        type = 2;
                        finish();
                    } else {
                        lockview.clearPattern();
                        text.setText("密码不正确，请重新输入");
                        type = 1;
                        dismissLock();
                    }
                    return;
                }

                if (type == 2) {
                    if (str.equals(currentPwd)) {
                        type = 1;
                        text.setText("密码正确，请输入新手势密码");
                        dismissLock();
                    } else {
                        text.setText("原密码错误，请重新输入");
                        dismissLock();
                    }
                    return;
                }


            }

            @Override
            public void onPatternCleared() {

                System.out.println("onPatternCleared");

            }

            @Override
            public void onPatternCellAdded(List<LockPatternViewEx.Cell> pattern) {

                System.out.println("onPatternCellAdded");

            }
        });
    }

    private void saveData(Context context, String string) {
        SharedPreferences sp = context.getSharedPreferences("gesture", MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString("pwd", string);
        editor.commit();
    }

    private String loadData(Context context) {
        SharedPreferences sp = context.getSharedPreferences("gesture", MODE_PRIVATE);
        String str = sp.getString("pwd", "").toString();

        return str;
    }

    private void dismissLock() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(800);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lockview.clearPattern();
                        }
                    });
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
