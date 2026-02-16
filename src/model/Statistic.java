package model;

import java.io.Serializable;

public class Statistic implements Serializable {

    private int questionsCorrect;
    private int totalQuestions;

    private int score = 0;
    private int totalHints = 0;
    private int highScore = 0;


    private int gamesPlayed = 0;
    private int quizPlayed = 0;

    public Statistic() {
        totalQuestions = 0;
        questionsCorrect = 0;
    }

    public int getQuestionsCorrect() {
        return questionsCorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getWrongQuestions() {
        return totalQuestions - questionsCorrect;
    }

    public double getCorrectPercentage() {
        if(totalQuestions == 0) return 0;
        return (double) questionsCorrect / (double) totalQuestions * 100;
    }

    public void addQuestion(boolean correctlyAnswered) {
        totalQuestions++;
        if (correctlyAnswered) {
            questionsCorrect++;
        }
    }

    public void addStatistic(Statistic s){
        totalQuestions += s.totalQuestions;
        questionsCorrect += s.getQuestionsCorrect();
        score += s.score;
        totalHints += s.totalHints;
        gamesPlayed += s.gamesPlayed;
        quizPlayed += s.quizPlayed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        if(score > highScore){
            setHighScore(score);
        }
    }

    public int getTotalHints() {
        return totalHints;
    }

    public void setTotalHints(int totalHints) {
        this.totalHints = totalHints;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getQuizPlayed() {
        return quizPlayed;
    }

    public void setQuizPlayed(int quizPlayed) {
        this.quizPlayed = quizPlayed;
    }
}
