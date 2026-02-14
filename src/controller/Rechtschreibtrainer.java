package controller;

import model.*;
import view.*;
import view.Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Rechtschreibtrainer implements Controller {

    private final Frame view;
    private Statistic statistic;

    private Quiz quiz;

    private Game game;


    public Rechtschreibtrainer() {
        view = new Frame(this, new MainPanel(this));
        statistic = new Statistic();
        quiz = new Quiz(this, "test", "");
        quiz.addQuestion(new Question("test", null, "test", new ArrayList<>()));
    }


    public static void main(String[] args) {
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
                game = new GameMode(quiz, statistic, this);
                view.getMainPanel().setCenterPanel(new QuestionPanel(this, gamemode, 1,  game.nextQuestion()));
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
            case enteredAnswer:

                QuestionPanel p = (QuestionPanel)(view.getMainPanel().getCenterPanel());
                view.answered(game.checkAnswer(p.getInput()));
                Question q = game.nextQuestion();
                if(q == null){
                    // Falls es die letzte Frage war
                    // TODO
                }else {
                    view.getMainPanel().setCenterPanel(new QuestionPanel(this, game.getGameMode(), 1, game.nextQuestion()));
                }
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
