package com.example.dontforget.model;

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

    public Cards() {
        itemsList = new ArrayList<>();
        file = new File(fileNameToOpen);
        load();
    }

    public Cards(List<T> cardsList) {
        itemsList = cardsList;
        file = new File(fileNameToOpen);
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
