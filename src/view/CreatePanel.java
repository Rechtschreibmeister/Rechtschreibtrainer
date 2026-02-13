package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import static java.io.File.separator;

public class CreatePanel extends JPanel {
    private final JTextField answer;
    private final JTextField question;

    private final FileDialog fd;
    private String lastSelectedDirectory = System.getProperty("user.home");
    File file = null;
    String fileName = null;
    String filePath = null;

    public CreatePanel(Controller c, JFrame f) {
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(layout);

        JPanel imageUpload = new JPanel();
        imageUpload.setLayout(new BoxLayout(imageUpload, BoxLayout.LINE_AXIS));
        JButton fileChooser = new JButton("Hochladen");
        JLabel fileNameDisplay = new JLabel();
        JButton imageOpen = new JButton("Preview Image");
        imageUpload.add(fileChooser);
        imageUpload.add(imageOpen);
        imageUpload.add(fileNameDisplay);


        answer = new JTextField();
        question = new JTextField();
        JButton submit = new JButton("Frage erstellen");

        answer.addActionListener(c);
        question.addActionListener(c);
        submit.addActionListener(c);

        JLabel[] l = new JLabel[3];
        l[0] = new JLabel("Geben Sie hier ihre Frage ein: ");
        l[1] = new JLabel("Geben Sie hier optional ein Bild an: ");
        l[2] = new JLabel("Geben Sie hier die richtige Antwort ein: ");

        this.add(l[0]);
        this.add(question);
        this.add(l[1]);
        this.add(imageUpload);
        this.add(l[2]);
        this.add(answer);
        this.add(submit);


        fd = new FileDialog(f, "Laden Sie ein Bild hoch!", FileDialog.LOAD);
        fd.setDirectory(lastSelectedDirectory);

        fd.setFilenameFilter(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                name = name.toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png");
            }
        });

        fileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fd.setVisible(true);
                fileName = fd.getFile();
                filePath = fd.getDirectory();
                fileNameDisplay.setText(fileName);
            }
        });

        imageOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Desktop.getDesktop().open(new File(filePath + separator + fileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public String getAnswer() {
        return answer.getText();
    }

    public String getQuestion() {
        return question.getText();
    }

    public ImageIcon getImage() {
        if (fileName != null) {
            file = new File(fd.getDirectory() + separator + fileName);
            lastSelectedDirectory = file.getParentFile().toPath().toString();
        }
        return new ImageIcon(fileName);
    }
}
