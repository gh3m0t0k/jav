import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;

    public DigitalClock() {
        setTitle("Digital Clocks");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Center the window

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(timeLabel, BorderLayout.CENTER);

        // Start the clock
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        updateClock(); // Initial call to set the time immediately
    }

    private void updateClock() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String currentTime = formatter.format(new Date());
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock();
            clock.setVisible(true);
        });
    }
}