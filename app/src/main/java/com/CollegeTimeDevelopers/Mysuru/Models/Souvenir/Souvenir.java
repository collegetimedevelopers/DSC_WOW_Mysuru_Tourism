package com.CollegeTimeDevelopers.Mysuru.Models.Souvenir;

import java.util.List;

public class Souvenir {
    boolean isAvailable;
    List<Items> items;

    public Souvenir(boolean isAvailable, List<Items> items) {
        this.isAvailable = isAvailable;
        this.items = items;
    }
    public Souvenir(){}

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
