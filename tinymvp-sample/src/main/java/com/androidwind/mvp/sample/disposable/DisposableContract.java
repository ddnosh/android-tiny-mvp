package com.androidwind.mvp.sample.disposable;

import io.reactivex.Observable;

import com.androidwind.mvp.BaseDisposableContract;
import com.androidwind.mvp.BaseDisposablePresenter;


/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public interface DisposableContract {

    interface View extends BaseDisposableContract.BaseView {
        void updateMsg(Boolean bool);
    }

    abstract class Presenter extends BaseDisposablePresenter<View , Model> {
        abstract void sendMsg();
    }

    interface Model extends BaseDisposableContract.BaseModel {
        Observable<Boolean> executeMSg();
    }
}
