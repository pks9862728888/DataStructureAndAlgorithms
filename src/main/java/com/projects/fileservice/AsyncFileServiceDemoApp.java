package com.projects.fileservice;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class AsyncFileServiceDemoApp {

    private static final Path inputFile = Paths.get("in", "LoremIpsum.txt");
    private static final Path outputFile = Paths.get("out", "LoremIpsumCopy.txt");

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.readContent(inputFile)
                .subscribe(content -> writeContentAndDeleteInputFile(fileService, content),
                        ex -> log.error("Exception while reading content: {}", ex.toString()),
                        () -> log.info("Read content job complete!"));
    }

    private static void writeContentAndDeleteInputFile(FileService fileService, String content) {
        fileService.writeContent(outputFile, content)
                .subscribe(onNext -> log.info("Nothing will get returned!"),
                        ex -> log.error("Exception while writing content: {}", ex.toString()),
                        () -> {
                            log.info("Write content job complete");
                            deleteInputFile(fileService);
                        });
    }

    private static void deleteInputFile(FileService fileService) {
        fileService.deleteFile(inputFile)
                .subscribe(onNext -> log.info("File deletion status: {}", onNext),
                        ex -> log.error("Exception while deleting input file: {}", inputFile),
                        () -> log.info("Delete file job completed!"));
    }
}
