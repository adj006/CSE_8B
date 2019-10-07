/**
* File: P3.java
* Assignment 3
* Login: cs8bcw
* Program P3 consists of 2 classes: P3BDay and P3
*   P3BDay: data members and methods for month and day
*   P3: public application driver class to display a day of the week
**/

/**
* This program allows you to enter a birthday by inputing month and day.
* The output will display the date and the day of the week it occurs on.
**/

import java.util.Scanner;		// Read keyboard input
import java.text.DecimalFormat;		// Floating point format

/**
* class P3BDay - package access
* public P3BDay() - No argument constructor
* public P3BDay(int,int) - Overloaded ctor
*
* getMon() - Return month ...
* getDay() - Return day ...
* isValid() - Test range of all inputs: month (1-12), day (1-31)
* setBday() - Assign inputs to month, day ( calls isValid() ) ...
* toString() - Format month/day into string
*
* isLeapBaby() - Test if a leap year birthday, February 29th
* dayOfYear() - Calculate number of the day in the year e.g. 3 (1/3/13)
* dayOfWeek() - Calculate name of the day in the week e.g. "Tuesday"
**/

/**
* This class has the methods for the driver.
**/
class P3BDay
{
  static final int YEAR = 2013; // Package access to P3 driver
  private int month = 0, day = 0; // Data members
  private final int FIRST_MON = 1, FIRST_DAY = 8; // First day of class
  private int [][] date = new int [12][]; // Store date
  private int lastDay; // Last day of a month
  private int dayOfYear = 0; // Day of the year
  // Last day a specific month
  private final int JAN_LAST = 31, FEB_LAST = 28, MAR_LAST = 31,
  APR_LAST = 30, MAY_LAST = 31, JUN_LAST = 30, JUL_LAST = 31, AUG_LAST = 31,
  SEP_LAST = 30, OCT_LAST = 31, NOV_LAST = 30, DEC_LAST = 31;
  private boolean result = false; // Stores T/F value
  public P3BDay()
  {
    month = FIRST_MON;
    day = FIRST_DAY;
  } // No argument constructor init to 1/08/13
  public P3BDay(int m, int d)
  {
    month = m;
    day = d;
  } // Overloaded ctor init to parameters
  public int getMon()
  {
    return month;
  } // Return month
  public int getDay()
  {
    return day;
  } // Return day
  /**
  * This method check to verify that it is a valid input
  **/
  private boolean isValid(int m, int d)
  {
    result = false;
    // Creates an array to store the length of the months
    for (int i = 0; i < date.length; i++)
    {
      switch (i)
      {
        case 0: lastDay = JAN_LAST; break;
        case 1: lastDay = FEB_LAST; break;
        case 2: lastDay = MAR_LAST; break;
        case 3: lastDay = APR_LAST; break;
        case 4: lastDay = MAY_LAST; break;
        case 5: lastDay = JUN_LAST; break;
        case 6: lastDay = JUL_LAST; break;
        case 7: lastDay = AUG_LAST; break;
        case 8: lastDay = SEP_LAST; break;
        case 9: lastDay = OCT_LAST; break;
        case 10: lastDay = NOV_LAST; break;
        case 11: lastDay = DEC_LAST; break;
      }
      date[i] = new int[lastDay];
    }
    // Checks to verify the month is in legal range
    if( (m < FIRST_MON) || (m > date.length) )
    {
      System.out.println("ERROR - Month legal range 1-12!");
      System.out.println("ERROR - Birthday NOT in legal range!");
      result = false;
    }
    // Checks to verify the day is in legal range
    else if ( (d < FIRST_MON) || (d > date[m - 1].length) )
    {
      // Checks to verify if leap baby
      if( (m == (FIRST_MON + 1)) && (d == (FEB_LAST + 1)) )
      {
        isLeapBaby();
        result = true;
      }
      else
      {
        System.out.println("ERROR - Birthday NOT in legal range!");
        result = false;
      }
    }
    else
      result = true;
    return result;
  }
  /**
  * This method sets the birthday to a specific month and day
  **/
  public boolean setBday(int m, int d)
  {
    if( isValid(m, d) )
    {
      month = m;
      day = d;
      result = true;
    }
    else
      result = false;
    return result;
  }
  /**
  * This method formats the date
  **/
  public String toString()
  {
    // 2 digits wide, zero filled
    DecimalFormat twoDigits = new DecimalFormat( "00" );
    return(twoDigits.format(month) + "/" + twoDigits.format(day) + "/" + YEAR);
  } // Return formatted date values
  /**
  * This method checks to verify if leap baby
  **/
  public boolean isLeapBaby()
  {
    result = false;
    if( (month == 2) && (day  == 29) )
    {
      result = true;
    }
    else
      result = false;
    return result;
  } // Return true if 2/29
  /**
  * Method calculates the day of the year
  **/
  public int dayOfYear()
  {
    dayOfYear = 0;
    isValid(month, day);
    for(int i = 0; i < month - 1; i++)
    {
      dayOfYear += date[i].length;
    }
    dayOfYear += day;
    return dayOfYear;
  } // Return day of the year (1-365)
  /**
  * Method calculates the day of the week
  **/
  public String dayOfWeek()
  {
    dayOfYear = dayOfYear();
    String dayOfWeek = new String();
    if( !(isLeapBaby()) )
    {
      switch(dayOfYear % 7)
      {
        case 0: dayOfWeek = "Monday"; break;
        case 1: dayOfWeek = "Tuesday"; break;
        case 2: dayOfWeek = "Wednesday"; break;
        case 3: dayOfWeek = "Thursday"; break;
        case 4: dayOfWeek = "Friday"; break;
        case 5: dayOfWeek = "Saturday"; break;
        case 6: dayOfWeek = "Sunday"; break;
      }
    }
    else
      dayOfWeek = "*****FUN day*****!";
    return dayOfWeek;
  } // Return day of the e.g. "Sunday" 
}

/**
* public class P3
* This is the application driver class...
*/
public class P3
{
/**
* Instantiates 2 P3BDay objects representing a day in the year.
* Allows input of a month and day to calculate its occurrence of the day
* of the week. Displays the day of the week.
*/
  public static void main( String [] args )
  {
    final int DUE_MONTH = 2; // February
    final int DUE_DAY = 2; // 02/2 is PA#3 due date
    boolean validDay; // Boolean for error input
    char choice; // Repeat program
    int m, d; // Temporaries for input
    Scanner scan = new Scanner(System.in); // Read input from keyboard
    String inputStr; // Repeat input
    P3BDay firstDay = new P3BDay(); // No arg ctor, init to 01/08/13
    P3BDay bday = new P3BDay(DUE_MONTH,DUE_DAY); // Overloaded 2 int ctor
    System.out.print("PA#3 is due on "+ bday);
    System.out.println(" which occurs on a " + bday.dayOfWeek());
    System.out.print("The first day of lecture is "+ firstDay);
    System.out.println(" which occurs on a " + firstDay.dayOfWeek());
    do
    {
      do
      {
        System.out.print("Enter your birthday month and day (1 22): ");
        m = scan.nextInt(); // Assign to int for month
        d = scan.nextInt(); // Assign to int for day
        if( validDay = bday.setBday(m,d) ) // Assign if legal
          System.out.println(bday + " occurs on a " + bday.dayOfWeek());
        else
        {
          System.out.printf("%02d/%02d/%d is an",m,d,P3BDay.YEAR);
          System.out.println(" INVALID birthday - enter AGAIN");
          validDay = false;
        }
      }while(!validDay); // Repeat program
        System.out.print("\nWant another birth date (y/n)? ");
      inputStr = scan.next(); // Read and assign to String
      choice = inputStr.charAt(0); // Assign to character
    }while(choice != 'n' && choice != 'N'); // Loop not n nor N
    scan.close(); // Close this scanner
    System.exit(0); // Close connections
  }
}
