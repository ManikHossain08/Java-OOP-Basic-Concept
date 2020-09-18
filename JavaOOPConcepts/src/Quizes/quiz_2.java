package Quizes;

// if we comment 'public A() {}' and 'super(10); ' what will be the error of this program?

class Aa1
{
 
	public Aa1() {}
	 
    public Aa1(int i)
    {
 
    }
}
 
class Ba1 extends Aa1
{
    public Ba1()
    {
       super(); 
    }
}


public class quiz_2 {
	public static void main(String[] args) {
		
	}

}

// if you manually define constructor then your have to call manually call super() constructor 
// from the child class properly. if everything is default then there is no problem. but if 
// you created the parameterized constructor on your own then you have to let your compiler know
// that you want to use this constructor of the base class.

