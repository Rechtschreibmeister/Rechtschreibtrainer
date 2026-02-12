package model;

public class Statistic {

    private int questionsCorrect;
    private int totalQuestions;

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

}
