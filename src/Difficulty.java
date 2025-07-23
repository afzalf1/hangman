import java.util.ArrayList;

//The point of this interface is that the code doesn't know what difficulty was chosen so this interface allows the code to deal with all difficulties
//All methods declared here can be used for any difficulty without having to know what difficulty was chosen

public interface Difficulty {
    int setRandomInteger();
    int getRandomInteger();
    ArrayList<String> setChosenWords();
    ArrayList<String> getChosenWords();
    int calculateNoOfAttempts();
}
