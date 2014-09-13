package ru;

import ru.planner.services.ImagesService;
import ru.planner.services.DataService;
import ru.planner.utils.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Frame extends JFrame {

    /** Высота окна. */
    private static final int WIDTH = 550;

    /** Ширина окна. */
    private static final int HEIGHT = 300;


    private JFormattedTextField date;
    private JTextArea text;


    public Frame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(screenSize.width / 2 - WIDTH / 2, screenSize.height / 2 - HEIGHT / 2);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setIconImage(ImagesService.getIcon(this.getClass()));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel panel = new JPanel() {{
            setFocusable(true);
            setLayout(null);
            setBackground(Color.white);
        }};
        add(panel);

        JButton buttonAdd = new JButton("Добавить задачи") {{
            setBounds(270, 5, 220, 30);
        }};
        panel.add(buttonAdd);

        JButton buttonViewOnDate = new JButton("Просмотреть задачи на день") {{
            setBounds(270, 40, 220, 30);
        }};
        panel.add(buttonViewOnDate);

        JButton buttonDelete = new JButton("Удалить/Изменить задачу") {{
            setBounds(270, 75, 220, 30);
        }};
        panel.add(buttonDelete);

        JButton buttonView = new JButton("Просмотреть все задачи") {{
            setBounds(270, 110, 220, 30);
        }};
        panel.add(buttonView);

        JButton buttonClear = new JButton("Очистить") {{
            setBounds(270, 145, 220, 30);
        }};
        panel.add(buttonClear);

        text = new JTextArea() {{
            setLineWrap(true);
            setWrapStyleWord(true);
        }};
        JScrollPane scrollPane = new JScrollPane() {{
            setViewportView(text);
            setBounds(5, 5, 260, 220);
        }};
        panel.add(scrollPane);

        JLabel labelDate = new JLabel("Введите дату") {{
            setBounds(300, 180, 210, 15);
        }};
        panel.add(labelDate);

        date = new JFormattedTextField(DateUtils.ONLY_DATE_FORMAT) {{
            setBounds(350, 195, 105, 20);
            setValue(new Date());
        }};
        panel.add(date);

        DataService.readData();

        text.setText("Задачи на сегодня:\n");
        int count = 0;
        for (Message message : MessageAgent.massTask)
            if (DateUtils.dateAsOfToday(message.getDate())) {
                text.append(message.toString());
                text.append("\n");
                count++;
            }
        if (count == 0)
            text.setText("На сегодня планов нет.");

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new FrameAdd();
                    }
                });
            }
        });

        buttonViewOnDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                for (Message message : MessageAgent.massTask) {
                    if (DateUtils.dateAsOfStringDay(message.getDate(), date.getText())) {
                        text.append(message.toString());
                        text.append("\n");
                    }
                }
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new FrameDel();
                    }
                });
            }
        });

        buttonView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (MessageAgent.massTask.isEmpty()) {
                    text.setText("Нет планов.");
                } else {
                    text.setText("");
                    for (Message message : MessageAgent.massTask) {
                        text.append(message.toString());
                        text.append("\n");
                    }
                }
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new FrameClear();
                    }
                });
            }
        });
    }
}