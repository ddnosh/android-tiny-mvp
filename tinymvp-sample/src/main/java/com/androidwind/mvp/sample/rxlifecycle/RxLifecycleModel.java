package com.androidwind.mvp.sample.rxlifecycle;

import com.androidwind.mvp.sample.disposable.DisposableContract;

import io.reactivex.Observable;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class RxLifecycleModel implements RxLifecycleContract.Model {

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
