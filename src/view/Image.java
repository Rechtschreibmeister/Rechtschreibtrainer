package view;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Paths;

public class Image extends JPanel implements Serializable {
    ImageIcon image;

    private boolean needRescale;

    public Image() {}

    public Image(ImageIcon image) {
        updateImage(image);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            if(needRescale) {
                updateImage(this.image);
                needRescale = false;
            }
            image.paintIcon(this, g, getWidth() / 2 - image.getIconWidth() / 2, 0);
        }
    }

    public void updateImage(ImageIcon image) {
        if  (image != null) {
            System.out.println(getWidth() + " " + getHeight() + " updateImage size");
            int newWidth;
            int newHeight;
            double widthToHeight = (double) image.getIconWidth() / image.getIconHeight();
            if (getHeight() * widthToHeight > getWidth()) {
                newWidth = getWidth();
                newHeight = (int) (newWidth / widthToHeight);
            } else {
                newHeight = getHeight();
                newWidth = (int) (newHeight * widthToHeight);
            }
            if (newWidth == 0 || newHeight == 0) {
                newWidth = image.getIconWidth();
                newHeight = image.getIconHeight();
                needRescale = true;
            }
            if(image.getImage() == null) return;
            image = new ImageIcon(image.getImage().getScaledInstance(newWidth, newHeight, 1));
            this.image = image;
            repaint();
        }
    }
}
