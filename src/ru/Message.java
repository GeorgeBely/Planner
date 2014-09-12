package ru;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private Date date;
    private String theme;
    private String text;
    private String time;

    public Message(Date d, String t, String tx, String ti) {
        date = d;
        theme = t;
        text = tx;
        time = ti;
    }

    public String getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }

    public String getTheme() {
        return theme;
    }

    public String getText() {
        return text;
    }


    public String toString() {
        return date.toString() + " " + theme + "\n " + text + "\n";
    }
}