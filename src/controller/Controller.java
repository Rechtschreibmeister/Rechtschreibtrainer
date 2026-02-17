package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;

public interface Controller extends ActionListener, Serializable {
    Random getRandom();
}
