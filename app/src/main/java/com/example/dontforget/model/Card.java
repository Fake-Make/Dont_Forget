package com.example.dontforget.model;


public class Card implements ICard {
    protected String caption, description;
    protected Alarms<Alarm> alarms;
    protected long id;

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
}
