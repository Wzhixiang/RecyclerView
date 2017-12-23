package com.wzx.recyclerview.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wzx.recyclerview.R;

import java.util.List;

/**
 * 描述 TODO
 * Created by 王治湘 on 2017/12/23.
 * version 1.0
 */

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.StringViewHolder> {

    private List<String> mList;

    public StringAdapter() {

    }

    public StringAdapter(List<String> mList) {
        this.mList = mList;
    }

    @Override
    public StringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StringViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string, parent, false));
    }

    @Override
    public void onBindViewHolder(StringViewHolder holder, int position) {
        if (holder instanceof StringViewHolder) {
            ((StringViewHolder) holder).mContent.setText(mList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    static class StringViewHolder extends RecyclerView.ViewHolder {
        private TextView mContent;

        public StringViewHolder(View itemView) {
            super(itemView);
            mContent = (TextView) itemView.findViewById(R.id.tv_content);
        }

    }
}
