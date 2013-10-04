package ru;
import java.io.*;

public class MessageAgent implements Serializable {
    public static void main(String args[]) throws IOException {
        File f = new File("SavePlans.txt");
        if (!f.exists()) f.createNewFile();
        MessageFrame p1 = new MessageFrame();
        p1.start();
        Timer p2 = new Timer();
        p2.start();
        Clock p3 = new Clock();
        p3.start();
    }
}
