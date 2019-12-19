package com.example.dontforget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Shows card's fields: caption and description
 * Also contains two control buttons: cancel and create
 */
public class CreatingCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_card);
    }
}
