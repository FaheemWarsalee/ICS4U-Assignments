/*
 Program: FileAcessEx2
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/18/2018
 
 Brief Description: Write a program or modify #1 above to output 5 random integer values between 1 and 10 to "file02.txt".  Verify your results.
 
 (a) Modify the program to read the 5 values from the file.  Output the values to the screen. (Turing Solution)
 (b) Let the user pick the number of values read from the file.  Output the values.
 (c) Increase the number of values to 100.  You may wish to use an array of integers for your variables.
 */

import java.io.*;
import java.util.Scanner;

class fileAccessEx2
{
  public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in);
    
    String[] sNums = new String[5];
    int[] nums = new int[5];
    
    for(int i = 0; i < 5; i ++)
    {
      do
      {
        System.out.print("Enter a number between 1-100: ");
        sNums[i] = userInput.nextLine();
        
        nums[i] = parseData(sNums[i]);
      }while(nums[i] < 1 || nums[i] > 100);
    }
    userInput.close();
    
    try
    {
      FileWriter fw = new FileWriter("file02.txt");
      PrintWriter pw = new PrintWriter(fw);
      
      for(int i : nums)
      {
        pw.println(i);
      }
      pw.close();
      
      FileReader fRead = new FileReader("file02.txt");
      BufferedReader bRead = new BufferedReader(fRead);
      String line;
      
      line = bRead.readLine();
      while(line != null)
      {
        System.out.println(line);
        line = bRead.readLine();
      }
      bRead.close();
    }
    catch(IOException e)
    {
      System.out.println("Error 202: IOException.");
    }
  }
  
  public static int parseData(String stringInp)
  {
    int parsedNum =0;
    try
    {
      parsedNum = Integer.parseInt(stringInp);
    }
    catch(NumberFormatException e)
    {
      System.out.println("Error 101: could not convert Strings to Ints.");
    }
    return parsedNum;
  }
}