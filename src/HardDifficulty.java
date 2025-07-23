import java.util.ArrayList;
public class HardDifficulty extends AbstractDifficulty implements Difficulty {
    public HardDifficulty() {
        super("words_list.txt"); //Applies the constructor in the abstract class readerRetriever to "words_list.txt"
        words = setChosenWords();
        randomInteger = setRandomInteger();
    }

    @Override
    public String getLine() {
        return super.getLine();
    }

    public int setRandomInteger() {
        return super.setRandomInteger();
    }

    public int getRandomInteger() {
        return super.getRandomInteger();
    }

    public ArrayList<String> setChosenWords() {
        String chosenDifficulty = "HardDifficulty";
        return super.setChosenWords(chosenDifficulty);
    }

    public ArrayList<String> getChosenWords() {
        return super.getChosenWords();
    }

    public int calculateNoOfAttempts() {
        noOfAttempts = 6;
        return super.calculateNoOfAttempts();
    }
}
