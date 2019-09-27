package com.androidwind.mvp.sample;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class MainModel implements MainContract.Model {

    @Override
    public Observable<Boolean> executeMSg() {
        return Observable.create(emitter -> {
                    try {
                        Thread.sleep(2000); // 假设此处是耗时操作
                    } catch (Exception e) {
                        e.printStackTrace();
                        emitter.onError(new RuntimeException());
                    }
                    emitter.onNext(true);
                }
        );
    }
}
