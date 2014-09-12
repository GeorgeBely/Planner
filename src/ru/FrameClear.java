package ru;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.*;

class FrameClear extends JFrame {
    private int Width;
    private int Height;
    private int screenWidth;
    private int screenHeight;
    private String name;
    private JPanel panel;

    public FrameClear() {
        Width = 300;
        Height = 100;
        name = "\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C";
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        setLocation(screenWidth / 2 - Width / 2, screenHeight / 2 - Height / 2);
        setSize(Width, Height);
        setTitle(name);
        setResizable(false);
        toFront();
        setVisible(true);
        Image img = kit.getImage("C:\\Workspace\\MassageAgent\\src\\ru\\Clear.jpg");
        setIconImage(img);
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);
        add(panel);
        JLabel label = new JLabel("\u0412\u044B \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0442\u0435\u043B\u044C\u043D\u043E \u0445\u043E\u0442\u0438\u0442\u0435 \u0443\u0434\u0430\u043B\u0438\u0442\u044C \u0432\u0441\u0435 \u0437\u0430\u0434\u0430\u0447\u0438?");
        label.setBounds(5, 5, 290, 15);
        panel.add(label);
        JButton buttonOK = new JButton("\u0414\u0430");
        buttonOK.setBounds(60, 30, 80, 30);
        panel.add(buttonOK);
        JButton buttonClose = new JButton("\u041D\u0435\u0442");
        buttonClose.setBounds(160, 30, 80, 30);
        panel.add(buttonClose);


        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameAdd.massTask.clear();
                try {
                    ObjectOutputStream bin = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Public\\SavePlans.txt"));
                    bin.writeObject(FrameAdd.massTask);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
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