package homework;

import java.util.Arrays;
import stdlib.*;

/**
 * CSC300Program2  version 1.0
 * 
 *   Patrick Kunst
 *   Section 601
 *   
 *   Does your program have compile errors?     Yes / No
 * 
 * This is a skeleton file for your programming assignment. Edit the sections marked TODO. 
 *
 * Unless specified otherwise, you must not change the declaration of any method. 
 * This will be true of every skeleton file I give you.
 *
 * For example, you will get zero points if you change the line
 * <pre>
 *     public static double valRange (double[] list)
 * </pre>
 * to something like
 * <pre>
 *     public static void valRange (double[] list)
 * </pre>
 * or
 * <pre>
 *     public static double valRange (double[] list, int i) {
 * </pre>
 * 
 * Each of the functions below is meant to be SELF CONTAINED. This means that
 * you should use no other functions or classes.  You should not use any HashSets
 * or ArrayLists, or anything else unless specifically indicated! Exception: You may use Math.abs  (look it up) 
 */
public class CSC300Program2 
{

	/**
	 * valRange returns the difference between the maximum and minimum values
	 * in the array; Max-Min.  
	 * Precondition: the array is nonempty. 
	 * Your solution must go through the array exactly once.  
	 * 
	 * Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *    0  == valRange (new double[] { -7 })
	 *    10 == valRange (new double[] { 1, 7, 8, 11 })
	 *    10 == valRange (new double[] { 11, 7, 8, 1 })
	 *    18 == valRange (new double[] { 1, -4, -7, 7, 8, 11 })
	 *    24 == valRange (new double[] { -13, -4, -7, 7, 8, 11 })
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static double valRange (double[] list) 
	{
		int min=0, max=0;
		for (int i=1; i<list.length; i++)
		{
			if (list[i] < list[min])
			{
				min=i;
			}
			if (list[i] > list[max])
			{
				max = i;
			}
		}
		return list[max] - list[min]; //TODO 1:  fix this

	}

	/**
	 * minPosition returns the position where the minimum value is located
	 *
	 * Precondition:  the array is nonempty and all elements are unique.
	 * Your solution must go through the array exactly once.  
	 * 
	 * Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *   0 == minPosition(new double[] { -7 })                      // -7 is the minimum
	 *   2 == minPosition(new double[] { 1, -4, -7, 7, 8, 11 }),    // -7 is is location 2
	 *   0 == minPosition(new double[] { -13, -4, -7, 7, 8, 11 })   // -13 is in location 0
	 *   6 == minPosition(new double[] { 1, -4, -7, 7, 8, 11, -9 }) // -9 is in location 6
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static int minPosition (double[] list) 
	{
		int min=0;
		for (int i=1; i<list.length; i++)
		{
			if (list[i] < list[min])
			{
				min = i;
			}
		}
		return min;

	}
	/**
	 * stringReformat takes a person's name in the format  <Last, First Initial.>  and
	 * reformats it to the form  <First Initial Last> 
	 *
	 * Preconditions:  
	 *       the string is not empty
	 *       there is exactly one ','  (comma) and it comes at the end of the Last name
	 *       there is 1 space after the comma
	 *       there is exactly one space between the First name and the Initial
	 *       The Initial is a single character followed by a '.' 
	 * 
	 * Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *   "Alex P Keaton" <--  stringReformat("Keaton, Alex P.");
	 *   "Luke A Boyd"   <--  stringReformat("Boyd, Luke A.");
	 *   "Lotta B Essen"  <--  stringReformat("Essen, Lotta B.");
	 *   
	 *   You may only use the    substring  and charAt methods of the string class.
	 *   You may not use any other Java classes or function without permission
	 *         Some sample code to help you think about the problem is given below for your reference; 
	 *          you should delete this from the solution you submit for credit.
	 *   You may write additional functions to help solve this problem if you want.
	 *   
	 *   Hints:  
	 *         Find the location of the  ',' and ' ' (spaces)  using charAt
	 *         Build the new string by extracting the corresponding substrings and concatenating them together
	 * </pre>
	 */
	public static String stringReformat( String name) 
	{
		/*String theAnswer = "this is not the answer";
		
		//  example code starts here:  delete or comment out when you have completed the function
		String  subExample = name.substring(1,5);  // some example code
		char  theChar = name.charAt(4);
		StdOut.println(" stringReformat demo1.  the substring(1,5) is: " + subExample);
		if ( theChar == ',' )
			StdOut.println(" stringReformat demo2.  the character in position 4 is a comma");
		else
			StdOut.println(" stringReformat demo2.  the character in position 4 is NOT a comma, it is: "+ theChar);
		//  end of example code
		*/
		
		int comLoc=0, perLoc=0;//To initialize so program compiles. With precondition, this will work
		for (int i=0; i < name.length(); i++)
		{
			if (name.charAt(i) == ',')
			{
				comLoc = i;
			}
			if (name.charAt(i) == '.')
			{
				perLoc = i;
			}
		}
		
		
		return name.substring(comLoc+2, perLoc) + " " + name.substring(0, comLoc);   // TODO 3:  fix this.
	}
	/**
	 * <pre>
	 * isPerfectNumber determines  (true or false) if a given number is a 'Perfect Number'
	 * 
	 * A perfect number is one that is equal to the sum of its proper divisors.
	 * Example 1:   6;   the proper divisors are  1, 2, 3 ;  1+ 2 + 3  is 6, so  6 IS a perfect number
	 * Example 2:   15; the proper divisors are  1, 3, 5 ; 1 + 3 + 5  is 9, so 15 IS NOT a perfect number
	 * Example 3:   28; the proper divisors are  1, 2, 4, 7, 14; 1 + 2 + 4 + 7 + 14 is 28, so  28 IS a perfect number
	 * 
	 * Precondition:  number is a positive integer
	 *
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * 
	 * Hint:  find the sum of the proper divisors
	 * </pre>
	 */
	public static boolean isPerfectNumber( int number) 
	{
		int sumDiv=1;//Obviously 1 is a divisor
		for (int i=2; i<number; i++)
		{
			if (number%i == 0)
			{
				sumDiv += i;
			}
		}
		return sumDiv == number; //TODO 4: fix this
	}
	/*
	 * A test program, using private helper functions.  See below.
	 */
	public static void main (String[] args) 
	{
		// do all the tests
		valueRangeTests();
		minPositionTests();
		stringReformatTests();
		perfectNumberTests();

		StdOut.println ("Finished tests");
	}

	/* Test functions --- lot's of similar code!    Do not change any of the code below*/
	
	
	private static void valueRangeTests() 
	{
		// for ValRange: array must be nonempty
		testValRange (0, new double[] {11} );
		testValRange (0, new double[] { 11,11,11,11,11} );
		testValRange (10, new double[] {11, 1} );
		testValRange (10, new double[] {1,11} );
		testValRange (32, new double[] {11, 21, 9, 31, 41});
		testValRange (32, new double[] {41, 21, 9, 31, 11});
		testValRange (32, new double[] {11, 41, 9, 31, 21});
		testValRange (32, new double[] {-41, -21, -11, -31, -9});
		testValRange (32, new double[] {-9, -21, -11, -31, -41});
		testValRange (32, new double[] {-41, -11, -9, -31, -21});
		testValRange (32, new double[] {-11, -21, -41, -31, -9});		
		testValRange (0.7, new double[] { 0.2, -0.5, -0.1});
		StdOut.println();
	}
	private static void testValRange (double expected, double[] list) 
	{
		double actual = valRange (list);  // calls your function

		if (expected != actual) 
		{   // compares your result with the expected result
			StdOut.format ("Failed valRange(%s): Expecting (%.1f) Actual (%.1f)\n", Arrays.toString(list), expected, actual);
		}
	}
	private static void minPositionTests() 
	{
		// for distanceBetweenMinAndMax: array must be nonempty with unique elements
		testMinPosition (0, new double[] {11});
		testMinPosition (0, new double[] {-11});
		testMinPosition (0, new double[] {9, 11, 21, 31, 41});
		testMinPosition (1, new double[] {11, 9, 21, 31, 41});
		testMinPosition (2, new double[] {11, 21, 9, 31, 41});
		testMinPosition (3, new double[] {11, 21, 31, 9, 41});
		testMinPosition (4, new double[] {11, 21, 31, 41, 9});
		testMinPosition (4, new double[] {9, -11, -21, -31, -41});
		testMinPosition (4, new double[] {-11, -21, -31, 9, -41});
		testMinPosition (3, new double[] {-11, -21, -31, -41, 9});
		testMinPosition (2, new double[] {1, -4, -7, 7, 8, 11, 9, -5});
		testMinPosition (1, new double[] {0.2, -0.5, -0.1});

		StdOut.println();
	}

	private static void testMinPosition (int expected, double[] list) 
	{

		int actual = minPosition (list); // calls your function

		if (expected != actual) 
		{ // compares your result with the expected result
			StdOut.format ("Failed testMinPosition(%s): Expecting (%d) Actual (%d)\n", Arrays.toString(list), expected, actual);
		}
	}	
	private static void stringReformatTests() 
	{

		testStringReformat( "Keaton, Alex P.", "Alex P Keaton");
		testStringReformat( "Boyd, Luke A.", "Luke A Boyd");
		testStringReformat("Essen, Lotta B.", "Lotta B Essen");
		testStringReformat("Rittenoff, Candace B.", "Candace B Rittenoff");
		testStringReformat("Blank, Drew A.", "Drew A Blank");
		testStringReformat("Bruptly, Vera A.", "Vera A Bruptly");
		testStringReformat("Datso, Wanda Y.", "Wanda Y Datso");
		testStringReformat("Silver, I O.", "I O Silver");

	}
	private static void testStringReformat (String stringToTest, String expected) 
	{

		String actual = stringReformat( stringToTest);    // calls your function

		if ( ! actual.equals(expected))        // compares your result with the expected result
			StdOut.format ("Failed  testStringReformat:  Expected: (%s)  Actual (%s) \n", expected, actual);

	}
	private static void perfectNumberTests() 
	{

		testPerfectNumber( 20,false);
		testPerfectNumber( 28,true);
		testPerfectNumber( 496,true);
		testPerfectNumber( 495,false);
		testPerfectNumber( 8128,true);
		testPerfectNumber( 33550336,true);

	}
	private static void testPerfectNumber (int number, boolean expected) 
	{

		boolean actual = isPerfectNumber(number);    // calls your function

		if ( actual != expected)        // compares your result with the expected result
			StdOut.format ("Failed  testPerfectNumber:  Expected: (%b)  Actual (%b) \n", expected, actual);

	}

}