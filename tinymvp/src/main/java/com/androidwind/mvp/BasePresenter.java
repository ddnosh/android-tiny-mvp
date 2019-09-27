package com.androidwind.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class BasePresenter<V extends BaseContract.BaseView, M extends BaseContract.BaseModel> implements BaseContract.BasePresenter<V, M> {

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
        unSubscribe();
    }

    protected M getModel() {
        return mModel;
    }

    @Override
    public void attachModel(M model) {
        mModel = model;
    }

    //增加使用CompositeDisposable方式处理防止RxJava内存泄漏的问题
    private CompositeDisposable mCompositeDisposable;

    public void addSubscribe(Disposable disposable){
        if(mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    private void unSubscribe() {
        if(mCompositeDisposable != null){
            mCompositeDisposable.dispose();//dispose防止下游(订阅者)收到观察者发送的消息
        }
    }
}
