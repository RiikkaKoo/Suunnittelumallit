import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanGame extends Game {

    private boolean isEnd = false;
    private boolean isCorrectGuess;
    private final int MAX_TRIES = 8;
    private int currentTries;
    private int currentRound;
    private int playersLeft;
    private Scanner scanner;
    private String word;
    List<Integer> known = new ArrayList<>();

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("THE HANGMAN GAME\nGuess the word");
        if (numberOfPlayers < 2) {
            System.out.println("Hangman must have at least two players");
            isEnd = true;
        } else {
            this.scanner = new Scanner(System.in);
            currentTries = 0;
            playersLeft = numberOfPlayers - 1;
        }
    }

    @Override
    public boolean endOfGame() {
        if (currentTries >= MAX_TRIES) {
            isEnd = true;
        } else if (isCorrectGuess) {
            isEnd = true;
        }
        return isEnd;
    }

    @Override
    public void playSingleTurn(int player) {
        if (player == 0 && currentRound == 0) {
            currentRound++;
            System.out.println("\nPlayer " + 1 + " enter a word: ");
            this.word = scanner.nextLine().toUpperCase();

            // Hide the word by adding empty lines
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        } else if (player != 0) {
            System.out.println("\nTRIES LEFT: " + (MAX_TRIES - currentTries));
            displayCurrentWord();
            System.out.println("\nGuessers, what do you want to do: ");
            System.out.println("1. Guess a letter (Wrong guess = -" + (int) (1 + (playersLeft*1.75/10)) + ")");
            System.out.println("2. Guess the word (Wrong guess = -" + (int) (2 + (playersLeft*1.75/10)) + ")");
            boolean isCorrectInput = false;
            while (!isCorrectInput) {
                switch (scanner.nextInt()) {
                    case 1:
                        guessLetter();
                        isCorrectInput = true;
                        break;
                    case 2:
                        guessWord();
                        isCorrectInput = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("\nGAME END");
        System.out.println("The word was " + word);
        if (isCorrectGuess) {
            System.out.println("The guessers have won! Congratulations!");
        } else {
            System.out.println("The guessers have lost.");
        }
    }

    private void guessLetter() {
        scanner.nextLine();
        System.out.println("Enter a letter: ");
        char letter = scanner.nextLine().charAt(0);
        if (word.indexOf(Character.toUpperCase(letter)) != -1) {
            System.out.println("Word does contain letter " + Character.toUpperCase(letter));
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == Character.toUpperCase(letter)) {
                    known.add(i);
                }
            }
        } else {
            System.out.println("Word does not contain letter " + Character.toUpperCase(letter));
        }
        currentTries += (int) (1 + (playersLeft*1.75/10));
    }

    private void guessWord() {
        scanner.nextLine();
        System.out.println("What is the word: ");
        String guess = scanner.nextLine().toUpperCase();
        if (guess.equals(word)) {
            System.out.println("That is the correct word!");
            isCorrectGuess = true;
        } else {
            System.out.println("That is not the correct word!");
            System.out.println("You have lost two tries.");
            currentTries += (int) (2 + (playersLeft*1.75/10));
            if (playersLeft != 0) playersLeft--;
        }
    }

    private void displayCurrentWord() {
        for (int i = 0; i < word.length(); i++) {
            if (known.contains(i)) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
    }

}
