package de.exxcellent.challenge.processors;

import de.exxcellent.challenge.readers.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Processes football data
 * Supported methods: calcTeamWithMinAbsoluteDifference()
 */
public class FootballDataProcessor extends DataProcessor{

    public FootballDataProcessor(Reader reader) throws IOException {
        super(reader);
    }

    /**
     * Delivers the team name of the team with the minimal absolute difference
     * Interpreting the minimal spread ('absolute difference') in this task as the smallest difference between scored goals und received goals:
     * E.g. (Goals | Goals Allowed):
     * 10 | 5 => 10 - 5 = 5
     * 40 | 50 => 40 - 50 = -10
     * 5 is the smallest difference between scored goals and received goals.
     *
     * @return String team name
     */
    public String calcTeamWithMinAbsoluteDifference() {
        List<Double> resultList = calculateSpread(5,6);
        List<Double> resultListTMP = new ArrayList<>();

        resultList.forEach(number -> resultListTMP.add(Math.abs(number))); //Convert all negative numbers into positive ones
        int indexOfMinSpreadTeam = resultListTMP.indexOf(Collections.min(resultListTMP)) + 1;
        String team = data.get(indexOfMinSpreadTeam)[0];

        return team;
    }
}
