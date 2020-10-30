package PracticeLab_5;

import java.util.Scanner;


public class priorityQ {
	public static Entry entry=new Entry(100);
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
	
		
		System.out.println("fibonachi binary recursion");
		int k=input.nextInt();
		binaryFibo(k);

		
//		entry.insert(10);
//		entry.insert(20);
//		entry.insert(2);
//		entry.insert(10);
//		entry.insert(0);
//		entry.insert(100);
//		entry.insert(30);
//		entry.insert(15);
//		entry.insert(200);
//		entry.insert(3);
		
//		System.out.println(entry.min());
//		System.out.println(entry.max());
//		System.out.println(entry.size());
		
//		System.out.println("print from min to max");
//		while(!entry.isEmpty()){
//			System.out.println(entry.removeFirst());
//		}
		
		System.out.println("print from max to min");
		while(!entry.isEmpty())
			System.out.println(entry.removeLast());
		input.close();
		
	}
	
	
	

public static int[] binaryFibo(int k) {
		
		int[] A=new int[2];
		int i=0;
		int j=0;
		
		if(k==0){
			i=k;
			j=0;
			
			A[0]=i; A[1]=j;
			
			System.out.print((i+j)+" ");
			return (A);
		}
		
		else if(k==1){
			i=k;
			j=0;
			
			A[0]=i; A[1]=j;
			entry.insert(j);
			entry.insert(i);
			System.out.print(j+" "+i+" ");
			return (A);
		}
		
		else{
			
			A=binaryFibo(k-1);
			i=A[0];
			j=A[1];
			entry.insert(i+j);
			System.out.print((i+j)+" ");
			A[0]=i+j;
			A[1]=i;
			return (A);
		}
	
}

}

class Entry{
	
	private int key;
	private int[] array;
	private int size;
	
	public Entry(int len) {
		
		key=0;
		size=0;
		array=new int[len];
		
	}
	
	public void insert(int value){
		if(size > array.length){
			throw new RuntimeException("q is full");
		}
		array[key]=value;
		key++;
		size++;
		
	}
	
	public int removeFirst(){
		if(size <=0){
			throw new RuntimeException("q is empty");
		}
		
		int min=Integer.MAX_VALUE;
		int index=0;
		for(int i=0;i<size;i++){
			
			if(min > array[i]){
				index=i;
				min=array[i];
				
			}
		}
	array[index]=array[size-1];
	array[size-1]=0;
	size--;
	key=size;
	
	return min;
		
	}
	
	public int min(){
		
		if(size <=0){
			throw new RuntimeException("q is empty");
		}
		
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<size;i++){
			
			if(min>array[i]){
				min=array[i];
			}
		}
		return min;
		
	}
	
   public int removeLast(){
	   if(size <=0){
			throw new RuntimeException("q is empty");
		}
	   
	   int max= Integer.MIN_VALUE;
	   int index=0;
	   for(int i=0;i<size;i++){
		   if(max< array[i]){
			   index=i;
			   max=array[i];
		   }
	   }
	   
	   array[index]=array[size-1];
	   array[size-1]=0;
	   size--;
	   key=size;
	   
	   return max;
	}
   
   public int max(){
	   
	   if(size <=0){
			throw new RuntimeException("q is empty");
		}
		
	   int max= Integer.MIN_VALUE;
	   
	   for(int i=0;i<size;i++){
		   
		   if(max<array[i]){
			   max=array[i];
		   }
	   }
	   return max;
	}
   
   public boolean isEmpty(){
	   return size==0;
   }
   
   public int size(){
	   return size;
   }
   
   
}