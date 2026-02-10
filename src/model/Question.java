package model;

import java.awt.*;

public class Question {
    private String question;
    private Image image;
    private String answer;

    public Question(String question, Image image, String answer) {
        this.question = question;
        this.image = image;
        this.answer = answer;
    }
}
