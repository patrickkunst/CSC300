/* Patrick Kunst
 * CSC 300
 * Homework 1
 */

package homework;

import stdlib.StdOut;
import stdlib.StdIn;

public class HomeworkOne 
{
	public static void main(String[] args)
	{
		A();
		B();
		C();
		D();
	}
	
	public static void A()
	{
		double num1, num2, sum, dif, quo, power;
		StdOut.println("Enter a floting point number");
		num1 = StdIn.readFloat();
		StdOut.println("Enter a floating point number");
		num2 = StdIn.readFloat();
		
		sum = num1 + num2;
		dif = num1 - num2;
		quo = num1 / num2;
		power = Math.pow(num1, num2);
		
		StdOut.println("The sum: " + sum);
		StdOut.println("The difference: " + dif);
		StdOut.println("The quotient: " + quo);
		StdOut.println("The exponent: " + power);
	}
	
	public static void B()
	{
		int n, log, iters=0;
		StdOut.println("Enter a postitive integer");
		n = StdIn.readInt();
		
		while(n != 1)
		{
			n /= 2;
			StdOut.println(n);
			iters++;
		}
		StdOut.println("Number of iterations: " + iters);
		//Figure out log later
		
	}
	
	public static void C()
	{
		int iq=1, sum=0, num=0; //To start loop
		
		while (iq >= 0)
		{
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
	
	public static void D()
	{
		
	}
}
