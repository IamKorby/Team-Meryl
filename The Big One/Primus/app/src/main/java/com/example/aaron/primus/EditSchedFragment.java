package com.example.aaron.primus;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EditSchedFragment extends Fragment implements View.OnClickListener{

    EditText periodDay;
    EditText periodStart;
    EditText periodEnd;
    String tempDay;
    int tempStart;
    int tempEnd;
    onPeriodSendListener onPeriodSendListener;

    public EditSchedFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_edit_sched, container, false);
        periodDay = (EditText) view.findViewById(R.id.editPeriodDay);
        periodStart = (EditText) view.findViewById(R.id.editStartTime);
        periodEnd = (EditText) view.findViewById(R.id.editEndTime);
        Button buttonAddPeriod = (Button) view.findViewById(R.id.buttonAddPeriod);
        buttonAddPeriod.setOnClickListener(this);
        Button buttonDeletePeriod = (Button) view.findViewById(R.id.buttonDeletePeriod);
        buttonDeletePeriod.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        //do what you want to do when button is clicked
        switch (view.getId()) {
            case R.id.buttonAddPeriod:
                tempDay = periodDay.getText().toString();
                tempStart = Integer.parseInt(periodStart.getText().toString());//parse to turn string to int. try-catch add later
                tempEnd = Integer.parseInt(periodEnd.getText().toString());
                onPeriodSendListener.setPeriodInfo(tempDay, tempStart, tempEnd);//send to MainActivity for use by other fragments
                break;
            case R.id.buttonDeletePeriod://nothing yet
                break;
        }
    }

    public interface onPeriodSendListener {//interface to communicate with MainActivity
        public void setPeriodInfo(String day, int start, int end);
    }

    @Override
    public void onAttach(Activity activity) {//dunno why its "deprecated"
        super.onAttach(activity);
        onPeriodSendListener = (onPeriodSendListener) activity;
    }
}
