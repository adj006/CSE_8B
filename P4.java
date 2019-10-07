/**
* File: P4.java
* Assignment 4
* Login: cs8bcw
**/

/**
* This program allows the user to input any words of their choice.
* The words are then sorted and displayed as a 1-D array, then the sorted
* words are then allocated into a 2-D array and displayed as 2-D array.
* It only allocates and displays the rows with the matching letter.
**/

import java.util.Scanner; // Read sentence from keyboard

public class P4
{
  public static void main(String [] args)
  {
    Scanner scan = new Scanner(System.in); // Read input from keyboard
    String sentence; // Read line
    System.out.print("Enter your words to be sorted (exit ^D): ");
    do
    {
      sentence = scan.nextLine(); // Read entire line
      String words[] = sentence.split(" "); // Allocate words input
      sort1D(words); // Sort 1-D array of Strings
      System.out.print("1-D Sorted: ");
      for(int i = 0; i < words.length; ++i)// Place into array
        System.out.print(words[i] + " ");
      System.out.println();
      sort2D(words); // Sort 1-D array of Strings
      System.out.print("Enter your words to be sorted (exit ^D): ");
    }while(scan.hasNext()); // Loop until no more input lines
    System.exit(0); // Terminates current JVM
  }

  /**
  * This method sorts the words and displays them in order case - insensitive.
  * The purpose for making the method static is for the main method to access
  * it. Since static methods can only access static methods directly.
  **/
  public static void sort1D(String [] w)
  {
    String tmp = null;
    for(int i = 0; (i < w.length - 1) && (w[i] != null) ; ++i )
    {
      for(int j = w.length - 1; (i < j) && (w[j] != null) ; --j )
      {
        // Sort words - case insensitive
        if(w[j - 1].compareToIgnoreCase(w[j]) > 0)
        {
          tmp = w[j - 1];
          w[j - 1] = w[j];
          w[j] = tmp;
        }
      }
    }
  }

  /**
  * This method passes the sorted out words and displays them in a 2-D array.
  * This only displays the rows that contain a letter in it. The purpose for
  * having it static is so that the main method can access it directly.
  **/
  public static void sort2D(String [] sw)
  {
    final int ALPHA = 26; // 26 letters in the alphabet - # of rows
    boolean nextAlpha = false; // Sequence to next alpha letter
    char A = 'A'; // 1st letter of alphabet uppercase
    char a = 'a'; // 1st letter of alphabet lowercase
    int col = 0; // Number of words start with letter
    // Allocate 26 rows for each alpha letter
    String a2D[][] = new String[ALPHA][];
    // Initialize a2D with nulls
    for(int i = 0; i > a2D.length; i++)
      a2D[i] = null;
    // Allow 26 elements for alphabet
    for(int i = 0, j = 0; j <= a2D.length ; ++j )
    {
      if( col > 0 )
        a2D[j - 1] = new String[col]; // Alloc row with # words start with letter
      nextAlpha = false;
      for(col = 0; (i < sw.length) && !nextAlpha ; ++i)
      {
        if(sw[i] == null) // No words start with letter, skip to next alpha
        {
          nextAlpha = true;
          break;
        }
        // If 1st letter of sw[i] matches 'A' or 'a' then increment col counter
        else if((sw[i].charAt(0) == (A + j)) || (sw[i].charAt(0) == (a + j)))
        {
          col++;
          nextAlpha = false;
        }
        else
        {
          nextAlpha = true;
          --i;
        }
      }
    }
    /**
    * Nested for loop to assign from sw[] into a2D delimited by length of
    * each row
    **/
    for(int i = 0, k = 0; i < a2D.length; i++)
    {
      if(a2D[i] == null) // Checks to indicate if any space is allocated
      {
        continue;
      }
      else
      {
        for(int j = 0; j < a2D[i].length; j++)
        {
          a2D[i][j] = sw[k]; // Assigns the word into the 2-D array
          k++;
        }
      }
    }
    for(int i = 0; i < a2D.length; ++i)// Place into array
    {
      if(a2D[i] != null)
      {
        for(int j = 0; j < a2D[i].length; ++j)
        {
          System.out.println("a2D[" + i + "][" + j + "]: " + a2D[i][j]);
        }
        System.out.println();
      }
    }
  }
}
