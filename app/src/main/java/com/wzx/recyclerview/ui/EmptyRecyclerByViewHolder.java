package com.wzx.recyclerview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wzx.recyclerview.R;
import com.wzx.recyclerview.ui.adapter.SupportEmptyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述 TODO 定义
 * Created by 王治湘 on 2017/12/23.
 * version 1.0
 */

public class EmptyRecyclerByViewHolder extends AppCompatActivity{

    private RecyclerView recyclerView;
    private SupportEmptyAdapter mAdapter;
    private List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_by_viewholder);

        mAdapter = new SupportEmptyAdapter(stringList);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }

    public void addItem(View view){
        stringList.add("11");
        mAdapter.notifyDataSetChanged();
    }

    public void removeItem(View view){
        stringList.clear();
        mAdapter.notifyDataSetChanged();
    }
}
