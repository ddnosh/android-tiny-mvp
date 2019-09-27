package com.androidwind.mvp.sample;

import io.reactivex.Observable;

import com.androidwind.mvp.BaseContract;
import com.androidwind.mvp.BasePresenter;


/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public interface MainContract {

    interface View extends BaseContract.BaseView {
        void updateMsg(Boolean bool);
    }

    abstract class Presenter extends BasePresenter<View , Model> {
        abstract void sendMsg();
    }

    interface Model extends BaseContract.BaseModel {
        Observable<Boolean> executeMSg();
    }
}
