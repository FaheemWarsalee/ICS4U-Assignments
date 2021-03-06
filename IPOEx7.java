/*
Program: IPO Exercise 7
Programmer: Faheem Warsalee
Course: ICS4U
Date: 9/5/2018

Brief Description: Ask the user their name, age, and the current year. Greet the user and tell them the year they were born.
Extend: Calculate and tell them the year they will be 25, 50, and 75.*/

class IPOEx7
{
  public static void main(String[] args)
  {
    String name;
    int age, year, byear;
    
    System.out.println("Enter your name: ");
    name = In.getString();
    
    System.out.println("Enter your age: ");
    age = In.getInt();
    
    System.out.println("Enter the current year: ");
    year = In.getInt();
    
    byear = year - age;
    
    System.out.println(name + " will be 25 in " + (byear + 25));
    System.out.println(name +" will be 50 in " + (byear + 50));
    System.out.println(name + " will be 75 in " + (byear + 75));
  }
}
