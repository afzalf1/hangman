import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//I have used lots of super classes here to avoid repeat code in the EasyDifficulty, MediumDifficulty and HardDifficulty classes since they all use very similar code
//All variables and methods are protected, allowing the subclasses EasyDifficulty, MediumDifficulty and HardDifficulty to use them without other classes also using them

public abstract class AbstractDifficulty {
    protected int noOfWords; //Stores number of words in the chosen difficulty
    protected int randomInteger; //Stores a random integer to randomly choose a word in the chosen difficulty
    protected int noOfAttempts; //Stores number of attempts in the chosen difficulty
    ArrayList<String> words; //Stores the words in the chosen difficulty
    protected BufferedReader reader; //Allows the "words_list.txt" file to be read
    protected AbstractDifficulty(String fileName) { //Now the easy, medium and hard classes can get this BufferedReader in their constructors using super();
        try {
            reader = new BufferedReader(new FileReader(fileName)); //reader now holds the relevant file
        } catch (IOException e) {
            System.out.println("File not found"); //Error exception for convention
        }
    }

    protected String getLine() {
        try {
            return reader.readLine(); //Returns the line of the file
        } catch (IOException e) {
            return "File not found";
        }
    }

    protected int setRandomInteger() {
        Random random = new Random();
        return random.nextInt(noOfWords); //Returns a random integer in the range of the number of words in the chosen difficulty level
    }

    protected int getRandomInteger() {
        return randomInteger; //Just returns the random integer that was created in setRandomInteger()
    }

    protected ArrayList<String> setChosenWords(String chosenDifficulty) { //Stores all the words of the difficulty chosen
        ArrayList<String> possibleWords = new ArrayList<>();
        while (reader != null) { //Loop runs until the reader reaches the end of the file
            String line = getLine();
            if (line == null) break;
            String[] parts = line.split(" ");
            if (parts[1].equals(chosenDifficulty)) {
                possibleWords.add(parts[0].toUpperCase());
            }
        }
        noOfWords = possibleWords.size();
        return possibleWords;
    }

    protected ArrayList<String> getChosenWords() {
        return words;
    }

    protected int calculateNoOfAttempts() {
        return noOfAttempts;
    }
}
