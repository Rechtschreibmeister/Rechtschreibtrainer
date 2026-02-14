package view;

import controller.Controller;
import model.Question;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {
    private Image img;
    private JLabel cor, incor, round, Question, tip;
    private JTextField inputTextfield;
    private boolean isGame;

    public QuestionPanel(Controller controller, boolean isGameMode, int rounds, Question q) {
        this.isGame = isGameMode;
        this.setLayout(new BorderLayout());
        JPanel p = new JPanel();

        p.setLayout(new BorderLayout());
        p.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        this.cor = new JLabel("Richtig:");
        cor.setForeground(Color.blue);
        p1.add(cor, BorderLayout.NORTH);

        this.incor = new JLabel("Falsch:");
        incor.setForeground(Color.red);
        p1.add(incor, BorderLayout.SOUTH);
        p.add(p1, BorderLayout.NORTH);

        this.round = new JLabel("Runde:");
        p.add(round, BorderLayout.SOUTH);

        this.add(p, BorderLayout.EAST);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
        main.setAlignmentX(Component.CENTER_ALIGNMENT);

        img = new Image(q.getImage());

        this.Question = new JLabel(" ");
        this.Question.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.Question.setPreferredSize(new Dimension(200, 100));

        JPanel userInput = new JPanel();
        userInput.setLayout(new BoxLayout(userInput, BoxLayout.LINE_AXIS));
        userInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputTextfield = new JTextField();
        inputTextfield.setMaximumSize(new Dimension(400, 24));
        inputTextfield.addActionListener(controller);
        inputTextfield.setActionCommand(Commands.enter.name());
        userInput.add(inputTextfield);

        this.tip = new JLabel();
        this.tip.setPreferredSize(new Dimension(600, 100));
        this.tip.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton hint = new JButton("Tipp");
        hint.addActionListener(controller);
        hint.setActionCommand(Commands.hint.name());

        if (this.isGame) {
            userInput.add(hint);
        }

        main.add(img);
        main.add(Question);
        main.add(userInput);
        main.add(tip);

        this.add(main, BorderLayout.CENTER);
        updatePage(0, 0, 1, rounds, q);
    }

    public void updatePage(int correct, int incorrect, int round, int maxround, Question q) {
        this.img.updateImage(q.getImage());
        this.Question.setText(q.getQuestion());
        this.cor.setText("" + correct);
        this.incor.setText("" + incorrect);
        this.round.setText("Frage: " + round + "/" + maxround);
    }

    public void setTip(String tip) {
        this.tip.setText(tip);
    }

    public String getInput(){
        return this.inputTextfield.getText();
    }
}
