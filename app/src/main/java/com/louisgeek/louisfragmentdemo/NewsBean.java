package com.louisgeek.louisfragmentdemo;

import java.io.Serializable;

/**
 * Created by louisgeek on 2016/5/20.
 */
public class NewsBean implements Serializable{

    private  String newsTitle;
    private  String newsIntro;

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsIntro() {
        return newsIntro;
    }

    public void setNewsIntro(String newsIntro) {
        this.newsIntro = newsIntro;
    }
}
