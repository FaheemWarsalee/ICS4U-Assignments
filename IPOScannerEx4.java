/*
 Program:IPOScannerEx4
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/14/2018
 
 Brief Description: Ask the user their name, age, and the current year. Greet the user and tell them the year they will be 25, 50, and 75.
 */

import java.util.Scanner;

class IPOScannerEx4
{
  public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in);
    
    String name, sAge, sCurrYear;
    int age = -1;
    int currYear = 0;
    int byear;
    
    System.out.print("Enter your name: ");
    name = userInput.next();
    
    do
    {
      System.out.print("Enter your age: ");
      sAge = userInput.next();
      try{
        age = Integer.parseInt(sAge);
      }
      catch(NumberFormatException e){
        System.out.println("ERROR Converting into Integers.");
      }
    }while(age < 0);
    
    do
    {
      System.out.print("Enter the current Year: ");
      sCurrYear = userInput.next();
      try{
        currYear = Integer.parseInt(sCurrYear);
      }
      catch(NumberFormatException e){
        System.out.println("you made an oopsie doopsie, i cannot make numbers from ur input uWu D;");
      }
    }while (currYear < 0);
    
    byear = currYear - age;
    
    System.out.println("");
    System.out.println(name + " You will be 25 in " + (byear+25) );
    System.out.println(name + " You will be 50 in " + (byear+50) );
    System.out.println(name + " You will be 75 in " + (byear+75) );
    
    userInput.close();
  }
}