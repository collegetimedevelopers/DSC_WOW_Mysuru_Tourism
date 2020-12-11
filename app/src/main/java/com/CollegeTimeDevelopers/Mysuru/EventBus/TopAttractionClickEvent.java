package com.CollegeTimeDevelopers.Mysuru.EventBus;

public class TopAttractionClickEvent {
     final boolean isSuccess;

    public TopAttractionClickEvent(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
