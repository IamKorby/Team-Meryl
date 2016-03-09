package com.example.aaron.primus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Global set so it can be used everywhere in main
    NavigationView navigationView = null;
    Toolbar toolbar = null;
    Schedule mySchedule;//serves as the users own schedule


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create blank schedule (later populated when database is implemented)
        mySchedule = new Schedule();
        //Set the Dashboard fragment initially and commits it
        android.app.FragmentManager fragmentManager = getFragmentManager();
        DashboardFragment fragment = new DashboardFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("DASHBOARD");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Options items
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "CHECK", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragmentHolder = new Fragment();//Used to hold the current fragment
        int id = item.getItemId();
        //Each fragment replaces the previous fragment
        if (id == R.id.nav_dashboard) {
            fragmentHolder = new DashboardFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragmentHolder);
            toolbar.setSubtitle("DASHBOARD");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_schedule) {
            fragmentHolder = new ScheduleFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragmentHolder);
            toolbar.setSubtitle("SCHEDULE");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_imports) {
            fragmentHolder = new ImportsFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragmentHolder);
            toolbar.setSubtitle("IMPORTS");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_events) {
            fragmentHolder = new EventsFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragmentHolder);
            toolbar.setSubtitle("EVENTS");
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        String doWhat = data.getStringExtra("Do What");
        switch(doWhat){
            case "add":
                setPeriodInfo(data.getStringExtra("Day"), data.getIntExtra("Start", 0), data.getIntExtra("End", 0), data.getStringExtra("Title"));
                Toast.makeText(getApplicationContext(), "Period Added", Toast.LENGTH_SHORT).show();//pop-up to show its done
                break;
            case "delete":
                deletePeriod(data.getStringExtra("Day"), data.getIntExtra("Start", 0), data.getIntExtra("End", 0), data.getStringExtra("Title"));
                Toast.makeText(getApplicationContext(), "Period Deleted", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //unique methods start here

    public void setPeriodInfo(String day, int start, int end, String title){//adds periods to schedule
        mySchedule.addNewPeriod(day, start, end, title);
    }

    public void deletePeriod(String day, int start, int end, String title){
        mySchedule.deletePeriod(day, start, end, title);
    }

    public Schedule getMySchedule(){//Sends the schedules to other fragments for viewing and comparing
        return mySchedule;
    }

}
