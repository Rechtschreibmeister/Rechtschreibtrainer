package model;

import controller.Controller;

public class QuizMode extends Game {
    public QuizMode(Quiz quiz, Statistic statistic, Controller controller) {
        super(controller, quiz, statistic);
    }

    @Override
    public void nextQuestion() {

    }

    @Override
    public void checkAnswer() {

    }
}
