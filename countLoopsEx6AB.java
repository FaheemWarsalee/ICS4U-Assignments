/*
Program: countLoopsEx6AB
Programmer: Faheem Warsalee
Course: ICS4U
Date: 9/7/2018

Brief Description: (a) [Challenge] Ask the user to input a number between 1 and 99, and then tell the user how many "tens" and how many "ones" in their number.
For example, if the user entered 75:
75 has 7 tens and 5 ones

Extension:
(b) Increase the scope of the program to include "hundreds" and allow inputs from 1 to 999
*/

class countLoopsEx6AB
{
  public static void main(String[] args)
  {
    int userNum, tens, ones, hunds, userTemp;
    
    do{
    System.out.print("Enter a number (1-999): ");
    userNum = In.getInt();
    }while(userNum < 1 && userNum >1000);
    
    userTemp = userNum;
    
    ones = userNum % 5;
    userNum -= ones;
    
    hunds = userNum / 100;
    userNum = userNum - (hunds*100);
    
    tens = userNum / 10;
    userNum = userNum - (tens*10);
    
    if(userNum < 10)
      ones = userTemp;
    
    System.out.println("There are: " + hunds + " hundreds, " + tens + " tens and " + ones + " ones.");
    
  }
}