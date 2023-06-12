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
        try {
            String fileContent = fileService.read(inputFile).block();
            if (writeContent(fileService, fileContent)) {
                deleteInputFile(fileService);
            }
        } catch (Throwable e) {
            log.error("Exception occurred while reading: {}", e.toString());
        }
    }

    private static boolean writeContent(FileService fileService, String content) {
        try {
            fileService.write(outputFile, content).block();
            return true;
        } catch (Throwable e) {
            log.error("Exception occurred while writing: {}", e.toString());
        }
        return false;
    }

    private static void deleteInputFile(FileService fileService) {
        try {
            fileService.delete(inputFile).block();
        } catch (Throwable e) {
            log.error("Exception occurred while deleting: {}", e.toString());
        }
    }
}
