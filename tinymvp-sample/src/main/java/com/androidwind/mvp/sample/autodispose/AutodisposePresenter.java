package com.androidwind.mvp.sample.autodispose;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;

import com.androidwind.mvp.sample.RxUtil;
import com.androidwind.mvp.sample.disposable.DisposableContract;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class AutodisposePresenter extends AutodisposeContract.Presenter {
    @Override
    void sendMsg() {
        getModel().executeMSg()
                .compose(RxUtil.applySchedulers())
                .as(getView().bindAutoDispose())
                .subscribe(bool -> getView().updateMsg(bool));
    }
}
