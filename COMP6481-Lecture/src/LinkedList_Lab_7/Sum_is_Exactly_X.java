package LinkedList_Lab_7;

import java.util.Arrays;

public class Sum_is_Exactly_X {
	
	public static void main(String[]args) {
		int a[] = new int[] { 1, 1, 2, 2, 3, 5, 4, 
				2, 2, 3, 1, 1, 1 }; 
		
		int x = 4; 
		System.out.print(test(a, x));
		
	}
	
	public static boolean test(int[] a, int val) 
	{
	    Arrays.sort(a);

	    int i = 0;            // index of first element.
	    int j = a.length - 1; // index of last element. 

	    while(i<j)
	    {
	        // check if the sum of elements at index i and j equals val, if yes we are done.
	        if(a[i]+a[j] == val)
	            return true;
	        // else if sum if more than val, decrease the sum.
	        else if(a[i]+a[j] > val)
	            j--;
	        // else if sum is less than val, increase the sum.
	        else
	            i++;
	    }
	    // failed to find any such pair..return false. 
	    return false;
	}

}
