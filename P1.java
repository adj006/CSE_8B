/**
* Assignment 1					P1.java				Due Jan. 19, 2013
* Login: cs8bcw
**/

/**
* This program allows you to input the number of students and scores of their grades. It finds the highest score
* and sets the curve for the class. It displays the score and grade letter the students received in the class.
* It also calculates how many of each letter grade did the class receive. The program calculates the average
* score of the class and displays how many scores above average and how many scores below average.
* It also allows you to input students and scores for multiple classes.
**/

import java.util.*;								// Scanner for input

public class P1
{

    static int aboveAvg = 0;							// Scores above average
    static int belowAvg = 0;							// Scores below average

  public static void main( String args[] )
  {
    final int MIN = 0;								// Minimum score
    final int MAX = 100;							// Maximum score
    final double A_PERCENT = 0.90;						// 90% letter grade A
    final double B_PERCENT = 0.80;						// 80% letter grade B
    final double C_PERCENT = 0.70;						// 70% letter grade C
    final double D_PERCENT = 0.60;						// 60% letter grade D
    final int MAX_STUDENTS = 10;						// Maximum students
    boolean errFlag = false;							// Error flag input scores range check
    char choice;								// Repeat loop
    double tmp = 0.0;								// Temporary input for scores
    double []scores;								// Array of scores
    int numStudents;								// Number of students in the class
    double highestScore = 0.0;							// Highest score
    char A, B, C, D, F;								// Letter grades
    char letter = ' ';								// Letter for grade
    int numA = 0, numB = 0, numC = 0, numD = 0, numF = 0;			// Number of grades
    double avg = 0.0;								// Average grade
    Scanner scan = new Scanner(System.in);					// Read input from keyboard
    String inputStr = null;							// Input string reference


    do
    {
      do
      {
        System.out.print("Enter number of students(");
        System.out.print((MIN + 1) + "-" + MAX_STUDENTS + "): ");
        numStudents = scan.nextInt();						// Assign to integer
        if ( (numStudents <= MIN) || (numStudents > MAX_STUDENTS) )
          System.out.println("ERROR: Enter an integer in the range of " + (MIN + 1) + "-" + MAX_STUDENTS + "!");
      }while( (numStudents <= MIN) || (numStudents > MAX_STUDENTS) );		// Checking range for number of students

      do
      {
        System.out.print("Enter " + numStudents + " scores (");
        System.out.print( MIN + "-" + MAX + "): ");

        scores = new double[numStudents];					// Allocate array scores ...

        errFlag = true;								// Allows it to enter the loop at least once
        while(errFlag == true)							// Continues to if there is an error
        {
          errFlag = false;							// Assuming there is no error
          tmp = 0.0;

          /**
          * stores the inputed values into an array
          **/
          for(int i = 0; i < scores.length; i++)
          {
            tmp = scan.nextDouble();						// Read input into temporary variable
            scores[i] = tmp;  
            if( (tmp < MIN) || (tmp > MAX) )					// Checking range for scores
              {errFlag = true; }						// Invalid score
          }
          if(errFlag == true)
          {
            System.out.println("ERROR: Enter number(s) in the range of " + MIN + "-" + MAX + "!");
            System.out.print("ERROR: Enter all " + numStudents + " scores again: ");
          }
        }
            
      }while( (tmp < MIN) || (tmp > MAX) );					// Checking range for scores

      highestScore = 0.0;

      /**
      * searches for the highest score
      **/
      for(int i = 0; i < scores.length; i++)
      {
        if(scores[i] > highestScore)
          highestScore = scores[i];
      }

      numA = 0;									// Number of A's
      numB = 0;									// Number of B's
      numC = 0;									// Number of C's
      numD = 0;									// Number of D's
      numF = 0;									// Number of F's

      /**
      * assigns and displays the letter grade the students received.
      * Also counts how many of each letter grade did the class receive.
      **/
      for(int i = 0; i < scores.length; i++)
      {
        if(scores[i] >= highestScore*A_PERCENT)
        {
          letter = 'A';
          System.out.printf("Student #" + (i + 1) + " score is %.2f and grade is " + letter + "\n", scores[i]);
        }
        else if(scores[i] >= highestScore*B_PERCENT)
        {
          letter = 'B';
          System.out.printf("Student #" + (i + 1) + " score is %.2f and grade is " + letter + "\n", scores[i]);
        }
        else if(scores[i] >= highestScore*C_PERCENT)
        {
          letter = 'C';
          System.out.printf("Student #" + (i + 1) + " score is %.2f and grade is " + letter + "\n", scores[i]);
        }
        else if(scores[i] >= highestScore*D_PERCENT)
        {
          letter = 'D';
          System.out.printf("Student #" + (i + 1) + " score is %.2f and grade is " + letter + "\n", scores[i]);
        }
        else
        {
          letter = 'F';
          System.out.printf("Student #" + (i + 1) + " score is %.2f and grade is " + letter + "\n", scores[i]);
        }
        switch (letter)
        {
          case 'A': numA += 1; break;
          case 'B': numB += 1; break;
          case 'C': numC += 1; break;
          case 'D': numD += 1; break;
          case 'F': numF += 1; break;
        }
      }

      System.out.println("Number of A's: " + numA);
      System.out.println("Number of B's: " + numB);
      System.out.println("Number of C's: " + numC);
      System.out.println("Number of D's: " + numD);
      System.out.println("Number of F's: " + numF);

      avg = avg(scores);
      System.out.printf("Average is: %.2f\n", avg);

      System.out.println("Number of scores >= average: " + aboveAvg);		
      System.out.println("Number of scores < average: " + belowAvg);

      System.out.print("Want to calculate grades (y/n)? ");
      inputStr = scan.next();							// Read and assign to String
      choice = inputStr.charAt(0);						// Assign to character
    }while( (choice != ('N')) && (choice != ('n')) );				// Loop while NOT n nor N
    scan.close();								// Close Scanner
    System.exit(0);								// Terminate with successful exit
  }

  /**
  * This method calculates the average scores of the array and calculates how many scores
  * are above and below average.
  **/
  public static double avg( double a[] )
  {
    double avg = 0.0;
    double sum = 0.0;
    for(int i = 0; i < a.length; i++)
    {
      sum += a[i];
    }
    avg = sum/a.length;
    aboveAvg = 0;
    belowAvg = 0;
    for(int i = 0; i < a.length; i++)
    {
      if(a[i] >= avg)
        aboveAvg += 1;
      else
        belowAvg += 1;
    }
    return avg;									// Returns the average score
  }
}
