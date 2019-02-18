/*
 Program: Game Scoreboard Assignment
 Programmer: Faheem Warsalee
 Course: ICS3U
 Date: 9/20/2018
 
 Brief Description:This program will emulate a scoreboard using random numbers*/

//import utilities
import java.util.Scanner;
import java.io.*;

class scoreBoardTest
{
  //~~~~ MAIN METHOD ~~~~
  public static void main(String[] args)
  {
    try
    {
      //Declaring JVMS
      FileReader fRead = new FileReader("gameData.txt");
      BufferedReader bRead = new BufferedReader(fRead);
      
      bRead.readLine();//Check to see if a file is already created.
      
      displayBoard();//Display the board
      
      bRead.close();
    }
    catch(IOException err)
    {
      System.out.println("Creating game file...");
      
      try
      {
        //Declaring JVM's, Variables, Arrays
        Scanner userInput = new Scanner(System.in);
        FileWriter fw = new FileWriter("gameData.txt");
        PrintWriter pw = new PrintWriter(fw);
        
        String[] names = new String[100];
        int[] scores = new int[100];
        
        String gameName;
        int sufx, indInBound;
        
        System.out.println("File 'gameData.txt' has been created.");
        System.out.print("Enter the name of the game: ");
        gameName = userInput.nextLine();
        userInput.close();
        
        //Printing main Titles
        pw.println("\t\t\t" + gameName.toUpperCase());//Print Game name to file
        pw.println("");
        pw.println( "\t\t\tHIGHSCORES");//Print HIGHSCORE title to file
        pw.println("");
        pw.println("RANK" + "\t\t\tNAMES" + "\t\t\tSCORE");//print subtitles 
        
        //Printing ranks, names and scores.
        for(int i = 0; i < names.length; i++)
        {
          indInBound = i+1;//Variable to keep index not outside bounds.
          sufx = indInBound % 10;//Determines if a st, nd, rd or th is needed as a suffix.
          
          names[i] = "***";// Set each name to *** by default
          scores[i] = 0;//Set all scores to 0
          
          //Print Ranks w/ Suffixes & names and scores to file
          if(indInBound == 11 || indInBound == 12|| indInBound ==13)//Exceptions to numbers ending in 1,2 or 3 having suffix st,nd,rd
            pw.println(indInBound +"th\t\t\t" + names[i] + "\t\t\t" + scores[i]);
          else if (sufx == 1)
            pw.println(indInBound + "st\t\t\t" + names[i] + "\t\t\t" + scores[i]);
          else if (sufx == 2)
            pw.println(indInBound + "nd\t\t\t" + names[i] + "\t\t\t" + scores[i]);
          else if (sufx == 3)
            pw.println(indInBound + "rd\t\t\t" + names[i] + "\t\t\t" + scores[i]);
          else
            pw.println(indInBound + "th\t\t\t" + names[i] + "\t\t\t" + scores[i]);
        }
        pw.close();//Close Print Writer
      }
      catch(IOException e)
      {
        System.out.println("Error, could not write to file 'gameData.txt'");
      }
    }
    
  }
  
  //~~~~DISPLAY BOARD IN CONSOLE~~~~
  public static void displayBoard()
  {
    try
    {
      //Declaring JVM's, Variables, Arrays
      FileReader fRead = new FileReader("gameData.txt");
      BufferedReader bRead = new BufferedReader(fRead);
      String readFile;
      
      readFile = bRead.readLine();
      System.out.println(readFile);
      while(readFile != null)
      {
        readFile = bRead.readLine();
        if(readFile != null)
          System.out.println(readFile);
      }
      
      
      bRead.close();
    }
    catch(IOException err)
    {
      System.out.println("Error 2: Could not read from file.");
    }
  }
}