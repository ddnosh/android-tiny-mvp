package com.androidwind.mvp.sample.rxlifecycle;

import com.androidwind.mvp.BaseRxLifecycleContract;
import com.androidwind.mvp.BaseRxLifecyclePresenter;

import io.reactivex.Observable;


/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public interface RxLifecycleContract {

    interface View extends BaseRxLifecycleContract.BaseView {
        void updateMsg(Boolean bool);
    }

    abstract class Presenter extends BaseRxLifecyclePresenter<View , Model> {
        abstract void sendMsg();
    }

    interface Model extends BaseRxLifecycleContract.BaseModel {
        Observable<Boolean> executeMSg();
    }
}
