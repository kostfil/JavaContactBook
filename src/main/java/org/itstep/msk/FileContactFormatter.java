package org.itstep.msk;

import java.io.PrintWriter;

/**
 * Prints a Contact object to the PrintWriter given as a simple string
 *
 * @author BogdanovaAnastasia
 * @version 1.0
 * */

public final class FileContactFormatter implements ContactFormatter {
    private final Contact origin;
    private final String splitItem;

    public FileContactFormatter(Contact origin,String splitItem) {
        this.origin = origin;
        this.splitItem = splitItem;
    }

    /**
     * Prints name and phone of Contact to the PrintWriter given
     *
     * @param writeToFile the PrintWriter to print name and phone with split-item between them
     * */

    @Override
    public void print(PrintWriter writeToFile) {
        writeToFile.write(origin.getName() + splitItem + origin.getPhone());
        writeToFile.println();
    }
}
