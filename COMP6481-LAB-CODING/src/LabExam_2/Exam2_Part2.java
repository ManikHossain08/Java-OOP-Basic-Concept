package LabExam_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exam2_Part2 {
	public static Entry pQue = new Entry(10);
	public static void main(String[] args) {
		Scanner sc = null;
		
		try {
			readFromExistingFile(sc);
		} catch (FileNotFoundException e) {
			System.out.println("Could not open input file for reading."
					+ " Please check if file exists.");	
			System.out.print("Program will terminate.");
			System.exit(0);
		}
		
		displayFile();
		
		
	}
	
	private static void displayFile() {
		System.out.print("The content of the file after ordering it: ");
		while(!pQue.isEmpty()) {
			Student ss = pQue.removeLast();
			System.out.println(ss.getName() + "  " + ss.getMark());
		}
	}

	private static void readFromExistingFile(Scanner sc) throws FileNotFoundException {
		sc = new Scanner(new FileInputStream("StudentsRecord.txt"));
		while(sc.hasNextLine())
		{
			String[] value = sc.nextLine().split(" ");
			Student student = new Student(value[0], Integer.parseInt(value[2]));
			pQue.insert(student);
			
		}
		
		sc.close();

	}

	
}

class Entry {
	private static int size;
	private static Student[] A = null;
	private static int key;
	

	Entry(int length) {
		size = 0;
		A = new Student[length];
		key = 0;
	}

	public void insert(Student e) {
		if (size >= A.length)
			throw new RuntimeException("Priority Queue is full");
		A[key++] = e;
		size++;
	}

	
	
	
	public Student removeLast() {
		if (size <= 0)
			throw new RuntimeException("Priority Queue is empty");

		int max = Integer.MIN_VALUE;
		int index = 0;
		Student s= null;
		for (int i = 0; i < size; i++) {
			if (max < A[i].getMark()) {
				index = i;
				max = A[i].getMark();
				s = A[i];
			}
		}

		A[index] = A[size - 1];
		A[size - 1] = null;
		size--;
		key = size;

		return s;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}

}

class Student {
	
	public String name;
	public int mark;
	
	public Student(String name, int mark) {
		this.name = name;
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	
}

