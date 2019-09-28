package com.androidwind.mvp;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public interface BaseDisposableContract {

    interface BaseView {

    }

    interface BasePresenter<V extends BaseView, M extends BaseModel> {

        void attachView(V view);

        void detachView();

        void attachModel(M model);
    }

    interface BaseModel {

    }
}
