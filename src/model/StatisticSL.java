package model;

import java.io.*;

public class StatisticSL{

    public static final String DEFAULT_PATH = ".\\quizzes";

    private String pfad;

    public StatisticSL(String pfad) {
        this.pfad = pfad;
    }

    public StatisticSL(){this.pfad = DEFAULT_PATH;}

    public Statistic load(String name) {
        Statistic s = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pfad + File.pathSeparator + name))){
            s = (Statistic) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public void save(Statistic s, String name) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pfad + File.pathSeparator+name))){
            oos.writeObject(s);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
