package ru;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*; // Referenced classes of package ru: // Message

class FrameChange extends JFrame {
    private int Width;
    private int Height;
    private int screenWidth;
    private int screenHeight;
    private String name;
    private JPanel panel;
    public static Message massTask[] = new Message[100];
    private static JFormattedTextField date;
    private static JFormattedTextField time;
    private static TextField theme;
    private static TextArea text;

    public FrameChange() {
        Width = 300;
        Height = 380;
        name = "\u0418\u0437\u043C\u0435\u043D\u0438\u0442\u044C \u0437\u0430\u0434\u0430\u0447\u0443";
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        setLocation(screenWidth / 2 - Width / 2, screenHeight / 2 - Height / 2);
        setSize(Width, Height);
        setTitle(name);
        setResizable(false);
        Image img = kit.getImage("C:\\Workspace\\MassageAgent\\src\\ru\\Add.png");
        setIconImage(img);
        panel = new JPanel();
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
        DateFormat formattime = DateFormat.getDateTimeInstance(2, 3);
        formattime.setLenient(false);
        time = new JFormattedTextField(formattime);
        time.setBounds(120, 280, 105, 20);
        time.setValue(new Date());
        panel.add(time);
        JButton buttonOK = new JButton("\u0418\u0437\u043C\u0435\u043D\u0438\u0442\u044C");
        buttonOK.setBounds(90, 305, 90, 30);
        panel.add(buttonOK);
        JButton buttonClose = new JButton("\u0417\u0430\u043A\u0440\u044B\u0442\u044C");
        buttonClose.setBounds(190, 305, 90, 30);
        panel.add(buttonClose);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                if (!FrameChange.theme.getText().equals("")) {
//                    FrameChange.massTask[Frame.p] = new Message(FrameChange.date.getText(), FrameChange.theme.getText(), FrameChange.text.getText(), FrameChange.time.getText());
//                    Frame.p = Integer.valueOf(Frame.p + 1);
//                    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
//                    Date datenow = new Date();
//                    FrameChange.date.setText(FrameChange.massTask[FrameDel.number].getDatePlan());
//                    FrameChange.time.setText(dateFormat.format(datenow));
//                    FrameChange.text.setText("");
//                    FrameChange.theme.setText("");
//                    try {
//                        ObjectOutputStream bin = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Public\\SavePlans.txt"));
//                        bin.writeObject(Frame.p);
//                        for (int i = 0; i < Frame.p; i++) bin.writeObject(FrameChange.massTask[i]);
//                    } catch (IOException e1) {
//                        e1.printStackTrace();
//                    }
//                }
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