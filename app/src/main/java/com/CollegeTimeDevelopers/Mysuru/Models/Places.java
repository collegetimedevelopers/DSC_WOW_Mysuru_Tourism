package com.CollegeTimeDevelopers.Mysuru.Models;


import com.CollegeTimeDevelopers.Mysuru.Models.NearBy.NearBy;
import com.CollegeTimeDevelopers.Mysuru.Models.Souvenir.Souvenir;

import java.util.List;

public class Places {
    String originalName,fmaousName,shortDescription,longDescription, specialAboutPlace, openingTime, closingTime;
    List<String> imageUrl;
    Location location;
    boolean isFamous;
    double rating;
    NearBy nearBy;
    Souvenir souvenir;

    public Places(String originalName, String fmaousName, String shortDescription, String longDescription, String specialAboutPlace, String openingTime, String closingTime, List<String> imageUrl, Location location, boolean isFamous, double rating, NearBy nearBy, Souvenir souvenir) {
        this.originalName = originalName;
        this.fmaousName = fmaousName;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.specialAboutPlace = specialAboutPlace;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.imageUrl = imageUrl;
        this.location = location;
        this.isFamous = isFamous;
        this.rating = rating;
        this.nearBy = nearBy;
        this.souvenir = souvenir;
    }
    public Places(){}

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getFmaousName() {
        return fmaousName;
    }

    public void setFmaousName(String fmaousName) {
        this.fmaousName = fmaousName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getSpecialAboutPlace() {
        return specialAboutPlace;
    }

    public void setSpecialAboutPlace(String specialAboutPlace) {
        this.specialAboutPlace = specialAboutPlace;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isFamous() {
        return isFamous;
    }

    public void setFamous(boolean famous) {
        isFamous = famous;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public NearBy getNearBy() {
        return nearBy;
    }

    public void setNearBy(NearBy nearBy) {
        this.nearBy = nearBy;
    }

    public Souvenir getSouvenir() {
        return souvenir;
    }

    public void setSouvenir(Souvenir souvenir) {
        this.souvenir = souvenir;
    }
}
