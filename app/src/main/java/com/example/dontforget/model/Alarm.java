package com.example.dontforget.model;

import java.util.Calendar;

public class Alarm implements IAlarm {
    protected String caption;
    // Timestamps
    protected long nextAlarm, interval;
    protected long id;

    public Alarm(Calendar lastDate, Calendar nextDate, String time) {
        // nextAlarm = nextDate + time;
        // interval = nextAlarm - lastDate;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
