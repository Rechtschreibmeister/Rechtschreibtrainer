package model;

import controller.Controller;

public class QuizMode extends Game {
    public QuizMode(Quiz quiz) {
        super(quiz, false);
    }

    @Override
    protected void increaseScore(boolean isCorrect) {
        addToScore(SCORE_PER_QUESTION);
    }

    @Override
    public int getCombo(){
        return 0;
    }
}
