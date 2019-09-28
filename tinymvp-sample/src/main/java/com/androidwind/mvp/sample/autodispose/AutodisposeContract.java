package com.androidwind.mvp.sample.autodispose;

import com.androidwind.mvp.BaseAutodisposeContract;
import com.androidwind.mvp.BaseAutodisposePresenter;
import com.androidwind.mvp.BaseDisposableContract;
import com.androidwind.mvp.BaseDisposablePresenter;

import io.reactivex.Observable;


/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public interface AutodisposeContract {

    interface View extends BaseAutodisposeContract.BaseView {
        void updateMsg(Boolean bool);
    }

    abstract class Presenter extends BaseAutodisposePresenter<View , Model> {
        abstract void sendMsg();
    }

    interface Model extends BaseAutodisposeContract.BaseModel {
        Observable<Boolean> executeMSg();
    }
}
