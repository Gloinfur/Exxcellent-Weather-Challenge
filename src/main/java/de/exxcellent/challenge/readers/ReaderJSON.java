package de.exxcellent.challenge.readers;

import java.util.List;

/**
 * Reader for JSON files.
 */
public class ReaderJSON implements Reader {
    private String filePath;

    public ReaderJSON(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String[]> read() {
        //TODO: Implement solution for reading JSON files. Not part of the challenge.
        return null;
    }
}
