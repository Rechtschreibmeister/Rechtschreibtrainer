package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class QuizSL implements SaveLoad{

    private String pfad;


    @Override
    public Quiz load(String name) {
        Quiz q = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pfad + " " + name))){
            q = (Quiz) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void save(Quiz q) {

    }
}
