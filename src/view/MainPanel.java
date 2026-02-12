package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JPanel center;

    public MainPanel(Controller controller) {
        this.setLayout(new BorderLayout());
        this.Panel(controller);
    }

    public void Panel(Controller controller) {
        JMenuBar menuBar = new JMenuBar();
        JMenu[] subMenu = new JMenu[] {new JMenu("Start"), new  JMenu("Statistik"), new JMenu("Hilfe")};

        subMenu[1].addActionListener(controller);
        subMenu[1].setActionCommand(Commands.stats.name());

        JMenuItem[] menuItem = new JMenuItem[] {new JMenuItem("Quiz starten"), new JMenuItem("Spiel starten"), new JMenuItem("Quiz erstellen"), new JMenuItem("Github"), new JMenuItem("Zur Anleitung")};
        for(JMenuItem menu : menuItem) {
            menu.addActionListener(controller);
        }
        menuItem[0].setActionCommand(Commands.quiz.name());
        menuItem[1].setActionCommand(Commands.game.name());
        menuItem[2].setActionCommand(Commands.create.name());
        menuItem[3].setActionCommand(Commands.github.name());
        menuItem[4].setActionCommand(Commands.help.name());

        for (int i = 0; i <= 2; i++) {
            subMenu[0].add(menuItem[i]);
        }

        subMenu[2].add(menuItem[3]);
        subMenu[2].add(menuItem[4]);

        menuBar.add(subMenu[0]);
        menuBar.add(subMenu[1]);
        menuBar.add(subMenu[2]);

        this.add(menuBar,  BorderLayout.NORTH);
    }

    public void setCenterPanel(JPanel j) {
        center = j;
        this.add(center, BorderLayout.CENTER);
        this.revalidate();
    }

    public JPanel getCenterPanel() {
        return center;
    }
}
