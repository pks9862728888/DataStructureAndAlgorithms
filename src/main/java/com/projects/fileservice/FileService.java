package com.projects.fileservice;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.file.Path;

@Slf4j
public class FileService {

    public Mono<String> readContent(Path filePath) {
        try {
            return Mono.fromSupplier(() -> {
                try {
                    return readFileContent(filePath);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<Void> writeContent(Path filePath, String fileContent) {
        try {
            return Mono.fromRunnable(() -> {
                try {
                    writeFileContent(filePath, fileContent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<Boolean> deleteFile(Path filePath) {
        try {
            return Mono.fromCallable(() -> filePath.toFile().delete());
        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    private String readFileContent(Path filePath) throws IOException {
        log.info("Read content from file: {}", filePath);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        log.info("Complete read content from file: {}", filePath);
        return sb.toString();
    }

    private void writeFileContent(Path filePath, String fileContent) throws IOException {
        log.info("Write content to file: {}", filePath);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.toString()))) {
            bw.write(fileContent);
        }
        log.info("Complete write content from file: {}", filePath);
    }

}




