package ru;
import java.io.*;

public class MessageAgent implements Serializable {
    public static File valuesFile = new File("SavePlans.ma");

    public static void main(String args[]) throws IOException {
        if (!valuesFile.exists())
            if(valuesFile.createNewFile())
                new ObjectOutputStream(new FileOutputStream(MessageAgent.valuesFile)).writeObject(0);

        new MessageFrame().start();

        while (true) {
            if (MessageFrame.frame != null) {
                new Timer().start();
                new Clock().start();
                break;
            }
        }
    }
}
