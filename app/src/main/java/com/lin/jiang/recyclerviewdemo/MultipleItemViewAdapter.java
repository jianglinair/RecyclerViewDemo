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

public class MultipleItemViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private String[] titles;

    public MultipleItemViewAdapter(Context context) {
        this.mContext = context;
        titles = mContext.getResources().getStringArray(R.array.titles);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if(viewType == ItemType.ITEM_TYPE_IMAGE) {
            View view = inflater.inflate(R.layout.item_image, parent, false);
            viewHolder = new ImageViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_text, parent, false);
            viewHolder = new TextViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).textView.setText(titles[position]);
        } else {
            ((ImageViewHolder) holder).textView2.setText(titles[position]);
        }
    }

    @Override
    public int getItemCount() {
        return titles == null ? 0 : titles.length;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ItemType.ITEM_TYPE_IMAGE : ItemType.ITEM_TYPE_TEXT;
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView2;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
            textView2 = (TextView) itemView.findViewById(R.id.text_view2);
        }
    }

    private static class ItemType {
        private static final int ITEM_TYPE_TEXT = 1;
        private static final int ITEM_TYPE_IMAGE = 2;
    }
}
