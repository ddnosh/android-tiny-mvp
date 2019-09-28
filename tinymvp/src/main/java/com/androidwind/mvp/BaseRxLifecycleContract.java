package com.androidwind.mvp;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public interface BaseRxLifecycleContract {

    interface BaseView {
        <T> LifecycleTransformer<T> bindToLife();
    }

    interface BasePresenter<V extends BaseView, M extends BaseModel> {

        void attachView(V view);

        void detachView();

        void attachModel(M model);
    }

    interface BaseModel {

    }
}
