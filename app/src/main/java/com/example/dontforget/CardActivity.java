package com.example.dontforget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dontforget.presenter.CardPresenter;

/**
 * Detailed card's page
 * Contains caption, description and list of alarms
 * Also contains button to create new alarm
 */
public class CardActivity extends AppCompatActivity {
    protected final String errorMessageNoSuchCard = "There is no such card!";
    protected long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        // Get card's id from intent
        String idAsString = getIntent().getStringExtra("CARD_ID");
        if (null == idAsString) {
            finish();
            Toast.makeText(this, errorMessageNoSuchCard, Toast.LENGTH_SHORT).show();
        } else {
            id = Long.parseLong(idAsString);
        }

        // Draw card info and alarms list
        CardPresenter presenter = new CardPresenter(CardActivity.this, id);
        presenter.showCardInfo((TextView) findViewById(R.id.textViewCaption), (TextView) findViewById(R.id.textViewDescription));
        presenter.switchEmptinessMessage((TextView) findViewById(R.id.emptinessMessageAlarms));
        presenter.showAlarms((RecyclerView) findViewById(R.id.recyclerViewAlarmsList));

        // Set listener at add button
        findViewById(R.id.buttonAddAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardActivity.this, CreatingAlarmActivity.class);
                intent.putExtra("CARD_ID", String.valueOf(id));
                startActivity(intent);
            }
        });
    }
}
