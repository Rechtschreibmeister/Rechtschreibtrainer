package view;

import model.Statistic;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JPanel {

    private Statistic s;
    private JLabel l;

    public StatisticsPanel(Statistic s, boolean totalStatistic) {
        this.s = s;
        l = new JLabel();
        this.setLayout(new GridLayout(1, 2));
    }

    public void initTotalStatistic(){
        initQuizStatistic();
    }

    public void initQuizStatistic(){
        JLabel right = new JLabel();
        JLabel nQuestions = new JLabel("Gesamtanzahl der gestellten Fragen: " + s.getTotalQuestions());
        JLabel rQuestions = new JLabel("Anzahl der Richtig beantworteten Fragen: " + s.getQuestionsCorrect());
        JLabel wQuestions = new JLabel("Anzahl der falsch beantworteten Fragen: " + s.getWrongQuestions());
        JLabel ratio = new JLabel("Prozent der richtig beantworteten Fragen: " + s.getCorrectPercentage() + "%");
        right.add(nQuestions);
        right.add(rQuestions);
        right.add(wQuestions);
        right.add(ratio);
        this.add(right);
    }

    public void initGameStatistic(){
        initQuizStatistic();
    }


}
