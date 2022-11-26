package com.luminate.simplereminder;

public class model {
    private String title;
    private String event;
    private String date;
    private String key;

    public model()
    {

    }

    public model(String title, String event, String date) {
        this.title = title;
        this.event = event;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
