/**
* Assignment 2			P2.java			Due Jan. 26, 2013
* Login: cs8bcw
**/

/**
* This program allows you to play a 3 game tournament of TIC-TAC-TOE by
* inputting specific row and column position to mark it on the board. It 
* displays the game number you are currently playing. Also displays the
* winner of each game as soon as a player wins and displays the winners
* of each game at the end of the tournament.
**/

import java.util.*;					// Scanner for input

public class P2
{
  private static char [][] board;			// Board array
  private static final char NUL_CHAR = '\u0000';       // Null Unicode character
  private static final int MIN = 0;			// Minimum index
  private static final int ROW = 3;		// Number of rows in 2-D array
  private static final int COL = 3;		// Number of colums in 2-D array
  private static final int MAX_GAMES = 3;	// Number of games in tournament
  private static Scanner scan = new Scanner(System.in);	// Scanner input
  private static int row = 0;				// Input for row
  private static int col = 0;				// Input for column
  private static boolean errFlag = false;		// Error flag

  /**
  * Player chooses a cell to places marker
  **/
  public static void makeAmove(char player)
  {
    do
    {
      errFlag = false;
      System.out.print("Enter a row ( " + (MIN + 1) + "-" + ROW + " ) and a ");
      System.out.print("column ( " + (MIN + 1) + "-" + COL + " ): ");
      row = scan.nextInt();				// Store row selection
      col = scan.nextInt();			       // Store column selection
      if( (row <= MIN) || (row > ROW) || (col <= MIN) || (col > COL) )
      {
        System.out.println("ERROR: value(s) out of bounds, re-enter values");
        errFlag = true;
      }
      else if(board [row - 1][col - 1] == NUL_CHAR)
        // Assigns the player character on board
        board [row - 1][col - 1] = player;
      else if(board [row - 1][col - 1] != NUL_CHAR)
      {
        System.out.print("Position on board is already taken, please select ");
        System.out.println("another empty spot");
        errFlag = true;
      }
    // Repeats if position on board is already taken or there is an error
    }while(errFlag == true);
  }

  /**
  * Print current positions on board
  **/
  public static void displayBoard()
  {
    System.out.println("----------------");
    System.out.print("|  " + board [MIN][MIN] + "  |  " + board [MIN][MIN + 1]);
    System.out.println("  |  " + board [MIN][COL - 1] + "  |");
    System.out.println("----------------");
    System.out.print("|  " + board [MIN + 1][MIN] + "  |  ");
    System.out.print(board [MIN + 1][MIN + 1]);
    System.out.println("  |  " + board [MIN + 1][COL - 1] + "  |");
    System.out.println("----------------");
    System.out.print("|  " + board [ROW - 1][MIN] + "  |  ");
    System.out.print(board [ROW - 1][MIN + 1]);
    System.out.println("  |  " + board [ROW - 1][COL - 1] + "  |");
    System.out.println("----------------");
  }

  /**
  * Returns true, if winner from last move on board
  **/
  public static boolean isAwin(char ch)
  {
    char tmp [] = new char[ROW];// Temporary array to store the characters
    boolean result = false;
    /**
    * This nested for loop checks the rows and compares ever spot in the
    * row to determine if the characters are the same 
    **/
    for(int i = MIN; i < ROW; i++)
    {
      for(int j = MIN; j < COL; j++)
      {
        if(board [i][j] == 'X')
          tmp [j] = 'X';
        else if(board [i][j] == 'O')
          tmp [j] = 'O';
        else
          tmp [j] = NUL_CHAR; 
      }
      if((tmp [MIN] == tmp [MIN + 1]) && (tmp [MIN + 1] == tmp [MIN + 2]) &&
        (tmp [MIN + 2] == 'X'))
      {
        ch = 'X';
        result = true;
        break;
      }
      else if((tmp [MIN] == tmp [MIN + 1]) && 
        (tmp [MIN + 1] == tmp [MIN + 2]) && (tmp [MIN + 2] == 'O'))
      {
        ch = 'O';
        result = true;
        break;
      }
      else
        result = false;
    }
    if(result == false)
      {
      /**
      * This nested for loop checks the columns and compares ever spot in the
      * column to determine if the characters are the same 
      **/
      for(int j = MIN; j < COL; j++)
      {
        for(int i = MIN; i < ROW; i++)
        {
          if(board [i][j] == 'X')
            tmp [i] = 'X';
          else if(board [i][j] == 'O')
            tmp [i] = 'O';
          else
            tmp [j] = NUL_CHAR; 
        }
        if((tmp [MIN] == tmp [MIN + 1]) && (tmp [MIN + 1] == tmp [MIN + 2]) &&
        (tmp [MIN + 2] == 'X'))
        {
          ch = 'X';
          result = true;
          break;
        }
        else if((tmp [MIN] == tmp [MIN + 1]) && (tmp [MIN + 1] == tmp [MIN + 2]) &&
        (tmp [MIN + 2] == 'O'))
        {
          ch = 'O';
          result = true;
          break;
        }
        else
          result = false;
      }
    }
    if(result == false)
    {
      /**
      * these if-else statments check the diagonals and compares every spot
      * in the diagonals to determine if they are the same
      **/
      if(((board [MIN][MIN] == board [MIN + 1][MIN + 1]) &&
        (board [MIN + 1][MIN + 1] == board [ROW - 1][COL - 1]) &&
        (board [ROW - 1][COL - 1] == 'X')) ||
        ((board [MIN][COL - 1] == board [MIN + 1][MIN + 1]) &&
        (board [MIN + 1][MIN + 1] == board [ROW - 1][MIN]) &&
        (board [ROW - 1][MIN] == 'X')))
      {
        ch = 'X';
        result = true;
      }
      else if(((board [MIN][MIN] == board [MIN + 1][MIN + 1]) &&
        (board [MIN + 1][MIN + 1] == board [ROW - 1][COL - 1]) &&
        (board [ROW - 1][COL - 1] == 'O')) ||
        (board [MIN][COL - 1] == board [MIN + 1][MIN + 1]) &&
        (board [MIN + 1][MIN + 1] == board [ROW - 1][MIN]) &&
        (board [ROW - 1][MIN] == 'O'))
      {
        ch = 'O';
        result = true;
      }
      else
        result = false;
    }
    return result;
  }

  /**
  * Returns true, if every cell is filled and no winner
  **/
  public static boolean isAdraw()
  {
    boolean result = false;
    /**
    * This nested for loop checks every spot on the board to
    * determine if the board is completely filled
    **/
    for(int i = MIN; i < ROW; i++)
    {
      for(int j = MIN; j < COL; j++)
      {
        if(board [i][j] != NUL_CHAR)
          result = true;
        else
        {
          result = false;
          break;
        }
      }
      if(result == false)
        break;
    }
    return result;
  }
  public static void main(String[] args)
  {
    boolean gameOver = false;			// A winner or draw in a game
    char [] aTournament = new char[MAX_GAMES];	// 1-D char array holding winner
    int gameNum = 0;				// Game number
    char choice;				// Repeat loop
    String inputStr = null;			// Input string reference

    do
    {
      System.out.println("Start playing TIC-TAC-TOE Tournament of 3 games!");

      for(gameNum = 0; gameNum < MAX_GAMES; ++gameNum)
      {
        System.out.println("GAME #: " + (gameNum + 1));
        board = new char[ROW][COL];	// Allocate memory for 2-D char array
        displayBoard();
        gameOver = false;			// Clear flag showing game end
        do
        {
          // Prompt the first player
          makeAmove('X');			// Player X chooses position

          displayBoard();			// Print current status of board
          if (isAwin('X'))				// Test if a winner
          {
            gameOver = true;			// Flag to start next game
            System.out.println("X player won");
            aTournament[gameNum] = 'X';			// Store winner 'X'
            continue;				// Start next game in tournament
          }
          else if (isAdraw())
          {
            gameOver = true;			// Flag to start next game
            System.out.println("A draw! No winner");
            aTournament[gameNum] = '-';			// Store draw '-'
            continue;				// Start next game in tournament
          }

          // Prompt the second player
          makeAmove('O');			// Player O chooses position

          displayBoard();			// Print current status of board
          if (isAwin('O'))				// Test if a winner
          {
            gameOver = true;			// Flag to start next game
            System.out.println("O player won");
            aTournament[gameNum] = 'O';			// Store winner 'O'
            continue;				// Start next game in tournament
          }
          else if (isAdraw())
          {
            gameOver = true;			// Flag to start next game
            System.out.println("A draw! No winner");
            aTournament[gameNum] = '-';			// Store draw '-'
            continue;				// Start next game in tournament
          }
        }while(gameOver == false);	// Continues game until declared winner
      }
      System.out.print("WINNERS of the 3 games: " + aTournament[MIN]);
      System.out.print(" " + aTournament[MIN + 1] + " ");
      System.out.println(aTournament[MAX_GAMES - 1]);
      System.out.print("Want to play another tournament (y/n)? ");
      inputStr = scan.next();			// Read and assign to String
      choice = inputStr.charAt(0);			// Assign to character
    }while( (choice != ('N')) && (choice != ('n')) );// Loop while NOT n nor N
    scan.close();						// Close Scanner
    System.exit(0);			// Terminate with successful exit
  }
}
