package controller;

import model.*;
import view.*;
import view.Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

public class Rechtschreibtrainer implements Controller {
    private static final String GITHUB_LINK = "https://github.com/sziehensack/Rechtschreibtrainer";
    private static final String GUIDE_LINK = "https://biblehub.com/topical/s/scripture_as_a_guide_for_life.htm";

    private final Frame view;
    private Statistic statistic;

    private Quiz quiz;

    private Game game;
    private Font font = new Font(Font.SERIF, Font.BOLD, 30);

    private SaveLoad sl;
    private String quizSavePath = "." + File.separator + "Quizzes";

    public Rechtschreibtrainer() {
        view = new Frame(this, new MainPanel(this));
        statistic = new Statistic();
        quiz = new Quiz(this, "test", "");
        quiz.addQuestion(new Question("test", null, "test", new ArrayList<>()));
        quiz.addQuestion(new Question("test2", null, "test2", new ArrayList<>()));
        view.updateFontForAllComponents(view, font);

        sl = new SaveLoad(quizSavePath);
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
        if(c == null) throw new RuntimeException("Unknown ActionCommand: " + e.getActionCommand());
        switch (c) {
            case quiz:

                quiz = view.askForQuiz(quizSavePath, sl);
                game = new QuizMode(quiz);
                view.getMainPanel().setCenterPanel(new QuestionPanel(this, false, 1,  game.nextQuestion()));
                break;

            case game:

                quiz = view.askForQuiz(quizSavePath, sl);
                game = new GameMode(quiz, this);
                view.getMainPanel().setCenterPanel(new QuestionPanel(this, true, 1,  game.nextQuestion()));

                view.showSnackbar("Game Started", Color.green);
                break;
            case stats:
                view.getMainPanel().setCenterPanel(new StatisticsPanel(statistic));
                break;
            case create:
                view.getMainPanel().setCenterPanel(new CreatePanel(this, view));

                String[] s = view.askForNewQuizName();
                quiz = new Quiz(this, s[0], s[1]);

                break;
            case enteredAnswer:

                QuestionPanel p = (QuestionPanel)(view.getMainPanel().getCenterPanel());
                view.answered(game.checkAnswer(p.getInput()));
                Question q = game.nextQuestion();
                if(q == null){
                    // Falls es die letzte Frage war
                    view.finishedQuiz(game);
                    statistic.addStatistic(game.getStatistic());
                }else {
                    QuestionPanel qp = (QuestionPanel) view.getMainPanel().getCenterPanel();
                    qp.updatePage(game.getStatistic().getQuestionsCorrect(), game.getStatistic().getWrongQuestions(), game.getQuestionNumber(), game.getTotalQuestions(), q);
                }
                break;
            case hint:
                QuestionPanel qp = (QuestionPanel) view.getMainPanel().getCenterPanel();
                qp.setHint(game.getNextHint());
                break;
            case submitQuestion:
                quiz.addQuestion(view.getCreatedQuestion());
                view.showSnackbar("Frage wurde hinzugefügt!", Color.GREEN);
                break;
            case saveQuiz:
                sl.save(quiz.getName() + ".quiz", quiz);
                view.showSnackbar("Quiz wurde erstellt und gespeichert!", Color.GREEN);
                break;
            case help:
                openURI(GUIDE_LINK);
                break;
            case github:
                openURI(GITHUB_LINK);
                break;
        }
    }

    @Override
    public Random getRandom() {
        return new Random();
    }

    private void startQuiz(Quiz quiz, boolean gamemode) {
        game = gamemode ? new GameMode(quiz, this) : new QuizMode(quiz);
    }

    private void askQuestion() {
        view.getMainPanel().setCenterPanel(new QuestionPanel(this, game.getGameMode(), game.getRounds(), game.nextQuestion()));
        view.updateFontForAllComponents(view, font);
    }

    private void openURI(String uri) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(uri));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(new String[]{"xdg-open", uri});
            } catch (IOException e) {
                try {
                    runtime.exec(new String[]{"open", uri});
                }
                catch (IOException e1) {
                    throw new RuntimeException(e1);
                }
            }
        }
    }
}
