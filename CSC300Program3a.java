package homework;

import java.util.Arrays;
import stdlib.*;

/**
 * Version 1.0
 * 
 *   Patrick Kunst
 *   Section 601
 *   
 *   
 * This is a skeleton file for your homework. Edit the sections marked TODO. 
 *
 * You must not change the declaration of any method. This will be true of every
 * skeleton file I give you.
 *
 * For example, you would get zero points if you change the line
 * <pre>
 *     public static double minValue (double[] list) {
 * </pre>
 * to something like
 * <pre>
 *     public static void minValue (double[] list) {
 * </pre>
 * or
 * <pre>
 *     public static double minValue (double[] list, int i) {
 * </pre>
 * 
 * Each of the functions below is meant to be SELF CONTAINED. This means that
 * you should use no other functions or classes unless otherwise indicated. 
 * You should not use any HashSets or ArrayLists, or anything else! 
 * In addition, each of your functions should go
 * through the argument array at most once. The only exception to this is
 * removeDuplicates, which is allowed to call numDuplicates and then go through the
 * array once after that.
 */
public class CSC300Program3a 
{

	/**
	 * numDuplicates returns the number of duplicate values in an array of doubles.
	 * Precondition: the array may be empty, but if it is not empty the array is sorted from low to high.
	 *                            { your solution can assume this is true }
	 *
	 * Your solution must go through the array exactly once. Your solution must
	 * not call any other functions. Here are some examples (using "=="
	 * informally):
	 *
	 * <pre>
	 *     0 == numDuplicates(new int[] { })
	 *     0 == numDuplicates(new int[] { 11.0 })
	 *     3 == numDuplicates(new int[] { 11.0, 11.0, 11.0, 11.0 })
	 *     9 == numDuplicates(new int[] { 11.0, 11.0, 11.0, 11.0, 22.0, 33.0, 44.0, 44.0, 44.0, 44.0, 44.0, 55.0, 55.0, 66.0, 77.0, 88.0, 88.0 })
	 *     5 == numDuplicates(new int[] { 11.0, 22.0, 33.0, 44.0, 44.0, 44.0, 44.0, 44.0, 55.0, 55.0, 66.0, 77.0, 88.0 })
	 * </pre>
	 */
	public static int numDuplicates (double[] list) 
	{
		if (list.length==0 || list.length==1)
		{
			return 0;
		}
		
		int count=0;
		double num=list[0];
		
		for (int i=1; i<list.length; i++)
		{
			if (num==list[i]) {
				count++;
			}
			else {
				num = list[i];
			}
		}
		
		return count; //TODO1: fix this
	}

	/**
	 * removeDuplicates returns a new array containing the unique values in the
	 * array. There should not be any extra space in the array --- there should
	 * be exactly one space for each unique element (Hint: numDuplicates can 
	 * help you determine how big the array should be). 
	 * You may assume that the list is sorted, as you did for numDuplicates.
	 *
	 * Your solution may call numDuplicates, but should not call any other
	 * functions. After the call to numDuplicates, you may go through the array
	 * exactly one more time. Here are some examples; the left hand side  of "<--"
	 * means that is the returned result from the function call on the right hand side
	 *
	 * <pre>
	 *   new double[] { }       <--      removeDuplicates(new double[] { })
	 *   new double[] { 11 }  <--    removeDuplicates(new double[] { 11 })
	 *   new double[] { 11 }  <--    removeDuplicates(new double[] { 11, 11, 11, 11 })
     *   new double[] { 11, 22, 33, 44, 55, 66, 77, 88 }
	 *                <-- removeDuplicates(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 })
	 * </pre>
	 */
	public static double[] removeDuplicates (double[] list) 
	{
		if (list.length==0) {
			return new double[0];
		}
		if (list.length==1) {
			return list;
		}
		
		int index=1, dups = numDuplicates(list);
		double[] noDups = new double[list.length-dups];
		double num = list[0];
		noDups[0] = num;
		
		
		for (int i=1; i<list.length; i++)
		{
			if (list[i] != num)
			{
				num = list[i];
				noDups[index] = num;
				index++;
			}
		}
		return noDups; 
	}

	/**
	 * A test program, using private helper functions.  See below.
	 * You are encouraged to review the test cases and testing code below, but you should not
	 * change any of the code below.
	 */
	public static void main (String[] args) {		
		// for numUnique: array must be sorted
		
		testNumDuplicates (0, new double[] {});
		testNumDuplicates(0,new double[] {11.0});
		testNumDuplicates(3,new double[] {11.0,11.0,11.0,11.0});
		testNumDuplicates(0,new double[] {11.0,21.0,31.0,41.0});
		testNumDuplicates(5,new double[] {11.0,11.0,11.0,21.0,31.0,31.0,31.0,31.0,41.0});
		testNumDuplicates(5,new double[] {11.0,21.0,21.0,21.0,31.0,41.0,41.0,41.0,41.0});
		testNumDuplicates(7,new double[] {11.0,11.0,21.0,21.0,21.0,31.0,31.0,41.0,41.0,41.0,41.0});
		testNumDuplicates(6,new double[] {11.0,11.0,21.0,31.0,41.0,41.0,41.0,41.0,51.0,51.0,61.0,71.0,81.0,81.0});
		testNumDuplicates(5,new double[] {11.0,21.0,31.0,41.0,41.0,41.0,41.0,41.0,51.0,51.0,61.0,71.0,81.0});
		testNumDuplicates(8,new double[] {11.0,11.0,11.0,11.0,21.0,31.0,41.0,41.0,41.0,41.0,41.0,51.0,51.0,61.0,71.0});
		testNumDuplicates(5,new double[] {11.0,21.0,31.0,41.0,41.0,41.0,41.0,41.0,51.0,51.0,61.0,71.0});
		testNumDuplicates(7,new double[] {-81.0,-81.0,-81.0,-71.0,-61.0,-51.0,-51.0,-51.0,-41.0,-41.0,-31.0,-21.0,-11.0,-11.0,-11.0});

		
		
		// for removeDuplicates: array must be sorted
		testRemoveDuplicates (new double[] {}, new double[] {});
		testRemoveDuplicates (new double[] {11.0}, new double[] {11.0} );  
		testRemoveDuplicates (new double[] {11.0}, new double[] {11.0,11.0,11.0,11.0} );  
		testRemoveDuplicates (new double[] {11.0,21.0,31.0,41.0}, new double[] {11.0,21.0,31.0,41.0} ); 
		testRemoveDuplicates (new double[] {11.0,21.0,31.0,41.0}, new double[] {11.0,11.0,11.0,21.0,31.0,31.0,31.0,31.0,41.0} ); 
		testRemoveDuplicates(new double[] {11.0,21.0,31.0,41.0} , new double[] {11.0,21.0,21.0,21.0,31.0,41.0,41.0,41.0,41.0} );
		testRemoveDuplicates(new double[] {11.0,21.0,31.0,41.0} , new double[] {11.0,11.0,21.0,21.0,21.0,31.0,31.0,41.0,41.0,41.0,41.0} );
		testRemoveDuplicates(new double[] {11.0,21.0,31.0,41.0,51.0,61.0,71.0,81.0} , new double[] {11.0,11.0,11.0,11.0,21.0,31.0,41.0,41.0,41.0,41.0,41.0,51.0,51.0,61.0,71.0,81.0,81.0} );
		testRemoveDuplicates(new double[] {11.0,21.0,31.0,41.0,51.0,61.0,71.0,81.0} , new double[] {11.0,21.0,31.0,41.0,41.0,41.0,41.0,41.0,51.0,51.0,61.0,71.0,81.0} );
		testRemoveDuplicates(new double[] {11.0,21.0,31.0,41.0,51.0,61.0,71.0} , new double[] {11.0,11.0,11.0,11.0,21.0,31.0,41.0,41.0,41.0,41.0,41.0,51.0,51.0,61.0,71.0} );
		testRemoveDuplicates(new double[] {11.0,21.0,31.0,41.0,51.0,61.0,71.0} , new double[] {11.0,21.0,31.0,41.0,41.0,41.0,41.0,41.0,51.0,51.0,61.0,71.0} );
		testRemoveDuplicates(new double[] {-81.0,-71.0,-61.0,-51.0,-41.0,-31.0,-21.0,-11.0} , new double[] {-81.0,-81.0,-81.0,-81.0,-71.0,-61.0,-51.0,-51.0,-51.0,-51.0,-41.0,-41.0,-31.0,-21.0,-11.0,-11.0,-11.0} );
		StdOut.println ("Finished tests");

	}

	private static void testNumDuplicates (int expected, double[] list) {

		int actual = numDuplicates  (list);

		if (expected != actual) {
			StdOut.format ("Failed numDuplicates %s: Expecting (%d) Actual (%d)\n", Arrays.toString(list), expected, actual);
		}
	}
	private static void testRemoveDuplicates (double[] expected, double[] list) {

		double[] actual = removeDuplicates (list);

		// != operator does not do what we want on arrays, use   equals   function from Arrays  class
		if (! Arrays.equals (expected, actual)) {
			StdOut.format ("Failed removeDuplicates %s: Expecting %s Actual %s\n", Arrays.toString(list), Arrays.toString (expected), Arrays.toString (actual));
		}
	}
}