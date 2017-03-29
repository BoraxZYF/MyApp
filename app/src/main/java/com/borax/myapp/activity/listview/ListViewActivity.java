package com.borax.myapp.activity.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.borax.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;
    private String[] strs = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("ListView");
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        createData();
        initView();

    }

    private void initView() {

        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, strs));
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(Menu.NONE, Menu.NONE, 1, "Checked Multiple Choice");
        menu.add(Menu.NONE, Menu.NONE, 2, "Check Box Multiple Choice");
        menu.add(Menu.NONE, Menu.NONE, 3, "Radio Button Single Choice");
        menu.add(Menu.NONE, Menu.NONE, 4, "Count");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getOrder()) {

            case 1: {

                listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, strs));
                listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

                break;
            }

            case 2: {

                listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, strs));
                listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

                break;
            }

            case 3: {

                listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, strs));
                listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

                break;
            }

            case 4: {

                SparseBooleanArray checkedItems = listview.getCheckedItemPositions();

                String ids = "";

                for (int i = 0; i < listview.getAdapter().getCount(); i++) {

                    if (checkedItems.get(i) == true) {
                        ids += i + ",";
                    }

                }

                Toast.makeText(ListViewActivity.this, ids, Toast.LENGTH_SHORT).show();
                break;

            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void createData() {

        for (int i = 0; i < strs.length; i++) {
            strs[i] = "ITEM " + i;
        }

    }

}
