package model;

import controller.Controller;

public class GameMode extends Game {
    private static final int COMBO_TRIGGER = 2;
    private final double COMBO_MULTIPLIER = 1.2;

    private int[] questionOrder;


    public GameMode(Quiz quiz, Statistic statistic, Controller controller) {
        super(controller, quiz, statistic);
        questionOrder = new int[quiz.getQuestions().size()];
        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            questionOrder[i] = controller.getRandom();
        }
    }


    @Override
    public Question nextQuestion() {

    }

    @Override
    public boolean checkAnswer(String answer) {
        return false;
    }

    @Override
    public int getScore() {
        return 0;
    }
}
