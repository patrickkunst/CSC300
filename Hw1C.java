/* Patrick Kunst
 * CSC 300
 * Homework 1
 * Output:
 * The number of IQs: 4
   The sum of IQs: 418
   The average IQ: 104.5
 */

package homework;

import stdlib.StdOut;
import stdlib.StdIn;

public class Hw1C 
{

	public static void main(String[] args) 
	{
		int iq=1, sum=0, num=0; //Set to zero to start loop
		
		while (iq >= 0)
		{
			StdOut.println("Enter an IQ or a negative integer to stop");
			iq = StdIn.readInt();
			if (iq >= 0) 
			{
				sum += iq;
				num++;
			}
		}
		double avg = (double)sum / num;
		
		StdOut.println("The number of IQs: " + num);
		StdOut.println("The sum of IQs: " + sum);
		StdOut.println("The average IQ: " + avg);
	}

}
