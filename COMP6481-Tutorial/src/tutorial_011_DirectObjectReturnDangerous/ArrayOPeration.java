package tutorial_011_DirectObjectReturnDangerous;

//*******************************************************************
//ArrayOperations13.java 	By: Aiman Hanna (C) 1993 - 2016
//
//This program illustrates the privacy danger when arrays are 
//directly returned by methods (getters/accessors) because this will pass the same reference and when 
// value update on the same reffernce then it reflect everywhere. 
//
//	Key Points: 1) Danger: Privacy Leak when methods return arrays 
//*******************************************************************

public class ArrayOPeration {
	
	private String[] course = new String[3];

	public ArrayOPeration(String[] cours) {
		for (int i = 0; i < course.length; i++) {
			course[i] = "SOEN00" + i;
		}
	}

	public String[] getCourseDangerousCode() {
		return course; // this is the danger of returning the direct pass array by refference through return
	}
	
	public String[] getCourseAvoidDanger() {
		String[] tempCourse = new String[course.length];
		for (int i = 0; i < course.length; i++) {
			tempCourse[i] = course[i];
		}
		return tempCourse; // this code solve the problem because here same refference is not sending
	}

	public void setCourse(String[] course) {
		this.course = course;
	}
}
