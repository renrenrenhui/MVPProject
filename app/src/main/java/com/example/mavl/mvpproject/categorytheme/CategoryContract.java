package com.example.mavl.mvpproject.categorytheme;

import com.example.mavl.mvpproject.BasePresenter;
import com.example.mavl.mvpproject.BaseView;

import java.util.List;

/**
 * 契约类来统一管理view与presenter的所有的接口，
 * 这种方式使得view与presenter中有哪些功能，一目了然，维护起来也方便
 */
public interface CategoryContract {

    interface Presenter extends BasePresenter {
        void loadCategory();
    }

    interface View extends BaseView<Presenter> {
        void showProgress();
        void hideProgress();
        void showCategory(List<Category> list);
    }
}
