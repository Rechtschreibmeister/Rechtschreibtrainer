package model;

import controller.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Quiz implements Serializable {
    private String name;
    private String description;
    private final ArrayList<Question> questions = new ArrayList<Question>();
    //private final Controller controller;


    public Quiz(Controller controller, String name, String description) {
        setName(name);
        setDescription(description);
        //this.controller = controller;
    }


    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(int index) {
        questions.remove(index);
    }

    private Question getRandomQuestion() {
        return getQuestion(new Random().nextInt(questions.size()));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getRounds() {
        return questions.size();
    }
}
