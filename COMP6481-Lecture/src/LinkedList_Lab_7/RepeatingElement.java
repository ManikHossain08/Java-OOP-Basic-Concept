package LinkedList_Lab_7;

public class RepeatingElement 
{ 
	void printRepeating(int arr[], int size) 
	{ 
		int i, j; 
		System.out.println("Repeated Elements are :"); 
		for (i = 0; i < size; i++) 
		{ 
			for (j = i + 1; j < size; j++) 
			{ 
				if (arr[i] == arr[j]) 
					System.out.print(arr[i] + " "); 
			} 
		} 
	} 
	
	
	public void UniqueNumbers2(int[] arr,int n)
    {
        int sum =0;
        for(int i = 0;i<n;i++)
        {
           
            // Xor  all the elements of the array 
            // all the elements occuring twice will 
            // cancel out each other remaining 
            // two unnique numbers will be xored
            sum = (sum^arr[i]);
        }
       
        // Bitwise & the sum with it's 2's Complement
        // Bitwise & will give us the sum containing 
        // only the rightmost set bit
        sum = (sum&-sum);
 
        // sum1 and sum2 will contains 2 unique
        // elements elements initialized with 0 box 
        // number xored with 0 is number itself
        int sum1 = 0;
        int sum2 = 0;
 
        // traversing the array again
        for(int i = 0;i<arr.length;i++)
        {
 
            // Bitwise & the arr[i] with the sum
            // Two possibilities either result == 0 
            // or result > 0
            if((arr[i]&sum) > 0)
            {
 
                // if result > 0 then arr[i] xored 
                // with the sum1
                sum1 = (sum1^arr[i]);
            }
            else
            {
                // if result == 0 then arr[i] 
                // xored with sum2
                sum2 = (sum2^arr[i]); 
            }
        }
 
        // print the the two unique numbers
        System.out.println("The non-repeating elements are "+
                                          sum1+" and "+sum2); 
    }

	public static void main(String[] args) 
	{ 
		RepeatingElement repeat = new RepeatingElement(); 
		int arr[] = {4, 2, 4, 5, 2, 3, 1}; 
		int arr_size = arr.length; 
		repeat.printRepeating(arr, arr_size); 
		
		int[] a = new int[]{2, 3, 7, 9, 11, 2, 3, 11};
        int n = a.length;
		
		repeat.UniqueNumbers2(a, n);
	} 
} 

