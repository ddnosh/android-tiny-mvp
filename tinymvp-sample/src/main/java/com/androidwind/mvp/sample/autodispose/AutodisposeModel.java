package com.androidwind.mvp.sample.autodispose;

import com.androidwind.mvp.sample.disposable.DisposableContract;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class AutodisposeModel implements AutodisposeContract.Model {

    @Override
    public Observable<Boolean> executeMSg() {
        // return Observable.create(emitter -> {
        //             try {
        //                 Thread.sleep(2000); // 假设此处是耗时操作
        //             } catch (Exception e) {
        //                 e.printStackTrace();
        //                 emitter.onError(new RuntimeException());
        //             }
        //             emitter.onNext(true);
        //         }
        return Observable.timer(2, TimeUnit.SECONDS)
                .flatMap(new Function<Long, ObservableSource<Boolean>>() {
                    @Override
                    public ObservableSource<Boolean> apply(Long aLong) throws Exception {
                        return Observable.just(true);
                    }
                });
        // );
    }
}
