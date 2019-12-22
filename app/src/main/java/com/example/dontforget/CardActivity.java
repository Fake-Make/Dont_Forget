package com.example.dontforget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        long id = 0;
        String idAsString = getIntent().getStringExtra("CARD_ID");
        if (null == idAsString) {
            finish();
            Toast.makeText(this, errorMessageNoSuchCard, Toast.LENGTH_SHORT).show();
        } else {
            id = Long.parseLong(idAsString);
        }

        CardPresenter presenter = new CardPresenter(CardActivity.this, id);
        presenter.showCardInfo((TextView) findViewById(R.id.textViewCaption), (TextView) findViewById(R.id.textViewDescription));
        presenter.switchEmptinessMessage((TextView) findViewById(R.id.emptinessMessageAlarms));
        //presenter.showCardAlarms();
    }
}
