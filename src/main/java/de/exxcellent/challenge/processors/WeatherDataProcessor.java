package de.exxcellent.challenge.processors;

import de.exxcellent.challenge.readers.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeatherDataProcessor extends DataProcessor {
    public WeatherDataProcessor(Reader reader) {
        super(reader);
    }


    public int calcMinTemperatureSpread(int columnGreater, int columnSmaller) {

        List<Double> resultList = calculateSpread(columnGreater, columnSmaller);

        int indexOfMinSpreadDay = resultList.indexOf(Collections.min(resultList)) + 1;
        return indexOfMinSpreadDay;
    }
}
