package model;

import java.io.*;

/**
 * Diese Klasse kann ein Quiz-Objekt speichern bzw. laden.
 *
 * @author lmueller
 * @version 2026-2-10
 */
public class SaveLoad {
    private final String path;

    public SaveLoad(String path) {
        this.path = path;
    }


    public Quiz load(String filepath) {
        Quiz q;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + File.pathSeparator + filepath))) {
            q = (Quiz) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return q;
    }

    public void save(String filepath, Quiz q) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + File.pathSeparator + filepath))) {
            oos.writeObject(q);
        } catch (IOException e) {
            System.out.println("Unable to save quiz: " + e.getMessage());
            System.out.println(q);
            throw new RuntimeException(e);
        }
    }
}
