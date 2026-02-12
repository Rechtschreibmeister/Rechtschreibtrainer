package controller;

import model.Question;
import model.Statistic;
import view.*;

import java.awt.event.ActionEvent;
import java.util.Random;

public class Rechtschreibtrainer implements Controller {

    private Frame view;
    private Statistic statistic;

    public Rechtschreibtrainer() {
        view = new Frame(this, new MainPanel(this));
    }


    public static void main(String[] args) {
        Rechtschreibtrainer r = new Rechtschreibtrainer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Commands c = null;
        for(Commands c1 : Commands.values()) {
            if(e.getActionCommand().equals(c1.toString())) {
                c = c1;
            }
        }
        System.out.println(c);
        switch(c){
            case quiz:
                boolean gamemode = true;
                Question question = new Question("", null, "", null);
                view.getMainPanel().setCenterPanel(new QuestionPanel(this, gamemode, question));
                break;
            case game:

                break;
            case stats:
                view.getMainPanel().setCenterPanel(new StatisticsPanel(statistic));
                break;
            case create:
                view.getMainPanel().setCenterPanel(new CreatePanel(this));
                break;
            case enter:
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
}
