package com.borax.myapp.activity.versionupdate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.borax.myapp.R;

public class VersionUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_update);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Update App Version");
        builder.setMessage("有新版本更新：更新内容123123123123123");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("url", "http://yueban.cn/app_api_v2/yueban.apk");
                intent.setClass(VersionUpdateActivity.this, UpdateService.class);
                startService(intent);
                Toast.makeText(VersionUpdateActivity.this, "123", Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();

    }
}
