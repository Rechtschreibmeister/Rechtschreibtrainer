package view;

import controller.Controller;
import model.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import static java.io.File.separator;

public class CreatePanel extends JPanel {
    private final JTextField question;
    private final JTextField answer;
    private final JTextField hints;

    private final FileDialog fd;
    private String lastSelectedDirectory = System.getProperty("user.home");
    File file = null;
    String fileName = null;
    String filePath = null;

    public CreatePanel(Controller controller, JFrame frame) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JButton fileChooser = new JButton("Hochladen");
        JLabel fileNameDisplay = new JLabel(" ");

        question = new JTextField();
        answer = new JTextField();
        hints = new JTextField();
        JButton submit = new JButton("Frage erstellen");
        submit.setActionCommand(Commands.submitQuestion.name());

        JButton saveQuiz = new JButton("Quiz speichern");
        saveQuiz.setActionCommand(Commands.saveQuiz.name());

        question.addActionListener(controller);
        answer.addActionListener(controller);
        submit.addActionListener(controller);
        saveQuiz.addActionListener(controller);

        JLabel[] l = new JLabel[4];
        l[0] = new JLabel("Geben Sie hier ihre Frage ein: ");
        l[1] = new JLabel("Geben Sie hier optional ein Bild an: ");
        l[2] = new JLabel("Geben Sie hier die richtige Antwort ein: ");
        l[3] = new JLabel("Geben Sie hier Tips für ihre Frage mit einem # getrennt voneinander ein: ");

        for (JLabel lb : l) {
            lb.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        fileChooser.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveQuiz.setAlignmentX(Component.CENTER_ALIGNMENT);

        question.setMaximumSize(new Dimension(600, 25));
        answer.setMaximumSize(new Dimension(600, 25));
        hints.setMaximumSize(new Dimension(600, 25));

        Image image = new Image();

        this.add(l[0]);
        this.add(question);
        this.add(l[1]);
        this.add(fileChooser);
        this.add(image);
        this.add(l[2]);
        this.add(answer);
        this.add(l[3]);
        this.add(hints);
        this.add(submit);
        this.add(saveQuiz);


        fd = new FileDialog(frame, "Laden Sie ein Bild hoch!", FileDialog.LOAD);
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
                if (fileName == null) {
                    return;
                }
                file = new File(filePath + separator + fileName);
                lastSelectedDirectory = file.getParentFile().toPath().toString();
                image.updateImage(getImage());
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
        return new ImageIcon(filePath + separator + fileName);
    }

    public String[] getHints(){
        return hints.getText().split("#");
    }

    public Question generateQuestion() {
        return new Question(getQuestion(), getImage(), getAnswer(), getHints());
    }
}
