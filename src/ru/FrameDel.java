package ru;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.*;

class FrameDel extends JFrame {
    public static int number;
    private int Width;
    private int Height;
    private int screenWidth;
    private int screenHeight;
    private static TextField textNum;
    private static TextArea text;
    private String name;
    private JPanel panel;

    public FrameDel() {
        Width = 300;
        Height = 280;
        name = "\u0423\u0434\u0430\u043B\u0438\u0442\u044C/\u0418\u0437\u043C\u0435\u043D\u0438\u0442\u044C \u0437\u0430\u0434\u0430\u0447\u0443";
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
        Image img = kit.getImage("C:\\Workspace\\MassageAgent\\src\\ru\\Delete.png");
        setIconImage(img);
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);
        add(panel);
        JLabel labelText = new JLabel("\u0421\u043E\u0431\u044B\u0442\u0438\u044F");
        labelText.setBounds(110, 5, 100, 15);
        panel.add(labelText);
        text = new TextArea();
        text.setBounds(5, 25, 290, 150);
        panel.add(text);
        JLabel labelDate = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043D\u0443\u0436\u043D\u044B\u0439 \u043D\u043E\u043C\u0435\u0440");
        labelDate.setBounds(30, 180, 140, 15);
        panel.add(labelDate);
        textNum = new TextField();
        textNum.setBounds(185, 180, 50, 20);
        panel.add(textNum);
        JButton buttonChange = new JButton("\u0418\u0437\u043C\u0435\u043D\u0438\u0442\u044C");
        buttonChange.setBounds(5, 205, 90, 30);
        panel.add(buttonChange);
        JButton buttonDel = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
        buttonDel.setBounds(105, 205, 85, 30);
        panel.add(buttonDel);
        JButton buttonClose = new JButton("\u0417\u0430\u043A\u0440\u044B\u0442\u044C");
        buttonClose.setBounds(200, 205, 90, 30);
        panel.add(buttonClose);
        text.setText("");

        for (int i = 0; i < FrameAdd.massTask.size(); i++)
            text.setText((new StringBuilder(String.valueOf(text.getText()))).append(i + 1).append(": ")
                    .append(FrameAdd.massTask.get(i).getDate()).append(" ")
                    .append(FrameAdd.massTask.get(i).getTheme()).append("\n").append(" ")
                    .append(FrameAdd.massTask.get(i).getText()).append("\n").toString());


        buttonChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameDel.number = Integer.parseInt(textNum.getText());
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        FrameChange frame = new FrameChange();
                        frame.toFront();
                        frame.setVisible(true);
                    }
                });
            }
        });

        buttonDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(textNum.getText()) < FrameAdd.massTask.size()) {
//                    FrameDel.access$0(this.this$0, );

                    for(int i = Integer.parseInt(textNum.getText()); i < FrameAdd.massTask.size()-1; i++) {
                        FrameAdd.massTask.set(i, FrameAdd.massTask.get(i+1));
//                        FrameDel.access$0(this.this$0, FrameDel.access$1(this.this$0) + 1);
                    }
                }

                text.setText("");

                for(int i = 0; i < FrameAdd.massTask.size(); i++) {
                    text.setText(text.getText() + i + ": " + FrameAdd.massTask.get(i).getDate() + " " + FrameAdd.massTask.get(i).getTheme() + "\n" + "          " + FrameAdd.massTask.get(i).getText() + "\n");
//                    FrameDel.access$0(this.this$0, FrameDel.access$1(this.this$0) + 1);
                }

                try {
                    ObjectOutputStream e1 = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Public\\SavePlans.txt"));
                    e1.writeObject(FrameAdd.massTask);
                } catch (IOException var4) {
                    var4.printStackTrace();
                }

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