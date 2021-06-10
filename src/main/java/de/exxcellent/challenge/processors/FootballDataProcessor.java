package de.exxcellent.challenge.processors;

import de.exxcellent.challenge.readers.Reader;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FootballDataProcessor {
    public List<String[]> data;

    public FootballDataProcessor(Reader reader) {
        this.data = reader.read();
    }


    public int calculateSpread(int columnGreater, int columnSmaller) {
        // columns 6 7
        String[] arrTMP;
        List<Double> resultList = new ArrayList<>();;

        for (int i = 1; i < data.size(); i++) {
            arrTMP = data.get(i);
            resultList.add(Double.valueOf(arrTMP[columnGreater]) - Double.valueOf(arrTMP[columnSmaller]));
        }


        int indexOfMinSpreadTeam = resultList.indexOf(Collections.min(resultList)) + 1;
        return indexOfMinSpreadTeam;
    }
}
