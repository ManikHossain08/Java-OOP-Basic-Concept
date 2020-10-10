package LabExam_1;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		int n=input.nextInt();
		int[][] array=new int[n][n];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<array[i].length;j++){
				
				array[i][j]=input.nextInt();
			}
		}
		
		hourseglass(array,n);
		
	}

	public static void hourseglass(int[][] array,int n) {
		
		int max1 = 0 ; 
		for(int i=0;i<n-2;i++){
			
			for(int j=0;j<n-2;j++){
				
				int sum= (array[i][j]+array[i][j+1]+array[i][j+2])
						+(array[i+1][j+1])
								+(array[i+2][j]+array[i+2][j+1]+array[i+2][j+2]);
				
				max1=Math.max(max1,sum);
			}
			
		}
		
		System.out.println(max1);
		
	}
}
		



	

