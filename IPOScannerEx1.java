/*
 Program:IPOScannerEx1
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/13/2018
 
 Brief Description: Write a program that prompts the user for their name, age, and address, and then outputs this information using one or two nicely formatted sentences.
 */

import java.io.*;

class IPOScannerEx1
{
  public static void main(String[] args)
  {
    InputStreamReader inStream = new InputStreamReader(System.in);
    BufferedReader bufRead = new BufferedReader(inStream);
    
    String name = "";
    int age = -1;
    String adress = "";
    
    try
    {
      System.out.print("Enter your name: ");
      name = bufRead.readLine();
      
      do
      {
        try
        {
          System.out.print("Enter your age: ");
          String sAge = bufRead.readLine();
          
          age = Integer.parseInt(sAge);
        }
        
        catch(NumberFormatException err)
        {
          System.out.println("Could not parse data. Invalid inputs. Try again.");
        }
      }while (age < 0 );
      
      System.out.print("Enter your adress: ");
      adress = bufRead.readLine();
      
      inStream.close();
      bufRead.close();
    }
    catch(IOException err)
    {
      
      System.out.println("Could not read data stream.");
    }
    
    
    
    System.out.println(name + " is " + age + " years old and lives on " + adress);
  }
}