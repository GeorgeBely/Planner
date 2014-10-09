package ru.planner.services;

import ru.*;
import ru.Frame;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImagesService {

    /** ������������ ������ */
    private static final String ICON_LOCATION = "C:\\Workspace\\MassageAgent\\src\\ru\\";

    /** ����� � ������� �������� ����� ������ � ������ ������ */
    private static final Map<Class, String> CLASS_ICON_MAP = new HashMap<Class, String>() {{
        put(Frame.class, "MassageAgent.png");
        put(FrameClear.class, "Clear.jpg");
        put(FrameAdd.class, "Add.png");
        put(FrameMention.class, "Mention.png");
        put(FrameDel.class, "Delete.png");
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
