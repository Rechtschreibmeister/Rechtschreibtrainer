package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreatePanel extends JPanel {

    JTextField answer;
    JTextField question;
    JFileChooser image;

    public CreatePanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        answer = new JTextField();
        question = new JTextField();
        image = new JFileChooser();

    }


    public BufferedImage getImage() throws IOException {
        File f = image.getSelectedFile();
        return ImageIO.read(f);
    }

    public String getAnswer(){
        return answer.getText();
    }

    public String getQuestion(){
        return question.getText();
    }

}
