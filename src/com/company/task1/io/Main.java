package com.company.task1.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String outFolder = "./output-folder";
        String inFolder = "./input-folder";

        List<String> list = new ArrayList<>();
        String[] ends = {"exe"};
        findFiles(outFolder, ends, list);
        Copy copy = new Copy();
        for (String file : list) {
            try {

                copy.copyFile(outFolder + "/" + file, inFolder + "/" + file);
            } catch (IOException e) {
                throw new RuntimeException("File can't be copied", e);
            }
        }
    }

    private static void findFiles(
            String srcPath,
            String[] ends,
            List<String> list
    ) {
        File dir = new File(srcPath);
        File[] files = dir.listFiles(new Filter(ends));

        for (File file : files) {
            list.add(file.getName());
        }

    }
}
