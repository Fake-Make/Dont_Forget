package com.example.dontforget.model;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.dontforget.MainActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Cards<T extends Card> extends ADataSet<T> implements IDataSet<T> {
    private File file;
    private final String fileNameToOpen = "dont_forget.db";

    public Cards(File file) {
        itemsList = new ArrayList<>();

        this.file = new File(file, fileNameToOpen);
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.getStackTrace();
        }
        load();
    }

    public Cards(File file, List<T> cardsList) {
        itemsList = cardsList;

        this.file = new File(file, fileNameToOpen);
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.getStackTrace();
        }
        save();
    }

    @Override
    public void updateById(long id, T item) {
        super.updateById(id, item);
        save();
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        save();
    }

    @Override
    public void add(T item) {
        super.add(item);
        save();
    }

    @Override
    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(itemsList);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
    };

    @Override
    public boolean load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            List<T> itemsListTemp = (List<T>) in.readObject();
            if (0 < itemsListTemp.size())
                itemsList = itemsListTemp;
            return true;
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        }
        return false;
    }
}
