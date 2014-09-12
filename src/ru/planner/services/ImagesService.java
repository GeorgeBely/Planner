package ru.planner.services;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImagesService {

    /** ������������ ������ */
    private static final String ICON_LOCATION = "C:\\Workspace\\MassageAgent\\src\\ru\\";

    /** ����� � ������� �������� ����� ������ � ������ ������ */
    private static final Map<Class, String> CLASS_ICON_MAP = new HashMap<Class, String>() {{
        put(Frame.class, "MassageAgent.png");
    }};


    /**
     * ���������� ������ ��� ����������� ������.
     *
     * @param frameClass ����� ������.
     * @return ������.
     */
    public static Image getIcon(Class frameClass) {
        return Toolkit.getDefaultToolkit().getImage(ICON_LOCATION + CLASS_ICON_MAP.get(frameClass));
    }
}
