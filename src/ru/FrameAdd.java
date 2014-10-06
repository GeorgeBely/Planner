package ru;

import ru.planner.services.DataService;
import ru.planner.services.ImagesService;
import ru.planner.utils.DateUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class FrameAdd extends JFrame {

    /** ������ ���� */
    private static final int WIDTH = 300;

    /** ������ ���� */
    private static final int HEIGHT = 380;

    /** ������������ ������ */
    private static final String TITLE = "�������� ������";


    private static JFormattedTextField datePlan;
    private static JFormattedTextField dateMention;
    private static TextField theme;
    private static JTextArea text;

    public FrameAdd() {
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

        JLabel labelDate = new JLabel("������� ������ ����") {{
            setBounds(15, 0, 300, 15);
        }};
        panel.add(labelDate);

        datePlan = new JFormattedTextField(DateUtils.DATE_FORMAT) {{
            setBounds(120, 15, 105, 20);
            setValue(new Date());
        }};
        panel.add(datePlan);

        JLabel labelTheme = new JLabel("������� ����") {{
            setBounds(110, 40, 100, 15);
        }};
        panel.add(labelTheme);

        theme = new TextField() {{
            setBounds(25, 55, 245, 20);
        }};
        panel.add(theme);

        JLabel labelText = new JLabel("������� �����") {{
            setBounds(110, 80, 100, 15);
        }};
        panel.add(labelText);

        text = new JTextArea() {{
            setLineWrap(true);
            setWrapStyleWord(true);
        }};
        JScrollPane scrollPane = new JScrollPane() {{
            setViewportView(text);
            setBounds(15, 100, 265, 150);
        }};
        panel.add(scrollPane);

        JLabel labelTime = new JLabel("������� ���� ������ ���������:") {{
            setBounds(30, 260, 250, 20);
        }};
        panel.add(labelTime);

        dateMention = new JFormattedTextField(DateUtils.DATE_FORMAT) {{
            setBounds(120, 280, 105, 20);
            setValue(new Date());
        }};
        panel.add(dateMention);

        JButton buttonOK = new JButton("OK") {{
            setBounds(90, 305, 90, 30);
        }};
        panel.add(buttonOK);

        JButton buttonClose = new JButton("�������") {{
            setBounds(190, 305, 90, 30);
        }};
        panel.add(buttonClose);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!theme.getText().isEmpty()) {
                    MessageAgent.massTask.add(new Message(DateUtils.parseDate(datePlan.getText()), theme.getText(),
                                                          text.getText(), dateMention.getText()));

                    Date today = new Date();
                    datePlan.setText(DateUtils.DATE_FORMAT.format(today));
                    dateMention.setText(DateUtils.DATE_FORMAT.format(today));
                    text.setText("");
                    theme.setText("");

                    DataService.serializableData();
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