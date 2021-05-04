package com.company.task1.io;

import java.io.File;
import java.io.FilenameFilter;

public final class Filter implements FilenameFilter {

    private final String[] ends;

    public Filter(final String[] ends) {
        this.ends = ends;
    }

    @Override
    public boolean accept(final File dir, final String name) {
        boolean result = false;
        for (String end : this.ends) {
            if (name.endsWith(end)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
