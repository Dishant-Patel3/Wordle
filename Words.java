import java.util.Random;

public class Words {
    private final String[] Words;

    public Words(){
        Words = new String[]{"HELLO", "JOKES", "HOLES", "PAYNE", "PATEL", "DATTA", "SHREK", "BOOYA", "HOUSE", "SHOTY"};
    }

    public String getRandomWord() {
        Random rand = new Random();
        return Words[rand.nextInt(Words.length)];
    }
}