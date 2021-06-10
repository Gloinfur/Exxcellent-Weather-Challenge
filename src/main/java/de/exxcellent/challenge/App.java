package de.exxcellent.challenge;

import de.exxcellent.challenge.processors.FootballDataProcessor;
import de.exxcellent.challenge.processors.WeatherDataProcessor;
import de.exxcellent.challenge.readers.ReaderCSV;

import java.io.IOException;
import java.io.InputStream;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        weatherTask();
        footballTask();
    }

    /**
     * Starts challenge task 1: Determine the day with the minimal spread between the maxTemperature and minTemperature from the given data
     */
    public static void weatherTask() {
        InputStream weatherInputStream = App.class.getResourceAsStream("./weather.csv");
        WeatherDataProcessor weatherDataProcessor = null;

        try {
            weatherDataProcessor = new WeatherDataProcessor(new ReaderCSV(weatherInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int dayWithSmallestTempSpread = weatherDataProcessor.calcMinTemperatureSpread();
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
    }

    /**
     * Starts challenge task 2: Determine the team with the minimal spread (absolute difference) between scored goals ('Goals') and received goals ('Goals allowed') from the given data.
     */
    public static void footballTask() {
        InputStream footballInputStream = App.class.getResourceAsStream("./football.csv");
        FootballDataProcessor footballDataProcessor = null;

        try {
            footballDataProcessor = new FootballDataProcessor(new ReaderCSV(footballInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String teamWithSmallestGoalSpread =  footballDataProcessor.calcTeamWithMinAbsoluteDifference();
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
