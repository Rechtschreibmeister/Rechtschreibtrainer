package model;

import javax.swing.*;
import java.util.ArrayList;

public class Question {
    private String question;
    private ImageIcon image;
    private String answer;
    private ArrayList<String> hints;

    public Question(){

    }

    public Question(String question, ImageIcon image, String answer,  ArrayList<String> hints) {
        this.question = question;
        this.image = image;
        this.answer = answer;
        this.hints = hints;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() { return question; }

    public ImageIcon getImage() { return image; }
}
