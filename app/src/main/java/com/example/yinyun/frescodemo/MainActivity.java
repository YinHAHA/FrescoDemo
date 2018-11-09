package com.example.yinyun.frescodemo;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mGetCache;
    private Button mClearCache;
    private TextView mShowCache;
    private ListView mListView;
    private MyAdapter mAdapter;
    private List<String> datas = new ArrayList<>();

    private SimpleDraweeView simpleDraweeView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

        mAdapter = new MyAdapter(this, datas);
        mListView.setAdapter(mAdapter);


        String urlString1 = "http://img5.taoche.cn/33/76311fcc-021815e0u5.jpg";
        ImageLoaderUtils.getInstance().setImage(simpleDraweeView1, urlString1, new BaseControllerListener() {

            @Override
            public void onFinalImageSet(String id, @Nullable Object imageInfo, @Nullable Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                Log.i("=======成功=====", "============");
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
                Log.i("=======失败=====", "============");
            }
        });

    }


    private void initView() {
        mListView = findViewById(R.id.list_view);
        mGetCache = findViewById(R.id.get_cache_size);
        mClearCache = findViewById(R.id.clear_cache_size);
        mShowCache = findViewById(R.id.show_cache_size);
        simpleDraweeView1 = findViewById(R.id.simpleDraweeView1);

        mGetCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShowCache.setText(ImageLoaderUtils.getInstance().getDiskCache() + "");
            }
        });

        mClearCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoaderUtils.getInstance().clearDiskCache();
                mShowCache.setText(ImageLoaderUtils.getInstance().getDiskCache() + "");
            }
        });
    }

    private void initData() {
        datas.add("http://img5.taoche.cn/33/02180b8bhq.jpg");
        datas.add("http://img5.taoche.cn/33/76311fcc-021815e0u5.jpg");
        datas.add("http://img5.taoche.cn/33/f107eb63-02181814ns.jpg");
        datas.add("http://img5.taoche.cn/33/32d4153e-0218181c4f.jpg");
        datas.add("http://img5.taoche.cn/33/7c9019a8-0218180nqi.jpg");
        datas.add("http://img5.taoche.cn/33/13bbb5d6-02181808yj.jpg");
        datas.add("http://img5.taoche.cn/33/29a7adfa-021818093y.jpg");
        datas.add("http://img5.taoche.cn/33/9ef66b93-02181818ig.jpg");
        datas.add("http://img5.taoche.cn/33/654a9af7-021818mtyr.jpg");
        datas.add("http://img5.taoche.cn/33/5510176a-021818mslq.jpg");
        datas.add("http://img5.taoche.cn/33/cb0ab3ad-021818msfl.jpg");
        datas.add("http://img5.taoche.cn/1b/6f9aeb40-0218185ncv.jpg");
        datas.add("http://img5.taoche.cn/33/88ac622d-021818msak.jpg");
        datas.add("http://img5.taoche.cn/33/b80419d7-021818mswv.jpg");
        datas.add("http://img5.taoche.cn/33/177f6482-021817apok.jpg");
        datas.add("http://img5.taoche.cn/33/2c3bb265-0218120pp0.jpg");
        datas.add("http://img5.taoche.cn/33/0cb8dc23-02181213tf.jpg");
        datas.add("http://img5.taoche.cn/33/c1dd1c9f-021811zkvz.jpg");
        datas.add("http://img5.taoche.cn/33/6e30a973-021817nqo1.jpg");
        datas.add("http://img5.taoche.cn/1b/9f616702-021817zu28.jpg");
        datas.add("http://img5.taoche.cn/33/4196def7-021816pzq5.jpg");
        datas.add("http://img5.taoche.cn/33/3c439c3b-021816wygy.jpg");
        datas.add("http://img5.taoche.cn/33/12ce8439-021816ojn1.jpg");
        datas.add("http://img5.taoche.cn/33/ceaafcfb-0218182n1w.jpg");
        datas.add("http://img5.taoche.cn/33/02180b8bhq.jpg");
        datas.add("http://img5.taoche.cn/33/76311fcc-021815e0u5.jpg");
        datas.add("http://img5.taoche.cn/33/f107eb63-02181814ns.jpg");
        datas.add("http://img5.taoche.cn/33/32d4153e-0218181c4f.jpg");
        datas.add("http://img5.taoche.cn/33/7c9019a8-0218180nqi.jpg");
        datas.add("http://img5.taoche.cn/33/13bbb5d6-02181808yj.jpg");
        datas.add("http://img5.taoche.cn/33/29a7adfa-021818093y.jpg");
        datas.add("http://img5.taoche.cn/33/9ef66b93-02181818ig.jpg");
        datas.add("http://img5.taoche.cn/33/654a9af7-021818mtyr.jpg");
        datas.add("http://img5.taoche.cn/33/5510176a-021818mslq.jpg");
        datas.add("http://img5.taoche.cn/33/cb0ab3ad-021818msfl.jpg");
        datas.add("http://img5.taoche.cn/1b/6f9aeb40-0218185ncv.jpg");
        datas.add("http://img5.taoche.cn/33/88ac622d-021818msak.jpg");
        datas.add("http://img5.taoche.cn/33/b80419d7-021818mswv.jpg");
        datas.add("http://img5.taoche.cn/33/177f6482-021817apok.jpg");
        datas.add("http://img5.taoche.cn/33/2c3bb265-0218120pp0.jpg");
        datas.add("http://img5.taoche.cn/33/0cb8dc23-02181213tf.jpg");
        datas.add("http://img5.taoche.cn/33/c1dd1c9f-021811zkvz.jpg");
        datas.add("http://img5.taoche.cn/33/6e30a973-021817nqo1.jpg");
        datas.add("http://img5.taoche.cn/1b/9f616702-021817zu28.jpg");
        datas.add("http://img5.taoche.cn/33/4196def7-021816pzq5.jpg");
        datas.add("http://img5.taoche.cn/33/3c439c3b-021816wygy.jpg");
        datas.add("http://img5.taoche.cn/33/12ce8439-021816ojn1.jpg");
        datas.add("http://img5.taoche.cn/33/ceaafcfb-0218182n1w.jpg");
    }

    public class MyAdapter extends BaseAdapter {

        private List<String> mList;
        private Context mContext;

        public MyAdapter(Context context, List<String> list) {
            mContext = context;
            mList = list;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public String getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_view_item, null);
                holder = new ViewHolder();
                holder.simpleDraweeView = convertView.findViewById(R.id.simpleDraweeView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            String url = mList.get(position);

            ImageLoaderUtils.getInstance().setImage(holder.simpleDraweeView, url);

            return convertView;
        }

        class ViewHolder {
            SimpleDraweeView simpleDraweeView;
        }
    }
}
