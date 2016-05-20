package com.louisgeek.louisfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsListFragment.GoNextListener{

    List<NewsBean> newsBeanList=new ArrayList<>();
    FragmentManager fragmentManager;
    NewsListFragment newsListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        TextView id_btn = (TextView) findViewById(R.id.id_btn);

        id_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked !", Toast.LENGTH_SHORT).show();
            }
        });

        id_btn.performClick();//模拟一次点击

        for (int i = 0; i < 15; i++) {
            NewsBean newsBean=new NewsBean();
            newsBean.setNewsTitle("标题"+i);
            newsBean.setNewsIntro("内容"+i);
            newsBeanList.add(newsBean);
        }

        fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        //replace 第一个Fragment
        newsListFragment = NewsListFragment.newInstance(newsBeanList);

        //ft.replace(R.id.id_fl, newsListFragment);

        ft.add(R.id.id_fl,newsListFragment);
        //ft.hide(newsListFragment.this);

        ft.commit();

        }



    @Override
    public void goNext(NewsBean newsBean) {

        FragmentTransaction ft = fragmentManager.beginTransaction();

        DetailFragment detailFragment= DetailFragment.newInstance(newsBean);

        //加上Fragment替换动画
        // ft.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        // ft.replace(R.id.id_fl, fragment);
        ft.add(R.id.id_fl,detailFragment);
        ft.hide(newsListFragment);

        //调用addToBackStack将Fragment添加到栈中
        ft.addToBackStack(null);
        ft.commit();
    }

   /* @Override
    public void onBackPressed() {
        super.onBackPressed();
    if (fragmentManager.getBackStackEntryCount()>0){
        fragmentManager.popBackStack();
        return;
    }

    }*/



}
