package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private final MainPanel mainpanel;

    public Frame(Controller controller, MainPanel panel) {
        super("Rechtschreibtrainer");
        this.mainpanel = panel;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(panel, BorderLayout.CENTER);
    }

    public MainPanel getMainPanel() {
        return mainpanel;
    }
}
