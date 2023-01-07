package com.demo.reactiveprogramming.observertypes;

import com.demo.reactiveprogramming.ObservableDemoUtils;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompletableObserverDemo {

    private static final Logger log = LoggerFactory.getLogger(CompletableObserverDemo.class);

    public static void main(String[] args) {
        Completable completableObserver = Observable.fromArray(ObservableDemoUtils.getIntegerArray())
                .ignoreElements();
        completableObserver.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable disposable) {
                log.info("onSubscribe");
            }

            @Override
            public void onComplete() {
                log.info("onComplete");
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("onError");
            }
        });
    }
}
