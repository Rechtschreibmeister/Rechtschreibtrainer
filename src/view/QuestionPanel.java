package view;

import model.Question;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {
    JLabel cor,incor,round;
    public QuestionPanel(Controller controller, boolean game, Question q) {
        this.setLayout(new BorderLayout());
        this.Panel(controller);
    }

    public void Panel(Controller controller){
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
    }

    public void updateSidebar(int correct, int incorrect, int round) {
        this.cor.setText("Richtig:" + correct);
        this.incor.setText("Falsch:" + incorrect);
        this.round.setText("Runde:" + round);
    }
}
