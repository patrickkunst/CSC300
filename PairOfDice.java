package homework;

/**
*  CSC300 Program 3b:  the file name must be  PairOfDice
*  Version 1.0
*  
*   Patrick Kunst
*   Section 601
*   
*  copy/paste the output in the space below
*  ------------------------------------------------------
*  
*  
*  
*  --------------------------------------------------------
*  
* This is a skeleton file for your homework. Edit the sections marked TODO.
*
* You must not change the declaration of any method. 
* You may not use any other Java classes (e.g. ArrayLists, etc) without permission
* of the instructor.
* Do not change the main function
*/
import stdlib.StdOut;
import stdlib.StdRandom;
/*
 * The class PairOfDice implement some basic functionality
 * of a pair of dice.  You may not add any methods to this class
 * other than those indicated below.
 */
public class PairOfDice {
	private int die1, die2;

	public PairOfDice() {  // constructor
		roll();
	}

	public void roll() {  // randomize the dice values
		die1 = StdRandom.uniform(1, 7);  // returns a random number from 1 to 6
		die2 = StdRandom.uniform(1, 7);
	}
	public boolean isDoubles() { // determines if the two die values are the name
		return die1 == die2;
	}
	public int sum() {     // the the sum of the two die values
		return die1 + die2;
	}
	
	// ToDo 1
	// add an instance method that determines if the current dice sum is 7 or 11
	// return true or false
	
	public boolean isSevenEleven()
	{
		return this.sum()==7 || this.sum()==11;
	}

	// ToDo 2
	// add an instance method that determines if both dice are odd.
	// hint boolean
	
	public boolean isOdd()
	{
		return (die1%2)==1 && (die2%2)==1;
	}
	
//------------------------------------- testing program ---------------------
	
	 /* experiment 1
	 * 
	 * Q. how many rolls does it take (on the average) to roll a seven or eleven?
	 * 
	 * first write a loop to count the number of rolls needed to roll  a seven or eleven
	 * For example   if the rolls were:  2 8 3 5 12 11, it took 6 rolls to get an 11 (this time)
	 * then add code to repeat that test 1,000,000 times.  
	 * return: the average (number of rolls needed) of all the tests
	 * hint:  nested loops, use the  sevenOrEleven instance method
	 */
	
	public static double experimentOne( PairOfDice x) 
	{
		int count=1; //The constructor already rolls the dice, counts as one roll
		for (int i=0; i<1000000; i++)
		{	
			while (!x.isSevenEleven()) 
			{
				x.roll();
				count++;
			}
			while(x.isSevenEleven())//so first while loop runs on next iter
			{
				x.roll();
			}
		}
		return (double)count/1000000; // ToDo 3   

	}
	/*
	 * experiment 2
	 * Question:  what is the likelihood of rolling odd-valued doubles?
	 * To answer this, complete this function which
	 * should roll the dice 1,000,000 times and 
	 * determine and return the percentage of rolls that are doubles 
	 * with an odd die value.  ( 1,1)  or (3,3) or (5,5)
	 * 
	 * Hint: you will need to used instance methods of the PairOfDice class
	 */
	public static double experimentTwo( PairOfDice x) 
	{
		int count=0;
		for (int i=0; i<1000000; i++)
		{
			x.roll();
			if (x.isDoubles() && x.isOdd()) {
				count++;
			}
		}
		return (double)count/1000000;  // ToDo 2:
	}
	
	// nothing to do here
	public static void main(String[] args) {
		
		 PairOfDice myDice = new PairOfDice();
		
         double rollsToGet7or11 = experimentOne(myDice);
         double probOddDoubles = experimentTwo(myDice);

         StdOut.format(" The average number of rolls to get a 7 or 11 was %5.3f\n", rollsToGet7or11);
         StdOut.format(" The experimental probablity of rolling odd doubles is  %5.3f\n", probOddDoubles);

	}

	
	
}
