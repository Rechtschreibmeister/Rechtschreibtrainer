package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreatePanel extends JPanel {

    private final JTextField answer;
    private final JTextField question;
    private final FileDialog fd;
    private final JButton submit;

    public CreatePanel(Controller c, JFrame f) {
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(layout);

        answer = new JTextField();
        question = new JTextField();
        fd = new FileDialog(f, "Wählen Sie ein Bild aus!", FileDialog.LOAD);

        JLabel[] l = new JLabel[3];
        l[0] = new JLabel("Geben Sie hier ihre Frage ein: ");
        l[1] = new JLabel("Geben Sie hier optional ein Bild an: ");
        l[2] = new JLabel("Geben Sie hier die richtige Antwort ein: ");

        submit = new JButton("Frage erstellen");

        answer.addActionListener(c);
        question.addActionListener(c);
        submit.addActionListener(c);

        this.add(l[0]);
        this.add(question);
        this.add(l[1]);
        this.add(l[2]);
        this.add(answer);
        this.add(submit);
    }

    public String getAnswer() {
        return answer.getText();
    }

    public String getQuestion() {
        return question.getText();
    }
    }
