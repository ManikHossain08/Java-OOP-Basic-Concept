package JavaStatic;

// https://beginnersbook.com/2013/04/java-static-class-block-methods-variables/

// difference between object and instance :https://stackoverflow.com/questions/2885385/what-is-the-difference-between-an-instance-and-an-object
/*
 * Employee e; // e is an object, with no memory allocation
 * Employee e = new Employee(); // e is an instance, with memory allocation in the heap.
 */

// https://www.journaldev.com/22394/static-method-in-java
// https://www.geeksforgeeks.org/static-methods-vs-instance-methods-java/

/*
 * https://www.javatpoint.com/static-keyword-in-java
 The static keyword in Java is used for memory management mainly. 
 We can apply static keyword with variables, methods, blocks and nested classes. 
 The static keyword belongs to the class than an instance of the class.
- The static can be:
Variable (also known as a class variable)
Method (also known as a class method)
Block
Nested class

* Restrictions for the static method

There are two main restrictions for the static method. They are:
The static method can not use non static data member or call non-static method directly.
this and super cannot be used in static context.
 */


/*
 * Instance method vs Static method
Instance method can access the instance methods and instance variables directly.
Instance method can access static variables and static methods directly.
Static methods can access the static variables and static methods directly.
Static methods can’t access instance methods and instance variables directly. 
They must use reference to object. And static method can’t use this keyword as there is no instance for ‘this’ 
to refer to.
 */

/*
 * When to create static methods in java:
Static Method doesn’t require instance creation, so it’s generally faster and provides better performance. That’s why utility class methods in Wrapper classes, System class, Collections class are all static methods.
It’s possible to write fluent code when static imports are used. You will see this a lot in testing frameworks such as JUnit and TestNG.
When your method only depends on its parameters, object state has no effect on the method behavior. Then you can create the method as static.
 */

public class JavaStaicVariable {

}

//Hashtable is the only class listed that provides synchronized methods. If you need synchronization great; 
//otherwise, use HashMap, it's faster.
//HashSet will not contain duplicate key;