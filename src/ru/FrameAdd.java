package ru;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*; // Referenced classes of package ru: //

public class FrameAdd extends JFrame {
    public static List<Message> massTask = new ArrayList<Message>();
    private static JFormattedTextField date;
    private static JFormattedTextField time;
    private static TextField theme;
    private static TextArea text;

    public FrameAdd() {
        int width = 300;
        int height = 380;
        String name = "\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0437\u0430\u0434\u0430\u0447\u0443";
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setLocation(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2);
        setSize(width, height);
        setTitle(name);
        setResizable(false);
        toFront();
        setVisible(true);
        Image img = kit.getImage("C:\\Workspace\\MassageAgent\\src\\ru\\Add.png");
        setIconImage(img);
        JPanel panel = new JPanel();
        panel.setFocusable(true);
        panel.setLayout(null);
        add(panel);
        JLabel labelDate = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043D\u0443\u0436\u043D\u0443\u044E \u0434\u0430\u0442\u0443");
        labelDate.setBounds(15, 0, 300, 15);
        panel.add(labelDate);
        DateFormat formatdate = DateFormat.getDateTimeInstance(2, 3);
        formatdate.setLenient(false);
        date = new JFormattedTextField(formatdate);
        date.setBounds(120, 15, 105, 20);
        date.setValue(new Date());
        panel.add(date);
        JLabel labelTheme = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0442\u0435\u043C\u0443");
        labelTheme.setBounds(110, 40, 100, 15);
        panel.add(labelTheme);
        theme = new TextField();
        theme.setBounds(25, 55, 245, 20);
        panel.add(theme);
        JLabel labelText = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0442\u0435\u043A\u0441\u0442");
        labelText.setBounds(110, 80, 100, 15);
        panel.add(labelText);
        text = new TextArea();
        text.setBounds(15, 100, 265, 150);
        panel.add(text);
        JLabel labelTime = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0434\u0430\u0442\u0443 \u0432\u044B\u0432\u043E\u0434\u0430 \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F:");
        labelTime.setBounds(30, 260, 250, 20);
        panel.add(labelTime);
        final DateFormat formattime = DateFormat.getDateTimeInstance(2, 3);
        formattime.setLenient(false);
        time = new JFormattedTextField(formattime);
        time.setBounds(120, 280, 105, 20);
        time.setValue(new Date());
        panel.add(time);
        JButton buttonOK = new JButton("OK");
        buttonOK.setBounds(90, 305, 90, 30);
        panel.add(buttonOK);
        JButton buttonClose = new JButton("\u0417\u0430\u043A\u0440\u044B\u0442\u044C");
        buttonClose.setBounds(190, 305, 90, 30);
        panel.add(buttonClose);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!FrameAdd.theme.getText().equals("")) {
                    try {
                        FrameAdd.massTask.add(new Message(formattime.parse(date.getText()), FrameAdd.theme.getText(), FrameAdd.text.getText(), FrameAdd.time.getText()));
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                    Date datenow = new Date();
                    FrameAdd.date.setText(dateFormat.format(datenow));
                    FrameAdd.time.setText(dateFormat.format(datenow));
                    FrameAdd.text.setText("");
                    FrameAdd.theme.setText("");
                    try {
                        ObjectOutputStream bin = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Public\\SavePlans.txt"));
                        bin.writeObject(FrameAdd.massTask);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });


        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}