package model;

import controller.Controller;

public abstract class Game {
    private Controller controller;
    private Quiz quiz;
    private Statistic statistic;
    private int questionNumber = 0;


    public Game(Controller controller, Quiz quiz, Statistic statistic) {
        this.controller = controller;
        this.quiz = quiz;
        this.statistic = statistic;
    }

    abstract public void nextQuestion();
    abstract public void checkAnswer();

    public Quiz getQuiz() {
        return quiz;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public Controller getController() {
        return controller;
    }
}
