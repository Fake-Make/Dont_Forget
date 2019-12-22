package com.example.dontforget.presenter;

import android.content.Context;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.dontforget.R;
import com.example.dontforget.model.Alarm;
import com.example.dontforget.model.Alarms;
import com.example.dontforget.model.Card;
import com.example.dontforget.model.Cards;

public class CreatingAlarmPresenter extends APresenter implements IPresenter {
    protected String caption;
    protected final long millsInDay = 86400000;
    protected long lastDate, nextDate, time;
    protected long id;

    public CreatingAlarmPresenter(Context context, long id) {
        parent = context;
        this.id = id;
        cardsList = new Cards<>(getFile(context));
    }

    public void setCaption(EditText editTextAlarmCaption) {
        caption = editTextAlarmCaption.getText().toString();
    };

    public void setLastDate(CalendarView calendarViewLastDate) {
        long t = calendarViewLastDate.getDate();
        lastDate = t - t % millsInDay;
    }

    public void setNextDate(CalendarView calendarViewNextDate) {
        long t = calendarViewNextDate.getDate();
        nextDate = t - t % millsInDay;
    }

    public void setTime(TimePicker timePicker) {
        time = timePicker.getHour() * 1000 * 60 * 60 + timePicker.getMinute() * 1000 * 60;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int createAlarm() {
        if (null == caption || 0 >= caption.length())
            return 1;

        if (lastDate >= nextDate)
            return 2;

        try {
            // Take
            Card tempCard = cardsList.getById(id);
            // Change
            Alarm tempAlarm = new Alarm(lastDate, nextDate, time);
            tempAlarm.setCaption(caption);
            Alarms<Alarm> tempAlarms = tempCard.getAlarms();
            if (null == tempAlarms || null == tempAlarms.getList())
                tempAlarms = new Alarms<>();
            tempAlarms.add(tempAlarm);
            tempCard.setAlarms(tempAlarms);
            // Rewrite
            //cardsList.updateById(id, tempCard);
            cardsList.save();
        } catch (Exception e) {
            e.getStackTrace();
            return 3;
        }

        return 0;
    }


}
