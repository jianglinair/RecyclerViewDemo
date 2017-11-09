package com.lin.jiang.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *
 * @author jianglin
 * @date 17-11-7
 */

public class HeaderBottomItemViewAdapter extends BaseMultipleItemAdapter {

    private String[] titles;

    public HeaderBottomItemViewAdapter(Context context) {
        super(context);
        titles = context.getResources().getStringArray(R.array.titles);
        mHeaderCount = 1;
        mBottomCount = 1;
    }

    @Override
    protected int getContentItemCount() {
        return 4;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderView(ViewGroup parent) {
        return new HeaderViewHolder(mLayoutInflater.inflate(R.layout.item_image, parent, false));
    }

    @Override
    protected RecyclerView.ViewHolder onCreateContentView(ViewGroup parent) {
        return new ContentViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    protected RecyclerView.ViewHolder onCreateBottomView(ViewGroup parent) {
        return new BottomViewHolder(mLayoutInflater.inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).headerTextView.setText(titles[0]);
        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).contentTextView.setText(titles[position - mHeaderCount]);
        } else if (holder instanceof BottomViewHolder) {
            ((BottomViewHolder) holder).bottomTextView.setText("我是有底线的");
            ((BottomViewHolder) holder).bottomImageView.setImageResource(R.drawable.message);
        }
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView contentTextView;

        ContentViewHolder(View view) {
            super(view);
            contentTextView = (TextView) view.findViewById(R.id.text_view);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTextView;

        HeaderViewHolder(View view) {
            super(view);
            headerTextView = (TextView) view.findViewById(R.id.text_view2);
        }
    }

    public static class BottomViewHolder extends RecyclerView.ViewHolder {
        TextView bottomTextView;
        ImageView bottomImageView;

        BottomViewHolder(View view) {
            super(view);
            bottomTextView = (TextView) view.findViewById(R.id.text_view2);
            bottomImageView = (ImageView) view.findViewById(R.id.image_view);
        }
    }
}
