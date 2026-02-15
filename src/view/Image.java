package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Image extends JPanel implements Serializable {
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
                // Temporär leeres Image, damit keine Null-Pointer Exception beim testen kommt
                this.image = new ImageIcon(new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR));
                return;
            }
            image = new ImageIcon(image.getImage().getScaledInstance(newWidth, newHeight, 1));
            this.image = image;
            repaint();
        }
    }
}
