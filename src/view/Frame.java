package view;

import controller.Controller;
import model.Game;
import model.Question;
import model.Quiz;
import model.SaveLoad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;


public class Frame extends JFrame {

    private final MainPanel mainpanel;
    private Font f;


    public Frame(Controller controller, MainPanel panel) {
        super("Rechtschreibtrainer");
        this.mainpanel = panel;
        Image.initImage();
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
        mainpanel.setCenterPanel(new StatisticsPanel(g.getStatistic(), false));
    }


    public void showSnackbar(String message, Color color) {
        JDialog snackbarDialog = new JDialog(this, "", Dialog.ModalityType.MODELESS);
        snackbarDialog.setUndecorated(true);
        snackbarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        snackbarDialog.setLayout(new BorderLayout());
        snackbarDialog.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        snackbarDialog.setBackground(color.darker());

        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setForeground(color);

        messageLabel.setBackground(color.darker().darker());
        messageLabel.setOpaque(true);

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

    /*public void updateFont(){
        this.setFontRecursively(frame, new Font("Arial", Font.BOLD, 18));
    }*/

    public void updateFontForAllComponents(Container c, Font f){
        Component[] subC = c.getComponents();
        for(Component c1 : subC){
            c1.setFont(f);
            if(c1 instanceof Container) updateFontForAllComponents((Container) c1, f);
        }
    }

    /**
     * With this function the User is asked to give the newly generated Quiz a name and a description
     *
     * @return returns a String array, where index 0 is the name and index 1 the description of the Quiz
     */
    public String[] askForNewQuizName(){
        String s = JOptionPane.showInputDialog("Geben Sie einen Namen und eine Beschreibung, getrennt von einem '#' für Ihr Quiz  ein:");
        if(s == null) s = "#";
        return new String[]{s.split("#")[0], s.substring(s.split("#")[0].length())};
    }


    /**
     * Creates and returns a Question based of the User Input in the QuestionPanel.
     * @return
     */
    public Question getCreatedQuestion() {
        JPanel j = mainpanel.getCenterPanel();
        if(!(j instanceof CreatePanel)) throw new RuntimeException("MainPanel is not a CreatePanel!");
        CreatePanel c = (CreatePanel) j;
        return c.generateQuestion();
    }

    public Quiz askForQuiz(String path, SaveLoad sl){
        Quiz q = null;
        FileDialog fd = new FileDialog(this, "Wählen Sie ein Quiz aus:", FileDialog.LOAD);
        fd.setDirectory(path);

        fd.setFilenameFilter(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                name = name.toLowerCase();
                return name.endsWith(".quiz");
            }
        });
        fd.setVisible(true);
        String fileName = fd.getFile();
        return (Quiz) sl.load(fileName);
    }

}
