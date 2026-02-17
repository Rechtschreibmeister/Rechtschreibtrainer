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
        if(totalStatistic){
            initTotalStatistic();
        }else{
            if(s.getGamesPlayed() == 1){
                initGameStatistic();
            }else{
                initQuizStatistic();
            }
        }
    }

    public void initTotalStatistic(){
        initQuizStatistic();
        JPanel right = new JPanel(new GridLayout(0, 1));
        JLabel score = new JLabel("Gesamt-Score von allen Spielen: " + s.getScore());
        JLabel hints = new JLabel("Gesamtanzahl verwendeter Tips: " + s.getTotalHints());
        JLabel totalQuiz = new JLabel("Gesamtanzahl der durchgeführten Quizze: " + s.getQuizPlayed());
        JLabel totalGames = new JLabel("Gesamtanzahl der gespielten Spielmodi: " + s.getGamesPlayed());
        right.add(score);
        right.add(hints);
        right.add(totalQuiz);
        right.add(totalGames);
        this.add(right);
    }

    public void initQuizStatistic(){
        JPanel left = new JPanel(new GridLayout(0, 1));
        JLabel nQuestions = new JLabel("Gesamtanzahl der gestellten Fragen: " + s.getTotalQuestions());
        JLabel rQuestions = new JLabel("Anzahl der Richtig beantworteten Fragen: " + s.getQuestionsCorrect());
        JLabel wQuestions = new JLabel("Anzahl der falsch beantworteten Fragen: " + s.getWrongQuestions());
        JLabel ratio = new JLabel("Prozent der richtig beantworteten Fragen: " + s.getCorrectPercentage() + "%");
        left.add(nQuestions);
        left.add(rQuestions);
        left.add(wQuestions);
        left.add(ratio);
        this.add(left);
    }

    public void initGameStatistic(){
        initQuizStatistic();
        JPanel right = new JPanel(new GridLayout(0, 1));
        JLabel score = new JLabel("Score: " + s.getScore());
        JLabel hints = new JLabel("Anzahl verwendeter Tips: " + s.getTotalHints());
        right.add(score);
        right.add(hints);
        this.add(right);
    }


}
