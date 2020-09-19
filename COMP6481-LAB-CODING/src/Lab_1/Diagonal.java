package Lab_1;

import java.util.Scanner;

public class Diagonal {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int size = sc.nextInt();
	int [][] darray = new int[size][size];
	
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			darray[i][j] = sc.nextInt();
		}
	}
	
	String[][] diagonel = reverseColumn(darray, size);
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
				if(j != size-1 )System.out.print(diagonel[i][j] +" ");
				else System.out.print(diagonel[i][j]);
				}
				if(i != size-1) {
					 System.out.print("\n");
					}
			}
	
	sc.close();
		}
	

private static String[][] reverseColumn(int[][] darray, int size) {
	String[][] temp = new String[size][size];
	
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			temp [i][j]= darray[i][j] + "";
		}
	}
	
	for (int i = 0; i < size; i++) {
		String[] row = new String [size];
		row = temp[i];
		for (int j = i + 1; j < row.length; j++) {
			row[j] = "*"; 
		}
		
		temp[i] = row;
			//break;
	}
	return temp;
}
}
