package com.example.dontforget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Shows alarm's fields: caption prev- and next-date, time
 * Also contains two control buttons: cancel and create
 */
public class CreatingAlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_alarm);
    }
}
