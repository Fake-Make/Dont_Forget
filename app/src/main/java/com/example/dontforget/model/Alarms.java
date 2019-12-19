package com.example.dontforget.model;

import java.util.ArrayList;
import java.util.List;

public class Alarms<T extends Alarm> implements IDataSet<T> {
    List<T> alarmsList;

    public Alarms() {
        alarmsList = new ArrayList<>();
    }

    public Alarms(List<T> alarmsList) {
        this.alarmsList = alarmsList;
    }

    @Override
    public T getById(long id) {
        for (T item : alarmsList) {
            if (id == item.id)
                return item;
        }
        return null;
    }

    public int searchById(long id) {
        for (int i = 0; i < alarmsList.size(); i++) {
            if (id == alarmsList.get(i).id)
                return i;
        }
        return -1;
    }

    @Override
    public void updateById(long id, T item) {
        int existingItemIdx = searchById(id);
        if (-1 == existingItemIdx)
            return;

        alarmsList.set(existingItemIdx, item);
    }

    @Override
    public void deleteById(long id) {
        int existingItemIdx = searchById(id);
        if (-1 == existingItemIdx)
            return;

        alarmsList.remove(existingItemIdx);
    }

    @Override
    public void add(T item) {
        alarmsList.add(item);
    }

    @Override
    public List<T> getList() {
        return alarmsList;
    }

    @Override
    public void save() {
        // Not available for Alarms
    }

    @Override
    public void load() {
        // Not available for Alarms
    }
}
