package de.exxcellent.challenge.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reader for CSV files
 */
public class ReaderCSV implements Reader{
    private String filePath;

    public ReaderCSV(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String[]> read() {
        String line;
        String[] dataRow;
        List<String[]> data = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                dataRow = line.split(",");
                data.add(dataRow);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
