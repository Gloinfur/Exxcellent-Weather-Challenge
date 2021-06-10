package de.exxcellent.challenge.processors;

import de.exxcellent.challenge.readers.Reader;

import java.util.List;

public class WeatherDataProcessor implements DataProcessor {
    public List<String[]> data;

    public WeatherDataProcessor(Reader reader) {
        this.data = reader.read();
    }


    @Override
    public int calculateSpread() {
        return 0;
    }
}
