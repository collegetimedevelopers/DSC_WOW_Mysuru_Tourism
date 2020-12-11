package com.CollegeTimeDevelopers.Mysuru.Models.NearBy;

import com.CollegeTimeDevelopers.Mysuru.Models.NearBy.Lists.HotelList;

import java.util.List;

public class Hotels {
    boolean isAvailable;
    List<HotelList>list;

    public Hotels(boolean isAvailable, List<HotelList> list) {
        this.isAvailable = isAvailable;
        this.list = list;
    }
    public Hotels(){}

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<HotelList> getList() {
        return list;
    }

    public void setList(List<HotelList> list) {
        this.list = list;
    }
}
