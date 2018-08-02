package homework;

import csc300sp18.CSC300Sorts;  // you must have the csc300.jar file installed
// and added to the build path.
import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.Stopwatch;

/*
 * This is the starter file for Homework 9  Version 1.1
 *      Corrected descriptor in  output statement
 * Patrick Kunst
 * 
 */
public class CSC300HW9 {

	//	ToDo 1
	//	write a static function:  isSorted,  which will check to see if an array of doubles 
	//	passed as a parameter, is sorted.
	//  
	public static boolean isSorted(double[] a)
	{
		for (int i=1; i<a.length; i++)
		{
			if (a[i] < a[i-1])	return false;
		}
		return true;
	}
	
	// getARandomArrayOfSize 
	//   create an array of size n and fill will random doubles
	//   the array is returned
	public static double[] getARandomArrayOfSize( int n ){
		double[] a = new double[n];
		for ( int i=0; i < n; i++)
			a[i] = StdRandom.uniform();
		return a;
	}


	// this  main program performs the following experiment
	//  
	// create an array of size 1024, fill it with random data and then sort it using Sort0
	// 
	//  The experiment is done  reps  number of times; the average elapsed time is printed.
	//   Note the 'control loop' used to exclude the overhead cost
	//
	//   you might try changing Sort0 to Sort1, Sort2, Sort3, Sort4  just to make sure 
	//    they are 'callable' before proceeding further
	//
	//  ToDo:  Change main, add additional methods if you want to facilitate
	//         collecting the data you need.
	//         You can automate this as much or as little as you like
	//
	//		   You may not use any other Java classes or algorithms
	public static void main( String[] args) {

		// TODO:  add code to check which sorts actually work

		int N = 262144;             // size of data set to create and sort
		int reps = 100;			//  number of reps to perform
		double[] a;
		a = getARandomArrayOfSize(N);
		CSC300Sorts.Sort1(a);//sort1 failed
		if (!isSorted(a))	StdOut.println("failed");
		
		// control loop - to compute the time for the experimental overhead
		Stopwatch control = new Stopwatch();
		
		for (int i=0; i <= reps; i++ ) {
			a = getARandomArrayOfSize( N) ;
			//CSC300Sorts.Sort0(a);     //commented out on purpose to compute overhead
		}
		double control_elapsed =  control.elapsedTime();

		// end of control loop
		
		
		// experimental loop  - to calculate the total time for the experiment
		Stopwatch actual = new Stopwatch();

		for (int i=0; i <= reps; i++ ) {
			a = getARandomArrayOfSize( N) ;
			CSC300Sorts.Sort4(a);
		}
		double actual_elapsed =  actual.elapsedTime();

		// end of experimental loop
		
		// determine average time for doing just the sorting
		// by subtracting off the overhead time, dividing by the number of reps
		double averageTime =  ( actual_elapsed - control_elapsed)/reps;
		StdOut.format("Number of Reps: %10d  elapsed time %10.6f\n", reps, averageTime);	
	}
}
