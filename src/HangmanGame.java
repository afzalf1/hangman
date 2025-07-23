import java.util.ArrayList;
public class HangmanGame {
    private Utils utils = new Utils(); //Has been slightly edited by removing the print statement "Please enter a String" as it was redundant
    private String chosenDifficulty; //Stores the string of the chosen difficulty
    private int totalNoOfAttempts;
    private final ArrayList<Character> targetArray;
    private ArrayList<Character> guesses = new ArrayList<>();
    private final String targetWord;

    public HangmanGame() { //Sets the difficulty, number of attempts and the target word as well as the target arraylist to help play the game
        this.chosenDifficulty = setChosenDifficulty();//Ensures the difficulty stays constant and can be retrieved throughout the game
        WordSelector wordSelector = new WordSelector(this);
        this.totalNoOfAttempts = wordSelector.totalNoOfAttempts();
        targetWord = wordSelector.getTarget();
        targetArray = convertWordToArray(targetWord); //Arraylist is used for checking if a character exists in the array or the target word
    }

    public String setChosenDifficulty() {
        System.out.println("What difficulty do you want to use? (Easy, Medium, Hard): ");
        chosenDifficulty = utils.readStringFromCmd().toLowerCase();
        if (!chosenDifficulty.equals("easy") && !chosenDifficulty.equals("medium") && !chosenDifficulty.equals("hard")) {
            System.out.println("You entered an invalid difficulty!");
            return setChosenDifficulty(); //This recursively asks the user for the difficulty until they give a valid difficulty. Recursion makes the code here clean and tidy.
        } else {
            return chosenDifficulty; //This returns the string difficulty and will soon be used to get the target word for the respective difficulty
        }
    }
    public String getChosenDifficulty() {
        return chosenDifficulty; //Very easily retrieve the string difficulty
    }

    public ArrayList<Character> convertWordToArray(String word) { //Converts the target (or any word) to an arraylist
        ArrayList<Character> array = new ArrayList<>();
        int noOfCharacters = word.length();
        for (int i = 0; i < noOfCharacters; i++) {
            array.add(word.charAt(i));
        }
        return array;
    }

    public void play() { //Once the target word and number of attempts have been retrieved, the game is played using this method
        int attemptsLeft = totalNoOfAttempts;
        char characterGuess;
        ArrayList<Character> userProgressArray = new ArrayList<>();
        System.out.print("Your word: ");
        for (char c : targetArray) {
            userProgressArray.add('_'); //This for loop creates the underscore placeholders in the user's progress arraylist
        }
        for (char c : userProgressArray) { //Prints the user's progress from the arraylist
            System.out.print(c);
            System.out.print(" ");
        }
        while (attemptsLeft > 0) { //The game officially starts here
            System.out.println("\nEnter a letter: ");
            String characterGuessString = utils.readStringFromCmd().toUpperCase(); //Turns the character(s) uppercase to remove case sensitivity
            if (characterGuessString.length() != 1) { //Checks if the input is one character long
                System.out.println("Enter one character!");
            } else if (!Character.isLetter(characterGuessString.charAt(0))) { //Checks if the character is in the alphabet or not
                System.out.println("You entered an invalid character!");
            } else { //If the character entered is a valid letter of the alphabet, then give either correct or incorrect in this else statement
                characterGuess = characterGuessString.charAt(0);
                if (guesses.contains(characterGuess)) {
                    System.out.println("You already guessed that letter!");
                    yourWordAndAttemptsLeft(userProgressArray, attemptsLeft);
                    continue; //Run the loop again so that the user can enter a valid letter
                }
                guesses.add(characterGuess); //Now the guess is valid and is added to the arraylist of guesses
                if (!targetArray.contains(characterGuess)) { //If the guess is not correct then reduce the attempts left and loop back round
                    attemptsLeft--;
                    System.out.println("Incorrect!");
                    yourWordAndAttemptsLeft(userProgressArray, attemptsLeft);
                    continue;
                }
                for (int j = 0; j < userProgressArray.size(); j++) { //Now the guess is correct and the user progress arraylist is updated
                    if (targetArray.get(j).equals(characterGuess)) {
                        userProgressArray.set(j, characterGuess); //Replaces all the underscores with the correct guess at the correct positions of the target word
                    }
                }
                System.out.println("Correct!");
                if (userProgressArray.equals(targetArray)) { //This statement is not needed but is put so that the attempts left aren't said just before winning (looks cleaner)
                    win();
                }
                yourWordAndAttemptsLeft(userProgressArray, attemptsLeft);
            }
            if (userProgressArray.equals(targetArray)) {
                win();
            }
        }
        lose(); //Only runs if the while loop ends i.e. attemptsLeft = 0
    }
    public void yourWordAndAttemptsLeft(ArrayList<Character> userProgressArray, int attemptsLeft) { //Prints the user's progress and attempts left
        System.out.print("Your word: ");
        for (char c : userProgressArray) {
            System.out.print(c); //This prints out the user's progress by not going to a new line in each print, just printing on the same line and printing each character separately
            System.out.print(" "); //Separates each character to make it easier to read
        }
        System.out.println("\nAttempts left: " + attemptsLeft);
    }

    public void win() {
        System.out.println("\nYou won!");
        System.exit(0);
    }

    public void lose() {
        System.out.println("\nYou lost!");
        System.out.println("Word was: " + targetWord.toLowerCase());
        System.exit(0);
    }


    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame(); //Sets up the game including the difficulty and target word
        hangmanGame.play(); //Starts the actual hangmanGame game
    }
}