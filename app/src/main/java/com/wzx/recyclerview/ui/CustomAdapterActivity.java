package com.wzx.recyclerview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wzx.recyclerview.R;
import com.wzx.recyclerview.ui.adapter.StringCustomAdapter;

/**
 * 描述 TODO 自定义adapter实现添加多种item
 * Created by 王治湘 on 2017/12/23.
 * version 1.0
 */

public class CustomAdapterActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StringCustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_by_viewholder);

        mAdapter = new StringCustomAdapter(this);
        View headerView = LayoutInflater.from(this).inflate(R.layout.item_header, null);
        headerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mAdapter.addHeaderView(headerView);
        View headerView2 = LayoutInflater.from(this).inflate(R.layout.item_header_with_img, null);
        headerView2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mAdapter.addHeaderView(headerView2);
        View footerView = LayoutInflater.from(this).inflate(R.layout.item_footer, null);
        footerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mAdapter.addFooterView(footerView);
        View footerView2 = LayoutInflater.from(this).inflate(R.layout.item_footer_with_img, null);
        footerView2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mAdapter.addFooterView(footerView2);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }

    public void addItem(View view) {
        mAdapter.addSingleItems("aaa");
    }

    public void removeItem(View view) {
        mAdapter.removeAllItems();
    }
}
