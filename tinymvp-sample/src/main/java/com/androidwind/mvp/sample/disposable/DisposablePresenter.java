package com.androidwind.mvp.sample.disposable;

import com.androidwind.mvp.sample.RxUtil;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class DisposablePresenter extends DisposableContract.Presenter {
    @Override
    void sendMsg() {
        addSubscribe(
                getModel().executeMSg()
                        .compose(RxUtil.applySchedulers())
                        .subscribe(bool -> getView().updateMsg(bool))
        );
    }
}
