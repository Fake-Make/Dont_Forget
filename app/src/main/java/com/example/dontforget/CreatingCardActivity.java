package com.example.dontforget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dontforget.presenter.APresenter;
import com.example.dontforget.presenter.CreatingCardPresenter;

/**
 * Shows card's fields: caption and description
 * Also contains two control buttons: cancel and create
 */
public class CreatingCardActivity extends AppCompatActivity {
    private final String messageCardCreated = "Card is created!";
    private final String messageCaptionRequired = "At least caption is required!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_card);

        // Add listener for creating new card
        findViewById(R.id.buttonCreateCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatingCardPresenter presenter = new CreatingCardPresenter(CreatingCardActivity.this);

                presenter.setCaption((EditText) findViewById(R.id.editTextCaption));
                presenter.setDescription((EditText) findViewById(R.id.editTextDescription));

                switch (presenter.createCard()) {
                    case 0:
                        Toast.makeText(CreatingCardActivity.this, messageCardCreated, Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case 1:
                        Toast.makeText(CreatingCardActivity.this, messageCaptionRequired, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
