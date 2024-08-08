import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class Letters extends JLabel {
    private int x, y;
    private Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
    public Letters(int x, int y) {
        this.x = x;
        this.y = y;
        setBounds(x, y, 60, 60);
        setFont(new Font("Koulen", Font.BOLD, 21));
        setText("");
        setForeground(Color.BLACK);
        setBackground(Color.GRAY);
        setBorder(blackBorder);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setOpaque(true);
    }
}
