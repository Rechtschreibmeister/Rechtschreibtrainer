package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JPanel center = new JPanel();

    public MainPanel(Controller controller) {
        this.setLayout(new BorderLayout());
        this.Panel(controller);
    }

    public void Panel(Controller controller) {
        JMenuBar menuBar = new JMenuBar();
        JMenu[] subMenu = new JMenu[] {new JMenu("Start"),new JMenu("Hilfe")};


        JMenuItem[] menuItem = new JMenuItem[] {new JMenuItem("Quiz starten"), new JMenuItem("Spiel starten"), new JMenuItem("Quiz erstellen"), new JMenuItem("Github"), new JMenuItem("Zur Anleitung"), new JMenuItem("Statistik")};
        for(JMenuItem menu : menuItem) {
            menu.addActionListener(controller);
        }
        menuItem[0].setActionCommand(Commands.quiz.name());
        menuItem[1].setActionCommand(Commands.game.name());
        menuItem[2].setActionCommand(Commands.create.name());
        menuItem[3].setActionCommand(Commands.github.name());
        menuItem[4].setActionCommand(Commands.help.name());
        menuItem[5].setActionCommand(Commands.stats.name());

        for (int i = 0; i <= 2; i++) {
            subMenu[0].add(menuItem[i]);
        }

        subMenu[1].add(menuItem[3]);
        subMenu[1].add(menuItem[4]);

        menuBar.add(subMenu[0]);
        menuBar.add(menuItem[5]);
        menuBar.add(subMenu[1]);

        this.add(menuBar, BorderLayout.NORTH);
    }

    public void setCenterPanel(JPanel j) {
        this.remove(center);
        center = j;
        this.add(center, BorderLayout.CENTER);
        this.revalidate();
    }

    public JPanel getCenterPanel() {
        return center;
    }
}
