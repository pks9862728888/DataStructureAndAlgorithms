package com.demo.reactiveprogramming;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ObservableDemo {

    private static final Logger log = LoggerFactory.getLogger(ObservableDemo.class);

    public static void main(String[] args) {
        Observable.fromArray(new int[] {1, 2, 3, 4, 5})
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        log.info("onSubscribe");
                    }

                    @Override
                    public void onNext(int[] ints) {
                        log.info("onNext - " + Arrays.toString(ints));
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        log.info("onError");
                    }

                    @Override
                    public void onComplete() {
                        log.info("onComplete");
                    }
                });
    }
}
