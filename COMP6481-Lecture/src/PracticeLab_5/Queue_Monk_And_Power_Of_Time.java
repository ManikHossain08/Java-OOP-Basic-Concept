package PracticeLab_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_Monk_And_Power_Of_Time {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		
		
		Queue<Integer> q1 = new LinkedList<Integer>();

		Queue<Integer> q2 = new LinkedList<Integer>();

		for (int i = 0; i < n; i++)

		{

			q1.add(s.nextInt());

		}

		for (int i = 0; i < n; i++)

		{

			q2.add(s.nextInt());

		}

		int count = 0;

		while (!q1.isEmpty())

		{

			if (q1.peek() == q2.peek())

			{

				q1.remove();

				q2.remove();

				count++;

			}

			else

			{

				int temp = q1.remove();

				q1.add(temp);

				count++;

			}

		}

		System.out.println(count);
		s.close();
	}
}


/*
3
3 2 1
1 3 2

OP: 5
*/
