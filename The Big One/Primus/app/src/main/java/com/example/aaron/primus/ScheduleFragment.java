package com.example.aaron.primus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ScheduleFragment extends Fragment implements View.OnClickListener{

    public  ScheduleFragment () {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_schedule, container, false);

        //initialize buttons
        Button buttonViewSched = (Button) view.findViewById(R.id.buttonViewSched);
        buttonViewSched.setOnClickListener(this);
        Button buttonEditSched = (Button) view.findViewById(R.id.buttonEditSched);
        buttonEditSched.setOnClickListener(this);
        Button buttonNewSched = (Button) view.findViewById(R.id.buttonNewSched);
        buttonNewSched.setOnClickListener(this);
        Button buttonSendSched = (Button) view.findViewById(R.id.buttonSendSched);
        buttonSendSched.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Fragment fragmentHolder = new Fragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        //do what you want to do when button is clicked
        switch (view.getId()) {
            case R.id.buttonViewSched:
                fragmentHolder = new ViewSchedFragment();
                fragmentTransaction.replace(R.id.fragment_container, fragmentHolder);
                fragmentTransaction.addToBackStack(null);//so you can go back to the previous fragment on back press
                fragmentTransaction.commit();
                break;
            case R.id.buttonEditSched:
                fragmentHolder = new EditSchedFragment();
                fragmentTransaction.replace(R.id.fragment_container, fragmentHolder);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.buttonNewSched://Deletes old schedule
                break;
            case R.id.buttonSendSched:
                break;
        }
    }

}