package ru;

import ru.planner.utils.DateUtils;

import java.util.Date;

public class Clock extends Thread {

    public void run() {
        while (MessageAgent.useClock) {
            try {
                MessageFrame.frame.setTitle(DateUtils.DATE_FORMAT_WITH_SECOND.format(new Date()));
                Thread.sleep(1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

