package com.demo.javaconcepts.reactiveprogramming.observertypes;

import com.demo.javaconcepts.reactiveprogramming.ObservableDemoUtils;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleObserverDemo {

    private static final Logger log = LoggerFactory.getLogger(SingleObserverDemo.class);

    public static void main(String[] args) {
        Single<Integer> first = Observable.fromArray(ObservableDemoUtils.getIntegerArray())
                .first(999);
        first.subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                log.info("onSubscribe");
            }

            @Override
            public void onSuccess(Integer integer) {
                log.info("onSuccess - {}", integer);
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("onError - ", throwable);
            }
        });
    }
}
