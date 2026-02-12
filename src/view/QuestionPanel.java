package view;

import controller.Controller;
import model.Question;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {
    JLabel cor,incor,round,Question,tip;
    JPanel image;
    JTextField userInput;

    public QuestionPanel(Controller controller, boolean isGameMode, Question q) {
            this.setLayout(new BorderLayout());
            this.basicPanel(controller, isGameMode);
    }

    public void basicPanel(Controller controller, boolean game) {
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
        main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createLineBorder(Color.black));

        image = new JPanel();
        image.setSize(400,400);
        image.setBackground(Color.black);
        main.add(image);

        this.Question = new JLabel("Frage:");
        main.add(Question);

        JPanel p2 = new JPanel();

        userInput = new JTextField();
        userInput.addActionListener(controller);
        userInput.setActionCommand(Commands.enter.name());
        p2.add(userInput);

        if(game) {
            JButton hint = new JButton("Tipp");
            hint.addActionListener(controller);
            hint.setActionCommand(Commands.hint.name());
            p2.add(hint);
        }

        main.add(p2);

        tip = new JLabel("hallo");
        main.add(tip);
        this.add(main,BorderLayout.CENTER);


    }

    public void updateSidebar(int correct, int incorrect, int round) {
        this.cor.setText("Richtig:" + correct);
        this.incor.setText("Falsch:" + incorrect);
        this.round.setText("Runde:" + round);
    }

    public String getInput(){
        return this.userInput.getText();
    }
}
