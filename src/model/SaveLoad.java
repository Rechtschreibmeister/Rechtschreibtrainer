package model;

public interface SaveLoad {

    Quiz load(String name);
    void save(Quiz q);

}
