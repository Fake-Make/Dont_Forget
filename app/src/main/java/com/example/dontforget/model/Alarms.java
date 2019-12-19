package com.example.dontforget.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Alarms<T extends Alarm> extends ADataSet<T> implements IDataSet<T>, Serializable {
    public Alarms() {
        itemsList = new ArrayList<>();
    }

    public Alarms(List<T> alarmsList) {
        itemsList = alarmsList;
    }

    @Override
    public void save() {
        // Not available for Alarms
    }

    @Override
    public boolean load() {
        return false;
    }
}
