package ru;

import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date; // Referenced classes of package ru: // FrameAdd, Message, Frame

public class Timer extends Thread {
    public Timer() {
    }

    public void run() {
        for (i = 0; i < MessageAgent.massTask.size() + 1; i++) {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date date = new Date();
            if (MessageAgent.massTask.get(i) != null && MessageAgent.massTask.get(i).getTime().equals(dateFormat.format(date)))
                EventQueue.invokeLater(new Runnable(){
                    public void run() {
                        FrameMention frame = new FrameMention(MessageAgent.massTask.get(i));
                        frame.toBack();
                        frame.toFront();
                        frame.setVisible(true);
                    }
                });
            try {
                Thread.sleep(10000L);
            } catch (Exception exception) {
            }
        }
    }

    public static int i;
}

//Read more at: http://www.showmycode.com/
