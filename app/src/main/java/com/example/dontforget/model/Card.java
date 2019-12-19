package com.example.dontforget.model;


import java.io.Serializable;

public class Card implements ICard, IUniqueItem, Serializable {
    protected String caption, description;
    protected Alarms<Alarm> alarms;
    protected long id;

    public Card(String caption, String description) {
        this.caption = caption;
        this.description = description;
        id = System.currentTimeMillis();
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
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
