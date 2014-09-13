package ru.planner.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /** ������ ������ ���� ��� ������� */
    public static final DateFormat ONLY_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    /** ������ ������ ���� � �������� */
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    /** ������ ������ ���� � ��������� */
    public static final DateFormat DATE_FORMAT_WITH_SECOND = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");


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

    public static Date parseDate(String date) {
        try {
            return DATE_FORMAT.parse(date);
        } catch (Exception e) {
            return null;
        }
    }
}
