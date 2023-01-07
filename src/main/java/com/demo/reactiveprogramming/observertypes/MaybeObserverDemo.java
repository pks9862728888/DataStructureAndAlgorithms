package com.demo.reactiveprogramming.observertypes;

import com.demo.reactiveprogramming.ObservableDemoUtils;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MaybeObserverDemo {

    public static void main(String[] args) {
        maybeObserverEmitEvent();
        maybeObserverDoNotEmitEvent();
    }

    private static void maybeObserverEmitEvent() {
        System.out.println("----------------------------------------------------------------------");
        Maybe<Integer> maybeObservable = Observable.fromArray(ObservableDemoUtils.getIntegerArray())
                .first(999)
                .filter(i -> i.equals(1));
        maybeObservable.subscribe(new MaybeObserverSubscriber<>("maybeObserverEmitEvent"));
        Maybe<Integer> delay = maybeObservable.delay(1, TimeUnit.SECONDS);
        delay.blockingGet();
    }

    private static void maybeObserverDoNotEmitEvent() {
        System.out.println("----------------------------------------------------------------------");
        Maybe<Integer> maybeObservable = Observable.fromArray(ObservableDemoUtils.getIntegerArray())
                .first(999)
                .filter(i -> i.equals(-1));
        maybeObservable.subscribe(new MaybeObserverSubscriber<>("maybeObserverDoNotEmitEvent"));
    }
}

class MaybeObserverSubscriber<TEvent> implements MaybeObserver<TEvent> {

    private static Logger log;
    private String loggerName;

    public MaybeObserverSubscriber(String loggerName) {
        log = LoggerFactory.getLogger(loggerName);
        this.loggerName = loggerName;
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        log.info("{} - onSubscribe", loggerName);
    }

    @Override
    public void onSuccess(TEvent event) {
        log.info("{} - onSuccess - {}", loggerName, event);
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("{} - onError - ", loggerName, throwable);
    }

    @Override
    public void onComplete() {
        log.info("{} - onComplete", loggerName);
    }
}
