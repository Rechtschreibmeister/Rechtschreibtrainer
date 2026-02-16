package model;

import java.io.*;

/**
 * Diese Klasse kann ein Quiz-Objekt speichern bzw. laden.
 *
 * @author lmueller
 * @version 2026-2-10
 */
public class SaveLoad implements Serializable{
    private final String path;

    public SaveLoad(String path) {
        this.path = path;
    }


    public Object load(String name) {
        Object obj;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + File.pathSeparator + name))) {
            obj = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public void save(String name, Object obj) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + File.separator + name))) {
            oos.writeObject(obj);
            System.out.println(path + File.separator + name);

        } catch (IOException e) {
            System.out.println("Unable to save: " + e.getMessage());
            System.out.println(obj);
            throw new RuntimeException(e);
        }
    }
}
