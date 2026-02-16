package model;

import java.io.Serializable;

public abstract class Game implements Serializable {
    protected static final int SCORE_PER_QUESTION = 10;

    private final Quiz quiz;
    private final Statistic statistic;
    private int score = 0;
    private int questionNumber = -1;
    private final boolean gameMode;

    private int currentHint = 0;

    public Game(Quiz quiz, boolean gameMode) {
        this.quiz = quiz;
        this.statistic = new Statistic();
        this.gameMode = gameMode;
    }

    /**
     * Returns the next question specific to the game type.
     *
     * @return the next question
     */
    public Question nextQuestion() {
        questionNumber++;
        currentHint = 0;
        if(questionNumber >= quiz.getQuestions().size()) return null;
        Question nextQuestion = quiz.getQuestion(questionNumber);
        return nextQuestion;
    }

    /**
     * Checks the answer
     *
     * @return true if answer was correct, false if incorrect
     */
    public boolean checkAnswer(String answer) {
        boolean isCorrect = answer.trim().equals(quiz.getQuestion(questionNumber).getAnswer());
        statistic.addQuestion(isCorrect);
        increaseScore(isCorrect);
        return isCorrect;
    }

    abstract protected void increaseScore(boolean isCorrect);

    public int getScore() {
        return score;
    }

    protected void addToScore(int amount) {
        score += amount;
    }

    public boolean getGameMode() {
        return gameMode;
    }

    public int getRounds() {
        return quiz.getRounds();
    }

    public int getQuestionNumber(){
        return questionNumber;
    }

    public int getTotalQuestions(){
        return quiz.getRounds();
    }

    public Statistic getStatistic(){
        return statistic;
    }


    public String getNextHint(){
        String s = quiz.getQuestion(questionNumber).getHint(currentHint);
        currentHint++;
        if(currentHint > quiz.getQuestion(questionNumber).getHintLength()) currentHint = 0;
        return s;
    }
}
