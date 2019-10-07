/**
* File: P8.java
* Assignment 8
* Login: cs8bcw
**/

/**
* This program allows a user to open a selected file and it determines
* if the code is written correctly. It checks for it's data type, identifiers
* and access modifier. If it is not written correctly, it will print out
* it's errors.
**/

import java.io.*;
import java.text.DecimalFormat;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;

public class P8
{
	private static int index;	// Index tracker
	private static char [] c; // Stores a string into a character array
	/**
	* This method determines if the data type is valid
	**/
	private static boolean isDataType(String dataType)
	{
		// Array to hold valid data types
		String _arrData[] = {"byte", "boolean", "char", "int", "float",
																			 "double", "short", "long"};
		// Checks if data type is valid
		for (int i = 0; i < _arrData.length; i++)
		{
			if (_arrData[i].equals(dataType))
			{
				return true;			
			}
		}
		return false;
	}
	
	/**
	* This method determines if the start of the identifier is valid
	**/
	private static boolean isStartID(String id)
	{
		final int ALPHA = 26; // 26 letters in the alphabet
		c = id.toCharArray();	// String into an char[]
		// Checks if the first letter of identifier is valid
		for (int i = 0; i < ALPHA; i++)
		{
			// Checks only if the string contains characters
			if ((c.length != 0) && (Character.isJavaIdentifierStart(c[0])) )
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	* This method determines if the data type is valid
	**/
	private static int isID(String id)
	{
		index = 0;
		c = id.toCharArray();	// String into an char[]
		// Checks if the identifier is valid
		for (int i = 1; i < id.length(); i++)
		{
			if ( !Character.isJavaIdentifierPart(c[i]) )
			{
				index = i;
				return i;
			}
		}
		return -1;
	}
	
	/**
	* This method determines if the data type is a public access
	**/
	private static boolean isPublicVar(String accessModifier)
	{
		if (accessModifier.startsWith("public"))
		{
			return false;
		}
		return true;
	}
	
	/**
	* This method is the main driver to open and test the file selected
	**/
	public static void main( String [] args ) throws IOException
	{
		String inputStr; // Input line
		String[] tokens;	// Array of String from input
		int error = 0;	// Number of errors
		int warning = 0;	// Number of warnings
		/**
		* This allows the program to try the methods below and if an
		* exception are found then it enters into a catch block
		**/
		try
		{
			warning = 0;
			// Object to read the input from the file
			LineNumberReader in = null;
			in = new LineNumberReader( new FileReader(new File(args[0])) );
			// Continues to check if the condition is true
			while ( ( inputStr = in.readLine() ) != null )
			{
				DecimalFormat df = new DecimalFormat( "00" );	// Format line #
				// Only checks if it ends with semi-colon
				if (inputStr.endsWith(";"))
				{
					// Strip the semi-colon
					tokens = inputStr.substring(0,inputStr.length()-1).trim().split(" +");
					// itterates through the file
					for (int i = 0; i < tokens.length; i++)
					{
						// If it is public
						if ((i == 0) && (!isPublicVar(tokens[i])))
						{
							System.err.print(args[0] + ":" + df.format(in.getLineNumber()));
							System.err.println(": warning \"public\" access instance var");
							warning++;
							// Checks if it is a valid data type
							if ((i == 1) && (!isDataType(tokens[i])))
							{
								System.err.print(args[0] + ":" + df.format(in.getLineNumber()));
								System.err.print(": ");
								System.err.println("\"" + tokens[i] + "\", data type unknown");
								error++;
							}
							// Checks if the string contains only the semi-colon
							if (tokens[i].equals(";"))
							{
								System.err.print(args[0] + ":" + df.format(in.getLineNumber()));
								System.err.print(": ");
								System.err.println("no identifier specified");
								error++;
							}
							else
							{
								// Checks if first letter of identifier is valid
								if (!isStartID(tokens[i]))
								{
									System.err.print(args[0] + ":");
									System.err.print(df.format(in.getLineNumber()));
									System.err.print(": \'" + tokens[i].charAt(0) + "\': ");
									System.err.print("invalid first character of identifier, ");
									System.err.println("\"" + tokens[i] + "\"");
									error++;
								}
								// Checks if valid identifier
								if (isID(tokens[i]) != -1)
								{
									System.err.print(args[0] + ":");
									System.err.print(df.format(in.getLineNumber()));
									System.err.print(": \'" + tokens[i].charAt(index) + "\': ");
									System.err.print("invalid character ");
									System.err.println("in identifier, \"" + tokens[i] + "\"" );
									error++;
								}
							}
						}
						// Checks if not public
						else
						{
							// Checks if its a valid data type
							if ((i == 0) && (!isDataType(tokens[i])))
							{
								System.err.print(args[0] + ":" + df.format(in.getLineNumber()));
								System.err.print(": ");
								System.err.println("\"" + tokens[i] + "\", data type unknown");
								error++;
							}
							// Only check if ends with comma
							if((i != 0) && (tokens[i].endsWith(",")))
							{
								// Strips the comma
								tokens[i] = tokens[i].substring(0, tokens[i].length() - 1);
								if ((c.length != 0) && !(tokens[i].equals(",")))
								{
									System.err.print(args[0] + ":");
									System.err.print(df.format(in.getLineNumber()) + ": ");
									System.err.println("no identifier specified");
									error++;									
								}
								// Checks if there is there is no identifier
								else if ((tokens[i].length() == 0) && (!isStartID(tokens[i])))
								{
									System.err.print(args[0] + ":");
									System.err.print(df.format(in.getLineNumber()) + ": \'");
									System.err.print(tokens[i].charAt(0) + "\': invalid");
									System.err.print(" first character of identifier, \"");
									System.err.println(tokens[i] + "\"");
									error++;
								}
								// Checks if valid identifier
								if (isID(tokens[i]) != -1)
								{
									System.err.print(args[0] + ":");
									System.err.print(df.format(in.getLineNumber()));
									System.err.print(": \'" + tokens[i].charAt(index) + "\': ");
									System.err.print("invalid character ");
									System.err.println("in identifier, \"" + tokens[i] + "\"" );
									error++;
								}
							}
							// Checks if it does not end with a comma
							else if (i != 0)
							{
								// Checks if first letter of identifier is valid
								if (!isStartID(tokens[i]))
								{
									System.err.print(args[0] + ":");
									System.err.print(df.format(in.getLineNumber()) + ": \'");
									System.err.print(tokens[i].charAt(0) + "\': invalid");
									System.err.print(" first character of identifier, \"");
									System.err.println(tokens[i] + "\"");
									error++;
								}
								// Checks if valid identifier
								if (isID(tokens[i]) != -1)
								{
									System.err.print(args[0] + ":");
									System.err.print(df.format(in.getLineNumber()));
									System.err.print(": \'" + tokens[i].charAt(index) + "\': ");
									System.err.print("invalid character ");
									System.err.println("in identifier, \"" + tokens[i] + "\"" );
									error++;
								}
							}
							// Checks if one string is present and contains a comma
							else if ((tokens.length == 1) && !(tokens[i].equals(",")))
							{
								System.err.print(args[0] + ":");
								System.err.print(df.format(in.getLineNumber()) + ": ");
								System.err.println("no identifier specified");
								error++;	
							}
						}
					}
				}
			}
			System.err.println(warning + " warning");
			System.err.println(error + " errors");
		}
		/**
		* This catch block is exectuted if there is no file inputted 
		**/
		catch ( ArrayIndexOutOfBoundsException e )
		{
			System.err.println("Usage: java P8 [file]");
			System.exit(-1); // Close connections
			
		}
		/**
		* This catch block is executed if the file was not found
		**/
		catch ( FileNotFoundException e )
		{
			System.err.println("File \"" + args[0] + "\" is NOT found");
			System.exit(-1); // Close connections
		}
		System.out.flush();
	}
}
