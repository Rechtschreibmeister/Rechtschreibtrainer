package controller;

import view.Commands;
import view.Frame;
import view.MainPanel;

import java.awt.event.ActionEvent;

public class Rechtschreibtrainer implements Controller{

    Frame view;

    public Rechtschreibtrainer(){
        view = new Frame(this, new MainPanel(this));
    }


    public static void main(String[] args){
        Rechtschreibtrainer r = new Rechtschreibtrainer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Commands c = null;
        for(Commands c1 : Commands.values()){
            if(e.getActionCommand().equals(c1.toString())){
                c = c1;
            }
        }
        System.out.println(c);
        switch(c){
            case quiz:

                break;
            case game:
                break;
            case stats:
                break;
            case create:
                break;
            case enter:
                break;
            case hint:
                break;
            case submit_question:
                break;
        }
    }
}
