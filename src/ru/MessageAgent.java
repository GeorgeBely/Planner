package ru;
import ru.planner.frames.MainFrame;
import ru.planner.procedures.Clock;
import ru.planner.procedures.Timer;

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
    public static MainFrame mainFrame;


    public static void main(String args[]) throws IOException {
        mainFrame = new MainFrame();

        new Timer().start();
        new Clock().start();
    }
}
