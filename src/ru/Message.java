package ru;

import ru.planner.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private Date datePlan;
    private String theme;
    private String text;
    private Date dateMention;

    public Message(Date datePlan, String theme, String text, Date dateMention) {
        this.datePlan = datePlan;
        this.theme = theme;
        this.text = text;
        this.dateMention = dateMention;
    }

    public Date getDateMention() {
        return dateMention;
    }

    public Date getDatePlan() {
        return datePlan;
    }

    public String getTheme() {
        return theme;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return DateUtils.DATE_FORMAT.format(datePlan) + " " + theme + "\n " + text + "\n";
    }
}