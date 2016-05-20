package com.louisgeek.louisfragmentdemo;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by louisgeek on 2016/5/20.
 */
public class NewsListFragment extends Fragment {

    private  List<NewsBean> mNewsBeanList;
    private static final String PARAM_newsBeanList = "newsBeanList";
    private Context mContext;
    FragmentManager fragmentManagerFromAty;

    GoNextListener mGoNextListener;

    public static NewsListFragment newInstance(List<NewsBean> newsBeanList){
        NewsListFragment fragment=new NewsListFragment();
       Bundle args = new Bundle();
        args.putSerializable(PARAM_newsBeanList, (Serializable) newsBeanList);
       fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
        if(context instanceof GoNextListener)
        {
            mGoNextListener = (GoNextListener)context;
        }
        else{
            throw new IllegalArgumentException("Activity must implements GoNextListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam_title = getArguments().getString(PARAM_newsBeanList);
            mNewsBeanList = (List<NewsBean>) getArguments().getSerializable(PARAM_newsBeanList);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=LayoutInflater.from(mContext).inflate(R.layout.fragment_content_newslist,container,false);

        ListView listView= (ListView) view.findViewById(R.id.id_list);

        MyBaseAdapter myBaseAdapter=new MyBaseAdapter(mNewsBeanList,mContext);
        listView.setAdapter(myBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToDetail(position);
            }
        });
       // return super.onCreateView(inflater, container, savedInstanceState);
        return  view;
    }

    private void goToDetail(int position) {
        NewsBean newsBean=mNewsBeanList.get(position);
        mGoNextListener.goNext(newsBean);
    }
    /*接口*/
    public interface GoNextListener{
        /*定义一个获取信息的方法*/
        public void goNext(NewsBean newsBean);
    }
}
