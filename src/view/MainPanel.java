package view;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(Controller controller) {
        this.setLayout(new BorderLayout());
        this.Panel(controller);
    }
    public void Panel(Controller controller) {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        JButton quiz = new JButton("Quizmodus");
        quiz.setActionCommand("quizmode");
        quiz.addActionListener(controller);

        JButton stats = new JButton("Übersicht");
        stats.setActionCommand("stats");
        stats.addActionListener(controller);

        JButton game = new JButton("Spielmodus");
        game.setActionCommand("game");
        game.addActionListener(controller);
    }
}
