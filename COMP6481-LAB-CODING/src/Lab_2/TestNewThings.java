package Lab_2;

import java.util.HashSet;
import java.util.Set;

public class TestNewThings {
	public static void main(String[] args) {
		Set<Integer> ss = new HashSet<Integer>();
		
		ss.add(1);
		ss.add(10);
		for (Integer integer : ss) {
			System.out.println(integer);
		}
	}
}
