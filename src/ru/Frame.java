package ru;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Frame extends JFrame implements Serializable {

    private int Width;
    private int Height;
    private int screenWidth;
    private int screenHeight;
    private int count;
    public static int p ;
    public static int point;
    private JPanel panel;
    private JFormattedTextField date;
    public static TextArea text;

    public Frame() throws IOException, ClassNotFoundException {
        Width = 500;
        Height = 260;
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        setLocation(screenWidth / 2 - Width / 2, screenHeight / 2 - Height / 2);
        setSize(Width, Height);
        setResizable(false);
        Image img = kit.getImage("C:\\Workspace\\MassageAgent\\src\\ru\\MassageAgent.png");
        setIconImage(img);
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);
        add(panel);
        panel.setBackground(Color.white);
        JButton buttonAdd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0437\u0430\u0434\u0430\u0447\u0438");
        buttonAdd.setBounds(270, 5, 220, 30);
        panel.add(buttonAdd);
        JButton buttonDate = new JButton("\u041F\u0440\u043E\u0441\u043C\u043E\u0442\u0440\u0435\u0442\u044C \u0437\u0430\u0434\u0430\u0447\u0438 \u043D\u0430 \u0434\u0435\u043D\u044C");
        buttonDate.setBounds(270, 40, 220, 30);
        panel.add(buttonDate);
        JButton buttonDelete = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C/\u0418\u0437\u043C\u0435\u043D\u0438\u0442\u044C \u0437\u0430\u0434\u0430\u0447\u0443");
        buttonDelete.setBounds(270, 75, 220, 30);
        panel.add(buttonDelete);
        JButton buttonVivod = new JButton("\u041F\u0440\u043E\u0441\u043C\u043E\u0442\u0440\u0435\u0442\u044C \u0432\u0441\u0435 \u0437\u0430\u0434\u0430\u0447\u0438");
        buttonVivod.setBounds(270, 110, 220, 30);
        panel.add(buttonVivod);
        JButton buttonClear = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C");
        buttonClear.setBounds(270, 145, 220, 30);
        panel.add(buttonClear);
        text = new TextArea();
        text.setBounds(5, 5, 260, 220);
        panel.add(text);
        JLabel labelDate = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0434\u0430\u0442\u0443");
        labelDate.setBounds(300, 180, 210, 15);
        panel.add(labelDate);
        DateFormat formatdate = DateFormat.getDateInstance(2);
        formatdate.setLenient(false);
        date = new JFormattedTextField(formatdate);
        date.setBounds(350, 195, 105, 20);
        date.setValue(new Date());
        panel.add(date);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Public\\SavePlans.txt"));
            p = (Integer) ois.readObject();
            for (int i = 0; i < p; i++)
                FrameAdd.massTask[i] = (Message) ois.readObject();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date datenow = new Date();
        text.setText("\u0417\u0430\u0434\u0430\u0447\u0438 \u043D\u0430 \u0441\u0435\u0433\u043E\u0434\u043D\u044F:\n");
        for (int i = 0; i < p; i++)
            if (FrameAdd.massTask[i].getDate().length() > 10 && FrameAdd.massTask[i].getDate().substring(0, 10).equals(dateFormat.format(datenow))) {
                text.append((new StringBuilder(String.valueOf(FrameAdd.massTask[i].getDate()))).append(" ").append(FrameAdd.massTask[i].getTheme()).append("\n").append(" ").append(FrameAdd.massTask[i].getText()).append("\n").toString());
                count++;
            }
        if (count == 0)
            text.setText("\u041D\u0430 \u0441\u0435\u0433\u043E\u0434\u043D\u044F \u043F\u043B\u0430\u043D\u043E\u0432 \u043D\u0435\u0442.");

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        FrameAdd frame = new FrameAdd();
                        frame.toFront();
                        frame.setVisible(true);
                    }
                });
            }
        });

        buttonDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame.text.setText("");

                for(int i = 0; i < p; i++) {
                    if(FrameAdd.massTask[i].getDate().substring(0, 10).equals(date.getText())) {
                        Frame.text.setText(Frame.text.getText() + FrameAdd.massTask[i].getDate() + " " + FrameAdd.massTask[i].getTheme() + "\n" + "          " + FrameAdd.massTask[i].getText() + "\n");
                    }
                }
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        FrameDel frame = new FrameDel();
                        frame.toFront();
                        frame.setVisible(true);
                    }
                });
            }
        });

        buttonVivod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame.text.setText("");

                for(int i = 0; i < p; i++) {
                    Frame.text.append(FrameAdd.massTask[i].getDate() + " " + FrameAdd.massTask[i].getTheme() + "\n" + "          " + FrameAdd.massTask[i].getText() + "\n");
                }

                if(Frame.p == 0) {
                    Frame.text.setText("Нет планов.");
                }
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame.text.setText("");
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        FrameClear frame = new FrameClear();
                        frame.toFront();
                        frame.setVisible(true);
                    }
                });
            }
        });
    }
}