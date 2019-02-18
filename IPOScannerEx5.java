/*
 Program:IPOScannerEx5
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/1/72018
 
 Brief Description: Have the user enter two integers between 1 and 9. Do the basic math operations using these numbers and display the answer (add, subtract, multiply, divide, exponent).
 */

import java.util.Scanner;

class IPOScannerEx5
{
  public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in);
    
    String sNum1, sNum2;
    int num1 = 0;
    int num2 = 0;
    
    do
    {
      try
      {
        System.out.print("Enter a number between 1 and 9: ");
        sNum1 = userInput.next();
        
        num1 = Integer.parseInt(sNum1);
      }
      catch(NumberFormatException e)
      {
        System.out.println("Error 1. Couldn't convert String into numbers. ");
      }
    }while (num1 < 1 && num1 > 9);
    
    do
    {
      try
      {
        System.out.print("Enter a number between 1 and 9: ");
        sNum2 = userInput.next();
        
        num2 = Integer.parseInt(sNum2);
        
        userInput.close();
      }
      catch(NumberFormatException e)
      {
        System.out.println("Error 1. Couldn't convert String into numbers. ");
      }
    }while (num2 < 1 && num2 > 9); 
    
    
    System.out.println(num1 + " + " + num2 + " is  equal to.. " + (num1+num2));
    System.out.println(num1 + " - " + num2 + " is  equal to.. " + (num1-num2));
    System.out.println(num1 + " * " + num2 + " is  equal to.. " + (num1*num2));
    System.out.println(num1 + " / " + num2 + " is  equal to.. " + (num1/num2));
    System.out.println(num1 + " ^ " + num2 + " is  equal to.. " + Math.pow(num1,num2));
  }
}