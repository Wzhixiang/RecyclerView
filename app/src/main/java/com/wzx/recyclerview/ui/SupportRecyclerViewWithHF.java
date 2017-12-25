package com.wzx.recyclerview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wzx.recyclerview.R;
import com.wzx.recyclerview.ui.adapter.StringAdapter;
import com.wzx.recyclerview.ui.adapter.StringCustomAdapter;
import com.wzx.recyclerview.utils.RecyclerView.RecyclerViewHelper;
import com.wzx.recyclerview.widget.SupportEmptyRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述 TODO
 * Created by 王治湘 on 2017/12/23.
 * version 1.0
 */

public class SupportRecyclerViewWithHF extends AppCompatActivity {

    private SupportEmptyRecyclerView recyclerView;
    private StringCustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_by_custom_view);

        mAdapter = new StringCustomAdapter(this);

        recyclerView = (SupportEmptyRecyclerView) findViewById(R.id.recyclerview);

        View emptyView = findViewById(R.id.empty_view);
        recyclerView.setEmptyView(emptyView);

        RecyclerViewHelper.initRecyclerViewV(this, recyclerView, false, mAdapter);

    }

    public void addItem(View view){
        mAdapter.addSingleItems("12321");
    }

    public void removeItem(View view){
        mAdapter.removeAllItems();
    }
}
