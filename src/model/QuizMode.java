package model;

import controller.Controller;

public class QuizMode extends Game {
    public QuizMode(Quiz quiz, Statistic statistic) {
        super(quiz, statistic);
    }

    @Override
    protected void increaseScore(boolean isCorrect) {
        addToScore(SCORE_PER_QUESTION);
    }
}
