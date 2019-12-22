package com.example.dontforget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dontforget.presenter.CreatingAlarmPresenter;
import com.example.dontforget.presenter.CreatingCardPresenter;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Shows alarm's fields: caption prev- and next-date, time
 * Also contains two control buttons: cancel and create
 */
public class CreatingAlarmActivity extends AppCompatActivity {
    protected final String messageAlarmCreated = "Alarm is created!";
    protected final String errorMessageNoSuchCard = "There is no such card!";
    protected final String messageCaptionRequired = "Caption is required!";
    protected final String messageLastMustBeEarlierThanNext = "Last date must be earlier than next date!";

    protected long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_alarm);

        // Get card's id from intent
        String idAsString = getIntent().getStringExtra("CARD_ID");
        if (null == idAsString) {
            Toast.makeText(this, errorMessageNoSuchCard, Toast.LENGTH_SHORT).show();
            finish();
        } else {
            id = Long.parseLong(idAsString);
        }

        // Set listener at addAlarmButton
        ((CalendarView) findViewById(R.id.calendarViewNextDate)).setOnDateChangeListener(new MyCalendarListener());
        ((CalendarView) findViewById(R.id.calendarViewLastDate)).setOnDateChangeListener(new MyCalendarListener());
        findViewById(R.id.buttonAddAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatingAlarmPresenter presenter = new CreatingAlarmPresenter(CreatingAlarmActivity.this, id);

                // Transfer data to presenter
                presenter.setCaption((EditText) findViewById(R.id.editTextAlarmCaption));
                presenter.setLastDate((CalendarView) findViewById(R.id.calendarViewLastDate));
                presenter.setNextDate((CalendarView) findViewById(R.id.calendarViewNextDate));
                presenter.setTime((TimePicker) findViewById(R.id.timePickerAlarmTime));

                // Check presenter's response
                switch (presenter.createAlarm()) {
                    case 0:
                        Toast.makeText(CreatingAlarmActivity.this, messageAlarmCreated, Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case 1:
                        Toast.makeText(CreatingAlarmActivity.this, messageCaptionRequired, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(CreatingAlarmActivity.this, messageLastMustBeEarlierThanNext, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(CreatingAlarmActivity.this, "Unknown error occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    protected class MyCalendarListener implements CalendarView.OnDateChangeListener {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            Calendar calendar = new GregorianCalendar(year, month, dayOfMonth);
            view.setDate(calendar.getTimeInMillis());
        }
    }
}
