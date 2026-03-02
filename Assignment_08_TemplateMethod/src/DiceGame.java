import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiceGame extends Game {

    private final int ROUNDS = 8;
    private int players;
    private int currentRound;
    private int currentPlayer;
    private Scanner scanner;
    Map<String, Integer> scores = new HashMap<>();

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.players = numberOfPlayers;
        this.scanner = new Scanner(System.in);

        for (int i = 0; i < numberOfPlayers; i++) {
            scores.put(("Player " + (i + 1)), 0);
        }
        System.out.println(scores);

        System.out.println("THE DICE GAME\nGet the highest score");
    }

    @Override
    public boolean endOfGame() {
        // Final turn for the last player
        return (currentRound == ROUNDS && currentPlayer == players);
    }

    @Override
    public void playSingleTurn(int player) {
        currentPlayer = player + 1;
        // When the first player starts a new round, add 1 to current turn
        if (player == 0) {
            currentRound++;
        }

        System.out.println("\nROUND " + currentRound + "/" + ROUNDS + "\nPlayer " + currentPlayer);
        System.out.println("Roll the dice!");
        scanner.nextLine();
        int number = (int)(Math.random()*6) + 1; // Number from 1-6
        System.out.println("Player " + currentPlayer + " rolled a " + number);
        scores.put("Player " + currentPlayer, scores.get("Player " + currentPlayer) + number);
        System.out.println("Their current score is " + scores.get("Player " + currentPlayer));
    }

    @Override
    public void displayWinner() {
        int highest = 0;
        String winner = null;
        for (String player : scores.keySet()) {
            int score = scores.get(player);
            if (score > highest) {
                highest = score;
                winner = player;
            }
        }
        System.out.println("\nGAME END");
        System.out.println("The winner is " + winner + " with the score of " + highest + "! Congratulations!");
        System.out.println("Here are all the scores: ");
        for (String player : scores.keySet()) {
            System.out.println(player + " - Score: " + scores.get(player));
        }
    }
}
