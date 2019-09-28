package com.androidwind.mvp.sample.disposable;

import io.reactivex.Observable;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class DisposableModel implements DisposableContract.Model {

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
