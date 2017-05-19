package com.example.mavl.mvpproject.categorytheme;


import android.util.Log;

import java.util.List;

public class CategoryPresenter implements CategoryContract.Presenter, CategoryServerModel.DataLoadListener {

    private CategoryContract.View mView;
    private CategoryServerModel mServerModelHelper;

    public CategoryPresenter(CategoryContract.View view) {
        this.mView = view;
        view.setPresenter(this);
        //数据提供者 这里封装网络数据请求
        mServerModelHelper = new CategoryServerModel();
        mServerModelHelper.setListener(this);
    }

    @Override
    public void start() {
        mView.showProgress();
    }

    @Override
    public void failure() {
        mView.hideProgress();
    }

    @Override
    public void success(List<Category> list) {
        mView.hideProgress();
        mView.showCategory(list);
    }

    @Override
    public void loadCategory() {
        mServerModelHelper.getCategoryList();
    }
}
