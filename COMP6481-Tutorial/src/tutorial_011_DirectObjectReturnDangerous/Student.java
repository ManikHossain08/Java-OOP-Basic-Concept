package tutorial_011_DirectObjectReturnDangerous;


//*******************************************************************
//ArrayOperations13.java 	By: Aiman Hanna (C) 1993 - 2016
//
//This program illustrates the privacy danger when arrays are 
//directly returned by methods (getters/accessors) because this will pass the same reference and when 
//value update on the same reffernce then it reflect everywhere. 
//
//	Key Points: 1) Danger: Privacy Leak when methods return arrays 
//*******************************************************************

public class Student {
	
	public static void main(String[] args) {
		String[] courses = {"SOEN123","SOEN134", "COMP123"};
		ArrayOPeration stud = new ArrayOPeration(courses);
		stud.getCourseDangerousCode();
		String[] abc = stud.getCourseDangerousCode();
		
		System.out.println(abc +"-------"+ stud.getCourseDangerousCode());
		
		for (int i = 0; i < abc.length; i++) {
			System.out.print(abc[i]);
		}
		// here we are changing the value after getting the direct return from other class by getter
		for (int i = 0; i < abc.length; i++) {
			abc[i] = "fuck you";
		}
		
		for (int i = 0; i < stud.getCourseDangerousCode().length; i++) {
			System.out.println(stud.getCourseDangerousCode()[i]);
		}
		
		System.out.println(abc +"-------"+ stud.getCourseDangerousCode());
	}
	
}

