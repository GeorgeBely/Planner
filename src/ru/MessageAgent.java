package ru;
import ru.planner.frames.MainFrame;
import ru.planner.procedures.Clock;
import ru.planner.procedures.Timer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MessageAgent implements Serializable {

    /** При {true} использовать Timer оповещений */
    public static boolean useTimer = true;

    /** При {true} отображать время в заголовке программы */
    public static boolean useClock = true;

    /** Сохранённые задачи */
    public static List<Message> massTask = new ArrayList<Message>();

    /** Основной фрейм */
    public static MainFrame mainFrame;


    public static void main(String args[]) throws IOException {
        mainFrame = new MainFrame();

        new Timer().start();
        new Clock().start();
    }
}
