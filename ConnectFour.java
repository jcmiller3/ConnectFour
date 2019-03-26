import java.util.Scanner;

public class ConnectFour {

    // function to initialize the board by using an array to set the board size
    public static String [][] InitializeTheBoard() {

        // The 6 in the array represents the y direction, while the 7 represents the x direction for the board
        String [][] Board = new String [6][7];

        // for loops for y and x are used to iterate through the array so the board is now filled with spaces for the player to put their pieces in
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 7; x++) {
                Board [y][x] = "   ";
            }
        }

        return Board;
    }

    // function to print the board, which adds some boxes to it by using the for loop to design the board
    public static void PrintTheBoard(String [][] Board) {

        // Tells the player their positioning in terms of where they are putting their piece at
        System.out.println("  1   2   3   4   5   6   7");

        // Designs the board by giving it boxes and prints out a divider for those boxes horizontally
        for (int y = 0; y < 6; y++) {
            System.out.println("#" + Board[y][0] + "#" + Board[y][1] + "#" + Board[y][2] + "#" + Board[y][3] + "#" + Board[y][4] +
                    "#" + Board[y][5] + "#" + Board[y][6] + "#");
            System.out.println("#############################");
        }
    }

    // function to find y, or more specifically used to find an empty space to put the x or o in
    public static int FindTheY( int x, String [][] Board) {

        // starts at the bottom and makes sure that it is greater than negative one so that the player won't go out of bounds on the board
        for (int y = 5; y > -1; y--) {
            if (Board [y][x] == "   ") {
                return y;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // Used to pass in as a parameter for my other functions
        String [][] Board = InitializeTheBoard();


        // a variable that is set to false in order to keep the game going
        boolean gameOver = false;

        // initializes the player's turn
        char playerTurn = 'x';

        // set y to negative 2
        int y = -2;

        // uses variable from before that will always be met so that the game will continue unless user specifies otherwise
        while (gameOver == false) {

            // used to get user input
            Scanner sc = new Scanner(System.in);

            // The board that was initialized from before is passed into this function to print the board
            PrintTheBoard(Board);

            // This states who's turn it is and the user can specify when the game is over or is won
            System.out.println("Player " + playerTurn + "'s turn: Enter your move(Enter negative 1 to end the game): ");

            // reads the user input which should be an integer value
            int x = sc.nextInt();
            // This is done to get the correct value since the array indexes can throw it off otherwise
            x = x - 1;

            // x is negative 2 because I want the user to enter negative 1 to signal a game over
            if (x == -2) {
                gameOver = true;
                System.out.println("The game is over.");
            }

            // to keep players in the board
            if (x > -1 && x < 8) {
                // finds the first empty y position
                y = FindTheY(x, Board);
            }

            // makes playerTurn the right size to place on the board
            String stringTurn = " " + playerTurn + " ";

            // will keep the game going as long as a a value entered is in bounds
            if (y != -2 && x > -1 && x < 8){
                // sets board location to x or o
                Board [y][x] = stringTurn;
            }

            // Switches player turn based on who has went
            if (playerTurn == 'x') {
                playerTurn = 'o';
            }
            else {
                playerTurn = 'x';

            }
        }
    }
}
