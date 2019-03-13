
import java.util.ArrayList;


public class Hangman {
    private String secretWord;
    private String hint;
    private int guessesLeft;
    private int wordLength;

    public Hangman(String secretWord, String hint) {
        this.secretWord = secretWord;
        this.hint = hint;
        this.guessesLeft = 8;
        this.wordLength = secretWord.length();
    }

    public String verifyGuess(char guess) {
        ArrayList<Integer> wordChars = new ArrayList<>();
        char wordChar;
        String guessedWord;
        for (int i = 0; i < this.wordLength; i++) {
            wordChar = this.secretWord.charAt(i);
            if (guess == wordChar) {
                wordChars.add(i);
            }
        }
        if (!wordChars.isEmpty()) {
            modifyHint(wordChars, guess);
            wordChars.clear();
            guessedWord = "That guess is correct.";
        } else {
            guessedWord = "There are no " + guess + "'s in the word.";
            this.guessesLeft--;
        }

        return guessedWord;

    }

    private void modifyHint(ArrayList<Integer> chars, char guess) {
        StringBuilder hintBuilder = new StringBuilder();
        for (int i = 0; i < this.wordLength; i++) {
            hintBuilder.append(chars.contains(i) ? guess : this.hint.charAt(i));
        }
        this.hint = hintBuilder.toString();
    }

    public boolean compareSecretWord() {
        return this.secretWord.equals(this.hint);
    }

    public String displayHint() {
        return "The word now looks like this: " + this.hint;
    }

    public String showGuessesLeft() {
        return "You have " + this.guessesLeft + " guesses left.";
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
