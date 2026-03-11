import javax.swing.*;
import java.awt.*;

public class Fuckyou extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        String tekst = "FUCK YOU";

        Font font = new Font("Arial", Font.BOLD, 125);
        g2.setFont(font);

        int x = 100;
        int y = 200;

        // Bakre lag for 3D-effekt
        for (int i = 20; i >= 1; i--) {
            g2.setColor(new Color(30, 30, 30));
            g2.drawString(tekst, x + i, y + i);
        }

        // Fronttekst
        g2.setColor(Color.magenta);
        g2.drawString(tekst, x, y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("3D tekst");
        Fuckyou panel = new Fuckyou();

        frame.add(panel);
        frame.setSize(900, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
