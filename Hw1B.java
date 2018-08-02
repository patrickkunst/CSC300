/* Patrick Kunst
 * CSC 300
 * Homework 1
 * Output:
Enter a postitive integer
8
4
2
1
Number of iterations: 3
The log: 3.0

Enter a postitive integer
37
18
9
4
2
1
Number of iterations: 5
The log: 5.20945336562895
 */

package homework;

import stdlib.StdOut;
import stdlib.StdIn;

public class Hw1B 
{

	public static void main(String[] args) 
	{
		int n, iters=0;
		StdOut.println("Enter a postitive integer");
		n = StdIn.readInt();
		int m = n;
		
		while(m != 1)
		{
			m /= 2;
			StdOut.println(m);
			iters++;
		}
		StdOut.println("Number of iterations: " + iters);
		
		StdOut.println("The log: " + (Math.log(n)/Math.log(2)));
	}

}
