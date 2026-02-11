package model;

import controller.Controller;

public class QuizMode extends Game {
    private int questionNumber = 0;


    public QuizMode(Quiz quiz, Statistic statistic, Controller controller) {
        super(controller, quiz, statistic);
    }


    @Override
    public Question nextQuestion() {
        Question nextQuestion = getQuiz().getQuestion(getQuestionNumber());
        increaseQuestionNumber();
        return nextQuestion;
    }

    @Override
    public boolean checkAnswer(String answer) {
        boolean isCorrect = answer.trim().equals(getQuiz().getQuestion(getQuestionNumber()).getAnswer());
        getStatistic().addQuestion(isCorrect);
        return isCorrect;
    }

    @Override
    public int getScore() {
        return 0;
    }


    private int getQuestionNumber() {
        return questionNumber;
    }

    private void increaseQuestionNumber() {
        questionNumber++;
    }
}
