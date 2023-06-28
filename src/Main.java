import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard myBoard = new GameBoard();
        System.out.println(myBoard.board);

//        System.out.println(GameBoard.isPositionValid(myBoard,1));
//        System.out.println(myBoard.board);
//        boolean z = GameBoard.choosePosition(myBoard, 9, "X");
//        System.out.println(myBoard.board);
//        System.out.println(z);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choice;
            while (true) {

                // Class.PlayerTurn(myBoard, choice, symbol);

                choice = 0;
                while (!GameBoard.isPositionValid(myBoard, choice)) {
                    choice = scanner.nextInt();
                }
                GameBoard.choosePosition(myBoard, choice, "X");
                System.out.println(myBoard.board);
                //System.out.println(GameBoard.isGameOver(myBoard, "X"));
                if (GameBoard.isGameOver(myBoard, "X")) {
                    System.out.println("X is the winner.");
                    //System.out.println("%s is the winner.", myBoard.winner);
                    break;
                }
                if (myBoard.symbolsOnBoard == 9) {
                    System.out.println("Tie.");
                    break;
                }

                choice = 0;
                while (!GameBoard.isPositionValid(myBoard, choice)) {
                    choice = scanner.nextInt();
                }
                GameBoard.choosePosition(myBoard, choice, "O");
                System.out.println(myBoard.board);
                if (GameBoard.isGameOver(myBoard, "O")) {
                    System.out.println("O is the winner.");
                    //System.out.println("%s is the winner.", myBoard.winner);
                    break;
                }
                if (myBoard.symbolsOnBoard == 9) {
                    System.out.println("Tie.");
                    break;
                }
            }
            break;
        }


    }

    //public static void placePiece(){}

}
