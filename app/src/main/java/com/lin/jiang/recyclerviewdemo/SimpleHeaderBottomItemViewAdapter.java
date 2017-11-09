package com.lin.jiang.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *
 * @author jianglin
 * @date 17-11-7
 */

public class SimpleHeaderBottomItemViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private String[] titles;

    public SimpleHeaderBottomItemViewAdapter(Context context) {
        this.mContext = context;
        titles = mContext.getResources().getStringArray(R.array.titles);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if(viewType == ItemType.ITEM_TYPE_HEADER) {
            View view = inflater.inflate(R.layout.item_image, parent, false);
            viewHolder = new HeaderViewHolder(view);
        } else if(viewType == ItemType.ITEM_TYPE_TEXT) {
            View view = inflater.inflate(R.layout.item_text, parent, false);
            viewHolder = new TextViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_text, parent, false);
            viewHolder = new BottomViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).textView.setText(titles[position]);
        } else if(holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).textView2.setText(titles[position]);
        } else {
            ((BottomViewHolder) holder).textView.setText("==== 我是有底线的 ====");
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return ItemType.ITEM_TYPE_HEADER;
        } else if(position == getItemCount() - 1) {
            return ItemType.ITEM_TYPE_BOTTOM;
        } else {
            return ItemType.ITEM_TYPE_TEXT;
        }
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView2;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
            textView2 = (TextView) itemView.findViewById(R.id.text_view2);
        }
    }

    public static class BottomViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public BottomViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }

    private static class ItemType {
        private static final int ITEM_TYPE_TEXT = 1;
        private static final int ITEM_TYPE_HEADER = 2;
        private static final int ITEM_TYPE_BOTTOM = 3;
    }
}
