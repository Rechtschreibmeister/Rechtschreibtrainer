package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public interface Controller extends ActionListener {
    Random getRandom();
}
