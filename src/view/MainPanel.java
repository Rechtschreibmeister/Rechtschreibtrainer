package view;

import controller.Controller;
import model.Question;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(Controller controller) {
        this.setLayout(new BorderLayout());
        this.Panel(controller);
    }
    public void Panel(Controller controller) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));
        p.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton quiz = new JButton("Quizmodus");
        quiz.setActionCommand("quiz");
        quiz.addActionListener(controller);


        JButton game = new JButton("Spielmodus");
        game.setActionCommand("game");
        game.addActionListener(controller);

        JButton stats = new JButton("Übersicht");
        stats.setActionCommand("stats");
        stats.addActionListener(controller);

        JButton create = new JButton("Fragen erstellen");
        create.setActionCommand("create");
        create.addActionListener(controller);

        p.add(quiz);
        p.add(game);
        p.add(stats);
        p.add(create);

        this.add(p, BorderLayout.NORTH);
    }
}
