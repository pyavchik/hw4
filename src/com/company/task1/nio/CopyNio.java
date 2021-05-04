package com.company.task1.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyNio {
    public static void main(String[] args) {
        Path path = Paths.get(CopyVisitor.PATH_INPUT);

        final CopyVisitor visitor = new CopyVisitor("doc");
        try {
            Files.walkFileTree(path, visitor);
        } catch (IOException e) {
            throw new RuntimeException("Error. Can't walk file tree", e);
        }
    }

}

class CopyVisitor extends SimpleFileVisitor<Path> {
    public static final String PATH_OUTPUT = "output-folder";
    public static final String PATH_INPUT = "input-folder";
    private String extension;

    public CopyVisitor(String extension) {
        this.extension = extension;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {

        final String tempPath = path.toFile().getPath();

        if (tempPath.endsWith(extension)) {
            final String replacedPath = tempPath.replace(PATH_INPUT, PATH_OUTPUT);

            Files.copy(path, Paths.get(replacedPath), StandardCopyOption.REPLACE_EXISTING);
        }
        return super.visitFile(path, attrs);
    }
}
