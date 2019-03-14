import acm.program.*;

public class HangmanApp extends ConsoleProgram {

    private HangmanCanvas canvas;

    public void init() {
        this.canvas = new HangmanCanvas();
        add(this.canvas);
    }

    public void run() {
        setTitle("Hangman");
        println("Welcome to Hangman");

        char playAgain;

        do {
            this.canvas.reset();
            HangmanLexicon lexicon = new HangmanLexicon();
            Hangman game = new Hangman(lexicon.getRandWord(), lexicon.getHint());

            while (!game.compareSecretWord() && game.getGuessesLeft() != 0) {
                this.canvas.drawFigure(game.getGuessesLeft());
                this.canvas.displayHint(game.getHint());
                println(game.displayHint());
                println(game.showGuessesLeft());
                char guess = readLine("Your guess: ").toUpperCase().charAt(0);
                println(game.verifyGuess(guess));
                this.canvas.reset();
            }

            if (game.compareSecretWord()) {
                println("You guessed the word: " + game.getSecretWord());
            } else {
                println("You lose! The word is: " + game.getSecretWord());
                this.canvas.drawFigure(game.getGuessesLeft());
                this.canvas.displayHint("You lose! The word is: ");
                this.canvas.displaySecretWord(game.getSecretWord());
            }

            playAgain = readLine("Would you like to play again? Y/N: ").charAt(0);
        } while (playAgain == 'Y' || playAgain == 'y');

        println("Thank you for playing Hangman! Get lost, bitch!");
    }

    public static void main(String[] args) {
        new HangmanApp().start(args);
    }
}
