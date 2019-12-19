package com.example.dontforget.model;

import java.util.List;

public interface IDataSet<T> {
    T getById(long id);
    void updateById(long id, T item);
    void deleteById(long id);
    void add(T item);
    List<T> getList();

    void save();
    void load();
}
