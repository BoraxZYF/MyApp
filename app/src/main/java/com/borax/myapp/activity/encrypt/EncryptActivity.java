package com.borax.myapp.activity.encrypt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.borax.myapp.R;
import com.borax.myapp.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EncryptActivity extends BaseActivity {

    @BindView(R.id.listview)
    ListView listview;

    private String[] list = {"Aes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        initView();

    }

    private void initView() {
        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0: {
                        Intent intent = new Intent(EncryptActivity.this, AesActivity.class);
                        startActivity(intent);
                        break;
                    }
                }


            }
        });

    }

}
