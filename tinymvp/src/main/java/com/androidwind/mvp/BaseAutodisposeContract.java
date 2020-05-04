package com.androidwind.mvp;

import com.uber.autodispose.AutoDisposeConverter;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public interface BaseAutodisposeContract {

    interface BaseView {
        /**
         * 绑定Android生命周期 防止RxJava内存泄漏
         *
         * @param <T>
         * @return
         */
        <T> AutoDisposeConverter<T> bindAutoDispose();
    }

    interface BasePresenter<V extends BaseView, M extends BaseModel> {

        void attachView(V view);

        void detachView();

        void attachModel(M model);
    }

    interface BaseModel {

    }
}
