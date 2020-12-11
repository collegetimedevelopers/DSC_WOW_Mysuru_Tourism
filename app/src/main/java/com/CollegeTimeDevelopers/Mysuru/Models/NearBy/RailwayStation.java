package com.CollegeTimeDevelopers.Mysuru.Models.NearBy;

import com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Schedules.RailSchedule;

import java.util.List;

public class RailwayStation {
    boolean isAvailable;
    double lat,lng;
    List<RailSchedule> schedule;

    public RailwayStation(boolean isAvailable, double lat, double lng, List<RailSchedule> schedule) {
        this.isAvailable = isAvailable;
        this.lat = lat;
        this.lng = lng;
        this.schedule = schedule;
    }
    public RailwayStation(){}

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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

    public List<RailSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<RailSchedule> schedule) {
        this.schedule = schedule;
    }
}
