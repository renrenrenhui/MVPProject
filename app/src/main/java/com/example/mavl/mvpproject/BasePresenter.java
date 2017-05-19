package com.example.mavl.mvpproject;

/*
* BasePresenter中含有方法start(),
* 该方法的作用是presenter开始获取数据并调用view中方法改变界面显示，
* 其调用时机是在Fragment类的onResume方法中。
* */
public interface BasePresenter {
    void start();
}
