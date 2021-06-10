package de.exxcellent.challenge;

import de.exxcellent.challenge.processors.FootballDataProcessor;
import de.exxcellent.challenge.processors.WeatherDataProcessor;
import de.exxcellent.challenge.readers.ReaderCSV;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    //Predefined tests by eXXcellent
    private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

    //My tests
    private InputStream INPUTSTREAM_WEATHER = App.class.getResourceAsStream("./weather.csv");
    private InputStream INPUTSTREAM_FOOTBALL = App.class.getResourceAsStream("./football.csv");

    /**
     * Checks for the correct files with correct data. In this case only the last entry from the last column and row gets compared.
     */
    @Test
    void testDataSource() {
        File fileWeather = new File("src/main/resources/de/exxcellent/challenge/weather.csv");
        File fileFootball = new File("src/main/resources/de/exxcellent/challenge/football.csv");
        assertTrue(fileWeather.exists());
        assertTrue(fileFootball.exists());
    }

    @Test
    void testReadFile() {
        String line;
        String[] lastRowWeather = new String[0];
        String[] lastRowFootball = new String[0];
        try {
            BufferedReader readerWeather = new BufferedReader(new InputStreamReader(INPUTSTREAM_WEATHER));
            while ((line = readerWeather.readLine()) != null) {
                lastRowWeather = line.split(",");
            }
            readerWeather.close();

            BufferedReader readerFootball = new BufferedReader(new InputStreamReader(INPUTSTREAM_FOOTBALL));
            while ((line = readerFootball.readLine()) != null) {
                lastRowFootball = line.split(",");
            }
            readerFootball.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("1022.7", lastRowWeather[lastRowWeather.length -1]);
        assertEquals("28", lastRowFootball[lastRowFootball.length -1]);
    }

    @Test
    void testReaderCSV() {
        ReaderCSV readerCSV = new ReaderCSV(INPUTSTREAM_WEATHER);
        List<String[]> data = readerCSV.read();

        assertEquals("Day", data.get(0)[0]);
        assertEquals("MnT", data.get(0)[2]);
        assertEquals("1022.7", data.get(data.size()-1)[data.get(data.size()-1).length-1]);
    }

    @Test
    void testCalculateSpread() throws IOException {
        WeatherDataProcessor weatherDataProcessor = new WeatherDataProcessor(new ReaderCSV(INPUTSTREAM_WEATHER));
        FootballDataProcessor footballDataProcessor = new FootballDataProcessor(new ReaderCSV(INPUTSTREAM_FOOTBALL));

        assertEquals(14, weatherDataProcessor.calcMinTemperatureSpread());
        assertEquals("Aston_Villa", footballDataProcessor.calcTeamWithMinAbsoluteDifference());
    }
}