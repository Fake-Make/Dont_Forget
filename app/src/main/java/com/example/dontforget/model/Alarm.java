package com.example.dontforget.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Alarm implements IAlarm, IUniqueItem, Serializable {
    protected String caption;
    // Timestamps
    protected long nextAlarm, interval;
    protected long id;

    public Alarm(String caption, long lastDate, long nextDate, long time) {
        // Get data
        this.caption = caption;
        interval = nextDate - lastDate;
        nextAlarm = nextDate + time;
        id = System.currentTimeMillis();

        // Fix nextAlarm if it has past time
        long now = System.currentTimeMillis();
        for (; nextAlarm < now; nextAlarm += interval);

        // Starting service with notifications
        startAlarm();
    }

    public String getCaption() {
        return caption;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
