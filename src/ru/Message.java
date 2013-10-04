package ru;

import java.io.Serializable;

class Message implements Serializable {
    public Message(String d, String t, String tx, String ti) {
        date = d;
        theme = t;
        text = tx;
        time = ti;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getTheme() {
        return theme;
    }

    public String getText() {
        return text;
    }

    private String date;
    private String theme;
    private String text;
    private String time;
}