package ru;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class FrameMention extends JFrame {
    private int Width;
    private int Height;
    private int screenWidth;
    private int screenHeight;
    private int i;
    private String name;
    private JPanel panel;

    public FrameMention() {
        Width = 300;
        Height = 250;
        name = "Mention";
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        setLocation(screenWidth / 2 - Width / 2, screenHeight / 2 - Height / 2);
        setSize(Width, Height);
        setTitle(name);
        setResizable(false);
        Image img = kit.getImage("C:\\Workspace\\MassageAgent\\src\\ru\\Mention.png");
        setIconImage(img);
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);
        add(panel);
        TextField textTheme = new TextField();
        textTheme.setBounds(25, 5, 245, 20);
        panel.add(textTheme);
        TextArea text = new TextArea();
        text.setBounds(15, 35, 265, 140);
        panel.add(text);
        JButton button = new JButton("OK");
        button.setBounds(95, 180, 100, 30);
        panel.add(button);
        textTheme.setText(FrameAdd.massTask[Timer.i].getTheme());
        text.setText(FrameAdd.massTask[Timer.i].getText());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}