package tutorial_0011;

public class Client {
	public static void main(String[] args) {
		// --------------//
		Array arr = new Array();
		
		//--------------//
		char[] chs = { 'a', 'b', 'c', 'd', 'e', 'f'}; 
		String s = new String(chs, 1, 3); 
		System.out.println(s);
		
		// ------------ //
		char[] a = { 'a', 'b', 'c', 'd', 'e' };
		arr.change(a);
		System.out.println(new String(a));
		
	}
}
