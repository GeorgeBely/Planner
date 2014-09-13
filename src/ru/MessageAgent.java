package ru;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MessageAgent implements Serializable {

    /** ��� {true} ������������ Timer ���������� */
    public static boolean useTimer = true;

    /** ���������� ������ */
    public static List<Message> massTask = new ArrayList<Message>();

    public static void main(String args[]) throws IOException {
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
