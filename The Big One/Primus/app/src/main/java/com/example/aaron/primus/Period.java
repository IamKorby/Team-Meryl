package com.example.aaron.primus;


public class Period {

    //fields
    //Simple datatypes for now, will change into more suitable datatypes for date and time later on
    private String day;
    private int startTime;
    private int endTime;

    public Period(String day, int start, int end){
        this.day = day;
        this.startTime = start;
        this.endTime = end;
    }


    public String getDay() {
        return day;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

}
