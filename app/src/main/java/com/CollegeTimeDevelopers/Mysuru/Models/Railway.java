package com.CollegeTimeDevelopers.Mysuru.Models;

import com.google.firebase.database.PropertyName;

public class Railway {
    String arrival, departure, runsWeekDays, trainDestination, trainName, trainSource;
    int trainNumber;

    public Railway(String arrival, String departure, String runsWeekDays, String trainDestination, String trainName, String trainSource, int trainNumber) {
        this.arrival = arrival;
        this.departure = departure;
        this.runsWeekDays = runsWeekDays;
        this.trainDestination = trainDestination;
        this.trainName = trainName;
        this.trainSource = trainSource;
        this.trainNumber = trainNumber;
    }

    public Railway() {
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getRunsWeekDays() {
        return runsWeekDays;
    }

    @PropertyName("runsWeekDays")
    public void setRunsWeekDays(String runsWeekDay) {
        this.runsWeekDays = runsWeekDays;
    }

    public String getTrainDestination() {
        return trainDestination;
    }

    public void setTrainDestination(String trainDestination) {
        this.trainDestination = trainDestination;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainSource() {
        return trainSource;
    }

    public void setTrainSource(String trainSource) {
        this.trainSource = trainSource;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }
}