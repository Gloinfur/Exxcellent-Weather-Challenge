package de.exxcellent.challenge.processors;

import de.exxcellent.challenge.readers.Reader;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Processes weather data
 * Supported methods: calcMinTemperatureSpread()
 */
public class WeatherDataProcessor extends DataProcessor {
    public WeatherDataProcessor(Reader reader) throws IOException {
        super(reader);
    }

    /**
     * Calculates the index of the day with the smallest spread between MaxTemperature (MxT) and MinTemperature (MnT)
     * No parameters needed, since MxT and MnT doesn´t change in this challenge
     * @return int day
     */
    public int calcMinTemperatureSpread() {
        List<Double> resultList = calculateSpread(1, 2);

        int indexOfMinSpreadDay = resultList.indexOf(Collections.min(resultList)) + 1;
        return indexOfMinSpreadDay;
    }
}
