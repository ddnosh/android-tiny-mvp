package com.androidwind.mvp.sample;

import io.reactivex.functions.Consumer;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class MainPresenter extends MainContract.Presenter {
    @Override
    void sendMsg() {
        addSubscribe(
                getModel().executeMSg()
                        .compose(RxUtil.applySchedulers())
                        .subscribe(bool -> getView().updateMsg(bool))
        );
    }
}
