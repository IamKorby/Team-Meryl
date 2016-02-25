package com.example.aaron.primus;


import java.util.ArrayList;

public class Schedule {

    //fields
    private ArrayList<Period> periodArrayList;

    public Schedule(){
        periodArrayList = new ArrayList<Period>();
    }

    public void addNewPeriod(String day, int start, int end){
        Period temp = new Period(day, start, end);
        this.periodArrayList.add(temp);
    }

    //further getters will be implemented when more advanced datatypes are used for Period object
    public Period getPeriodByDay(String day){
        Period temp = null;
        for(int i = 0; i<periodArrayList.size(); i++){
            if(periodArrayList.equals(periodArrayList.get(i).getDay())){
                temp = periodArrayList.get(i);
            }
        }
        return temp;
    }

    public ArrayList<Period> getPeriodArrayList() {
        return periodArrayList;
    }
}
