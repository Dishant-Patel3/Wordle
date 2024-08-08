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

public class Wordle extends JPanel {

    private String letters, word, word1;
    private Words words;
    private Letters let;
    private ArrayList<Letters> key;
    private static int count;
    private static JLabel[][] wordColumns;
    
    public Wordle() {
        setBounds(90, 40, 400, 500);
        setBackground(Color.WHITE);
        setLayout(new GridLayout(6, 5)); 
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        wordColumns = new JLabel[6][5];
        for(int i = 0; i < wordColumns.length; i++) {
            for(int j = 0; j < wordColumns[i].length; j++) {
                wordColumns[i][j] = new JLabel("");
                wordColumns[i][j].setFont(new Font("Koulen", Font.BOLD, 30));
                wordColumns[i][j].setForeground(Color.BLACK);
                wordColumns[i][j].setHorizontalAlignment(JLabel.CENTER);
                wordColumns[i][j].setOpaque(true);
                wordColumns[i][j].setBorder(blackBorder);
                wordColumns[i][j].setBackground(new Color(221, 224, 225));
                add(wordColumns[i][j]);
            }
        }      
        words = new Words();
        word = words.getRandomWord().toUpperCase();
        System.out.println("the word is " + word);
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            String guess = "";
            int row=0;
            int col=0;
            public void keyPressed(KeyEvent e) {
                if(count < 5) {
                    if(e.getKeyCode()==KeyEvent.VK_ENTER && col == 5 && row < 6) {
                        // submit guess
                        //(logic)
                        for(int i = 0; i < 5; i++) {
                            String letterGuessed = guess.substring(i, i+1);
                            String realLetter = word.substring(i, i+1);
                            if(letterGuessed.equals(realLetter)) {
                                wordColumns[row][i].setBackground(new Color(106,192,96));
                                count++;
                            } else if(word.indexOf(letterGuessed) >= 0) {
                                wordColumns[row][i].setBackground(new Color(233,206,117));
                                count = 0;
                            } else {
                                wordColumns[row][i].setBackground(new Color(101,111,112));
                                count = 0;
                            }
                        }
                        // reset, after logic
                        row++;
                        col = 0;
                        guess = "";
                    } else if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE && col > 0 && row < 6) {
                        // delete letter
                        guess = guess.substring(0, guess.length() -1);
                        col--;
                        wordColumns[row][col].setText("");
                    } else if(e.getKeyCode()!= KeyEvent.VK_ENTER && e.getKeyCode()!= KeyEvent.VK_BACK_SPACE && col < 5 && row < 6){
                        // letters
                        guess += e.getKeyText(e.getKeyCode());
                        wordColumns[row][col].setText(e.getKeyText(e.getKeyCode()));
                        col++;
                    }
                }   
            }
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);


        // JLabel panel1 = new JLabel("Q");
        // panel1.setFont(new Font("Ubuntu", Font.BOLD, 30));
        // panel1.setForeground(Color.BLACK);
        // panel1.setBounds(70, 600, 25, 25);
        // panel1.setHorizontalAlignment(JLabel.CENTER);
        // panel1.setOpaque(true);
        // panel1.setBackground(Color.GRAY);
        // panel1.setBorder(blackBorder);
        // add(panel1);
    }

    public int getCount() {
        return count;
    }
}