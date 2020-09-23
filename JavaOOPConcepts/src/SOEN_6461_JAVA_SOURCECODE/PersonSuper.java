package SOEN_6461_JAVA_SOURCECODE;
class Person
  {
     String name;
     Person(String n)
      {
        name = "Person:  " + n;
      }
   }
class Mother extends Person
  {
     Mother(String n)
     {
       super(n);
       name = "Mother:  " + n;
     }
  void FeedChildren()
    {
       System.out.println(name + " is feeding the kids ...");
    }
 }
class Wife extends Person
  {
    Wife(String n)
     {
         super(n);
         name = "Wife:  " + n;
      }
  void CallHusband()
   {
      System.out.println(name + " is calling the husband ...");
   }
}
