package Exam_2_Practice;

public class Recursive_AdditiveNumber {
	public static void main(String[] args) {
		System.out.print(isAdditiveNumber("112358"));
	}

    public static boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i) {
            if (num.charAt(0) == '0' && i > 1) return false;
            for (int j = i + 1; n - j >= Math.max(i, j - i); ++j) {
                if (num.charAt(i) == '0' && j > i + 1) continue;
                long a = Long.parseLong(num.substring(0, i));
                long b = Long.parseLong(num.substring(i, j));
                if (backtrack(num, j, a, b)) return true;
            }
        }
        return false;
    }
    
    public  static boolean backtrack(String s, int idx, long a, long b) {
        if (idx == s.length()) return true;
        
        for (int i = idx; i < s.length(); ++i) {
            if (s.charAt(idx) == '0' && i > idx) break;
            
            long c = Long.parseLong(s.substring(idx, i + 1));
            if (c == a + b && backtrack(s, i + 1, b, c)) return true;
        }
        
        return false;
    }
}



	