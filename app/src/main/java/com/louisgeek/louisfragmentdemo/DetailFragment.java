package com.louisgeek.louisfragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by louisgeek on 2016/5/20.
 */
public class DetailFragment extends Fragment {

    private Context mContext;

    private static final String PARAM_TITLE = "title";
    private static final String PARAM_INTRO = "intro";

    private String mParam_title;
    private String mParam_intro;

    /**
     * Activity重新创建时，会重新构建它所管理的Fragment，原先的Fragment的字段值将会全部丢失，
     * 但是通过 Fragment.setArguments(Bundle bundle)方法设置的bundle会保留下来。
     * 所以尽量使用 Fragment.setArguments(Bundle bundle)方式来传递参数
     *
     * 切换横竖屏时，Fragment会调用自己的无参构造函数同理
     * @param newsBean
     * @return
     */
    public static DetailFragment newInstance(NewsBean newsBean) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(PARAM_TITLE, newsBean.getNewsTitle());
        args.putString(PARAM_INTRO, newsBean.getNewsIntro());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam_title = getArguments().getString(PARAM_TITLE);
            mParam_intro = getArguments().getString(PARAM_INTRO);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=LayoutInflater.from(mContext).inflate(R.layout.fragment_content_detail,container,false);
        TextView textView_title= (TextView) view.findViewById(R.id.id_tv_title);
        TextView textView_intro= (TextView) view.findViewById(R.id.id_tv_intro);

        textView_title.setText(mParam_title);
        textView_intro.setText(mParam_intro);

        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }




}
