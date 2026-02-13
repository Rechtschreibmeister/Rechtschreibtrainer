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


    public Object load(String filepath) {
        Object obj;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + File.pathSeparator + filepath))) {
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public void save(String filepath, Object obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + File.pathSeparator + filepath))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            System.out.println("Unable to save: " + e.getMessage());
            System.out.println(obj);
            throw new RuntimeException(e);
        }
    }
}
