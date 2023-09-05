import java.util.Scanner;

public class Player {
    char symbol;      // "X" or "O"                                         // IDEA: TIME ELEMENT FOR TURNS, IF TAKE TOO LONG SKIPS TURN?????
    String name;
    int wins;
    int loses;
    int score; // more points if win with fewer symbol placements.
    int demerits; // for timing out during turns.
    //String message;     // "X is the winner." or "O is the winner."
    public static boolean signal = false;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.wins = 0;
        this.loses = 0;
        this.score = 0;
        this.demerits = 0;
    }

    public static Player initializePlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter Player Name: ");
        String name = scanner.next();
        System.out.print("\nPlease choose a Symbol: ");
        char symbol = scanner.next().charAt(0);
        System.out.println();
        return new Player(name, symbol);
    }

    public static void displayPlayerStats(Player player1, Player player2) {
        String merge1 = player1.name + " (" + player1.symbol + ")";
        String merge2 = player2.name + " (" + player2.symbol + ")"; // necessary for name alignment
        System.out.printf(
                "*_________________________________________*\n" +
                "|              PLAYER STATS               |\n" +
                "|  %-13s         %-13s    |\n" +
                "|  ~~~~~~~~~~~~~~~       ~~~~~~~~~~~~~~~  |\n" +
                "|    wins:  %d              wins:  %d       |\n" +
                "|    loses: %d              loses: %d       |\n" +
                "|    score: %-3d            score: %-3d     |\n" +
                "*-----------------------------------------*\n" +
                "\n", merge1, merge2, player1.wins, player2.wins, player1.loses, player2.loses, player1.demerits, player2.demerits
        );
    }
}
