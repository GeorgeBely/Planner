package ru.planner.frames;

import ru.Message;
import ru.MessageAgent;
import ru.planner.services.DataService;
import ru.planner.services.ImagesService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrameDel extends JFrame {

    /** Ширина окна */
    private static final int WIDTH = 300;

    /** Высота окна */
    private static final int HEIGHT = 280;

    /** Наименование фрейма */
    private static final String TITLE = "Удалить/Изменить задачу";

    private static TextField textNum;
    private static TextArea text;

    public FrameDel() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2 - WIDTH/2, screenSize.height/2 - HEIGHT/2);
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        setResizable(false);
        toFront();
        setVisible(true);
        setIconImage(ImagesService.getIcon(FrameDel.class));

        JPanel panel = new JPanel() {{
            setFocusable(true);
            setLayout(null);
        }};
        add(panel);

        JLabel labelText = new JLabel("События") {{
            setBounds(110, 5, 100, 15);
        }};
        panel.add(labelText);

        text = new TextArea() {{
            setBounds(5, 25, 290, 150);
            setText("");
        }};
        panel.add(text);

        JLabel labelDate = new JLabel("Введите нужный номер") {{
            setBounds(30, 180, 140, 15);
        }};
        panel.add(labelDate);

        textNum = new TextField() {{
            setBounds(185, 180, 50, 20);
        }};
        panel.add(textNum);

        JButton buttonChange = new JButton("Изменить") {{
            setBounds(5, 205, 90, 30);
        }};
        panel.add(buttonChange);

        JButton buttonDel = new JButton("Удалить") {{
            setBounds(105, 205, 85, 30);
        }};
        panel.add(buttonDel);

        JButton buttonClose = new JButton("Закрыть") {{
            setBounds(200, 205, 90, 30);
        }};
        panel.add(buttonClose);

        int i = 1;
        for (Message message : MessageAgent.massTask) {
            text.append(i + ": " + message.toString() + "\n");
            i++;
        }

        buttonChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new FrameChange(MessageAgent.massTask.get(Integer.parseInt(textNum.getText())));
                    }
                });
            }
        });

        buttonDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(textNum.getText());
                if (num < MessageAgent.massTask.size() && num > 0) {
                    MessageAgent.massTask.remove(num - 1);
                }

                text.setText("");
                int i = 1;
                for(Message message : MessageAgent.massTask) {
                    text.append(i + ": " + message.toString() + "\n");
                    i++;
                }

                DataService.serializableData();
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