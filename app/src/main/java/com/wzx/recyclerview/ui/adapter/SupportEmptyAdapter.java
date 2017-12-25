package com.wzx.recyclerview.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wzx.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述 TODO
 * Created by 王治湘 on 2017/12/23.
 * version 1.0
 */

public class SupportEmptyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int EMPTY_VIEW = 1;
    private static final int NORMAL_VIEW = 0;

    private List<String> mList;

    public SupportEmptyAdapter() {
        mList = new ArrayList<>();
    }

    public SupportEmptyAdapter(List<String> mList) {
        this.mList = mList;
    }

    @Override
    public int getItemViewType(int position) {
        return mList.size() == 0 ? EMPTY_VIEW : NORMAL_VIEW;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == NORMAL_VIEW) {
            return new StringViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string, parent, false));
        }

        return new EmptyViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StringViewHolder) {
            ((StringViewHolder) holder).mContent.setText(mList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size() == 0 ? 1 : mList.size();
    }

    static class StringViewHolder extends RecyclerView.ViewHolder {
        private TextView mContent;

        public StringViewHolder(View itemView) {
            super(itemView);
            mContent = (TextView) itemView.findViewById(R.id.tv_content);
        }

    }

    static class EmptyViewHolder extends RecyclerView.ViewHolder {
        private TextView mContent;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            mContent = (TextView) itemView.findViewById(R.id.tv_content);
        }

    }
}
