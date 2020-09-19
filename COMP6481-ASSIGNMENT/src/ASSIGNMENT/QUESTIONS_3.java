package ASSIGNMENT;

public class QUESTIONS_3 {
	public static void main(String[] args) {
		
		int[] arr = {20, 52,400, 3, 30, 70, 72, 47, 28, 38, 41, 53, 20};
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] bigDiff = new  int[2];
		int[] smallDiff = new  int[2];
		
		for (int i = 1; i < arr.length; i++) {
			int dif = Math.abs(arr[i-1] - arr[i]);
			if( dif > max) {
				 bigDiff[0] = arr[i-1];
				 bigDiff[1] = arr[i];
				 max = Math.max(dif, max);
			}
			if(dif < min) {
				smallDiff[0] = arr[i-1];
				smallDiff[1] = arr[i];
				 min = Math.min(dif, min);
			}
		}
		
			System.out.println(bigDiff[0] +" " +bigDiff[1]);
			System.out.print(smallDiff[0] + " "+smallDiff[1]);
		
	}
}
