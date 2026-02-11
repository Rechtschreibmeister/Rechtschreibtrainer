package model;

import controller.Controller;

public abstract class Game {
    private Controller controller;
    private Quiz quiz;
    private Statistic statistic;
    private int score = 0;

    public Game(Controller controller, Quiz quiz, Statistic statistic) {
        this.controller = controller;
        this.quiz = quiz;
        this.statistic = statistic;
    }

    abstract public Question nextQuestion();

    /**
     * Checks the answer
     * @return true if answer was correct, false if incorrect
     */
    abstract public boolean checkAnswer(String answer);

    public Quiz getQuiz() {
        return quiz;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    abstract public int getScore();
}
