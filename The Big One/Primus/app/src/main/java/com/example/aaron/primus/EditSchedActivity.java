package com.example.aaron.primus;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditSchedActivity extends AppCompatActivity implements View.OnClickListener {
    EditText periodDay;
    EditText periodStart;
    EditText periodEnd;
    EditText periodTitle;
    String tempDay;
    int tempStart;
    int tempEnd;
    String tempTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sched);
        periodDay = (EditText) findViewById(R.id.editPeriodDay);
        periodStart = (EditText) findViewById(R.id.editStartTime);
        periodEnd = (EditText) findViewById(R.id.editEndTime);
        periodTitle = (EditText) findViewById(R.id.editPeriodTitle);
        Button buttonAddPeriod = (Button) findViewById(R.id.buttonAddPeriod);
        buttonAddPeriod.setOnClickListener(this);
        Button buttonDeletePeriod = (Button) findViewById(R.id.buttonDeletePeriod);
        buttonDeletePeriod.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //do what you want to do when button is clicked
        switch (view.getId()) {
            case R.id.buttonAddPeriod:
                tempDay = periodDay.getText().toString();
                tempStart = Integer.parseInt(periodStart.getText().toString());//parse to turn string to int. try-catch add later
                tempEnd = Integer.parseInt(periodEnd.getText().toString());
                tempTitle = periodTitle.getText().toString();
                Intent returnPeriodInfo = new Intent();
                Bundle extras = new Bundle();//bundle used so we can send many at once
                extras.putString("Day", tempDay);
                extras.putInt("Start", tempStart);
                extras.putInt("End", tempEnd);
                extras.putString("Title", tempTitle);
                extras.putString("Do What", "add");//so main knows if it is adding or deleting a period
                returnPeriodInfo.putExtras(extras);
                setResult(RESULT_OK, returnPeriodInfo);//sent result back to MainActivity
                finish();
                break;
            case R.id.buttonDeletePeriod:
                tempDay = periodDay.getText().toString();
                tempStart = Integer.parseInt(periodStart.getText().toString());
                tempEnd = Integer.parseInt(periodEnd.getText().toString());
                tempTitle = periodTitle.getText().toString();
                Intent DeletePeriodInfo = new Intent();
                Bundle extras2 = new Bundle();
                extras2.putString("Day", tempDay);
                extras2.putInt("Start", tempStart);
                extras2.putInt("End", tempEnd);
                extras2.putString("Title", tempTitle);
                extras2.putString("Do What", "delete");
                DeletePeriodInfo.putExtras(extras2);
                setResult(RESULT_OK, DeletePeriodInfo);
                finish();
                break;
        }
    }

}
