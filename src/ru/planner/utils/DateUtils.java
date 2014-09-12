package ru.planner.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /** ������ ������ ���� ��� ������� */
    public static final DateFormat ONLY_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");


    /**
     * ��������� �������� �� ���� {date} �� �������.
     *
     * @param date ����, ������� ����� ���������.
     * @return {true}, ���� ���� �� �������.
     */
    public static boolean dateAsOfToday(Date date) {
        return date != null && ONLY_DATE_FORMAT.format(date).equals(ONLY_DATE_FORMAT.format(new Date()));
    }

    public static boolean dateAsOfDay(Date date, Date day) {
        return dateAsOfStringDay(date, ONLY_DATE_FORMAT.format(day));
    }

    public static boolean dateAsOfStringDay(Date date, String day) {
        return date != null && ONLY_DATE_FORMAT.format(date).equals(day);
    }
}
