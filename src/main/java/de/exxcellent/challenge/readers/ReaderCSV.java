package de.exxcellent.challenge.readers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Reader for CSV files
 */
public class ReaderCSV implements Reader{
    private InputStream inputStream;

    public ReaderCSV(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public List<String[]> read() {
        String line;
        String[] dataRow;
        List<String[]> data = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
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
