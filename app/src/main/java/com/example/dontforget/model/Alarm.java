package com.example.dontforget.model;

import android.content.Context;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.dontforget.R;

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
    }

    public String getDatetime() {
        Calendar calendar = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat("MMM d, H:m");
        calendar.setTimeInMillis(nextAlarm);
        return dateFormat.format(calendar.getTime());
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

    public long getNextAlarm() {
        return nextAlarm;
    }

    public void startAlarm(Context context) {
        // Change next alarm time
        nextAlarm += interval;

        // Create notification
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, String.valueOf(R.string.app_name))
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(String.valueOf(R.string.app_name))
                        .setContentText(caption)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);
        notificationManager.notify((int) id, builder.build());
    }
}
