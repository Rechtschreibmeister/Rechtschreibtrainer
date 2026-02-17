import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnackbarExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnackbarExample::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Snackbar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button = new JButton("Show Snackbar");
        button.addActionListener(e -> showSnackbar(frame, "This is a Snackbar message!"));

        frame.setLayout(new BorderLayout());
        frame.add(button, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void showSnackbar(JFrame frame, String message) {
        JDialog snackbarDialog = new JDialog(frame, "", Dialog.ModalityType.MODELESS);
        snackbarDialog.setUndecorated(true);
        snackbarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        snackbarDialog.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        snackbarDialog.add(messageLabel, BorderLayout.CENTER);

        snackbarDialog.setSize(250, 50);
        snackbarDialog.setLocationRelativeTo(frame);
        snackbarDialog.setLocation(frame.getX() + (frame.getWidth()/2) - (snackbarDialog.getWidth()/2),
                frame.getY() + frame.getHeight() - 100);
        snackbarDialog.setVisible(true);

        // Timer to auto-dispose snackbar after a delay
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snackbarDialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}