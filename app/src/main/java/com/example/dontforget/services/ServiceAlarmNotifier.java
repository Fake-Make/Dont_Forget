package com.example.dontforget.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.dontforget.model.Alarm;
import com.example.dontforget.model.Alarms;
import com.example.dontforget.model.Card;
import com.example.dontforget.model.Cards;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ServiceAlarmNotifier extends Service {
    private Cards<Card> cardsList;
    private List<Alarm> alarmList;

    public ServiceAlarmNotifier() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Load list of alarms
        cardsList = new Cards<Card>(ServiceAlarmNotifier.this.getFilesDir());
        alarmList = new ArrayList<>();
        for (Card item : cardsList.getList()) {
            Alarms<Alarm> alarms = item.getAlarms();
            if (null != alarms && null != alarms.getList() && 0 < alarms.getList().size()) {
                alarmList.addAll(alarms.getList());
            }
        }

        // Start everlasting processing of alarms
        startProcess();
    }

    private void startProcess() {
        while (true) {
            // Check if time has come and make alarm
            int changedCount = 0;
            long curTime = System.currentTimeMillis();
            for (Alarm item : alarmList) {
                if (curTime > item.getNextAlarm()) {
                    item.startAlarm(ServiceAlarmNotifier.this);
                    changedCount++;
                }
            }

            // Well, I hope that all these alarms are really saved
            if (0 < changedCount)
                cardsList.save();

            // Now need to make a pause
            // TODO: Make ACTUAL pause
            try {
                sleep(5000);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
