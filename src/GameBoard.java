public class GameBoard {
    private String board = "   |   |   \n---|---|---\n   |   |   \n---|---|---\n   |   |   \n";


    int symbolsOnBoard = 0;
    char[] XOorSPACE = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private String boardSkeleton = " %c | %c | %c \n---|---|---\n %c | %c | %c \n---|---|---\n %c | %c | %c \n";

    public void clearBoard() {
        for (int i = 0; i < 9; i++) {
            this.XOorSPACE[i] = ' ';
            this.symbolsOnBoard = 0;
        }
    }

//    public void fillBoardWithCharacter(GameBoard b, char x) {
//        b.board = " x | x | x \n---|---|---\n x | x | x \n---|---|---\n x | x | x \n";
//
//    }

    public String getBoard() {
        return this.board;
    }

    public String getBoardSkeleton() {
        return this.boardSkeleton;
    }

    public boolean choosePosition(int position, String symbol) {
        String updatedBoard = this.board;
        if (isPositionValid(this, position)) {     //   |   |   \n---|---|---\n   |   |   \n---|---|---\n   |   |   \n
            String segmentA;
            String segmentB;
            String segmentC;
            if (position == 1) {
                segmentA = updatedBoard.substring(0,1);
                segmentB = symbol;
                segmentC = updatedBoard.substring((2));
                this.board = segmentA + segmentB + segmentC;
                this.symbolsOnBoard++;
            }
            if (position == 2) {
                segmentA = updatedBoard.substring(0,5);
                segmentB = symbol;
                segmentC = updatedBoard.substring((6));
                this.board = segmentA + segmentB + segmentC;
                this.symbolsOnBoard++;
            }
            if (position == 3) {
                segmentA = updatedBoard.substring(0,9);
                segmentB = symbol;
                segmentC = updatedBoard.substring((10));
                this.board = segmentA + segmentB + segmentC;
                this.symbolsOnBoard++;
            }
            if (position == 4) {
                segmentA = updatedBoard.substring(0,25);
                segmentB = symbol;
                segmentC = updatedBoard.substring((26));
                this.board = segmentA + segmentB + segmentC;
                this.symbolsOnBoard++;
            }
            if (position == 5) {
                segmentA = updatedBoard.substring(0,29);
                segmentB = symbol;
                segmentC = updatedBoard.substring((30));
                this.board = segmentA + segmentB + segmentC;
                this.symbolsOnBoard++;
            }
            if (position == 6) {
                segmentA = updatedBoard.substring(0,33);
                segmentB = symbol;
                segmentC = updatedBoard.substring((34));
                this.board = segmentA + segmentB + segmentC;
                this.symbolsOnBoard++;
            }
            if (position == 7) {
                segmentA = updatedBoard.substring(0,49);
                segmentB = symbol;
                segmentC = updatedBoard.substring((50));
                this.board = segmentA + segmentB + segmentC;
                this.symbolsOnBoard++;
            }
            if (position == 8) {
                segmentA = updatedBoard.substring(0,53);
                segmentB = symbol;
                segmentC = updatedBoard.substring((54));
                this.board = segmentA + segmentB + segmentC;
                this.symbolsOnBoard++;
            }
            if (position == 9) {
                segmentA = updatedBoard.substring(0,57);
                segmentB = symbol;
                segmentC = updatedBoard.substring((58));
                this.board = segmentA + segmentB + segmentC;
                this.symbolsOnBoard++;
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
            //b.winner = symbol;
            return true;
        }
        else {
            return false;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean isPositionValid2(int position) {
        if (this.XOorSPACE[position-1] == ' ') return true;
        else return false;
    }

    public void choosePosition2(int position, char symbol) {
        //String updateBoard = this.boardSkeleton;
        if (this.isPositionValid2(position)) {
            XOorSPACE[position-1] = symbol;
            symbolsOnBoard++;
        }
    }

    public boolean isGameOver2(char symbol) {
        if (this.XOorSPACE[0] == symbol && this.XOorSPACE[1] == symbol && this.XOorSPACE[2] == symbol ||
            this.XOorSPACE[3] == symbol && this.XOorSPACE[4] == symbol && this.XOorSPACE[5] == symbol ||
            this.XOorSPACE[6] == symbol && this.XOorSPACE[7] == symbol && this.XOorSPACE[8] == symbol ||
            this.XOorSPACE[0] == symbol && this.XOorSPACE[3] == symbol && this.XOorSPACE[6] == symbol ||
            this.XOorSPACE[1] == symbol && this.XOorSPACE[4] == symbol && this.XOorSPACE[7] == symbol ||
            this.XOorSPACE[2] == symbol && this.XOorSPACE[5] == symbol && this.XOorSPACE[8] == symbol ||
            this.XOorSPACE[0] == symbol && this.XOorSPACE[4] == symbol && this.XOorSPACE[8] == symbol ||
            this.XOorSPACE[2] == symbol && this.XOorSPACE[4] == symbol && this.XOorSPACE[6] == symbol
        ) return true;
        else return false;
    }

    public void displayCurrentBoard() {
        boardSkeleton = String.format(this.boardSkeleton, this.XOorSPACE[0], this.XOorSPACE[1], this.XOorSPACE[2],
                                                          this.XOorSPACE[3], this.XOorSPACE[4], this.XOorSPACE[5],
                                                          this.XOorSPACE[6], this.XOorSPACE[7], this.XOorSPACE[8]);
//        boardSkeleton = String.format(" %c | %c | %c \n---|---|---\n %c | %c | %c \n---|---|---\n %c | %c | %c \n",
//                this.XOorSPACE[0], this.XOorSPACE[1], this.XOorSPACE[2],
//                this.XOorSPACE[3], this.XOorSPACE[4], this.XOorSPACE[5],
//                this.XOorSPACE[6], this.XOorSPACE[7], this.XOorSPACE[8]);
        System.out.println(boardSkeleton);
        boardSkeleton = " %c | %c | %c \n---|---|---\n %c | %c | %c \n---|---|---\n %c | %c | %c \n";
    }

    public void displayCurrentBoard_VariableSymbol(char symbol) {
        boardSkeleton = " %c | %c | %c \n---|---|---\n %c | %c | %c      %c TURN\n---|---|---\n %c | %c | %c \n";
        boardSkeleton = String.format(this.boardSkeleton, this.XOorSPACE[0], this.XOorSPACE[1], this.XOorSPACE[2],
                this.XOorSPACE[3], this.XOorSPACE[4], this.XOorSPACE[5], symbol,
                this.XOorSPACE[6], this.XOorSPACE[7], this.XOorSPACE[8]);
        System.out.println(boardSkeleton);
    }

    ///DISPLAY CURRENT BOARD (X VERSION) ADJACENT TO PLAYER TURN GRAPHIC
    public void displayCurrentBoard_Version_X() {
        String board = " %c | %c | %c     \\   /" +
                      "\n---|---|---     \\ /" +
                      "\n %c | %c | %c      / \\" +
                    "\n---|---|---    /   \\" +
                "\n %c | %c | %c     X TURN \n";
        board = String.format(board, this.XOorSPACE[0], this.XOorSPACE[1], this.XOorSPACE[2],
                this.XOorSPACE[3], this.XOorSPACE[4], this.XOorSPACE[5],
                this.XOorSPACE[6], this.XOorSPACE[7], this.XOorSPACE[8]);
        System.out.println();
        System.out.print(board);
    }

    public void displayCurrentBoard_Version_O() {
        String board = " %c | %c | %c     /   \\" +
                      "\n---|---|---   |     |" +
                      "\n %c | %c | %c    |     |" +
                      "\n---|---|---    \\___/" +
                      "\n %c | %c | %c     O TURN \n";
        board = String.format(board, this.XOorSPACE[0], this.XOorSPACE[1], this.XOorSPACE[2],
                this.XOorSPACE[3], this.XOorSPACE[4], this.XOorSPACE[5],
                this.XOorSPACE[6], this.XOorSPACE[7], this.XOorSPACE[8]);
        System.out.println("                ___");
        System.out.print(board);
    }

    public static void instructions() {
        System.out.println(
             "*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*\n" +
                "*    ____________________                             ____________________       ___                         ____________________             ____________         *\n" +
                "*    \\\\\\______    _______\\                            \\\\\\______    _______\\     //  \\                        \\\\\\______    _______\\            \\\\    ______\\        *\n" +
                "*           \\\\\\  .\\        (( o )   _______                  \\\\\\  .\\           ///\\  \\    _______                   \\\\\\  .\\       __________   \\\\   \\____          *\n" +
                "*            \\\\\\  .\\        \\\\  \\   \\\\   ____\\     /\\         \\\\\\  .\\         ///==\\  \\   \\\\   ____\\     /\\          \\\\\\  .\\      \\\\   ___  \\   \\\\    ____\\        *\n" +
                "*             \\\\\\  .\\__      \\\\  \\   \\\\  \\____     \\/          \\\\\\  .\\__     ///    \\  \\   \\\\  \\____     \\/           \\\\\\  .\\___   \\\\  \\__\\  \\   \\\\   \\______      *\n" +
                "*              \\\\\\______\\     \\\\__\\   \\\\______|                 \\\\\\______\\  ///      \\__\\   \\\\_______\\                 \\\\\\______\\   \\\\________\\   \\\\__________\\    *\n" +
                "*                                      _______________________________________________________________________________________________________________________     *\n" +
                "*                                                                            _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-Version 1.0.2     *\n" +
                "*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*\n" +
                "Welcome! Please enter Player details and choose numbers 1-9 for corresponding positions on board. Good Luck!\n"
        );
    }

//    public static void instructions2() {
//        System.out.println(
//            "*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*\n" +
//            "*    ____________________                             ____________________       ___                         ____________________             ____________         *\n" +
//            "*    \\\______    _______\                            \\\______    _______\     //  \                        \\\______    _______\            \\    ______\        *\n" +
//            "*           \\\   \        (( o )   _______                  \\\  .\           ///\  \    _______                   \\\   \       __________   \\   \____          *\n" +
//            "*            \\\   \        \\  \   \\   ____\     /\         \\\  .\         ///==\  \   \\   ____\     /\          \\\   \      \\   ___  \   \\    ____\        *\n" +
//            "*             \\\   \__      \\  \   \\  \____     \/          \\\  .\__     ///    \  \   \\  \____     \/           \\\   \___   \\  \__\  \   \\   \______      *\n" +
//            "*              \\\______\     \\__\   \\______|                 \\\______\  ///      \__\   \\_______\                 \\\______\   \\________\   \\__________\    *\n" +
//            "*                                      _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_______________________________________________________________________________________________________________________     *\n" +
//            "*                                                                            -----------------------------------_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_----------------------------------------------     *\n" +
//            "*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*\n"
//            "Enter numbers 1-9 for corresponding positions on board.\n"
//        );
//    }


}