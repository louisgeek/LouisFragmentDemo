package com.louisgeek.louisfragmentdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by louisgeek on 2016/5/20.
 */
public class MyBaseAdapter extends BaseAdapter {
    public MyBaseAdapter(List<NewsBean> newsBeanList, Context context) {
        mNewsBeanList = newsBeanList;
        mContext = context;
    }

    private List<NewsBean> mNewsBeanList;
    private Context mContext;
    @Override
    public int getCount() {
        return mNewsBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mNewsBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=LayoutInflater.from(mContext).inflate(R.layout.newslist_item,parent,false);
            viewHolder.textView_title= (TextView) convertView.findViewById(R.id.id_tv_title);
            viewHolder.textView_intro= (TextView) convertView.findViewById(R.id.id_tv_intro);

            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.textView_title.setText(mNewsBeanList.get(position).getNewsTitle());
        viewHolder.textView_intro.setText(mNewsBeanList.get(position).getNewsIntro());

        return convertView;
    }

    class  ViewHolder{
        TextView textView_title;
        TextView textView_intro;
    }
}
