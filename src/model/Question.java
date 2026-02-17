package model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
    private String question;
    private ImageIcon image;
    private String answer;
    private ArrayList<String> hints;

    public Question(String question, ImageIcon image, String answer, String[] hints){
        this(question, image, answer, new ArrayList<>(List.of(hints)));
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

    public String getHint(int i){
        if(i >= hints.size()) return "";
        return hints.get(i);
    }

    public int getHintLength() {
        return hints.size();
    }
}
