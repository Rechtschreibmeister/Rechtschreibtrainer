package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(Controller controller, MainPanel panel) {
        super("Rechtschreibtrainer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(panel, BorderLayout.CENTER);
    }
}
