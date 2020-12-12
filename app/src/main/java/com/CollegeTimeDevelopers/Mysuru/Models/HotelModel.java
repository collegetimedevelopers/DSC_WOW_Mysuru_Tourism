package com.CollegeTimeDevelopers.Mysuru.Models;

import java.util.List;

public class HotelModel {
String name , address, category ,description,famousName , priceRange;
List<String> imageURL;
Double lat , lng , rating;
List<String> facilities;

    public HotelModel(String name, String address, String category, String description, String famousName, String priceRange, List<String> imageURL, Double lat, Double lng, Double rating, List<String> facilities) {
        this.name = name;
        this.address = address;
        this.category = category;
        this.description = description;
        this.famousName = famousName;
        this.priceRange = priceRange;
        this.imageURL = imageURL;
        this.lat = lat;
        this.lng = lng;
        this.rating = rating;
        this.facilities = facilities;
    }

    public HotelModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFamousName() {
        return famousName;
    }

    public void setFamousName(String famousName) {
        this.famousName = famousName;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public List<String> getImageURL() {
        return imageURL;
    }

    public void setImageURL(List<String> imageURL) {
        this.imageURL = imageURL;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }
}




//"Barbeque Nation": {
//        "address": "BM Habitat Mall, Ground Floor, Mangalore - Mysore Hwy, Jayalakshmipuram, Mysuru, Karnataka 570012",
//        "category": "restaurant",
//        "description": "Barbeque nation stands as one of the major barbeque restaurants across the country. They have pioneered the use of barbeque or grill on the table. With ample live counters for exotic meat, kulfi and special one’s set-up for festivals, a meal at Barbeque Nation is usually an affair of pomp and gaiety. With barbecue and non-barbeque options like 'Mushroom', 'Paneer', 'Patty', ‘Assorted Exotic Grill Veg’, ‘Cajun Potato’, ‘Pinapple’, ‘Crispy Corn’, ‘Potatoes’, ‘Mutton Sheek Kebab’, ‘Tangdi Kebab’, ‘Chicken Drum Stick’, ‘Deep Marinated Fish’ and more, you can take a hard pass on the main course. From the main course, try the ‘Dal Makhani’, ‘Crabs’, 'Seafood with Rice and you are sorted. If Chinese is more of your thing, find solace in ‘Noodles’, ‘Manchurian’, etc.",
//        "facilities": [
//        "No-contact delivery",
//        "Takeaway",
//        "Dine-in",
//        "Rooftop seating"
//        ],
//        "famousName": "Barbeque Nation",
//        "imageURL": [
//        "https://lh3.googleusercontent.com/bbnIY3ND5o-5ZYwJcG7lSL8NOAoDrWW7jUS2Kl88KeNTbdmPeZe7xdcmT8JoJRW3oOsrjWKeR9G9apDxWWbm8FS1Eg=w1000",
//        "https://d4t7t8y8xqo0t.cloudfront.net/resized/720X280/restaurant%2F662368%2Frestaurant020190312115629.jpg",
//        "https://content.jdmagicbox.com/comp/hyderabad/e7/040pxx40.xx40.190307190824.x2e7/catalogue/barbeque-nation-as-rao-nagar-hyderabad-barbeque-restaurants-pporp861v7.jpg?clr=#664e00?fit=around%7C270%3A130&crop=270%3A130%3B%2A%2C%2A"
//        ],
//        "lat": 12.3213811,
//        "long": 76.6185944,
//        "priceRange": "700-2000",
//        "rating": 4.2
//        }