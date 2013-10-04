package ru;

import java.awt.EventQueue;
import java.io.IOException;

public class MessageFrame extends Thread {
    public static Frame frame;

    public MessageFrame() {
    }

    public void run() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MessageFrame.frame = new Frame();
                    MessageFrame.frame.toBack();
                    MessageFrame.frame.setDefaultCloseOperation(3);
                    MessageFrame.frame.setVisible(true);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

