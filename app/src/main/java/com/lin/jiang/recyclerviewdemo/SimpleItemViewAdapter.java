package com.lin.jiang.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 *
 * @author jianglin
 * @date 17-11-7
 */

public class SimpleItemViewAdapter extends RecyclerView.Adapter<SimpleItemViewAdapter.SimpleViewHolder> {

    private static final String TAG = "SimpleItemViewAdapter";

    private Context mContext;
    private String[] titles;

    private OnItemClickListener mOnItemClickListener;

    public SimpleItemViewAdapter(Context context) {
        this.mContext = context;
        titles = mContext.getResources().getStringArray(R.array.titles);
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_text, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder holder, final int position) {
        holder.mTextView.setText(titles[position]);
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v, titles[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles == null ? 0 : titles.length;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, String text);
    }
}
