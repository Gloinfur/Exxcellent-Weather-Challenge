
# Exxcellent-Weather-Challenge
Programming challenge from Exxcellent Solutions GmbH.


## Overview

App.java is the entry point 
It provides the two methods _WeatherTask_ and _FootballTask_ to solve the tasks from the challenge.


_ReaderCSV_ and _ReaderJSON_ are responsible for reading, parsing and providing the data. 
They expect the data as InputStreams and return the read data as a 2D array list.


Both _WeatherDataProcessor_ and _FootballDataProcessor_ are using the same method from their parent abstract class _DataProcessor_ to calculate the spread.

## Design Choices
* Separation of concerns to support different file formats
* Using InputStreams to support different data sources
* Using an abstract class for the _DataProcessors_ to reduce redundant code



## Architecture
<img src="https://user-images.githubusercontent.com/56250123/121522260-351a0400-c9f5-11eb-91d8-69657164515b.png" alt="drawing" width="1000"/>
