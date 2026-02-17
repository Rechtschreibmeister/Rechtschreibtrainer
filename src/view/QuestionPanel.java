package view;

import controller.Controller;
import model.Question;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {
    private Image img;
    private JLabel cor, incor, round, question, hint;
    private JTextField inputTextfield;
    private boolean isGame;

    public QuestionPanel(Controller controller, boolean isGameMode, int rounds, Question question) {
        this.isGame = isGameMode;
        this.setLayout(new BorderLayout());
        JPanel p = new JPanel();

        p.setLayout(new BorderLayout());
        p.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        this.cor = new JLabel("Richtig:");
        this.cor.setForeground(Color.blue);
        p1.add(this.cor, BorderLayout.NORTH);

        this.incor = new JLabel("Falsch:");
        this.incor.setForeground(Color.red);
        p1.add(incor, BorderLayout.SOUTH);
        p.add(p1, BorderLayout.NORTH);

        this.round = new JLabel("Runde:");
        p.add(this.round, BorderLayout.SOUTH);

        this.add(p, BorderLayout.EAST);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
        main.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.img = new Image(question.getImage());

        this.question = new JLabel("Peter");
        this.question.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.question.setPreferredSize(new Dimension(200, 100));

        JPanel userInput = new JPanel();
        userInput.setLayout(new BoxLayout(userInput, BoxLayout.LINE_AXIS));
        userInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.inputTextfield = new JTextField();
        this.inputTextfield.setMaximumSize(new Dimension(400, 24));
        this.inputTextfield.addActionListener(controller);
        this.inputTextfield.setActionCommand(Commands.enteredAnswer.name());
        userInput.add(inputTextfield);

        this.hint = new JLabel();
        this.hint.setPreferredSize(new Dimension(600, 100));
        this.hint.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton newHint = new JButton("Tipp");
        newHint.addActionListener(controller);
        newHint.setActionCommand(Commands.hint.name());
        newHint.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (this.isGame) {
            userInput.add(newHint);
        }

        main.add(this.img);
        main.add(this.question);
        main.add(userInput);
        main.add(this.hint);

        this.add(main, BorderLayout.CENTER);
        updatePage(0, 0, 1, rounds, question);
    }

    public void updatePage(int correct, int incorrect, int round, int maxround, Question question) {
        this.img.updateImage(question.getImage());
        this.question.setText(question.getQuestion());
        this.cor.setText("" + correct);
        this.incor.setText("" + incorrect);
        this.round.setText("Frage: " + round + "/" + maxround);
    }

    public void setHint(String hint) {
        this.hint.setText(hint);
    }

    public String getInput(){
        return this.inputTextfield.getText();
    }
}
