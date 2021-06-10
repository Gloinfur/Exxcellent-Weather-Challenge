package de.exxcellent.challenge;

import de.exxcellent.challenge.processors.WeatherDataProcessor;
import de.exxcellent.challenge.readers.ReaderCSV;

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
        String FILEPATH_WEATHER = "src/main/resources/de/exxcellent/challenge/weather.csv";
        WeatherDataProcessor weatherDataProcessor = new WeatherDataProcessor(new ReaderCSV(FILEPATH_WEATHER));

        int dayWithSmallestTempSpread = weatherDataProcessor.calculateSpread();
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
    }

    /**
     * Starts challenge task 2: Determine the team with the minimal spread (absolute difference) between scored goals ('Goals') and received goals ('Goals allowed') from the given data.
     * Interpreting the minimal spread ('absolute difference') in this task as the smallest difference between scored goals und received goals:
     * E.g. (Goals | Goals Allowed):
     * 10 | 5 => 10 - 5 = 5
     * 40 | 50 => 40 - 50 = -10
     * 5 is the smallest difference between scored goals and received goals.
     */
    public static void footballTask() {
        String FILEPATH_FOOTBALL = "src/main/resources/de/exxcellent/challenge/football.csv";
        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
