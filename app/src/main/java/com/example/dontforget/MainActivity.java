package com.example.dontforget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dontforget.presenter.IPresenter;
import com.example.dontforget.presenter.MainPresenter;

/**
 * Shows cards list and button to add one
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainPresenter presenter = new MainPresenter();
        presenter.switchEmptinessMessage((TextView) findViewById(R.id.emptinessMessage));
        presenter.showCards((RecyclerView) findViewById(R.id.cardsList));
    }

    public void showList() {
        // presenter.toAnotherActivity(this, )
    }
}
