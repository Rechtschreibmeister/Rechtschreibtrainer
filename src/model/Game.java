package model;

public abstract class Game {
    protected static final int SCORE_PER_QUESTION = 10;

    private Quiz quiz;
    private Statistic statistic;
    private int score = 0;
    private int questionNumber = 0;


    public Game(Quiz quiz, Statistic statistic) {
        this.quiz = quiz;
        this.statistic = statistic;
    }

    /**
     * Returns the next question specific to the game type.
     * @return the next question
     */
    public Question nextQuestion() {
        Question nextQuestion = quiz.getQuestion(questionNumber);
        questionNumber++;
        return nextQuestion;
    }

    /**
     * Checks the answer
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
}
