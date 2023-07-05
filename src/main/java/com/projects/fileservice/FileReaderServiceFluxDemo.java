package com.projects.fileservice;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

@Slf4j
public class FileReaderServiceFluxDemo {

    public static void main(String[] args) {
        Path in = Paths.get("in", "line-file.txt");
        FileReaderService.read(in)
                .subscribe(line -> log.info("Received: {}", line),
                        onError -> log.error("{}", onError.toString()),
                        () -> log.info("completed!"));
    }
}

@Slf4j
class FileReaderService {

    private static Callable<BufferedReader> stateSupplierCallable(Path in) {
        return () -> Files.newBufferedReader(in);
    }

    private static BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> publisher() {
        return (bufferedReader, synchronousSink) -> {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    synchronousSink.complete();
                } else {
                    synchronousSink.next(line);
                }
//                log.info("{}", 1 / 0);
            } catch (Exception e) {
                synchronousSink.error(e);
            }
            return bufferedReader;
        };
    }

    public static Consumer<BufferedReader> stateConsumer() {
        return (br) -> {
            try {
                br.close();
                log.info("Close called");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public static Flux<String> read(Path in) {
        return Flux.generate(stateSupplierCallable(in), publisher(), stateConsumer());
    }
}
