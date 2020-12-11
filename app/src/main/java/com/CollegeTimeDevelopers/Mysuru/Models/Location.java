package com.CollegeTimeDevelopers.Mysuru.Models;

public class Location {
    String district, locality;
    double lat, lng;
    int pincode;

    public Location(String district, String locality, double lat, double lng, int pincode) {
        this.district = district;
        this.locality = locality;
        this.lat = lat;
        this.lng = lng;
        this.pincode = pincode;
    }

    public Location() {

    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
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

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
