package ru;

import java.awt.EventQueue;

public class MessageFrame extends Thread {
    public static Frame frame;


    public void run() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame = new Frame();
            }
        });
    }
}

