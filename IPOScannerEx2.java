/*
 Program:IPOScannerEx2
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/14/2018
 
 Brief Description: Write a program that asks the user to input marks for 4 courses, and the displays the average mark.
 */
import java.util.Scanner;

class IPOScannerEx2
{
  public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in);
    
    int avg;
    String[] sMarks = new String[4];
    int[] marks = new int[4];
    
    for(int i = 0; i < 4; i ++)
    {
    System.out.print("Enter mark " + (i+1) + ": ");
    sMarks[i] = userInput.next();
    
    try
    {
      marks[i] = Integer.parseInt(sMarks[i]);
    }
    catch(NumberFormatException err)
    {
      System.out.println("NOO");
    }
    }
    userInput.close();
    
    avg = (marks[0] + marks[1] + marks[2] + marks[3])/4;
    
    System.out.println("Your average is " + avg);
  }
}