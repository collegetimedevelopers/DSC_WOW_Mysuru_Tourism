package com.CollegeTimeDevelopers.Mysuru.Models.UI.Home;

public class Glimpses {
    String placeName,imageUrl;

    public Glimpses(String placeName, String imageUrl) {
        this.placeName = placeName;
        this.imageUrl = imageUrl;
    }
    public Glimpses(){}

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
