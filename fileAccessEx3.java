/*
 Program: FileAcessEx3
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/18/2018
 
 Brief Description: Write a program that will input information (name, address, age) for 3 people from a data file called "file03.txt".  
 You should use a text editor to create the file in advance.  Output the data on the screen.  Format your output so all of the information for a single person is on one
 line (i.e., name, address, age).  For example, the contents of the data file might look like:
 Bob
 123 Some Road
 16
 Doug
 456 Other Place
 17
 Mackenzie
 789 Elsewhere Avenue
 15
 Extensions:
 (a)  Start by asking the user for name, address, and age information for 3 people.  Save that information to a file first.
 (b)  Let the user edit information after it has been loaded from the file.  Give the option to save the new data to the file (overwriting the old data).  Verify your program is working by inspecting the file in a text editor. (Turing Solution)
 */
import java.io.*;
import java.util.Scanner;

class fileAccessEx3
{
  public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in);
    String[] names = new String[3];
    String[] adresses = new String[3];
    String[] sAge = new String[3];
    int[] age = new int[3];
    
    try
    {
      FileWriter fw = new FileWriter("file03.txt");
      PrintWriter pw = new PrintWriter(fw);
      
        for(int i = 0; i < 3; i++)
      {
        System.out.print("User " + (i+1) + ", enter your name.");
        names[i] = userInput.nextLine();
        pw.println(names[i]);
        
        System.out.print(names[i] + " Enter your adress: ");
        adresses[i] = userInput.nextLine();
        pw.println(adresses[i]);
        
        do
        {
          System.out.print(names[i] + " Enter your age: ");
          sAge[i] = userInput.nextLine();
          
          age[i] = parseData(sAge[i]);
        }while (age[i] <= 0 );
        pw.println(age[i]);
        
        System.out.println("");
      }
      userInput.close();
      pw.close();
      
      FileReader fRead = new FileReader("file03.txt");
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
      System.out.println("Error 202: Error reading/writing file");
    }
    
  }
  
  public static int parseData(String stringInput)
  {
    int ageInt;
    try
    {
      ageInt = Integer.parseInt(stringInput);
      return ageInt;
    }
    catch(NumberFormatException e)
    {
      System.out.println("Error 101: Could not parse data.");
    }
    return 0;
  }
}