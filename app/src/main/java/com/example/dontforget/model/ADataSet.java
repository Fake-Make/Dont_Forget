package com.example.dontforget.model;

import java.io.Serializable;
import java.util.List;

abstract public class ADataSet<T extends IUniqueItem> implements IDataSet<T>, Serializable {
    List<T> itemsList;

    @Override
    public T getById(long id) {
        for (T item : itemsList) {
            if (id == item.getId())
                return item;
        }
        return null;
    }

    public int searchById(long id) {
        for (int i = 0; i < itemsList.size(); i++) {
            if (id == itemsList.get(i).getId())
                return i;
        }
        return -1;
    }

    @Override
    public void deleteById(long id) {
        int existingItemIdx = searchById(id);
        if (-1 == existingItemIdx)
            return;

        itemsList.remove(existingItemIdx);
    }

    @Override
    public void updateById(long id, T item) {
        int existingItemIdx = searchById(id);
        if (-1 == existingItemIdx)
            return;

        item.setId(id);
        itemsList.set(existingItemIdx, item);
    }

    @Override
    public boolean isEmpty() {
        return null == itemsList || 0 >= itemsList.size();
    }

    @Override
    public void add(T item) {
        itemsList.add(item);
    }

    @Override
    public List<T> getList() {
        return itemsList;
    }
}
