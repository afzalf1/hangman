import java.util.ArrayList;
public class MediumDifficulty extends AbstractDifficulty implements Difficulty {
    public MediumDifficulty() {
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
        String chosenDifficulty = "MediumDifficulty";
        return super.setChosenWords(chosenDifficulty);
    }

    public ArrayList<String> getChosenWords() {
        return super.getChosenWords();
    }

    public int calculateNoOfAttempts() {
        noOfAttempts = 8;
        return super.calculateNoOfAttempts();
    }
}
