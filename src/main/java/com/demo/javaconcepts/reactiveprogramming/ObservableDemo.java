package com.demo.javaconcepts.reactiveprogramming;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObservableDemo {

    protected static final Logger log = LoggerFactory.getLogger(ObservableDemo.class);

    /**
     * We can create observable from array and have subscriber to subscribe from observable
     * @param args
     */
    public static void main(String[] args) {
        Observable<Integer> integerObservable = Observable.fromArray(ObservableDemoUtils.getIntegerArray());
        integerObservable
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        log.info("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        log.info("onNext - {}", integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        log.info("onError", throwable);
                    }

                    @Override
                    public void onComplete() {
                        log.info("onComplete");
                    }
                });
    }
}
