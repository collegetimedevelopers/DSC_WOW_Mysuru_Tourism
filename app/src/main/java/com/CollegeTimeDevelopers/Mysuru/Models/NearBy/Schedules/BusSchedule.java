package com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Schedules;

public class BusSchedule {
    int busNumber;
    String busDestination,time;

    public BusSchedule(int busNumber, String busDestination, String time) {
        this.busNumber = busNumber;
        this.busDestination = busDestination;
        this.time = time;
    }
    public BusSchedule(){}

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusDestination() {
        return busDestination;
    }

    public void setBusDestination(String busDestination) {
        this.busDestination = busDestination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
