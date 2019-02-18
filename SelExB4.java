/*
Program: SelExB4
Programmer: Faheem Warsalee
Course: ICS4U
Date: 9/6/2018

Brief Description: Write a program that asks for the user's age.  If the user is under 13, output, "You are a child".  For 13 to 19, output, 
                                 "You are a teen".  From 20 to 65, "You are an adult".  Over 65, "You are a senior citizen".*/

class SelExB4
{
  public static void main(String[] args)
  {
    int age;
    
    do
    {
    System.out.println("Enter your age: ");
    age = In.getInt();
    }while (age < 0);
    
    if (age < 13)
      System.out.println("You are child.");
    else if( age >= 13 && age <= 19)
      System.out.println("You are teen.");
    else if (age >= 20 && age <= 65)
      System.out.println("You are adult.");
    else 
      System.out.println("You are senior citizen");
  }
}