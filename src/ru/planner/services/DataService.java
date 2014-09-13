package ru.planner.services;

import ru.Message;
import ru.MessageAgent;

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
            MessageAgent.massTask = new ArrayList<Message>();
            File dataFile = new File(LOCATION_FILE_DATA);
            if (!dataFile.exists()) {
                if (dataFile.createNewFile())
                    new ObjectOutputStream(new FileOutputStream(dataFile)).writeObject(MessageAgent.massTask);
                return;
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFile));
            List list = (List) ois.readObject();
            if (list != null && !list.isEmpty()) {
                for (Object obj : list)
                    MessageAgent.massTask.add((Message) obj);
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
            bin.writeObject(MessageAgent.massTask);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
