/* Patrick Kunst
 * CSC 300
 * Homework 1
 * Output:
 * The sum: 10.699999809265137
   The difference: -2.3000001907348633
   The quotient: 0.646153816810021
   The exponent: 11249.164286127385
 */

package homework;

import stdlib.StdOut;
import stdlib.StdIn;

public class Hw1A 
{

	public static void main(String[] args) 
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

}
