package com.example.aaron.primus;


public class Period {

    //fields
    //Simple datatypes for now, will change into more suitable datatypes for date and time later on
    private String day;
    private int startTime;
    private int endTime;
    private String title;

    public Period(String day, int start, int end, String title){
        this.day = day;
        this.startTime = start;
        this.endTime = end;
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.day + " " + this.startTime + " to " + this.endTime;
    }

    public String getDay() {
        return this.day;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public String getTitle() {
        return this.title;
    }

}
