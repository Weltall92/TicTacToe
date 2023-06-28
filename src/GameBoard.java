public class GameBoard {
    String board = "   |   |   \n---|---|---\n   |   |   \n---|---|---\n   |   |   \n";
    String winner = null;
    int symbolsOnBoard = 0;

    public void clearBoard(GameBoard b) {
        b.board = "   |   |   \n---|---|---\n   |   |   \n---|---|---\n   |   |   \n";
    }

//    public void fillBoardWithCharacter(GameBoard b, char x) {
//        b.board = " x | x | x \n---|---|---\n x | x | x \n---|---|---\n x | x | x \n";
//
//    }

    public static boolean choosePosition(GameBoard b, int position, String symbol) {
        String updatedBoard = b.board;
        if (isPositionValid(b, position)) {     //   |   |   \n---|---|---\n   |   |   \n---|---|---\n   |   |   \n
            String segmentA;
            String segmentB;
            String segmentC;
            if (position == 1) {
                segmentA = updatedBoard.substring(0,1);
                segmentB = symbol;
                segmentC = updatedBoard.substring((2));
                b.board = segmentA + segmentB + segmentC;
                b.symbolsOnBoard++;
            }
            if (position == 2) {
                segmentA = updatedBoard.substring(0,5);
                segmentB = symbol;
                segmentC = updatedBoard.substring((6));
                b.board = segmentA + segmentB + segmentC;
                b.symbolsOnBoard++;
            }
            if (position == 3) {
                segmentA = updatedBoard.substring(0,9);
                segmentB = symbol;
                segmentC = updatedBoard.substring((10));
                b.board = segmentA + segmentB + segmentC;
                b.symbolsOnBoard++;
            }
            if (position == 4) {
                segmentA = updatedBoard.substring(0,25);
                segmentB = symbol;
                segmentC = updatedBoard.substring((26));
                b.board = segmentA + segmentB + segmentC;
                b.symbolsOnBoard++;
            }
            if (position == 5) {
                segmentA = updatedBoard.substring(0,29);
                segmentB = symbol;
                segmentC = updatedBoard.substring((30));
                b.board = segmentA + segmentB + segmentC;
                b.symbolsOnBoard++;
            }
            if (position == 6) {
                segmentA = updatedBoard.substring(0,33);
                segmentB = symbol;
                segmentC = updatedBoard.substring((34));
                b.board = segmentA + segmentB + segmentC;
                b.symbolsOnBoard++;
            }
            if (position == 7) {
                segmentA = updatedBoard.substring(0,49);
                segmentB = symbol;
                segmentC = updatedBoard.substring((50));
                b.board = segmentA + segmentB + segmentC;
                b.symbolsOnBoard++;
            }
            if (position == 8) {
                segmentA = updatedBoard.substring(0,53);
                segmentB = symbol;
                segmentC = updatedBoard.substring((54));
                b.board = segmentA + segmentB + segmentC;
                b.symbolsOnBoard++;
            }
            if (position == 9) {
                segmentA = updatedBoard.substring(0,57);
                segmentB = symbol;
                segmentC = updatedBoard.substring((58));
                b.board = segmentA + segmentB + segmentC;
                b.symbolsOnBoard++;
            }
            return true;
        }
       else {
           return false;
        }
    }

    public static boolean isPositionValid(GameBoard b, int position) {
        String substring;
        if (position == 1) {
            substring = b.board.substring(1,2);
            return (substring.equals(" "));
        }
        if (position == 2) {
            substring = b.board.substring(5,6);
            return (substring.equals(" "));
        }
        if (position == 3) {
            substring = b.board.substring(9,10);
            return (substring.equals(" "));
        }
        if (position == 4) {
            substring = b.board.substring(25,26);
            return (substring.equals(" "));
        }
        if (position == 5) {
            substring = b.board.substring(29,30);
            return (substring.equals(" "));
        }
        if (position == 6) {
            substring = b.board.substring(33,34);
            return (substring.equals(" "));
        }
        if (position == 7) {
            substring = b.board.substring(49,50);
            return (substring.equals(" "));
        }
        if (position == 8) {
            substring = b.board.substring(53,54);
            return (substring.equals(" "));
        }
        if (position == 9) {
            substring = b.board.substring(57,58);
            return (substring.equals(" "));
        }
        return false;
    }
    //  1   5   9                25  29  33                49  53  57
    //" x | x | x \n---|---|---\n x | x | x \n---|---|---\n x | x | x \n";
    public static boolean isGameOver(GameBoard b, String symbol) {
//        if (b.symbolsOnBoard == 9) {
//            b.winner = "Tie";
//            return true;
//        }
        /*else*/ if (
            b.board.substring(1,2).equals(symbol) && b.board.substring(5,6).equals(symbol) && b.board.substring(9,10).equals(symbol) ||
            b.board.substring(25,26).equals(symbol) && b.board.substring(29,30).equals(symbol) && b.board.substring(33,34).equals(symbol) ||
            b.board.substring(49,50).equals(symbol) && b.board.substring(53,54).equals(symbol) && b.board.substring(57,58).equals(symbol) ||
            b.board.substring(1,2).equals(symbol) && b.board.substring(25,26).equals(symbol) && b.board.substring(49,50).equals(symbol) ||
            b.board.substring(5,6).equals(symbol) && b.board.substring(29,30).equals(symbol) && b.board.substring(53,54).equals(symbol) ||
            b.board.substring(9,10).equals(symbol) && b.board.substring(33,34).equals(symbol) && b.board.substring(57,58).equals(symbol) ||
            b.board.substring(1,2).equals(symbol) && b.board.substring(29,30).equals(symbol) && b.board.substring(57,58).equals(symbol) ||
            b.board.substring(9,10).equals(symbol) && b.board.substring(29,30).equals(symbol) && b.board.substring(49,50).equals(symbol)
        ) {
            b.winner = symbol;
            return true;
        }
        else {
            return false;
        }
    }
}