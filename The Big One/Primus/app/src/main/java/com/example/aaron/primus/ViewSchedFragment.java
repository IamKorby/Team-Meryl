package com.example.aaron.primus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewSchedFragment extends Fragment {

    Schedule mySchedule;
    ArrayList<Period> periodList;
    ListView periodListView;

    public  ViewSchedFragment () {
        mySchedule = new Schedule();
        periodList = new ArrayList<Period>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_view_sched, container, false);
        mySchedule = ((MainActivity)getActivity()).getMySchedule();
        periodList = mySchedule.getPeriodArrayList();
        periodListView = (ListView) view.findViewById(R.id.periodListView);//uses ListView to display each period for now
        ArrayAdapter<Period> schedulePeriods = new ArrayAdapter<Period>(getActivity(), android.R.layout.simple_list_item_1, periodList);
        periodListView.setAdapter(schedulePeriods);
        return view;
    }
}
