package ru;

import ru.planner.services.ImagesService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrameMention extends JFrame {

    /** Ширина окна */
    private static final int WIDTH = 300;

    /** Высота окна */
    private static final int HEIGHT = 250;

    /** Наименование окна */
    private static final String TITLE = "Напоминание";

    public FrameMention(final Message message) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2 - WIDTH/2, screenSize.height/2 - HEIGHT/2);
        setSize(WIDTH, HEIGHT);
        setTitle(TITLE);
        setResizable(false);
        setIconImage(ImagesService.getIcon(this.getClass()));
        setVisible(true);

        JPanel panel = new JPanel() {{
            setFocusable(true);
            setLayout(null);
        }};
        add(panel);

        TextField textTheme = new TextField() {{
            setBounds(25, 5, 245, 20);
            setText(message.getTheme());
        }};
        panel.add(textTheme);

        JTextArea text = new JTextArea() {{
            setBounds(15, 35, 265, 140);
            setText(message.getText());
        }};
        panel.add(text);

        JButton button = new JButton("OK") {{
            setBounds(95, 180, 100, 30);
        }};
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}