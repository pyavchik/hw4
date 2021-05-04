package com.company.task1.io;

import java.io.*;

public class Copy {
    public void copyFile(final String from, final String to) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(from));
             BufferedWriter bw = new BufferedWriter(new FileWriter(to))) {
            int buf;
            while ((buf = br.read()) != -1) {
                bw.write(buf);
            }

        }
    }
}