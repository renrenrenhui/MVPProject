package com.example.mavl.mvpproject.categorytheme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.mavl.mvpproject.R;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment implements CategoryContract.View {

    private ProgressBar mLoading;
    private ListView mListView;
    private CategoryContract.Presenter mPresenter;
    private CategoryAdapter mAdapter;
    private List<Category> mCategoryThemeInfos = new ArrayList<Category>();

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        mListView = (ListView) view.findViewById(R.id.category_list);
        mListView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mAdapter = new CategoryAdapter(getActivity(), mCategoryThemeInfos);
        mListView.setAdapter(mAdapter);
        mLoading = (ProgressBar) view.findViewById(R.id.category_loading);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();

        mPresenter.loadCategory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mCategoryThemeInfos != null && !mCategoryThemeInfos.isEmpty()) {
            mCategoryThemeInfos.clear();
        }
    }

    @Override
    public void showProgress() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLoading.setVisibility(View.GONE);
    }

    @Override
    public void showCategory(List<Category> list) {
        mCategoryThemeInfos.clear();
        mCategoryThemeInfos.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(CategoryContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}