package com.example.dontforget.model;

import java.io.Serializable;
import java.util.Calendar;

public class Alarm implements IAlarm, IUniqueItem, Serializable {
    protected String caption;
    // Timestamps
    protected long nextAlarm, interval;
    protected long id;

    public Alarm(long lastDate, long nextDate, long time) {
        interval = nextDate - lastDate;
        nextAlarm = nextDate + time;
        id = System.currentTimeMillis();
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
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
