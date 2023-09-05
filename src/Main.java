import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        GameBoard.instructions();
        Player player1 = Player.initializePlayer();
        Player player2 = Player.initializePlayer();
        Player.displayPlayerStats(player1, player2);
        GameBoard myBoard = new GameBoard();

        char[] elipsis = {'.','.','.','.','.','.'};
        System.out.println("~READY!~");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(200);
                if (i == 3) System.out.print("\n ");
                System.out.print(elipsis[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("~SET!~");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(200);
                if (i == 3) System.out.print("\n ");
                System.out.print(elipsis[i]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("~GO!!!~\n");


        //myBoard.displayCurrentBoard();
        if (player1.symbol == 'X' || player1.symbol == 'x') {
            myBoard.displayCurrentBoard_Version_X();
        }
        else {
            myBoard.displayCurrentBoard_VariableSymbol(player1.symbol);
        }

        boolean playAgain = true;
        String choiceStr;
        int choice;
        Scanner scanner = new Scanner(System.in);
        Player turn;
        int count = 0;
        //boolean signal = false;

        while (playAgain) {

            while (true) {
                count++;
                if (count % 2 == 1) {
                    turn = player1;
                }
                else {
                    turn = player2;
                }


                long startTime = System.currentTimeMillis();
                System.out.println();
                System.out.print("4  ...  ");
                Timer t1 = new Timer();
                t1.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.print("3  ...  ");
                    }
                }, 1000);
                Timer t2 = new Timer();
                t2.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.print("2  ...  ");
                    }
                }, 2000);
                Timer t3 = new Timer();
                t3.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.print("1  ...  ");
                    }
                }, 3000);

//                // BEGIN TIMER?
//                Timer timer = new Timer();
//                TimerTask task = new TimerTask() {
//                    //Player.signal = false;
//                    @Override
//                    public void run() { //stores code for thread (task)
//                        System.out.println("TIME'S UP! TURN SKIPPED!!!\n");
//                        Player.signal = true;
//                    }
//                };
//
//                timer.schedule(task, 2000);
//                if (Player.signal) {
//                    Player.signal = false;
//                    continue;
//                }
                //

//                CountdownTimer timer1 = new CountdownTimer(2);
//                timer1.run();
//                if (timer1.getSeconds() == 0) {
//                    System.out.println("TURN SKIPPED!!!");
//                    continue;
//                }
                //

                while (!scanner.hasNextInt()) scanner.next();
                choice = scanner.nextInt();

//                if (Player.signal) {
//                    Player.signal = false;
//                    continue;
//                }

//                if (timer1.getSeconds() == 0) {
//                    System.out.println("TURN SKIPPED!!!");
//                    continue;
//                }

                while ((choice < 1 || choice > 9) || !myBoard.isPositionValid2(choice)) {       // need to take string then parseInt to check????
                    while (!scanner.hasNextInt()) scanner.next();///
                    turn.demerits--;
                    choice = scanner.nextInt();
                }
//                timer.cancel();
                t1.cancel();
                t2.cancel();
                t3.cancel();

                long endTime = System.currentTimeMillis();

                if (endTime - startTime > 4000) {
                    System.out.println("TURN SKIPPED!!!");
                    System.out.println();
                    turn.demerits--;
                    if (turn.symbol == 'X' || turn.symbol == 'x') {         // WHERE CAN THIS BLOCK OF CODE AS A METHOD BE PUT?
                        myBoard.displayCurrentBoard_Version_O();
                    }
                    else if (turn.symbol == 'O' || turn.symbol == 'o') {
                        myBoard.displayCurrentBoard_Version_X();
                    }
                    else {
                        if (turn.symbol == player1.symbol) {
                            myBoard.displayCurrentBoard_VariableSymbol(player2.symbol);
                        }
                        else {
                            myBoard.displayCurrentBoard_VariableSymbol(player1.symbol);
                        }
                    }
                    continue;
                }
                myBoard.choosePosition2(choice, turn.symbol);
                //myBoard.displayCurrentBoard();
                if (turn.symbol == 'X' || turn.symbol == 'x') {
                    myBoard.displayCurrentBoard_Version_O();
                }
                else if (turn.symbol == 'O' || turn.symbol == 'o') {
                    myBoard.displayCurrentBoard_Version_X();
                }
                else {
                    if (turn.symbol == player1.symbol) {
                        myBoard.displayCurrentBoard_VariableSymbol(player2.symbol);
                    }
                    else {
                        myBoard.displayCurrentBoard_VariableSymbol(player1.symbol);
                    }
                }
                if (myBoard.isGameOver2(turn.symbol)) {
                    System.out.printf("%s (%c) is the winner!\n", turn.name, turn.symbol);
                    turn.wins++;
                    //score++
                    break;
                }
                if (myBoard.symbolsOnBoard == 9) {
                    System.out.println("Tie.");
                    //tie++
                    break;
                }


//                choice = scanner.nextInt();
//                while (!myBoard.isPositionValid2(choice)) {
//                    choice = scanner.nextInt();
//                }
//                myBoard.choosePosition2(choice, 'O');
//                myBoard.displayCurrentBoard();
//                if (myBoard.isGameOver2('O')) {
//                    System.out.println("O is the winner!");
//                    break;
//                }
//                if (myBoard.symbolsOnBoard == 9) {
//                    System.out.println("Tie.");
//                    break;
//                }

            }


            System.out.println("Play again?           Y/N");
            System.out.println("Check Player stats?   S");
            String answer = scanner.next();
            while (!answer.equalsIgnoreCase("N") && !answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("S")) {
                answer = scanner.next();
            }
            if (answer.equalsIgnoreCase("N")) {
                playAgain = false;
                break;
            }
            if (answer.equalsIgnoreCase("Y")) {
                myBoard.clearBoard();
                if (turn.symbol == 'X' || turn.symbol == 'x') {         // WHERE CAN THIS BLOCK OF CODE AS A METHOD BE PUT?
                    myBoard.displayCurrentBoard_Version_O();
                }
                else if (turn.symbol == 'O' || turn.symbol == 'o') {
                    myBoard.displayCurrentBoard_Version_X();
                }
                else {
                    if (turn.symbol == player1.symbol) {
                        myBoard.displayCurrentBoard_VariableSymbol(player2.symbol);
                    }
                    else {
                        myBoard.displayCurrentBoard_VariableSymbol(player1.symbol);
                    }
                }
                //myBoard.displayCurrentBoard();
            }
            if (answer.equalsIgnoreCase("S")) {
                Player.displayPlayerStats(player1, player2);
                System.out.println("\nPlay again?          Y/N");
                answer = scanner.next();

                if (answer.equalsIgnoreCase("N")) {/////////// CLEAN THIS UP / BETTER IMPLEMENTATION RATHER THAN THIS REDUNDANCY?
                    playAgain = false;
                    break;
                }
                if (answer.equalsIgnoreCase("Y")) {///////////////
                    myBoard.clearBoard();
                    //myBoard.displayCurrentBoard();
                    if (turn.symbol == 'X' || turn.symbol == 'x') {         // WHERE CAN THIS BLOCK OF CODE AS A METHOD BE PUT?
                        myBoard.displayCurrentBoard_Version_O();
                    }
                    else if (turn.symbol == 'O' || turn.symbol == 'o') {
                        myBoard.displayCurrentBoard_Version_X();
                    }
                    else {
                        if (turn.symbol == player1.symbol) {
                            myBoard.displayCurrentBoard_VariableSymbol(player2.symbol);
                        }
                        else {
                            myBoard.displayCurrentBoard_VariableSymbol(player1.symbol);
                        }
                    }
                }

            }


        }

        System.out.println("Goodbye!");

    }

    //public static void placePiece(){}

}
