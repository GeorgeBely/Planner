package ru;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MessageAgent implements Serializable {

    /** ��� {true} ������������ Timer ���������� */
    public static boolean useTimer = true;

    /** ��� {true} ���������� ����� � ��������� ��������� */
    public static boolean useClock = true;

    /** ���������� ������ */
    public static List<Message> massTask = new ArrayList<Message>();

    /** �������� ����� */
    public static Frame frame;


    public static void main(String args[]) throws IOException {
        frame = new Frame();

        new Timer().start();
        new Clock().start();
    }
}
