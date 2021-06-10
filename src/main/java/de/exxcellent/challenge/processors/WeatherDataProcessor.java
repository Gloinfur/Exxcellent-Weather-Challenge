package de.exxcellent.challenge.processors;

import de.exxcellent.challenge.readers.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeatherDataProcessor implements DataProcessor {
    public List<String[]> data;

    public WeatherDataProcessor(Reader reader) {
        this.data = reader.read();
    }


    @Override
    public int calculateSpread() {
        int columnMxT = 1;
        int columnMnT = 2;
        String[] arrTMP;
        List<Double> resultList = new ArrayList<>();;

        for (int i = 1; i < data.size(); i++) {
            arrTMP = data.get(i);
            resultList.add(Double.valueOf(arrTMP[columnMxT]) - Double.valueOf(arrTMP[columnMnT]));
        }

        int indexOfMinSpreadDay = resultList.indexOf(Collections.min(resultList)) + 1;
        return indexOfMinSpreadDay;
    }
}
