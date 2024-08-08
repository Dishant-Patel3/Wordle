import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
public class Game extends JPanel {
    private Letters let;
    private ArrayList<Letters> key;
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        Game key = new Game();
        Wordle wordle = new Wordle();
        JLabel label = new JLabel("WORDLE");
        label.setFont(new Font("Ubuntu", Font.BOLD, 30));
        label.setForeground(Color.BLACK);
        label.setBounds(220, 5, 500, 35);
        frame.add(label);
        frame.setSize(600, 800);
        frame.setTitle("TypoCommand - Patel");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(key);
        frame.add(wordle);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public Game() {
        key = new ArrayList<Letters>();
        int x1 = 80;
        int y1 = 550;
        int let1 = 0;
        for(int k = 0; k < 6; k++) {
            x1 = 80;
            for(int j = 0; j < 5; j++) {
                key.add(new Letters(x1, y1));
                x1+=60;
                add(key.get(let1));
                repaint();
                let1++;
            }
            y1+=60;
        }
        let1 = 0;
    }
}