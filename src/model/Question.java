package model;

import java.awt.*;
import java.util.ArrayList;

public class Question {
    private String question;
    private Image image;
    private String answer;
    private ArrayList<String> tips;

    public Question(String question, Image image, String answer,  ArrayList<String> tips) {
        this.question = question;
        this.image = image;
        this.answer = answer;
        this.tips = tips;
    }
}
