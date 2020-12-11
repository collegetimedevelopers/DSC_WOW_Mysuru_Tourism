package com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Lists;

public class HotelList {
    String name,imageUrl,priceRange, address;
    double rating;



    public HotelList(String name, String imageUrl, String priceRange, String address, double rating) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.priceRange = priceRange;
        this.address = address;
        this.rating = rating;
    }

    public HotelList(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
