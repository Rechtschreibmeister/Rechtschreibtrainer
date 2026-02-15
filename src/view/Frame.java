package view;

import controller.Controller;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private final MainPanel mainpanel;
    private Font f;


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

    public void answered(boolean correctly){
        //JOptionPane.showMessageDialog(mainpanel, correctly ? "Correct Answer" : "Wrong Answer");
        showSnackbar(correctly ? "Correct Answer" : "Wrong Answer", correctly ? Color.GREEN : Color.RED);
        /*JDialog dialog = new JDialog();
        dialog.setTitle(correctly ? "Richtig" : "Falsch");
        dialog.setLocationRelativeTo(null);
        dialog.setSize(1280, 720);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setVisible(true);*/
    }

    public void finishedQuiz(Game g){
        mainpanel.setCenterPanel(new StatisticsPanel(g.getStatistic()));
    }


    public void showSnackbar(String message, Color color) {
        JDialog snackbarDialog = new JDialog(this, "", Dialog.ModalityType.MODELESS);
        snackbarDialog.setUndecorated(true);
        snackbarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        snackbarDialog.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setForeground(color);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        snackbarDialog.add(messageLabel, BorderLayout.CENTER);

        snackbarDialog.setSize(250, 50);
        snackbarDialog.setLocationRelativeTo(this);
        snackbarDialog.setLocation(this.getX() + (this.getWidth()/2) - (snackbarDialog.getWidth()/2),
                this.getY() + this.getHeight() - 100);
        snackbarDialog.setVisible(true);

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snackbarDialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void updateFont(){
        this.setFontRecursively(frame, new Font("Arial", Font.BOLD, 18));
    }

    public void updateFontForAllComponents(){
        this.getComponents();
    }


}
