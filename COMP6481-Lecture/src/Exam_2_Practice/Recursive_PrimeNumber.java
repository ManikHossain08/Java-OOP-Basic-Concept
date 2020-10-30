package Exam_2_Practice;

public class Recursive_PrimeNumber {

	// java Program to find whether a Number 
	// is Prime or Not using Recursion 

		// Returns true if n is prime, else 
		// return false. 
		// i is current divisor to check. 
		static boolean isPrime(int n, int i) 
		{ 

			// Base cases 
			if (n <= 2) 
				return (n == 2) ? true : false; 
			if (n % i == 0) 
				return false; 
			if (i * i > n) 
				return true; 
		
			// Check for next divisor 
			return isPrime(n, i + 1); 
		} 
		
		// Driver program to test above function 
		public static void main(String[] args) 
		{ 

			int n = 15; 

			if (isPrime(n, 2)) 
				System.out.println("Yes"); 
			else
				System.out.println("No"); 
		} 
	} 


