package com.example.dontforget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

/**
 * Shows cards list and button to add one
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // presenter.loadList
    }

    public void showList() {
        // presenter.toAnotherActivity(this, )
    }
}
