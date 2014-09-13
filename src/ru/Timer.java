package ru;

import ru.planner.utils.DateUtils;

import java.awt.EventQueue;
import java.util.Date;

public class Timer extends Thread {

    public void run() {
        while (MessageAgent.useTimer) {
            for (final Message message : MessageAgent.massTask) {
                if (message != null && message.getTime().equals(DateUtils.DATE_FORMAT.format(new Date()))) {
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new FrameMention(message);
                        }
                    });
                }
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}