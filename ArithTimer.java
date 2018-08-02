package homework;

import stdlib.In;
import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.Stopwatch;

public class ArithTimer {

	public static int addTwoIntsNtimes(int reps) {

		int a,b,c, sum =0;
		c = StdRandom.uniform(0,1000);
		for (int i = 1; i <= reps; i++) {
			a=StdRandom.uniform(1000);       // get two random ints from 0 to 9999
			b=StdRandom.uniform(1000);
			c = a+b;                                            // add two ints
			sum = sum + c;
			sum = sum % 12345;                     // don't let sum get too big
		}
		return sum;
	}

	public static int addThreeIntsNtimes(int reps) {

		int a,b,c, sum =0;
		c = StdRandom.uniform(0,1000);
		for (int i = 1; i <= reps; i++) {
			a=StdRandom.uniform(1000);      // get two random ints from 0 to 9999
			b=StdRandom.uniform(1000);
			c = b + a + c;                                   // add  three ints
			sum = sum + c;
			sum = sum % 12345;  	                // don't let sum get too big
		}
		return sum;
	}

	public static void main(String[] args)  {

		int result1, result2, reps;
		double time1,time2, diff;

		reps = 1000000000;                      									// number of repetitions

		Stopwatch timer1 = new Stopwatch();           
		result1 = addTwoIntsNtimes(reps);             
		time1 = timer1.elapsedTime()/reps;    // Q1.  average time to ?
		StdOut.println(time1);

		Stopwatch timer2 = new Stopwatch();
		result2 = addThreeIntsNtimes(reps);
		time2 = timer2.elapsedTime()/reps;				       // Q2. average time to ?
		StdOut.println(time2);

		diff = (time2-time1);                                 // Q3. average time to ?

		StdOut.format(" time value:  %e \n", diff);
	}
}

