package com.daivp.xlistview.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.daivp.xlistview.R;
import com.daivp.xlistview.XListview.XListView;
import com.daivp.xlistview.adapter.TagManagementAdapter;

import java.util.ArrayList;

public class TagManagementActivity extends BaseActivity {

    XListView mLvTag;
    ArrayList<String> mTagList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setupView() {
        super.setupView();
        setContentView(R.layout.activity_tag_management);
        mLvTag = (XListView) findViewById(R.id.activity_tag_listview);
        setupAdapter();
    }

    /**
     * setup adapter for listview tag
     */
    private void setupAdapter(){
        dummyData();
        TagManagementAdapter adapter = new TagManagementAdapter(this, R.layout.row_tag_listview, mTagList);
        mLvTag.setAdapter(adapter);
        mLvTag.setPullRefreshEnable(true);
    }

    /**
     * dummy data
     */
    private void dummyData(){
        mTagList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mTagList.add(""+i);
        }
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    mLvTag.stopRefresh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onLoadMore() {
        super.onLoadMore();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tag_management, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
