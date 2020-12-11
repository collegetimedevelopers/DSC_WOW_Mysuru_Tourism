package com.CollegeTimeDevelopers.Mysuru.Models.NearBy;

public class NearBy {
    BusStand busStand;
    RailwayStation railwayStation;
    Hotels hotels;

    public NearBy(BusStand busStand, RailwayStation railwayStation, Hotels hotels) {
        this.busStand = busStand;
        this.railwayStation = railwayStation;
        this.hotels = hotels;
    }
    public NearBy(){}

    public BusStand getBusStand() {
        return busStand;
    }

    public void setBusStand(BusStand busStand) {
        this.busStand = busStand;
    }

    public RailwayStation getRailwayStation() {
        return railwayStation;
    }

    public void setRailwayStation(RailwayStation railwayStation) {
        this.railwayStation = railwayStation;
    }

    public Hotels getHotels() {
        return hotels;
    }

    public void setHotels(Hotels hotels) {
        this.hotels = hotels;
    }
}
