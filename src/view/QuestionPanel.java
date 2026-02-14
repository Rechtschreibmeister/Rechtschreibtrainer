package view;

import controller.Controller;
import model.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class QuestionPanel extends JPanel {
    private JPanel ip;
    private JLabel cor, incor, round, Question, tip;
    private JTextField inputTextfield;
    private boolean isGame;

    private class ImagePanel extends JPanel {
        private ImageIcon image;

        public ImagePanel(ImageIcon image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                image.paintIcon(this, g, 0, 0);
            }
        }
    }

    public QuestionPanel(Controller controller, boolean isGameMode, int rounds, Question q) {
        this.isGame = isGameMode;
        this.setLayout(new BorderLayout());
        JPanel p = new JPanel();

        p.setLayout(new BorderLayout());
        p.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        this.cor = new JLabel("Richtig:");
        p1.add(cor, BorderLayout.NORTH);

        this.incor = new JLabel("Falsch:");
        p1.add(incor, BorderLayout.SOUTH);
        p.add(p1, BorderLayout.NORTH);

        this.round = new JLabel("Runde:");
        p.add(round, BorderLayout.SOUTH);

        this.add(p, BorderLayout.EAST);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
        main.setAlignmentX(Component.CENTER_ALIGNMENT);

        ip = new JPanel(); // image Panel
        ip.setPreferredSize(new Dimension(600, 400));
        ip.setBackground(Color.blue);

        this.Question = new JLabel(" ");
        this.Question.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.Question.setPreferredSize(new Dimension(200, 100));

        JPanel userInput = new JPanel();
        userInput.setLayout(new BoxLayout(userInput, BoxLayout.LINE_AXIS));
        userInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputTextfield = new JTextField();
        inputTextfield.setMaximumSize(new Dimension(400, 24));
        inputTextfield.addActionListener(controller);
        inputTextfield.setActionCommand(Commands.enter.name());
        userInput.add(inputTextfield);

        this.tip = new JLabel(" ");
        this.tip.setPreferredSize(new Dimension(600, 100));

        JButton hint = new JButton("Tipp");
        hint.addActionListener(controller);
        hint.setActionCommand(Commands.hint.name());

        if (this.isGame) {
            userInput.add(hint);
        }

        main.add(ip);
        main.add(Question);
        main.add(userInput);
        main.add(tip);

        this.add(main, BorderLayout.CENTER);
        updatePage(0, 0, 1, rounds, q);
    }

    public void updatePage(int correct, int incorrect, int round, int maxround, Question q) {
        this.ip.removeAll();

        ImageIcon img = q.getImage();
        ImagePanel imagePanel = new ImagePanel(img);
        imagePanel.setPreferredSize(new Dimension(600, 400));

        this.ip.add(imagePanel);
        this.Question.setText(q.getQuestion());
        this.cor.setText("" + correct);
        this.incor.setText("" + incorrect);
        this.round.setText("Frage: " + round + "/" + maxround);

        this.ip.revalidate();
        this.ip.repaint();
    }

    public void setTip(String tip) {
        this.tip.setText(tip);
    }

    public String getInput(){
        return this.inputTextfield.getText();
    }
}
