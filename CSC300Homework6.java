package homework;

import stdlib.*;
public class CSC300Homework6 {

	/* 
	 * CSC300Homework6  version 1.0
	 * 
	 *   Patrick Kunst
	 *   Section 601
	 *   
	 *  this class maintains a linked structure via the instance variable first
	 *  
	 * Complete the 5 methods below marked ToDo
	 * None of the methods should modify the list, unless that is the purpose of the method.
	 * 
	 * You may not add any fields to the node or list classes.
	 * You may not add any methods to the node class.
	 * 
	 * You MAY add private methods to the CSC300Homework6 class (helper functions for the recursion). 
	 * 
	 * You may NOT use any other Java classes without permission.
	 */
	static boolean showMeSuccess = false;   // set to true to also see Success notifications for tests
	//  set to false to only see Failure notifications for tests

	static class Node {
		public Node (char item, Node next) { this.item = item; this.next = next; }
		public char item;
		public Node next;
	}

	Node first;

	// sizeIterative
	//
	// a function to compute the size of the list, using a loop
	//  an empty list has size 0
	public int sizeIterative () {
		int size = 0;
		for (Node i=first; i != null; i = i.next)
		{
			size++;
		}
		return size; //TODO 1: fix this
	}


	// sizeRecursive
	//
	// a function to compute the size of the list using recursion
	// empty list has size 0
	// You will want to create a helper function to do the recursion
	public int sizeRecursive () {

		return sizeHelper(first); //TODO 2: fix this

	}
	
	public int sizeHelper(Node i)
	{
		if (i==null)	
			return 0;
		
		return 1 + sizeHelper(i.next);
	}

	// positionOfSecondToLastOccurrence
	//
	// a function to compute: the position within the list of the second to last occurrence 
	// of the parameter: letter 
	// positions are counted as an offset from the beginning.  
	//
	// if the list contains 'a' 'b' 'c' 'd' 'c' , then the second to last  'c' is in position 2
	// if letter appears either 0 or 1 time, return -1
	//
	// you can write this iteratively or recursively,  but you should only have one loop or recursive helper
	// I would expect
	// ["ababcdefb"].positionOfSecondToLastOccurrence('b') == 3
	// ["ababcdefb"].positionOfSecondToLastOccurrence('f') == -1


	public int positionOfSecondToLastOccurrence (char letter) 
	{
		int secondLast = -1, last = -1, pos=0;
		for (Node i=first; i != null; i = i.next)
		{
			if (i.item == letter) {
				secondLast = last;
				last=pos;
			}
			pos++;
		}
		return secondLast; //TODO 3: fix this
	}



	// lastMletters
	//
	// return a string consisting of the last m letters in the list, where m is a parameter
	// Precondition:  the list has at least m nodes
	//  you can write this iteratively or recursively,  but you should only have one loop or recursive helper
	//
	// ["ababcdefb"].lastMletters(2) == "fb"
	// ["ababcdefb"].lastMletters(4) == "defb"
	//
	//  You may not use any methods from the String class except  length
	//  Suggestion:  start with an empty string and concatenate chars to it
	
	public String lastMletters ( int m) 
	{
		String letters = "";
		int size = sizeIterative(), start = size-m, pos=0;

		for (Node i=first; i != null; i = i.next)
		{
			if (pos >= start)
				letters += i.item;
			pos++;
		}
		return letters; //TODO 4: fix this
	}

	// deleteTheFirstConsecutiveDuplicateItem
	//
	// a function to delete the second of two consecutive nodes containing the same character
	//     only delete the duplicate for the first such occurrence
	// Examples:
	//  "abcdef".deleteTheFirstConsecutiveDuplicateItem()   -->  "abcdef"   // no consecutive duplicates
	//  "ababab".deleteTheFirstConsecutiveDuplicateItem()   -->  "ababab"   // no consecutive duplicates
	//  "aabcde".deleteTheFirstConsecutiveDuplicateItem()   -->  "abcde "   // delete the 'a'
	//  "abbcde".deleteTheFirstConsecutiveDuplicateItem()   -->  "abcde"   //delete the 'b'
	//  "aabbde".deleteTheFirstConsecutiveDuplicateItem()   -->  "abbde"   //delete the 'a'

	public void deleteTheFirstConsecutiveDuplicateItem() 
	{
		if (first != null)
		{
			char curChar = first.item;
			Node prevNode = first;
			for (Node i=first.next; i != null; i = i.next)
			{
				if (i.item == curChar)
				{
					prevNode.next = i.next;
					break;
				}
				curChar = i.item;
				prevNode=i;
			}
		}
	}

	// for debugging purposes, you may comment/uncomment the two calls in main below 
	// you should restore the call to mainRunTests as below when you submit your solution
	public static void main (String args[]) {
	   //mainDebug ();    
		mainRunTests ();
	}
	private static void mainDebug () {
		// Use this for debugging!
		// Add the names of helper functions if you use them.
		Trace.drawStepsOfMethod ("sizeIterative");
		Trace.drawStepsOfMethod ("sizeRecursive");
		Trace.drawStepsOfMethod ("positionOfSecondToLastOccurrence");
		Trace.drawStepsOfMethod ("deleteTheFirstConsecutiveDuplicateItem");
		Trace.drawStepsOfMethod ("lastMletters");
		Trace.run (); 
		// To Use:  Put the test here you want to debug:
		testSizeIterative (4, "abcd");
	}
	private static void mainRunTests () {
		testSizeIterative (0, "");
		testSizeIterative (1, "a");
		testSizeIterative (2, "ab");	
		testSizeIterative (4, "abcd");

		testSizeRecursive (0, "");
		testSizeRecursive (1, "a");
		testSizeRecursive (2, "ab");	
		testSizeRecursive (4, "abcd");

		testPositionOfSecondToLastOccurrence(-1,"", 'x');
		testPositionOfSecondToLastOccurrence(-1,"x",  'x');
		testPositionOfSecondToLastOccurrence(0,"xx",  'x');
		testPositionOfSecondToLastOccurrence(1,"axax",  'x');
		testPositionOfSecondToLastOccurrence(3,"xxxxx",  'x');
		testPositionOfSecondToLastOccurrence(2,"aaxxaa",  'x');
		testPositionOfSecondToLastOccurrence(-1,"aaaxaaa",  'x');
		testPositionOfSecondToLastOccurrence(4,"aaaaxaaxa",  'x');

		testDeleteTheFirstConsecutiveDuplicateItem("","");
		testDeleteTheFirstConsecutiveDuplicateItem("a","a");
		testDeleteTheFirstConsecutiveDuplicateItem("ab","ab");
		testDeleteTheFirstConsecutiveDuplicateItem("abc","abc");
		testDeleteTheFirstConsecutiveDuplicateItem("aabcde","abcde");
		testDeleteTheFirstConsecutiveDuplicateItem("abbcde","abcde");
		testDeleteTheFirstConsecutiveDuplicateItem("aabbcde","abbcde");
		testDeleteTheFirstConsecutiveDuplicateItem("abcdee","abcde");

		testLastMletters("", "abcde",0);
		testLastMletters("e", "abcde",1);
		testLastMletters("de", "abcde",2);
		testLastMletters("cde", "abcde",3);
		testLastMletters("abcde", "abcde",5);

		StdOut.println ("Finished tests");
	}


	/* ToString method to print */
	public String toString () { 
		StringBuilder result = new StringBuilder ("");
		for (Node x = first; x != null; x = x.next)
			result.append ( x.item);
		return result.toString ();
	}

	/* Method to create lists */
	public static CSC300Homework6 of(String s) {
		Node first = null;

		for (int i=s.length()-1; i >=0; i--) 
			first = new Node (s.charAt(i), first);  

		CSC300Homework6 result = new CSC300Homework6 ();
		result.first = first;
		return result;
	}

	// lots of copy and paste in these test!
	private static void testSizeIterative (int expected, String sList) {
		CSC300Homework6 list = CSC300Homework6.of (sList);
		String sStart = list.toString ();
		int actual = list.sizeIterative();
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.sizeIterative(): Expecting: %d Actual: %d\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.sizeIterative(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess) 
			StdOut.format ("Success sizeIterative:  Result: %d  input: %s\n", actual, sStart);
	}	

	private static void testSizeRecursive (int expected, String sList) {
		CSC300Homework6 list = CSC300Homework6.of (sList);
		String sStart = list.toString ();
		int actual = list.sizeRecursive();
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.sizeRecursive(): Expecting: %d  Actual: %d\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.sizeRecursive(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess)  
			StdOut.format ("Success sizeRecursive():  Result: %d  input: %s\n", actual, sStart);
	}	

	private static void testPositionOfSecondToLastOccurrence (int expected, String sList, char toFind) {
		CSC300Homework6 list = CSC300Homework6.of (sList);
		String sStart = list.toString ();
		int actual = list.positionOfSecondToLastOccurrence(toFind);
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.positionOfSecondToLastOccurrence(): Expecting: %d, Actual: %d\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.positionOfSecondToLastOccurrence(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess) 
			StdOut.format ("Success positionOfSecondToLastOccurrence():  Result: %2d  position of 2nd to last %c in [%s]\n", actual, toFind , sStart);
	}	

	private static void testDeleteTheFirstConsecutiveDuplicateItem (String sList, String expected) {
		CSC300Homework6 list = CSC300Homework6.of (sList);
		list.deleteTheFirstConsecutiveDuplicateItem();
		String actual = list.toString();
		boolean status = true;
		if (!expected.equals(actual) ) {
			StdOut.format ("Failed %s.deleteTheFirstConsecutiveDuplicateItem(): Expecting [%s] Actual [%s]\n",sList, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();

		if ( status && showMeSuccess) 
			StdOut.format ("Success deleteTheFirstConsecutiveDuplicateItem():  Before: [%s]  after  [%s]\n", sList,actual);
	}	
	private static void testLastMletters (String expected, String sList, int m) {
		CSC300Homework6 list = CSC300Homework6.of (sList);
		String sStart = list.toString ();
		String actual = list.lastMletters(m);
		boolean status = true;
		if (!expected.equals(actual)) {
			StdOut.format ("Failed %s.lastMletters(): Expecting [%s] Actual [%s]\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.lastMletters(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess) 
			StdOut.format ("Success lastMLetters:  Start: [%s] , m %d  Result: [%s]  \n", sStart, m , actual);
	}	


}
