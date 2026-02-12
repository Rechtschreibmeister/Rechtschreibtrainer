package model;

import java.io.*;

/**
 * Diese Klasse kann ein Quiz-Objekt speichern bzw. laden.
 *
 * @author lmueller
 * @version 2026-2-10
 */
public class QuizSL implements SaveLoad {
    public static final String DEFAULT_PATH = ".\\quizzes";

    private String path;


    public QuizSL(String path) {
        this.path = path;
    }


    @Override
    public Quiz load(String name) {
        Quiz q;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + File.pathSeparator + name))) {
            q = (Quiz) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return q;
    }

    @Override
    public void save(Quiz q, String name) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + File.pathSeparator + name))) {
            oos.writeObject(q);
        } catch (IOException e) {
            System.out.println("Unable to save quiz: " + e.getMessage());
            System.out.println(q);
            throw new RuntimeException(e);
        }
    }
}
