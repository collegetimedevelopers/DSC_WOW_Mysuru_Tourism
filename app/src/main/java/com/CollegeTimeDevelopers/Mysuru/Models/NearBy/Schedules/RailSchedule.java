package com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Schedules;

public class RailSchedule {
    int trainNumber;
    String arrival, departure,runsWeekDays,trainName ;


    public RailSchedule(int trainNumber, String arrival, String departure, String runsWeekDays, String trainName) {
        this.trainNumber = trainNumber;
        this.arrival = arrival;
        this.departure = departure;
        this.runsWeekDays = runsWeekDays;
        this.trainName = trainName;
    }

    public RailSchedule() {

    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
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

    public void setRunsWeekDays(String runsWeekDays) {
        this.runsWeekDays = runsWeekDays;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
}
