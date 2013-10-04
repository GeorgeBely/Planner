package ru;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package ru: // MassageFrame, Frame

public class Clock extends Thread {
    public Clock() {
    }

    public void run() {
        do {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy EEEE HH:mm:ss");
            Date date = new Date();
            try {
                MessageFrame.frame.setTitle(dateFormat.format(date));
            } catch (Exception exception) {
            }
            try {
                Thread.sleep(100L);
            } catch (Exception exception1) {
            }
        } while (true);
    }

    public static int i;
}

