package Exam_3_Practice;

//Java program to merge two max heaps. 

public class Heaps_Merge_MaxHeap { 

	// Standard heapify function to heapify a 
	// subtree rooted under idx. It assumes 
	// that subtrees of node are already heapified. 
	public static void maxHeapify(int[] arr, int n, 
											int i) 
	{ 
		// Find largest of node and its children 
		if (i >= n) { 
			return; 
		} 
		int l = i * 2 + 1; 
		int r = i * 2 + 2; 
		int max; 
		if (l < n && arr[l] > arr[i]) { 
			max = l; 
		} 
		else
			max = i; 
		if (r < n && arr[r] > arr[max]) { 
			max = r; 
		} 
		
		// Put maximum value at root and 
		// recur for the child with the 
		// maximum value 
		if (max != i) { 
			int temp = arr[max]; 
			arr[max] = arr[i]; 
			arr[i] = temp; 
			maxHeapify(arr, n, max); 
		} 
	} 
	
	// Merges max heaps a[] and b[] into merged[] 
	public static void mergeHeaps(int[] arr, int[] a, 
								int[] b, int n, int m) 
	{ 
		for (int i = 0; i < n; i++) { 
			arr[i] = a[i]; 
		} 
		for (int i = 0; i < m; i++) { 
			arr[n + i] = b[i]; 
		} 
		n = n + m; 

		// Builds a max heap of given arr[0..n-1] 
		for (int i = n / 2 - 1; i >= 0; i--) { 
			maxHeapify(arr, n, i); 
		} 
	} 
	
	// Driver Code 
	public static void main(String[] args) 
	{ 
		int[] a = {10, 5, 6, 2}; 
		int[] b = {12, 7, 9}; 
		int n = a.length; 
		int m = b.length; 

		int[] merged = new int[m + n]; 

		mergeHeaps(merged, a, b, n, m); 

		for (int i = 0; i < m + n; i++) 
			System.out.print(merged[i] + " "); 
		System.out.println(); 
	} 
} 


/*
 public class MergeHeap { 
public static void helper(int mergedArray[], int size, int currentNodeIndex) 
{ 
int rootIndex = currentNodeIndex; // Initialize currentNodeIndex as rootNodeIndex for current subtree. 
int leftChildIndex = 2 * currentNodeIndex + 1; // Finding leftchildIndex of current Node = 2*currentNodeIndex + 1 
int rightChildIndex = 2 * currentNodeIndex + 2; // Finding rightchildIndex of current node= 2*currenNodeIndex + 2 
  
// If left child is greater, make it root.
if (leftChildIndex < size && mergedArray[leftChildIndex] > mergedArray[rootIndex]) 
    rootIndex = leftChildIndex; 
 
// If right child is greater, make it root.
if (rightChildIndex < size && mergedArray[rightChildIndex] > mergedArray[rootIndex]) rootIndex = rightChildIndex; 
  
// Swapping of root if not the largest.
if (rootIndex != currentNodeIndex) { 
    int swap = mergedArray[currentNodeIndex]; 
    mergedArray[currentNodeIndex] = mergedArray[rootIndex]; 
    mergedArray[rootIndex] = swap; 
   
  // Recursively calling helper function on subtree. 
    helper(mergedArray, size, rootIndex); 
    } 
} 
  
    
// Heapify function.
public static void heapify(int mergedArray[], int size) 
{ 
// Index of last non-leaf node 
int lastindex = (size / 2) - 1;

// Performing heapify in reverse order for every index less than last leaf node index. 
for (int i = lastindex; i >= 0; i--) { 
 helper(mergedArray, size, i); 
} 
}     
    
public static void copyArrays(int mergedArray[], int A1[],  int A2[], int m, int n)
{
    // Copy elements of both array to new array. 
for (int i = 0; i < m; i++) 
    mergedArray[i] = A1[i]; 
for (int i = 0; i < n; i++) 
    mergedArray[m + i] = A2[i]; 
// finally calling on heapify function.
heapify(mergedArray, m+n); 
}
 
// Main method
public static void main(String[] args) 
{ 
int A1[] = { 20, 6, 9, 33, 88, 56, 79 }; 
int A2[] = { 81, 100, 45, 37, 11, 67 }; 
int m = A1.length; 
int n = A2.length; 
  
int[] mergedArray = new int[m + n]; 
  
copyArrays(mergedArray, A1, A2, m, n); 
    
System.out.println("After merging two max heaps into one we get:");
  
for (int i = 0; i < m + n; i++) 
    System.out.print(mergedArray[i] + " "); 
System.out.println(); 
    } 
}
 */

