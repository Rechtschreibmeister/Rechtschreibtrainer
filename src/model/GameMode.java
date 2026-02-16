package model;

import controller.Controller;

import java.util.Collections;

public class GameMode extends Game {
    private static final int COMBO_TRIGGER = 2;
    private final double COMBO_MULTIPLIER = 1.2;

    private int currentCombo = 0;

    public GameMode(Quiz quiz, Controller controller) {
        Collections.shuffle(quiz.getQuestions(), controller.getRandom());
        super(quiz, true);
    }

    @Override
    protected void increaseScore(boolean isCorrect) {
        if (!isCorrect) {
            currentCombo = 0;
            return;
        }
        currentCombo++;
        if (currentCombo >= COMBO_TRIGGER) {
            addToScore(SCORE_PER_QUESTION * (int) Math.pow(COMBO_MULTIPLIER, currentCombo));
        }
        getStatistic().setScore(getScore());
    }
}
