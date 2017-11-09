package com.lin.jiang.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 *
 * @author jianglin
 * @date 17-11-7
 */

public abstract class BaseMultipleItemAdapter extends RecyclerView.Adapter {

    private Context mContext;
    protected int mHeaderCount;
    protected int mBottomCount;
    protected LayoutInflater mLayoutInflater;

    public BaseMultipleItemAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void setHeaderCount(int count) {
        this.mHeaderCount = count;
    }

    public void setBottomCount(int count) {
        this.mBottomCount = count;
    }

    public boolean isHeaderView(int position) {
        return mHeaderCount != 0 && position < mHeaderCount;
    }

    public boolean isBottomView(int position) {
        return mBottomCount != 0 && position >= (mHeaderCount + getContentItemCount());
    }

    /**
     * 返回内容 item 个数
     *
     * @return
     */
    protected abstract int getContentItemCount();

    /**
     * 创建头部 ViewHolder
     *
     * @param parent
     * @return
     */
    protected abstract RecyclerView.ViewHolder onCreateHeaderView(ViewGroup parent);

    /**
     * 创建 item ViewHolder
     *
     * @param parent
     * @return
     */
    protected abstract RecyclerView.ViewHolder onCreateContentView(ViewGroup parent);

    /**
     * 创建底部 ViewHolder
     *
     * @param parent
     * @return
     */
    protected abstract RecyclerView.ViewHolder onCreateBottomView(ViewGroup parent);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ItemType.ITEM_TYPE_CONTENT) {
            return onCreateContentView(parent);
        } else if (viewType == ItemType.ITEM_TYPE_HEADER) {
            return onCreateHeaderView(parent);
        } else if (viewType == ItemType.ITEM_TYPE_BOTTOM) {
            return onCreateBottomView(parent);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return mHeaderCount + mBottomCount + getContentItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderCount != 0 && position < mHeaderCount) {
            return ItemType.ITEM_TYPE_HEADER;
        } else if (mBottomCount != 0 && position >= (mHeaderCount + getContentItemCount())) {
            return ItemType.ITEM_TYPE_BOTTOM;
        } else {
            return ItemType.ITEM_TYPE_CONTENT;
        }
    }

    private static class ItemType {
        private static final int ITEM_TYPE_HEADER = 1;
        private static final int ITEM_TYPE_CONTENT = 2;
        private static final int ITEM_TYPE_BOTTOM = 3;
    }
}
