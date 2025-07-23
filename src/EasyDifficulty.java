import java.util.ArrayList;
public class EasyDifficulty extends AbstractDifficulty implements Difficulty {
    public EasyDifficulty() {
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
        return randomInteger;
    }

    public ArrayList<String> setChosenWords() {
        String chosenDifficulty = "EasyDifficulty";
        return super.setChosenWords(chosenDifficulty);
    }

    public ArrayList<String> getChosenWords() {
        return super.getChosenWords();
    }

    public int calculateNoOfAttempts() {
        noOfAttempts = 10;
        return super.calculateNoOfAttempts();
    }
}
