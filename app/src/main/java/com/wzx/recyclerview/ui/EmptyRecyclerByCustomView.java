package com.wzx.recyclerview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.wzx.recyclerview.R;
import com.wzx.recyclerview.widget.SupportEmptyRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述 TODO
 * Created by 王治湘 on 2017/12/23.
 * version 1.0
 */

public class EmptyRecyclerByCustomView extends AppCompatActivity {

    private SupportEmptyRecyclerView recyclerView;
    private StringAdapter mAdapter;
    private List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_by_custom_view);

        mAdapter = new StringAdapter(stringList);

        recyclerView = (SupportEmptyRecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        View emptyView = findViewById(R.id.empty_view);

        recyclerView.setAdapter(mAdapter);
        recyclerView.setEmptyView(emptyView);

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
