package com.example.dontforget.model;

import java.util.ArrayList;
import java.util.List;

public class Alarms<T extends Alarm> implements IDataSet<T> {
    List<T> alarms;

    public Alarms() {
        alarms = new ArrayList<>();
    }

    public Alarms(List<T> alarms) {
        this.alarms = alarms;
    }

    @Override
    public T getById(long id) {
        for (T item : alarms) {
            if (id == item.id)
                return item;
        }
        return null;
    }

    public int searchById(long id) {
        for (int i = 0; i < alarms.size(); i++) {
            if (id == alarms.get(i).id)
                return i;
        }
        return -1;
    }

    @Override
    public void updateById(long id, T item) {
        int existingItemIdx = searchById(id);
        if (-1 == existingItemIdx)
            return;

        alarms.set(existingItemIdx, item);
    }

    @Override
    public void deleteById(long id) {
        int existingItemIdx = searchById(id);
        if (-1 == existingItemIdx)
            return;

        alarms.remove(existingItemIdx);
    }

    @Override
    public void add(T item) {
        alarms.add(item);
    }

    @Override
    public List<T> getList() {
        return alarms;
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
