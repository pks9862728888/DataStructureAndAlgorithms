package com.demo.reactiveprogramming.reactor.fluxsink;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

@Slf4j
public class MissingPersonFinderChannel implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    public MissingPersonFinderChannel(String name) {
    }

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void next(String item) {
        if (!this.fluxSink.isCancelled()) {
            this.fluxSink.next(Thread.currentThread().getId() + " : " + item);
        }
    }
}
