package ru.planner.frames;

import ru.MessageAgent;
import ru.planner.services.DataService;
import ru.planner.services.ImagesService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrameClear extends JFrame {

    /** ������ ���� */
    private static final int WIDTH = 300;

    /** ������ ���� */
    private static final int HEIGHT = 100;

    /** ������������ ������ */
    private static final String TITLE = "��������";


    public FrameClear() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2 - WIDTH/2, screenSize.height/2 - HEIGHT/2);
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        setResizable(false);
        toFront();
        setVisible(true);
        setIconImage(ImagesService.getIcon(this.getClass()));

        JPanel panel = new JPanel() {{
            setFocusable(true);
            setLayout(null);
        }};
        add(panel);

        JLabel label = new JLabel("�� ������������� ������ ������� ��� ������?") {{
            setBounds(5, 5, 290, 15);
        }};
        panel.add(label);

        JButton buttonOK = new JButton("��") {{
            setBounds(60, 30, 80, 30);
        }};
        panel.add(buttonOK);

        JButton buttonClose = new JButton("���") {{
            setBounds(160, 30, 80, 30);
        }};
        panel.add(buttonClose);


        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MessageAgent.massTask.clear();
                DataService.serializableData();
                dispose();
            }
        });

        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}