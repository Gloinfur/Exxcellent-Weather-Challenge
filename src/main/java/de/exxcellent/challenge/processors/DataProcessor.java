package de.exxcellent.challenge.processors;

import de.exxcellent.challenge.readers.Reader;

import java.util.ArrayList;
import java.util.List;

public abstract class DataProcessor {
    protected List<String[]> data;

    public DataProcessor(Reader reader) {
        this.data = reader.read();
    }

    public List<Double> calculateSpread(int columnGreater, int columnSmaller) {
        String[] arrTMP;
        List<Double> resultList = new ArrayList<>();;

        for (int i = 1; i < data.size(); i++) {
            arrTMP = data.get(i);
            resultList.add(Double.valueOf(arrTMP[columnGreater]) - Double.valueOf(arrTMP[columnSmaller]));
        }

        return resultList;
    }
}
