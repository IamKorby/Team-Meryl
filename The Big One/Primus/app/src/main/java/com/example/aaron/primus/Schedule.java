package com.example.aaron.primus;


import java.util.ArrayList;

public class Schedule {

    //fields
    private ArrayList<Period> periodArrayList;

    public Schedule(){
        periodArrayList = new ArrayList<Period>();
    }

    public void addNewPeriod(String day, int start, int end, String title){
        Period temp = new Period(day, start, end, title);
        this.periodArrayList.add(temp);
    }

    public void deletePeriod(String day, int start, int end, String title) {
        for (int i = 0; i < periodArrayList.size(); i++) {
            if ((day.equals(periodArrayList.get(i).getDay()))&&(start==periodArrayList.get(i).getStartTime())
                    &&(end==periodArrayList.get(i).getEndTime())&&(title.equals(periodArrayList.get(i).getTitle()))
                    ) {
                periodArrayList.remove(i);
            }
        }
    }

    public ArrayList<Period> getPeriodArrayList() {
        return periodArrayList;
    }
}
