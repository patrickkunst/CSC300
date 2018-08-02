package homework;

import stdlib.StdOut;

// Homework 8   version 1.0
//   
//   Patrick Kunst
//
//   In this homework you will implement a scaled down version of the Java List Interface
//    As noted in class, Java provides two implementations of the List Interface:
//        -  ArrayList :   using resizable arrays
//        -  Linkedlist:   using a linked list of nodes
// 
//  And so this List ADT can be implemented using either a basic Java array or linked structure
//  Each implementation has performance advantages and disadvantages
//
//  a Simplification:    The Java List interface is GENERIC; this one is NOT
//                                     You are implementing a 'list' of integers - int
//
//  You get to choose which of the two approaches to use
//   Complete all the ToDo's  (in the suggested order)
//
//-------------------------------------------------------------------------------------------
//    Some helper functions are provided for you;  you are free to change/adapt/delete them
//    however you should only do so purposefully since some of them are used in the testing framework
//
//    createFrom  can be used to populate  your list using data from an input array.
//             you will need to comment-in the correct part corresponding to your implementation choice
//    
//    resize()      this only applies to array implementations. 
//             to use it you will need to comment-in the body of the function
//
//    print      will print the list information:  size and contents.  
//------------------------------------------------------------------------------------------------
//    Note that the provided testing framework will not work correctly until you have completed some of the
//    required functions.  And all testing is NOT automated; in some cases you will need to examine the output and verify
//    that the output is as expected.
//
//    You may not use any other Java classes or algorithms in creating your solutions.
//    
public class CSC300List {

	// ToDo 0

	// decide if you want to use:
	//  a) linked list
	//  b) resizing array     for your container
	//       you might review all the instance methods below first; some will be easier to do
	//       depending on which container you choose.


	// ToDo  0.5
	//   choose your private data variables:   comment-in the ones you want:   A  or B
	//   you can delete the other ones if you want
	//  you will also want to comment-in the relevant sections in the helper functions at the bottom of the file

	//  A      
	private Node first;    // reference to the beginning of the list
	
	static class Node 
	{
		public Node (int item, Node next) { this.item = item; this.next = next; }
		public int item;
		public Node next;
	}

	//B
	//	private   int[] a;     // a is to be a resizeable array
	//	private   int  N;     // how many spaces in the array are currently used

	public CSC300List() 
	{   
		// the List constructor
		// ToDo 1  initialize your private data
		// suggestion, for an array start with an array of size 5 , 
		first = null;

	}

	// size
	//
	//  return the number of elements in the list.
	//      this *may not be* the same as the size of the array 
	public int size() 
	{
		int count = 0;
		
		for (Node i = first; i != null; i = i.next)
		{
			count++;
		}
		return count;  // toDo 2  fix this
	}

	//  get
	//
	//  return the value in position i of your list
	//  Hint:  for an array this is *really* easy
	//              for a linked list, you will need to traverse the list, counting as  you go
	// precondition:   i  is a valid position for the list  
	public int get(int i) 
	{
		Node k = first;
		for (int j = 0; j < size(); j++)
		{
			if (j == i) return k.item;
			k = k.next;
		}
		return -999999; //because precondition, will never return this value. Needed to compile.
	}

	// removeAt
	//
	// delete the element in position k (where k is between 0 and N-1 inclusive)
	// positions are numbered starting with 0, N is the size of the list
	// preconditions:  0 <= k <= N-1
	//                            :  N >=1 ; list is not empty
	//     Examples:   
	//             10   20   30   40   50,   removeAt(0)  would result in:    20  30  40  50
	//             10   20   30   40   50,   removeAt(1)  would result in:    10  30  40  50
	//             10   20   30   40   50,   removeAt(4)  would result in:    10   20  30  40 
	//   Hint:  for an array, you will need to move every value to the right of position k, left one position
	//            for a linked list you will need to delete the node in that position
	//                     deleting the  first node in a linked list is a special case to handle
	public void removeAt (int k) 
	{
		if (k==0) first = first.next;
		else
		{
			int index = 1;
			Node prev = first;
			for (Node i = first.next; i != null; i = i.next)
			{
				if (index == k)
				{
					prev.next = i.next;
					break;
				}
				index++;
				prev = prev.next;
			}
		}
		// ToDo 4
	}

	// insertAt
	//
	// insert a new value into the list at position k with value: val
	// positions are numbered starting with 0
	// preconditions:  0 <= k <= N-1
	//               list may be empty
	//     for an array, this operation may require resizing the array
	//    inserting at the front of a list is a special case
	public void insertAt( int val, int k) 
	{
		Node inserted = new Node(val, null);
		if (k == 0)
		{
			Node x = first;
			first = inserted;
			inserted.next = x;
		}
		else
		{
			int index = 1;
			Node prev = first;
			for (Node i = first.next; i != null; i = i.next)
			{
				if (index == k)
				{
					prev.next = inserted;
					inserted.next = i;
					break;
				}
				index++;
				prev = prev.next;
			}
		}
		//ToDo 5    fix this
	}

	// contains
	//
	// returns true if the list contains the value: val;  false otherwise
	//
	public boolean contains( int val) 
	{
		for (Node i=first; i!=null; i=i.next)
		{
			if (i.item==val) return true;
		}
		return false; // ToDo 6  fix this
	}

	//  A+ level    (see instructions)
	//
	// append
	//   this function is passed a list instance named other
	//   copy all the values from other to the end of  the invoking instance list
	//   for array implementations you may need to resize the list instance array
	// Example:  if the invoking list is  1 2 3 4   and  other is:  5 6 7 8 then
	//     the invoking list becomes:   1 2 3 4 5 6 7 8

	public void append( CSC300List other) 
	{
		int s = size();
		Node i = first;
		for (int index=0; index < s; index++)
		{
			if (index == s-1)
			{
				Node prev = i;
				for (Node j = other.first; j != null; j = j.next)
				{
					prev.next = new Node(j.item, null);
					prev = prev.next;
				}
			}
			i = i.next;
		}
		// ToDo A+
	}

	public static void main(String[] args) {

		testContainsMethod();
		testGetMethod();
		testInsertAtMethod();
		testRemoveAtMethod();

		// ToDO A+ uncomment the line below to perform your append tests
		testAppendMethod();
	}


	public static void testAppendMethod () {
		//  ToDo  A+  add code that tests two distinct cases for the append operation
		//  The  OUTPUT should include text that describes what is being tested. You should think about what would constitute:
		//        'normal'  and 'extreme' append cases
		
		CSC300List x = createFrom(new int[] {0, 2, 3, 5, 6, 1, 7});
		StdOut.println("----------------------------------");
		print(x);
		StdOut.println("testing append(createFrom(new int[] {90, 102, 50}))    Result: ");
		x.append(createFrom(new int[] {90, 102, 50}));
		print(x);
		
		CSC300List y = createFrom(new int[] {1, 2, 3, 4, 5});
		StdOut.println("----------------------------------");
		print(y);
		StdOut.println("testing append(createFrom(new int[] {6, 7, 8, 9, 10}))    Result: ");
		y.append(createFrom(new int[] {6, 7, 8, 9, 10}));
		print(y);
		
		

	}
	// Testing functions
	//   Each testing function contains at least one sample test case.
	//   Review these test cases and then develop your own test case ( test something different than the example tests!)
	//   Include a comment and a print statement that indicates what you are trying test for.  Hint: think about the extremes

	public static void testContainsMethod() {
		CSC300List x = createFrom( new int[] {0,1,2,3,4,5} );
		StdOut.println("----------------------------------");
		print(x);
		StdOut.println("contains(2)"); // test:     val in the middle of the list
		if ( x.contains(2)) 
			StdOut.println("   test successful\n");
		else
			StdOut.println("   test fails\n");

		StdOut.println("----------------------------------");
		print(x);
		StdOut.println("test:  contains(8)"); //  test:  val NOT in the list")
		if ( x.contains(8)) 
			StdOut.println("   test fails.  contains reports the value is in the list\n");
		else
			StdOut.println("   test succeeds\n");
		
		//T1
		CSC300List y = createFrom(new int[] {0, 2, 4, 6, 8, 10});
		StdOut.println("----------------------------------");
		print(y);
		StdOut.println("contains(1)"); //should be false
		if (!y.contains(1))	StdOut.println("   test successful\n");
		else	StdOut.println("   test fails\n");

	}
	public static void testGetMethod() {
		CSC300List x = createFrom( new int[] {0,2,4,6,8} );
		StdOut.println("----------------------------------");
		print(x);
		StdOut.println("test:  get(2)");    //  get a value 'in the middle' of the list
		if ( x.get(2) == 4) 
			StdOut.println("  test successful\n");
		else
			StdOut.println("  test failure\n");
		
		//T2
		CSC300List y = createFrom(new int[] {1, 2, 3, 4, 5});
		StdOut.println("----------------------------------");
		print(y);
		StdOut.println("get(1)");
		if (y.get(1) == 2)	StdOut.println("   test successful\n");
		else	StdOut.println("  test failure\n");

	}
	public static void testInsertAtMethod() {
		CSC300List x = createFrom( new int[] {0,1,2,3,4,5} );
		StdOut.println("----------------------------------");
		print(x);
		x.insertAt(99, 2);						// insert a value 'in the middle' of the list
		StdOut.println("test:  insertAt(99,2)       Result:  "); 
		print(x);
		
		//T3
		CSC300List y = createFrom(new int[] {2, 4, 6, 8, 10});
		StdOut.println("----------------------------------");
		print(y);
		y.insertAt(0, 0);
		StdOut.println("test:  insertAt(0,0)      Result:  ");
		print(y);

	}

	public static void testRemoveAtMethod() {
		CSC300List x = createFrom( new int[] {0,1,2,3,4,5} );
		StdOut.println("----------------------------------");
		print(x);
		x.removeAt( 2);
		StdOut.println("test:  removeAt( 2)     Result:");
		print(x);
		
		
		//T4
		CSC300List y = createFrom(new int[] {2, 4, 6, 8, 10});
		StdOut.println("----------------------------------");
		print(y);
		y.removeAt(0);
		StdOut.println("test  removeAt(0)     Result:  ");
		print(y);

	}


	// ---------------------------------------------------------------------------------------------
	// Helper functions.  
	// These require your methods to work correctly.
	//
	// print
	// print the list information
	public static void print( CSC300List a) {
		StdOut.format(" size: %d\n", a.size());
		for (int i=0; i < a.size(); i++)
			StdOut.format(" %d ", a.get(i));
		StdOut.println();
	}

	//createFrom
	//  creates a list instance using the input array data
	//  comment in/out the segment corresponding to your implementation
	//  for an array implementation the array size will be exactly equal to the data array size
	public static CSC300List createFrom(int[] data) {

		CSC300List result = new CSC300List ();
		//  A   List creation code
		//  Comment-in the code below if you are using a linked list implementation
		Node first = null;
		//
		for (int i=data.length-1; i >=0; i--) 
			first = new Node (data[i], first);  

		result.first = first;
		return result;

		//  B   Array creation code
		//  Comment-in the code below if you are using an array implementation
		//	
		//		int[] temp = new int[data.length];
		//		for (int i=0; i < temp.length; i++ ) temp[i] = data[i];
		//		result.a = temp;
		//		result.N= data.length;

		//return result;

	}

	// resize
	// resizes the array to the specified capacity
	//     copies the old data to the new space
	//     precondition:  capacity >= a.length
	// Comment-in the body of this function if you are doing the array implementation
	//private void resize(int capacity) {
		//	StdOut.println("***** array resized *****");
		//	int[] b = new int[capacity];
		//	for ( int i=0; i < a.length; i++) b[i] = a[i];
		//
		//	a =b;
	//}

}



