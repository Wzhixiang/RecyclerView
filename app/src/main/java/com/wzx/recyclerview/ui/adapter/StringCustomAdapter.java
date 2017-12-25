package com.wzx.recyclerview.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wzx.recyclerview.R;
import com.wzx.recyclerview.base.BaseRecyclerViewAdapter;
import com.wzx.recyclerview.base.BaseRecyclerViewHolder;

import java.util.List;

/**
 * 描述 TODO
 * Created by 王治湘 on 2017/12/23.
 * version 1.0
 */

public class StringCustomAdapter extends BaseRecyclerViewAdapter<String> {

    private static final int TYPE_NORMAL = 0x1;
    private static final int TYPE_OTHER = 0x2;

    public StringCustomAdapter(Context context) {
        super(context);
    }

    public StringCustomAdapter(Context context, List<String> dataList) {
        super(context, dataList);
    }

    @Override
    public int setItemViewType(int position) {
        if (position == 0) {
            return TYPE_OTHER;
        } else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public void onBind(BaseRecyclerViewHolder viewHolder, int position, String data) {
        
        viewHolder.setText(R.id.tv_content, data);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        if (viewType == TYPE_NORMAL) {
            return R.layout.item_string;
        } else {
            return R.layout.item_other_string;
        }
    }
}
