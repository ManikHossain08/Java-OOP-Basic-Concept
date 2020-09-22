package JavaComposition;

/*
 * https://www.journaldev.com/1325/composition-in-java-example
 * Composition in java is the design technique to implement has-a relationship in classes. 
 * We can use java inheritance or Object composition in java for code reuse.
 * 
 *  If you are looking for code reuse and the relationship between two classes is has-a then 
 *  you should use composition rather than inheritance.
 *  
 *  BENIFITS: Benefit of using composition in java is that we can control the visibility of other object 
 *  to client classes and reuse only what we need.
 */

class Job {
	private String role;
	private long salary;
	private int id;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

class Person {

	// composition has-a relationship
	private Job job;

	public Person() {
		this.job = new Job();
		job.setSalary(1000L);
	}

	public long getSalary() {
		return job.getSalary();
	}

}

public class JavaCompositionExample {
	public static void main(String[] args) {
		Person person = new Person();
		long salary = person.getSalary();
		System.out.print(salary);
	}

}
