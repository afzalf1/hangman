import java.util.ArrayList;

public class WordSelector {
    private final String target; //Where the target word will be stored
    private final HangmanGame hangmanGame; //Declared hangmanGame here so can be used throughout the class
    private final Difficulty difficulty; //This instance of "Difficulty" represents either easy, medium or hard, whatever was chosen

    public WordSelector(HangmanGame hangmanGame) {
        this.hangmanGame = hangmanGame;
        this.difficulty = setDifficulty();
        this.target = setTarget();
    }

    public Difficulty setDifficulty() { //Gets the chosen difficulty and creates an instance of that difficulty's class
        if (hangmanGame.getChosenDifficulty().equals("easy")) {
            return new EasyDifficulty(); //If easy was chosen, create an instance of the EasyDifficulty class
        } else if (hangmanGame.getChosenDifficulty().equals("medium")) {
            return new MediumDifficulty(); //If medium was chosen, create an instance of the MediumDifficulty class
        } else {
            return new HardDifficulty(); //If hard was chosen, create an instance of the HardDifficulty class
        }
    }

    public String setTarget() {
        ArrayList<String> words = difficulty.getChosenWords(); //Retrieves all the words at the chosen difficulty level
        return words.get(difficulty.getRandomInteger()); //Randomly chooses a word in the chosen difficulty level in the retrieved arraylist before and returns it
    }

    public int totalNoOfAttempts() {
        return difficulty.calculateNoOfAttempts();
    }

    public String getTarget() {
        return target;
    } //Returns the target word
}
