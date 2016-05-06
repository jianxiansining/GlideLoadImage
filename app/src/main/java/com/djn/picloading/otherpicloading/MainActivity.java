package com.djn.picloading.otherpicloading;

import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView tableView;
    private List<PicBean> picList;
    private GridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initImage();
        initData();

    }


    private void initView() {
        tableView = (GridView) findViewById(R.id.pic_viewpager);

    }
    private void initImage() {
        picList=new ArrayList<PicBean>();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;//uri
        String[] projection = { MediaStore.Images.Media.TITLE,
                MediaStore.Images.Media.DATA };
        Cursor c =getContentResolver().query(uri, projection, null, null, null);
        while (c.moveToNext()) {
            String title = c.getString(c.getColumnIndex(MediaStore.Images.Media.TITLE));
            String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
            PicBean picBean = new PicBean();
            picBean.path=path;
            picBean.title=title;
            picList.add(picBean);
        }
    }
    private void initData() {
        adapter=new GridAdapter(this,picList);
        tableView.setAdapter(adapter);
    }
}
