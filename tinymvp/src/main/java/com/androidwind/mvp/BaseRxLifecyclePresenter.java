package com.androidwind.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class BaseRxLifecyclePresenter<V extends BaseRxLifecycleContract.BaseView, M extends BaseRxLifecycleContract.BaseModel>
        implements BaseRxLifecycleContract.BasePresenter<V, M> {

    private Reference<V> mRefView;
    private M mModel;

    protected V getView() {
        if (!isViewAttached()) {
            throw new IllegalStateException("mvp's view is not attached, please check again!");
        }
        return mRefView.get();
    }

    private boolean isViewAttached() {
        return mRefView != null && mRefView.get() != null;
    }

    @Override
    public void attachView(V view) {
        mRefView = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (mRefView != null) {
            mRefView.clear();
            mRefView = null;
        }
    }

    protected M getModel() {
        return mModel;
    }

    @Override
    public void attachModel(M model) {
        mModel = model;
    }

}
