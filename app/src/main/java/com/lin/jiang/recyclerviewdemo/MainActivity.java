package com.lin.jiang.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @author jianglin
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
//        SimpleItemViewAdapter adapter = new SimpleItemViewAdapter(this);
//        adapter.setOnItemClickListener(new SimpleItemViewAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, String text) {
//                Toast.makeText(MainActivity.this, text + "@" + view, Toast.LENGTH_SHORT).show();
//            }
//        });
//        MultipleItemViewAdapter adapter = new MultipleItemViewAdapter(this);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        final HeaderBottomItemViewAdapter adapter = new HeaderBottomItemViewAdapter(this);
        mRecyclerView.setAdapter(adapter);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (adapter.isHeaderView(position) || adapter.isBottomView(position)) ? layoutManager.getSpanCount() : 1;
            }
        });

    }
}
