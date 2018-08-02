/* Patrick Kunst
 * CSC 300
 * Homework 1
 * Output:
Enter a positive integer
10
The argument passed: 0
The value returned by the function: 0
The value of the equation: 0.0

The argument passed: 1
The value returned by the function: 1
The value of the equation: 1.0

The argument passed: 2
The value returned by the function: 3
The value of the equation: 3.0

The argument passed: 3
The value returned by the function: 6
The value of the equation: 6.0

The argument passed: 4
The value returned by the function: 10
The value of the equation: 10.0

The argument passed: 5
The value returned by the function: 15
The value of the equation: 15.0

The argument passed: 6
The value returned by the function: 21
The value of the equation: 21.0

The argument passed: 7
The value returned by the function: 28
The value of the equation: 28.0

The argument passed: 8
The value returned by the function: 36
The value of the equation: 36.0

The argument passed: 9
The value returned by the function: 45
The value of the equation: 45.0

The argument passed: 10
The value returned by the function: 55
The value of the equation: 55.0

 */

package homework;

import stdlib.StdOut;
import stdlib.StdIn;

public class Hw1D 
{

	public static void main(String[] args) 
	{
		StdOut.println("Enter a positive integer");
		int m = StdIn.readInt();
		
		for (int i=0; i<=m; i++)
		{
			int sum = sumToN(i);
			double val = (double)((i+1)*i)/2;
			
			StdOut.println("The argument passed: " + i);
			StdOut.println("The value returned by the function: " + sum);
			StdOut.println("The value of the equation: " + val);
			StdOut.println();
		}
		
	}
	
	public static int sumToN(int n)
	{
		int sum=0;
		for (int i=1; i<=n; i++)
		{
			sum += i;
		}
		return sum;
	}

}
