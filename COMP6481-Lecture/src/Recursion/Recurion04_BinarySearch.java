package Recursion;

import java.util.Scanner;

public class Recurion04_BinarySearch {
	
	public static int search(int[] A, int startIndex, int endIndex, int v)		
	{
		int foundIndex = -1, mid;		
		
		if(startIndex > endIndex )		// Stopping condition; search is exhausted 
			return -1;					// without finding the value
				
		// Now find if the value is in the middle of the array
		// and if it is not there, then on which part of the array
		// it could be there, then search only that part
		
		mid = (startIndex + endIndex)/2;	// Find the middle index
											// If the array has an odd number of elements
											// that index is in the exact middle; otherwise 
											// it is one of the middle two, which is okay
		if(A[mid] == v )				
		{						
			System.out.print("\nThe value was found ......");
			return mid;		// Return the index where the value was found
		}
		else				// Recursive Steps
		{
			if(v < A[mid])	// Value could only be in the left part of the array
			{
				System.out.print("\nWill search the array between index # " + startIndex + 
						          " and index # " + (mid-1));
				foundIndex = search(A, startIndex, mid-1, v); 
			}
			else			// Value could only be in the right part of the array
			{
				System.out.print("\nWill search the array between index # " + (mid+1) + 
									" and index # " + endIndex);
				foundIndex = search(A, mid+1, endIndex, v); 				
			}
		}
		return foundIndex;
	}
	
	public static void main(String[] args)
	  {
	    	 
	    	 Scanner kb = new Scanner (System.in);
	    	 int[] Arr = new int[15];
	    	 int val, result;
	    	 
	    	
	    	 // Just initialize the array; array must be sorted
	    	 Arr[0] = 12; Arr[1] = 14; Arr[2] = 28; Arr[3] = 31; 
	    	 Arr[4] = 35; Arr[5] = 48; Arr[6] = 50; Arr[7] = 51; 
	    	 Arr[8] = 57; Arr[9] = 64; Arr[10] = 68; Arr[11] = 75; 
	    	 Arr[12] = 82; Arr[13] = 84; Arr[14] = 94; 
	    	 
	    	 System.out.print("Please enter the value you wish to search for: ");
	    	 val = kb.nextInt();
	    	 
	    	 // Call the recursive method to find whether or not the value is in the array
	    	 // Initially, start the search over the entire array
	    	 System.out.print("\nInitial search will take place over the entire " +
	    	 					"array between index # 0 and index # " + (Arr.length-1));

	    	 result = search(Arr, 0, Arr.length-1, val);
	    	 
	    	 if (result == -1)
	    		 System.out.println("\nValue " + val + " was not found in the array.");
	    	 else
	    		 System.out.println("\nValue " + val + " was found in the array at index # " + result);
	       kb.close();  
	 }

}
