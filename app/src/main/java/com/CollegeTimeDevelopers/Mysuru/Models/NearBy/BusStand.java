package com.CollegeTimeDevelopers.Mysuru.Models.NearBy;

import com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Schedules.BusSchedule;

import java.util.List;

public class BusStand {
    boolean isAvailable;
    List<BusSchedule> schedule;
    double lat, lng;


    public BusStand(boolean isAvailable, List<BusSchedule> schedule, double lat, double lng) {
        this.isAvailable = isAvailable;
        this.schedule = schedule;
        this.lat = lat;
        this.lng = lng;
    }

    public BusStand(){}

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<BusSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<BusSchedule> schedule) {
        this.schedule = schedule;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
