package ru.planner.services;

import ru.FrameAdd;
import ru.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataService {

    /** ���� � ����� � ������� ���������� ������������� ������ */
    private static final String LOCATION_FILE_DATA = "C:\\Users\\Public\\SavePlans.ma";


    /**
     * ��������� ������ �� ����������� ����� � �������.
     */
    public static void readData() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LOCATION_FILE_DATA));
            FrameAdd.massTask = new ArrayList<Message>();
            List list = (List) ois.readObject();
            if (list != null && !list.isEmpty()) {
                for (Object obj : list)
                    FrameAdd.massTask.add((Message) obj);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /**
     * ��������� ���� � �������.
     */
    public static void serializableData() {
        try {
            ObjectOutputStream bin = new ObjectOutputStream(new FileOutputStream(LOCATION_FILE_DATA));
            bin.writeObject(FrameAdd.massTask);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
