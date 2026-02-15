package model;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
    private String question;
    private transient ImageIcon image;
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
        if(this.image == null){
            this.image = new ImageIcon(new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR));
        }
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() { return question; }

    public ImageIcon getImage() { return image; }
}
