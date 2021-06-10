# Exxcellent-Weather-Challenge
Programming challenge from Exxcellent Solutions GmbH.


## Overview

App.java is the entry point 
It provides the two methods _WeatherTask_ and _FootballTask_ to solve the tasks from the challenge.


_ReaderCSV_ and _ReaderJSON_ expect are responsible for reading, parsing and providing the data. 
They expect the data as InputStreams to support different data sources.


Both _WeatherDataProcessor_ and _FootballDataProcessor_ are using the same method from their parent abstract class _DataProcessor_ to calculate the spread to reduce redundant code.
