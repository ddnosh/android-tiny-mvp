package com.androidwind.mvp.sample.rxlifecycle;

import com.androidwind.mvp.sample.RxUtil;
import com.androidwind.mvp.sample.disposable.DisposableContract;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class RxLifecyclePresenter extends RxLifecycleContract.Presenter {
    @Override
    void sendMsg() {
        getModel().executeMSg()
                .compose(RxUtil.applySchedulers())
                .compose(getView().bindToLife())
                .subscribe(bool -> getView().updateMsg(bool));
    }
}
