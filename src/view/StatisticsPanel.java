package view;

import model.Statistic;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JPanel {


    public StatisticsPanel(Statistic s) {
        setLayout(new GridLayout(0, 1));
        JLabel nQuestions = new JLabel("Gesamtanzahl der gestellten Fragen: " + s.getTotalQuestions());
        JLabel rQuestions = new JLabel("Anzahl der Richtig beantworteten Fragen: " + s.getQuestionsCorrect());
        JLabel wQuestions = new JLabel("Anzahl der falsch beantworteten Fragen: " + s.getWrongQuestions());
        JLabel ratio = new JLabel("Prozent der richtig beantworteten Fragen: " + s.getCorrectPercentage());
        add(nQuestions);
        add(rQuestions);
        add(wQuestions);
        add(ratio);
    }


}
