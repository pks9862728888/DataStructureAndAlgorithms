package com.projects.fileservice;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class FileService {

    public Mono<String> read(Path filePath) {
        return Mono.fromSupplier(() -> readFile(filePath));
    }

    public Mono<Void> write(Path filePath, String fileContent) {
        return Mono.fromRunnable(() -> writeToFile(filePath, fileContent));
    }

    public Mono<Void> delete(Path filePath) {
        return Mono.fromRunnable(() -> deleteFile(filePath));
    }


    private String readFile(Path filePath) {
        try {
            log.info("Read file contents: {}", filePath);
            String content = new String(Files.readAllBytes(filePath));
            log.info("Read file content complete!");
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToFile(Path filePath, String fileContent) {
        try {
            log.info("Write content to file: {}", filePath);
            Files.write(filePath, fileContent.getBytes());
            log.info("Complete write content from file: {}", filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteFile(Path filePath) {
        try {
            log.info("Deleting file: {}", filePath);
            Files.delete(filePath);
            log.info("File deleted!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
