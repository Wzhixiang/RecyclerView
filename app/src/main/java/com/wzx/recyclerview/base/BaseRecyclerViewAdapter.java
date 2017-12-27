package com.wzx.recyclerview.base;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述 TODO
 * Created by 王治湘 on 2017/12/23.
 * version 1.0
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    protected static final int TYPE_HEADER = -100000;
    protected static final int TYPE_FOOTER = -200000;

    private Context mContext;
    private List<T> mDataList;
    private LayoutInflater mLayoutInflater;

    //SparseArrayCompat<View>
    protected SparseArrayCompat<View> mHeaderViews = new SparseArrayCompat<>();
    protected SparseArrayCompat<View> mFooterViews = new SparseArrayCompat<>();

    public BaseRecyclerViewAdapter(Context context) {
        this.mContext = context;
        this.mDataList = new ArrayList<>();
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public BaseRecyclerViewAdapter(Context context, List<T> dataList) {
        this.mContext = context;
        this.mDataList = dataList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void updateItemViews(List<T> datas) {
        if (datas != null) {
            mDataList = new ArrayList<>(datas);
        }
        notifyDataSetChanged();
    }

    public void addMoreItems(List<T> datas) {
        if (datas != null && mDataList != null) {
            mDataList.addAll(datas);
        }
        notifyDataSetChanged();
    }

    public void addSingleItems(T item) {
        if (item != null) {
            if (mDataList == null) {
                mDataList = new ArrayList<>();
            }
            mDataList.add(item);
        }
        notifyDataSetChanged();
    }

    public void removeItems(T item) {
        if (mDataList != null && mDataList.contains(item)) {
            mDataList.remove(item);
        }
        notifyDataSetChanged();
    }

    public void removeAllItems() {
        if (mDataList != null) {
            mDataList.clear();
        }
        notifyDataSetChanged();
    }

    protected int getRealCount() {
        return mDataList.size();
    }

    @Override
    public int getItemCount() {
        return getRealCount() + mHeaderViews.size() + mFooterViews.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderView(position)) {
            return mHeaderViews.keyAt(position);
        } else if (isFooterView(position)) {
            return mFooterViews.keyAt(position - getHeadersCount() - getRealCount());
        }

        return setItemViewType(position - getHeadersCount());
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderViews.get(viewType) != null) {
            return new BaseRecyclerViewHolder(mContext, mHeaderViews.get(viewType));
        } else if (mFooterViews.get(viewType) != null) {
            return new BaseRecyclerViewHolder(mContext, mFooterViews.get(viewType));
        }

        return new BaseRecyclerViewHolder(mContext,
                mLayoutInflater.inflate(getItemLayoutId(viewType), parent, false));

    }

    @Override
    public void onBindViewHolder(final BaseRecyclerViewHolder holder, final int position) {

        if ((isHeaderView(position)) || isFooterView(position)) {
            return;
        }

        final int realPos = position - getHeadersCount();
        if (realPos < mDataList.size()) {
            T data = mDataList.get(realPos);
            onBind(holder, realPos, data);
        }

    }

    public void addHeaderView(View view) {
        mHeaderViews.put(TYPE_HEADER + getHeadersCount(), view);
    }

    public void addFooterView(View view) {
        mFooterViews.put(TYPE_FOOTER + getFootersCount(), view);
    }


    /**
     * 返回第一个FoView
     *
     * @return
     */
    public View getFooterView() {
        return getFootersCount() > 0 ? mFooterViews.get(TYPE_FOOTER) : null;
    }

    /**
     * 返回第一个HeaderView
     *
     * @return
     */
    public View getHeaderView() {
        return getHeadersCount() > 0 ? mHeaderViews.get(TYPE_HEADER) : null;
    }


    public void removeAllHeaderView() {
        mHeaderViews.clear();
    }

    public boolean isHeaderView(int position) {
        return position < getHeadersCount();
    }

    public boolean isFooterView(int position) {
        return position >= getHeadersCount() + getRealCount();
    }

    public int getHeadersCount() {
        return mHeaderViews.size();
    }

    public int getFootersCount() {
        return mFooterViews.size();
    }

    /**
     * 当LayoutManager是GridLayoutManager时，设置header和footer占据的列数
     *
     * @param recyclerView recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) layoutManager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return (isFooterView(position) || isHeaderView(position))
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    /**
     * 当LayoutManager是StaggeredGridLayoutManager时，设置header和footer占据的列数
     *
     * @param holder holder
     */
    @Override
    public void onViewAttachedToWindow(BaseRecyclerViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        final ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            params.setFullSpan(isHeaderView(holder.getLayoutPosition())
                    || isFooterView(holder.getLayoutPosition()));
        }
    }

    /**
     * item layout布局类型
     *
     * @param position
     * @return
     */
    public abstract int setItemViewType(int position);

    /**
     * item 布局id
     *
     * @param viewType item type
     * @return item 布局id
     */
    public abstract int getItemLayoutId(int viewType);

    /**
     * 绑定数据
     *
     * @param viewHolder holder
     * @param position   pos
     * @param data       数据源
     */
    public abstract void onBind(BaseRecyclerViewHolder viewHolder, int position, T data);
}
