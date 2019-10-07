/**
* File: P7.java
* Assignment 7
* Login: cs8bcw
**/

/**
* This program allows the user to enter 5 quiz scores and it finds the largest
* value. If the user inputs characters that are not valid. the program has 
* code to handle these exceptions
**/

import java.io.*;

class P7
{
	private static final int ASIZE = 5;	// Array size
	private static final int MIN_RANGE = 0;	// Minimum quiz score
	private static final int MAX_RANGE = 10;	// Maximum quiz score
	private static int []qz = new int [ASIZE];	// 5 element array
	private static int max;	// largest quiz score
	// Error flag if number is out of range
	private static boolean errFlag = false; 
	/**
	* main method:
	* driver for the try and catch blocks
	**/
	public static void main(String [] args) throws IOException
	{
		String inputStr; // Input line
		String []s; // Array of String from input
		// Object to read the input from the keyboard
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
		System.out.print("ENTER " + ASIZE + " Quizzes (range " + MIN_RANGE + "-");
		System.out.print(MAX_RANGE + "): ");
		/**
		* Allows the user to continue to input as long as the input is not blank
		**/
		while ( ( inputStr = in.readLine() ) != null )
		{
			s = inputStr.split(" "); // Parse into tokens
			/**
			* This allows the program to try the methods below and if an
			* exception are found then it enters into a catch block
			**/
			try
			{
				/**
				* Converts a string array into a int array and checks through the 
				* entire input to check if the inputs are valid and determines 
				* how to handle it
				**/
				for (int i = MIN_RANGE; i < s.length; i++)
				{
					qz[i] = Integer.parseInt( s[i] );	// Converts string into int
					if ( (qz[i] > MAX_RANGE) || (qz[i] < MIN_RANGE) )
					{
						errFlag = true;	// assume there is no errors
						System.out.println(inputStr);
						System.err.print("\tERROR! Out of range " + MIN_RANGE + "-");
						System.err.println(MAX_RANGE + ".  Enter again.");
						System.out.print("\nENTER " + ASIZE + " Quizzes (range ");
						System.out.print(MIN_RANGE + "-" + MAX_RANGE + "): ");
						break;
					}
					else
						errFlag = false;
				}
				if ( (s.length == ASIZE) && !(errFlag) )
				{
					System.out.println("Input: " + inputStr);
					max();	// Calls max() method
				}
				else if ( (s.length < ASIZE) && !(errFlag) )
				{
					System.err.println("Not enough quiz scores, please try again");
					System.out.print("\nENTER " + ASIZE + " Quizzes (range ");
					System.out.print(MIN_RANGE + "-" + MAX_RANGE + "): ");
				}
				else if ( (s.length > ASIZE) && !(errFlag) )
				{
					max();	// Calls max() method
				}
			}
			/**
			* This catch block is executed if a input is an invalid number format
			**/
			catch ( NumberFormatException e )
			{
				System.err.print("Input: " + inputStr);
				System.err.println(" are not valid quiz scores.");
				e.printStackTrace();	// Prints out the stack trace of the exception
				System.out.print("\nENTER again - " + ASIZE + " Quizzes (range ");
				System.out.print(MIN_RANGE + "-" + MAX_RANGE + "): ");
			}
			/**
			* This catch block is executed if a input is more than 5 quiz scores
			**/
			catch ( ArrayIndexOutOfBoundsException e )
			{
				System.err.println("Input: " + inputStr);
				System.err.println("\tEntered more than " + ASIZE + " quizzes.");
				System.err.print("\tFirst " + ASIZE + " scores accepted.  ");
				System.err.println("Continuing ...");
				max();	// Calls max() method
			}
			/**
			* This catch block is executed if a input has any other exceptions
			**/
			catch ( Exception e )
			{
				//	Displays the exception parameter (println(e))
				System.err.println(e);
				e.printStackTrace();	// Prints out the stack trace of the exception
				System.exit(-1); // Close connections
			}
			System.out.flush();
		}
	}
	/**
	* This max() method reads the inputs and determines the largest quiz score
	**/
	public static void max()
	{
		max = MIN_RANGE;	// Resets the max value
		for (int i = MIN_RANGE; (i < ASIZE) && !(errFlag); i++)
		{
			if ( qz[i] > max )
			{
				max = qz[i];
			}
		}
		System.out.println("Largest value of the " + ASIZE + " quizzes is: " + max);
		System.out.print("\nENTER " + ASIZE + " Quizzes (range ");
		System.out.print(MIN_RANGE + "-" + MAX_RANGE + "): ");
	}
}
