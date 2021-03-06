/*
 Program: FileAcessEx1
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/18/2018
 
 Brief Description: Write a program that creates/opens a file called "file01.txt" and outputs a single string (sentence) to the file.  
 Once your program is completed, check the file to confirm the contents.  Make sure to open your file for output.
 
 (a) Modify your program.  After writing to the file, open the same file for input.  Read the sentence into a single string variable and output the string to the screen.
 (b)  Let the user input the sentence to be output to the file.*/

import java.io.*;
import java.util.Scanner;

class fileAccessEx1
{
  public static void main(String[] args)
  {
    try
    {
      Scanner userInput = new Scanner(System.in);
      String userString;
      
      System.out.print("Enter a Sentence: ");
      userString = userInput.nextLine();
      
      FileWriter fw = new FileWriter("file01.txt");
      PrintWriter pw = new PrintWriter(fw); 
      pw.println(userString);
      pw.close();
      
      
      FileReader fr = new FileReader("file01.txt");
      BufferedReader bRead = new BufferedReader(fr);
      String line;
      
      line = bRead.readLine();
      
      while(line != null)
      {
        System.out.println(line);
        line = bRead.readLine();
      }
      
      bRead.close();
      userInput.close();
    }
    catch(IOException e)
    {
      System.out.println("Error 101: Ooppsie doopsie.");
    }
    
  }
}