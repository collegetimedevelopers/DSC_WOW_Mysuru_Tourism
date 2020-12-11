package com.CollegeTimeDevelopers.Mysuru.Models.Souvenir;

public class Items {
    String name,imageUrl,priceRange;

    public Items(String name, String imageUrl, String priceRange) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.priceRange = priceRange;
    }
    public Items(){}

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
}
