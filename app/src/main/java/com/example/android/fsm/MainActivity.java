package com.example.android.fsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean AlarmDisarmed_AllUnlocked = true;

    boolean AlarmDisarmed_AllLocked = false;

    boolean AlarmArmed_AllLocked = false;

    boolean AlarmDisarmed_DriverUnlocked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    //method for button LOCK
    public void lock (View view) {

        if (AlarmDisarmed_AllUnlocked) {

            AlarmDisarmed_AllUnlocked = false;

            AlarmDisarmed_AllLocked = true;
        }

        if (AlarmDisarmed_DriverUnlocked) {

            AlarmDisarmed_DriverUnlocked = false;
            AlarmArmed_AllLocked = true;

        }

        if (AlarmDisarmed_AllLocked) {

        }

        if (AlarmArmed_AllLocked) {


        }

        displayStatus();
    }


    //method for button LOCKx2
    public void lock_double(View view) {

        if (AlarmDisarmed_AllUnlocked){

            AlarmDisarmed_AllUnlocked = false;
            AlarmArmed_AllLocked = true;
        }

        if (AlarmDisarmed_DriverUnlocked){

            AlarmDisarmed_DriverUnlocked = false;
            AlarmArmed_AllLocked = true;
        }

        if (AlarmDisarmed_AllLocked) {

            AlarmDisarmed_AllLocked = false;
            AlarmArmed_AllLocked = true;
        }

        displayStatus();
    }

    //method for button UNLOCK
    public void unlock(View view) {

        if (AlarmDisarmed_AllLocked) {

            AlarmDisarmed_AllLocked = false;
            AlarmDisarmed_DriverUnlocked = true;
        }

        if (AlarmArmed_AllLocked) {

            AlarmArmed_AllLocked = false;
            AlarmDisarmed_DriverUnlocked = true;

        }

        displayStatus();
    }


    //method for button UNLOCKx2
    public void unlock_double(View view) {

        if (AlarmDisarmed_AllLocked) {

            AlarmDisarmed_AllLocked = false;
            AlarmDisarmed_AllUnlocked = true;
        }

        if (AlarmArmed_AllLocked) {

            AlarmArmed_AllLocked = false;
            AlarmDisarmed_AllUnlocked = true;
        }


        displayStatus();
    }

    //this method displays the state of the alarm (red for armed, green for disarmed)
    // and the state of the doors
    private void displayStatus() {
        final TextView statusTextView = (TextView) findViewById(R.id.current_status);

        String status;

        if(AlarmDisarmed_AllUnlocked){
            status = getString(R.string.all_unlocked);
        }
        else if (AlarmDisarmed_DriverUnlocked) {
            status = getString(R.string.driver_unlocked);
        }
        else {
            status = getString(R.string.all_locked);
        }


        if (AlarmArmed_AllLocked){
            statusTextView.setBackgroundResource(R.color.colorArmed);
        } else {
            statusTextView.setBackgroundResource(R.color.colorDisarmed);
        }

        statusTextView.setText(status);

    }


}