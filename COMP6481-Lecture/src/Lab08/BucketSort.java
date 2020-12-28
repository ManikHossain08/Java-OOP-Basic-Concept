package Lab08;

//Bucket sort in Java

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
	public void bucketSort(float[] arr, int n) {
		if (n <= 0)
			return;
		@SuppressWarnings("unchecked")
		ArrayList<Float>[] bucket = new ArrayList[n];

		// Create empty buckets
		for (int i = 0; i < n; i++)
			bucket[i] = new ArrayList<Float>();

		// Add elements into the buckets
		for (int i = 0; i < n; i++) {
			int bucketIndex = (int) arr[i] * n;
			bucket[bucketIndex].add(arr[i]);
		}

		// Sort the elements of each bucket
		for (int i = 0; i < n; i++) {
			Collections.sort((bucket[i]));
		}

		// Get the sorted array
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0, size = bucket[i].size(); j < size; j++) {
				arr[index++] = bucket[i].get(j);
			}
		}
	}

// Driver code
	public static void main(String[] args) {
		BucketSort b = new BucketSort();
		float[] arr = { (float) 0.42, (float) 0.32, (float) 0.33, (float) 0.52, (float) 0.37, (float) 0.47,
				(float) 0.51 };
		b.bucketSort(arr, 7);

		for (float i : arr)
			System.out.print(i + "  ");
	}
}

/*
// Java program to sort an array 
// using bucket sort 
import java.util.*; 
import java.util.Collections; 

class GFG { 

	// Function to sort arr[] of size n 
	// using bucket sort 
	static void bucketSort(float arr[], int n) 
	{ 
		if (n <= 0) 
			return; 

		// 1) Create n empty buckets 
		@SuppressWarnings("unchecked") 
		Vector<Float>[] buckets = new Vector[n]; 

		for (int i = 0; i < n; i++) { 
			buckets[i] = new Vector<Float>(); 
		} 

		// 2) Put array elements in different buckets 
		for (int i = 0; i < n; i++) { 
			float idx = arr[i] * n; 
			buckets[(int)idx].add(arr[i]); 
		} 

		// 3) Sort individual buckets 
		for (int i = 0; i < n; i++) { 
			Collections.sort(buckets[i]); 
		} 

		// 4) Concatenate all buckets into arr[] 
		int index = 0; 
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < buckets[i].size(); j++) { 
				arr[index++] = buckets[i].get(j); 
			} 
		} 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		float arr[] = { (float)0.897, (float)0.565, 
						(float)0.656, (float)0.1234, 
						(float)0.665, (float)0.3434 }; 

		int n = arr.length; 
		bucketSort(arr, n); 

		System.out.println("Sorted array is "); 
		for (float el : arr) { 
			System.out.print(el + " "); 
		} 
	} 
} 

// This code is contributed by Himangshu Shekhar Jha 


*/
