package ru.planner.services;

import ru.planner.frames.*;
import ru.planner.frames.MainFrame;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ImagesService {

    /** Расположение иконок */
    private static final String ICON_LOCATION = "C:\\Workspace\\MassageAgent\\src\\ru\\";

    /** Карта в которой записано какая иконка к какому фрейму */
    private static final Map<Class, String> CLASS_ICON_MAP = new HashMap<Class, String>() {{
        put(MainFrame.class, "MassageAgent.png");
        put(FrameClear.class, "Clear.jpg");
        put(FrameAdd.class, "Add.png");
        put(FrameMention.class, "Mention.png");
        put(FrameDel.class, "Delete.png");
    }};


    /**
     * Возврашает иконку для конкретного фрейма.
     *
     * @param frameClass класс фрейма.
     * @return иконка.
     */
    public static Image getIcon(Class frameClass) {
        return Toolkit.getDefaultToolkit().getImage(ICON_LOCATION + CLASS_ICON_MAP.get(frameClass));
    }
}
