package view;

import controller.Controller;
import model.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class QuestionPanel extends JPanel {
    private JPanel ip;
    private JLabel cor,incor,round,Question,tip;
    private JTextField inputTextfield;
    private boolean isGame;

    public QuestionPanel(Controller controller, boolean isGameMode, Question q) {
        this.isGame = isGameMode;
        this.setLayout(new BorderLayout());
        JPanel p = new JPanel();

        p.setLayout(new BorderLayout());
        p.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        this.cor = new  JLabel("Richtig:");
        p1.add(cor, BorderLayout.NORTH);

        this.incor = new  JLabel("Falsch:");
        p1.add(incor,  BorderLayout.SOUTH);
        p.add(p1,BorderLayout.NORTH);

        this.round = new JLabel("Runde:");
        p.add(round, BorderLayout.SOUTH);

        this.add(p,BorderLayout.EAST);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.PAGE_AXIS));
        main.setAlignmentX(Component.CENTER_ALIGNMENT);

        ip = new JPanel(); // image Panel
        ip.setPreferredSize(new Dimension(600,400));

        this.Question = new JLabel(" ");
        this.Question.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.Question.setPreferredSize(new Dimension(200,100));

        JPanel userInput = new JPanel();
        userInput.setLayout(new BoxLayout(userInput,BoxLayout.LINE_AXIS));
        userInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputTextfield = new JTextField();
        inputTextfield.setMaximumSize(new Dimension(400,24));
        inputTextfield.addActionListener(controller);
        inputTextfield.setActionCommand(Commands.enter.name());
        userInput.add(inputTextfield);

        this.tip = new JLabel(" ");
        this.tip.setPreferredSize(new Dimension(600,100));

        JButton hint = new JButton("Tipp");
        hint.addActionListener(controller);
        hint.setActionCommand(Commands.hint.name());

        if(this.isGame) {
            userInput.add(hint);
        }

        main.add(ip);
        main.add(Question);
        main.add(userInput);
        main.add(tip);


        this.add(main,BorderLayout.CENTER);
    }

    public void updatePage(int correct, int incorrect, int round, Question q) {
        this.ip.removeAll();
        this.ip.add(q.getImage());
        this.Question.setText(q.getQuestion());
        this.cor.setText("Richtig:" + correct);
        this.incor.setText("Falsch:" + incorrect);
        this.round.setText("Runde:" + round);
    }

    public String getInput(){
        return this.inputTextfield.getText();
    }
}
