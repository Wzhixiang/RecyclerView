package com.wzx.recyclerview.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * 描述 TODO 当没有数据时显示空布局
 * RecyclerView有数据观察者AdapterDataObserver用于监听数据变化，可以通过重写AdapterDataObserver实现数据个数为0时显示所有“空布局”
 * Created by 王治湘 on 2017/12/23.
 * version 1.0
 */

public class SupportEmptyRecyclerView extends RecyclerView {

    private View mEmptyView;

    private static final String Tag = "EmpatyRecyclerView";

    final private AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            //检车是否为空
            checkIfEmpty();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            checkIfEmpty();
        }
    };

    public SupportEmptyRecyclerView(Context context) {
        super(context);

    }

    public SupportEmptyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public SupportEmptyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    /**
     * 检验是否没有数据
     */
    private void checkIfEmpty() {
        if (mEmptyView != null && getAdapter() != null) {
            boolean emptyViewVisible = getAdapter().getItemCount() == 0;
            mEmptyView.setVisibility(emptyViewVisible ? VISIBLE : GONE);
            setVisibility(emptyViewVisible ? GONE : VISIBLE);
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        Adapter mAdapter = getAdapter();
        if (mAdapter != null) {
            mAdapter.unregisterAdapterDataObserver(observer);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(observer);
        }

        checkIfEmpty();
    }

    /**
     * setting empty view
     *
     * @param emptyView
     */
    public void setEmptyView(View emptyView) {
        this.mEmptyView = emptyView;
        checkIfEmpty();
    }
}
