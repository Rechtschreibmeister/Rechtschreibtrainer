package controller;

import model.*;
import view.*;
import view.Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Rechtschreibtrainer implements Controller {

    private final Frame view;
    private Statistic statistic;

    private Game game;


    public Rechtschreibtrainer() {
        view = new Frame(this, new MainPanel(this));
        statistic = new Statistic();
    }


    static void main(String[] args) {
        Rechtschreibtrainer r = new Rechtschreibtrainer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Commands c = null;
        for (Commands c1 : Commands.values()) {
            if (e.getActionCommand().equals(c1.toString())) {
                c = c1;
            }
        }
        System.out.println(c);
        switch (c) {
            case quiz:
                boolean gamemode = false;
                Question question = new Question("", null, "", null);
                view.getMainPanel().setCenterPanel(new QuestionPanel(this, gamemode, game.getRounds(),  question));
                break;
            case game:
                view.showSnackbar("Game Started", Color.green);
                break;
            case stats:
                view.getMainPanel().setCenterPanel(new StatisticsPanel(statistic));
                break;
            case create:
                view.getMainPanel().setCenterPanel(new CreatePanel(this, view));
                break;
            case enter:
                QuestionPanel p = (QuestionPanel)(view.getMainPanel().getCenterPanel());
                view.answered(game.checkAnswer(p.getInput()));
                break;
            case hint:
                break;
            case submit_question:
                break;
        }
    }

    @Override
    public Random getRandom() {
        return new Random();
    }

    private void startQuiz(Quiz quiz, boolean gamemode) {
        game = gamemode ? new GameMode(quiz, statistic, this) : new QuizMode(quiz, statistic);
    }

    private void askQuestion() {
        view.getMainPanel().setCenterPanel(new QuestionPanel(this, game.getGameMode(), game.getRounds(), game.nextQuestion()));
    }

}
