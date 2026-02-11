package model;

import controller.Controller;

public class GameMode extends Game {
    private static final int COMBO_TRIGGER = 2;
    private final double COMBO_MULTIPLIER = 1.2;

    public GameMode(Quiz quiz, Statistic statistic, Controller controller) {
        super(quiz, statistic, controller);
    }

    @Override
    public void startGame() {

    }
}
