package model;

import java.io.*;

/**
 * Diese Klasse kann ein Quiz-Objekt speichern bzw. laden.
 *
 * @author lmueller
 * @version 2026-2-10
 */
public class QuizSL implements SaveLoad{

    public static final String DEFAULT_PATH = ".\\quizzes";

    private String pfad;

    public QuizSL(String pfad) {
        this.pfad = pfad;
    }


    @Override
    public Quiz load(String name) {
        Quiz q = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pfad + File.pathSeparator + name))){
            q = (Quiz) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return q;
    }

    @Override
    public void save(Quiz q, String name) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pfad + File.pathSeparator + name))){
            oos.writeObject(q);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
