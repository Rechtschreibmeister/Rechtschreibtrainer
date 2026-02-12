package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Question {
    private final String question;
    private final BufferedImage image;
    private final String answer;
    private final ArrayList<String> tips;

    public Question(String question, BufferedImage image, String answer, ArrayList<String> tips) {
        this.question = question;
        this.image = image;
        this.answer = answer;
        this.tips = tips;
    }

    public String getAnswer() {
        return answer;
    }
}
