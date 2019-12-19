package com.example.dontforget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Detailed card's page
 * Contains caption, description and list of alarms
 * Also contains button to create new alarm
 */
public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
    }
}
