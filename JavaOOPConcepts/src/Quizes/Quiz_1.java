package Quizes;

// for more quiz questions regrading the inheritance please visit this website
// https://javaconceptoftheday.com/java-inheritance-practice-coding-questions/

// what would be the output of this program?
// https://www.geeksforgeeks.org/access-modifiers-java/
// http://www.codespaghetti.com/inheritance-interview-questions/#questions

class A
{
    {
        System.out.println(1);
    }
}
 
class B extends A
{
    {
        System.out.println(2);
    }
}
 
class C extends B
{
    {
        System.out.println(3);
    }
}
 
public class Quiz_1
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}