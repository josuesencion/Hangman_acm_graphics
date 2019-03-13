import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class HangmanApp extends ConsoleProgram {

    private HangmanCanvas canvas;

    public void init() {
        this.canvas = new HangmanCanvas();
        add(this.canvas);
    }

    public void run() {

        println("Welcome to Hangman");

        HangmanLexicon lexicon = new HangmanLexicon();
        Hangman game = new Hangman(lexicon.getRandWord(), lexicon.getHint());

        while (!game.compareSecretWord() && game.getGuessesLeft() != 0) {
            this.canvas.displayWord(game.getHint());
            println(game.displayHint());
            println(game.showGuessesLeft());
            char guess = readLine("Your guess: ").toUpperCase().charAt(0);
            println(game.verifyGuess(guess));
            this.canvas.reset();
        }

        if (game.compareSecretWord()) {
            println("You guessed the word: " + game.getSecretWord());
        } else {
            println("You lost. The word is: " + game.getSecretWord());
            this.canvas.displayWord(game.getSecretWord());
        }
    }

    public static void main(String[] args) {
        new HangmanApp().start(args);
    }
}
