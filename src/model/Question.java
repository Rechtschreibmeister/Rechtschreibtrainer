package model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Question {
    private String question;
    private ImageIcon image;
    private String answer;
    private ArrayList<String> tips;

    public Question(){

    }

    public Question(String question, ImageIcon image, String answer,  ArrayList<String> tips) {
        this.question = question;
        this.image = image;
        this.answer = answer;
        this.tips = tips;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() { return question; }

    public ImageIcon getImage() { return image; }
}
