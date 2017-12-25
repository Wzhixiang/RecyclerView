package com.wzx.recyclerview.utils.RecyclerView;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

public class RecyclerViewHelper {

    /**
     * 垂直性Recyclerview
     * @param context
     * @param view
     * @param isDivided 是否显示分割线
     * @param adapter
     * @return
     */
    public static LinearLayoutManager initRecyclerViewV(Context context, RecyclerView view, boolean isDivided,
                                                                     RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (isDivided) {
            view.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        }
        view.setAdapter(adapter);

        return layoutManager;
    }

    /**
     *
     * @param context
     * @param view
     * @param itemDecoration 自定义item留白大小
     * @param adapter
     */
    public static void initRecyclerViewV(Context context, RecyclerView view, RecyclerView.ItemDecoration itemDecoration,
                                                RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (itemDecoration != null) {
            view.addItemDecoration(itemDecoration);
        }
        view.setAdapter(adapter);
    }

    /**
     *
     * @param context
     * @param view
     * @param itemDecoration 自定义item留白大小
     * @param adapter
     */
    public static void initRecyclerViewH(Context context, RecyclerView view, RecyclerView.ItemDecoration itemDecoration,
                                                RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (itemDecoration != null) {
            view.addItemDecoration(itemDecoration);
        }
        view.setAdapter(adapter);
    }

    /**
     *
     * @param context
     * @param view
     * @param isDivided 是否显示分割线
     * @param adapter
     */
    public static void initRecyclerViewH(Context context, RecyclerView view, boolean isDivided,
                                         RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (isDivided) {
            view.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL));
        }

        view.setAdapter(adapter);
    }


    /**
     * 竖向分类标题跨行
     *
     * @param view
     */
    public static void initSpanRecyclerViewGH(Context context, RecyclerView view, RecyclerView.ItemDecoration itemDecoration,
                                              RecyclerView.Adapter adapter, final int column, final int spanNum) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, column, LinearLayoutManager.HORIZONTAL, false);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (itemDecoration != null) {
            view.addItemDecoration(itemDecoration);
        }
        view.setAdapter(adapter);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position % (spanNum + 1 + (column - spanNum)) == 0 ? spanNum : 1;
            }
        });
    }

    /**
     * 横向分类标题跨行
     *
     * @param view
     */
    public static void initSpanRecyclerViewGV(Context context, RecyclerView view, RecyclerView.ItemDecoration itemDecoration,
                                              RecyclerView.Adapter adapter, final int column, final int spanNum) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, column, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (itemDecoration != null) {
            view.addItemDecoration(itemDecoration);
        }
        view.setAdapter(adapter);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position % (spanNum + 1 + (column - spanNum)) == 0 ? spanNum : 1;
            }
        });
    }

    /**
     * 动态分类标题跨行
     *
     * @param view
     */
    public static void initDynamicSpanRecyclerViewGV(Context context, RecyclerView view, RecyclerView.ItemDecoration itemDecoration,
                                                     RecyclerView.Adapter adapter, final int column, final int spanNum, final List<Integer> spanPoss) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, column, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (itemDecoration != null) {
            view.addItemDecoration(itemDecoration);
        }
        view.setAdapter(adapter);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                for (int i = 0; i < spanPoss.size(); i++) {
                    if (position == spanPoss.get(i)) {
                        return spanNum;
                    }
                }
                return 0;
            }
        });
    }


    /**
     * 配置网格列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewG(Context context, RecyclerView view, RecyclerView.ItemDecoration itemDecoration,
                                         RecyclerView.Adapter adapter, int column) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, column, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (itemDecoration != null) {
            view.addItemDecoration(itemDecoration);
        }
        view.setAdapter(adapter);
    }

    /**
     * 配置网格列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewG(Context context, RecyclerView view, boolean isDivided,
                                         RecyclerView.Adapter adapter, int column) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, column, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (isDivided) {
            view.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        }
        view.setAdapter(adapter);
    }

    /**
     * 网格RecyclerView，第一个item独占一行
     *
     * @param view
     */
    public static void initRecyclerViewGOC(Context context, RecyclerView view, boolean isDivided,
                                           RecyclerView.Adapter adapter, final int column) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, column, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 1) {
                    return 4;//只占一行中的一列，
                } else {
                    return 1;//独占一行
                }
            }
        });
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (isDivided) {
            view.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        }
        view.setAdapter(adapter);
    }

    /**
     * 配置瀑布流列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewSV(Context context, RecyclerView view, boolean isDivided,
                                          RecyclerView.Adapter adapter, int column) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(column,
                StaggeredGridLayoutManager.VERTICAL);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (isDivided) {
            view.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        }
        view.setAdapter(adapter);
    }

    /**
     *
     * @param view
     * @param itemDecoration
     * @param adapter
     * @param column
     */
    public static void initRecyclerViewSV(RecyclerView view, RecyclerView.ItemDecoration itemDecoration,
                                          RecyclerView.Adapter adapter, int column) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(column,
                StaggeredGridLayoutManager.VERTICAL);
        //不处理间隙（item乱跳问题）
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        view.setLayoutManager(layoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        if (itemDecoration != null) {
            view.addItemDecoration(itemDecoration);
        }
        view.setAdapter(adapter);
    }
}
