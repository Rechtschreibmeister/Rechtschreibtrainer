package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Question {
    private String question;
    private BufferedImage image;
    private String answer;
    private ArrayList<String> tips;

    public Question(String question, BufferedImage image, String answer,  ArrayList<String> tips) {
        this.question = question;
        this.image = image;
        this.answer = answer;
        this.tips = tips;
    }

    public String getAnswer() {
        return answer;
    }
}
