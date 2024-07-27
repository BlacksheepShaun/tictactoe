/*
ALGORITHM:
I. initialize ALGORITHM:
II.  Display board
III. While no win or tie
     A. player takes a turn
     B. change player
*/     


// Author(s): Constance Conner and Shun Lae Thawtar Khaing
// Date of Last Modification: 03/19/2024 
// Course: CS111B 
// Instructor: C. Conner
// File Name: TicTacToeStub.java
// This program will plays a simpified version of Tic Tac Toe using 2-D array


import java.util.Scanner;

public class TicTacToeStub
{
  public static char[][] initBoard(int size)
  {
    //your code goes here update the return to the board
        char[][] board = new char[size][size];
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          board[i][j] = '-';
        }
      }

    return board;
  }

  ///////  STEP 2: display board ////////

  public static void displayBoard(char [][] board){
      
      // STEP 2: PUT CODE TO DISPLAY INTO A METHOD named display SEE STEP 2 ABOVE
    System.out.println("\n--------");
    for(int row=0; row < board.length; row++)
    {
      for(int col=0; col < board[row].length; col++)
          System.out.print(board[row][col] + "  ");
      System.out.println();
      System.out.println("--------");
    }
    System.out.println();
      
  }

  ///////  STEP 3: check for win ////////
  // check 3 rows, 3 coluns, 2 diagonals
  // return true if we have a winner
  public static boolean isWinner(char move, char[][] board) {
    // Check rows
    for (int row = 0; row < 3; row++) {
        if (board[row][0] == move && board[row][1] == move && board[row][2] == move) {
            return true;
        }
    }

    // Check columns
    for (int col = 0; col < 3; col++) {
        if (board[0][col] == move && board[1][col] == move && board[2][col] == move) {
            return true;
        }
    }

    // Check diagonals
    if (board[0][0] == move && board[1][1] == move && board[2][2] == move) {
        return true;
    }
    if (board[0][2] == move && board[1][1] == move && board[2][0] == move) {
        return true;
    }

    return false; // No winning condition found
}

 ///////  STEP 4: check for tie ////////
 // check each element in board
 // if any element is not a dash (-) tie is false
public static boolean isTie(char [][] tieBoard) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (tieBoard[i][j] == '-') {
                // If any dash found, game is not a tie
                return false;
            }
        }
    }
    // If no dash found, game is a tie
    return true;
}
  ///////  takeTurn  ////////
  // Allow the curPlayer to take a turn.
  // Ask user for row col to play
  // Read user's input and verify that it is a
  // valid move (array element has not been chosen).
  // When a valid move is entered,
  // put it on the board.
  //
  // STEP 5: Check if game is over (YOU WILL WRITE THIS NESTED if/else) below
  
  public static boolean takeTurn(char thePlayer, char [][] board)
  {
    int row = 0;
    int col = 0;
    
    boolean isGameOver = false; //do we have a win or a tie
    
    Scanner scan = new Scanner(System.in);


    System.out.println(thePlayer +  " your turn. Enter row col (0 0 is top left): ");
   // System.out.print("Example 0 0 is top left: ");
    row = scan.nextInt();
    col = scan.nextInt();

    scan.nextLine();
    //if array element is not a dash (-) user must choose again
    //as that move is invalid
    while (board[row][col] != '-')
    {
        System.out.println("Invalid entry: Row " + row + " at Column " + col
                           + " already contains: " + board[row][col]);
        System.out.println("Please try again.");
        row = scan.nextInt();
        col = scan.nextInt();
        
        scan.nextLine();
    }
    
    // Now that input validation loop is finished, put the move on the board:
    board[row][col] = thePlayer;
    
    
    /// STEP 5: Check if game is over (YOU WILL WRITE THIS NESTED if/else/if)
    // I. if isWinner
    //    A.  dispaly "You Won!!"
     //   B.  set isGameOver to true
    // else 
    //    A'. if isTie
    //          1. display "It's a Tie!" 
    //          2. set isGameOver to true
    //         else 
    //           1'. set isGameover to false
      boolean winner = isWinner(thePlayer, board);
      boolean tie = isTie(board);

    if (winner) {
        System.out.println( thePlayer + " You won!!");
        isGameOver = true;
    } else if (tie) {
        System.out.println("It's a tie!");
        isGameOver = true;
    }
    
    return isGameOver;
    
    
  }

   ///////  play the game ////////
   //  while game not over
   //  user takes a turn 
   //      checks for win or tie
   //  alternate play between player X and O
  public static void main(String [] args)
  {
    char curPlayer = 'X'; //first player is X
    char[][] board;       //tic tac toe board as 2-D array
    boolean gameOver = false;

    
    board = initBoard(3);
    System.out.println("***LET'S PLAY TIC TAC TOE***");
    
    /////// beginning of  display board ////////
    // STEP 2: PUT CODE TO DISPLAY INTO A METHOD named display SEE STEP 2 ABOVE
    displayBoard(board);
    ///////  end of display board ////////
    ///CALL display METHOD HERE passing board as argument

    //game continues while there is no winner or tie
    while( !gameOver )
    {
      
      //player makes a move and we check if win or tie
      gameOver = takeTurn(curPlayer, board);
      
      displayBoard(board);
      
      if(curPlayer == 'X') //change player
          curPlayer = 'O';
        else
          curPlayer = 'X';
          
    } 

    
  } //end main

}  //end class

