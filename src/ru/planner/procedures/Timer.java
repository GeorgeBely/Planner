package ru.planner.procedures;

import ru.Message;
import ru.MessageAgent;
import ru.planner.frames.FrameMention;

import java.awt.EventQueue;
import java.util.Date;

public class Timer extends Thread {

    /**
     * Период через который выполняется процесс. Равен одной секунде.
     */
    private static final int SEK = 60000;

    public void run() {
        while (MessageAgent.useTimer) {
            for (final Message message : MessageAgent.massTask) {
                if (message != null && Math.abs(new Date().getTime() - message.getDateMention().getTime()) < SEK/2) {
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new FrameMention(message);
                        }
                    });
                }
            }
            try {
                Thread.sleep(SEK);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}