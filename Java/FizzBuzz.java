/*
 *  Program that prints Fizz & Buzz for numbers from 1 to 100. 
 *	If number is multiples of '3' print "Fizz". 
 *	If number is multiples of '5' print "Buzz".
 *	If number is multiples of '3' & '5' print "FizzBuzz" instead of the number.
 */
public class FizzBuzz {

	public static void main(String[] args) {
		int n = 100; 

		// loop for 100 times 
		for (int i=1; i<=n; i++)                                  
		{  
			// number divisible by 3 & 5, print 'FizzBuzz'
			if (i%15==0) {                                                 
				System.out.print("FizzBuzz"+" ");  
			}
			// number divisible by 5, print 'Buzz'  
			else if (i%5==0) {
				System.out.print("Buzz"+" ");  
			}
			// number divisible by 3, print 'Fizz'   
			else if (i%3==0) {
				System.out.print("Fizz"+" ");  
			}
			// print the numbers 
			else {
				System.out.print(i+" ");
			}
		} 
	}
}
