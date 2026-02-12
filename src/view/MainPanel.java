package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(Controller controller) {
        this.setLayout(new BorderLayout());
        this.Panel(controller);
    }
    public void Panel(Controller controller) {
        JMenuBar mB = new JMenuBar();
        JMenu m = new JMenu("Start");

        m.add(new JMenuItem("Quiz starten"));
        m.add(new JMenuItem("Spiel starten"));
        m.add(new JMenuItem("Quiz erstellen"));
        mB.add(m);

        this.add(mB,  BorderLayout.NORTH);
    }

    public void setCenterPanel(JPanel j){
        this.add(j, BorderLayout.CENTER);
        this.revalidate();
    }
}
