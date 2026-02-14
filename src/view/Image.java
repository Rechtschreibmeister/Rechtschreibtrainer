package view;

import javax.swing.*;
import java.awt.*;

public class Image extends JPanel {
    ImageIcon image;

    public Image() {}

    public Image(ImageIcon image) {
        updateImage(image);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            image.paintIcon(this, g, getWidth() / 2 - image.getIconWidth() / 2, 0);
        }
    }

    public void updateImage(ImageIcon image) {
        if  (image != null) {
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
            image = new ImageIcon(image.getImage().getScaledInstance(newWidth, newHeight, 1));
            this.image = image;
            repaint();
        }
    }
}
