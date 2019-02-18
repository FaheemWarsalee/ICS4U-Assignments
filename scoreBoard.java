/*
 Program: Game Scoreboard Assignment
 Programmer: Faheem Warsalee
 Course: ICS3U
 Date: 9/20/2018
 
 Brief Description:This program will emulate a scoreboard using random numbers anda text file to keep all previous scores, updating the text file whenever new scores reach the top 100*/

//import utilities
import java.util.Scanner;
import java.io.*;

class scoreBoard
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
      
      bRead.close();//close bufferedReader
    }
    catch(IOException err)
    {
      System.out.println("Creating game file...");
      defaultBoard();//Display and create empty board when there is no game file created
    }
    
    //Delay to slow down dr.java display so text can be read.
    try 
    {
      System.out.println("Game file 'gameData.txt' has been created.\n");
      Thread.sleep(1500);
    } catch (InterruptedException err)
    {
      System.out.println("Error producing a delay.");
    }
    displayBoard();//Display the board
    
    try
    {
      //Declaring JVM's, Arrays, Variables
      Scanner userInput = new Scanner(System.in);
      FileReader fRead = new FileReader("gameData.txt");
      BufferedReader bRead = new BufferedReader(fRead);
      String[] titles = new String[5];
      String[] names = new String[100];
      int[] scores = new int[100];
      String line;
      int randScore;
      String currName;
      boolean isNameValid = false;
      boolean isPlaced  = false;
      int tempScore1 = 0, tempScore2 = 0;
      String tempName1 = "", tempName2 = "";
      
      //Places titles in an array
      for(int i = 0; i < titles.length; i ++)
      {
        line = bRead.readLine();//Skips titles
        titles[i] = line;
      }
      
      //Places names and scores into their own arrays
      for(int i = 0; i < scores.length; i ++)
      {
        line = trimWord(bRead.readLine());//trims the array to start at the *.
        names[i] = line.substring(0,line.indexOf('\t'));//cuts string from * to but not including the proceeding tab
        scores[i] = Integer.parseInt(trimWord(line));//Trims the last part of the string to leave the score.
      }
      
      randScore = (int)(999999999*Math.random()) + 1;//Generates a random score.
      
      //Check if score makes the board.
      for(int i = 0; i < scores.length; i ++)
      {
        if(randScore > scores[i] && (!isPlaced))//Score has made the scoreBoard
        {
          isPlaced = true;
          System.out.println("\nYou made the scoreboard with a score of: " + randScore);
          do
          {
            System.out.print("Enter your name (3-initial max): ");//get user initials
            currName = userInput.nextLine();
            currName = currName.toUpperCase();
            
             if(currName.length() == 0)
            {
              isNameValid = true;
              currName = "***";
              System.out.println("Name has defaulted to '***'");
            }
            else if(currName.length()==3 && currName.charAt(0) >= 'A' && currName.charAt(0) <= 'Z' && currName.charAt(1) >= 'A' && currName.charAt(1) <= 'Z' && currName.charAt(2) >= 'A' && currName.charAt(2) <= 'Z')//Check if user has 3 letters
              isNameValid = true;//initials are 3 in length and are from a-z
            else if(currName.length() == 2 && currName.charAt(0) >= 'A' && currName.charAt(0) <= 'Z' && currName.charAt(1) >= 'A' && currName.charAt(1) <= 'Z')//Check if initials are 2 letters
              isNameValid = true;//initials are 2 in length and are from a-z
            else if(currName.length() == 1 && currName.charAt(0) >= 'A' && currName.charAt(0) <= 'Z')//Check if initials are 1 letter
              isNameValid = true;//initials are one in length 
             else
            {
              isNameValid = false;
              System.out.println("Error. Name must be a max of 3 in length and contain letters from A-Z");
            }
          }while(!isNameValid);//Loop so long as name is invalid and length is greater than 3
          
          //used to print the updated scores to the board
          FileWriter fw = new FileWriter("gameData.txt");
          PrintWriter pw = new PrintWriter(fw);
          
          //Sets score and name that made the scoreboard
          tempScore1 = randScore;
          tempName1 = currName;
          
          for(int j = i; j < scores.length; j++)
          {
            //sets name and score to be replaced into a temp
            tempScore2 = scores[j];
            tempName2 = names[j];
            
            //puts new score and name in the correct place
            scores[j] = tempScore1;
            names[j] = tempName1;
            
            //Sets the removed score and name up to the temp name and score to be checked again.
            tempName1 = tempName2;
            tempScore1 = tempScore2;
          }
          
          //Prints titles to scoreboard
          for(int l= 0; l < titles.length; l ++)
          {
            pw.println(titles[l]);
          }
          
          //prints all of updated scores.
          for(int l = 0; l< scores.length; l++)
          {
            int sufx = (l+1) %  10;//Determines what suffix is needed 22%10 = 2; 2 ends in nd therefore nd is the suffix
            
            if((l+1) == 11 || (l+1) == 12|| (l+1) ==13)//Exceptions to numbers ending in 1,2 or 3 having suffix st,nd,rd
              pw.println((l+1) +"th\t\t\t" + names[l] + "\t\t\t" + scores[l]);//Suffix = th in case of exceptions above^^
            else if (sufx == 1)
              pw.println((l+1) + "st\t\t\t" + names[l] + "\t\t\t" + scores[l]);//Suffix = st
            else if (sufx == 2)
              pw.println((l+1) + "nd\t\t\t" + names[l] + "\t\t\t" + scores[l]);//Suffix = nd
            else if (sufx == 3)
              pw.println((l+1) + "rd\t\t\t" + names[l] + "\t\t\t" + scores[l]);//Suffix = rd
            else
              pw.println((l+1) + "th\t\t\t" + names[l] + "\t\t\t" + scores[l]);//Suffix = th
          }
          pw.close();//Close print writer
        }
      }
      userInput.close();//Close Scanner
      bRead.close();//Close buffered Reader.
    }
    catch(IOException e)
    {
      System.out.println("Error reading/writing from file.");//If the file cannot be read from or written to.
    }
    
    printTopTen();
  }
  
  //~~~~PRINT DEFAULT BOARD TO FILE~~~~
  public static void defaultBoard()
  {
    try
    {
      //Declaring JVM's, Variables, Arrays
      Scanner userInput = new Scanner(System.in);
      FileWriter fw = new FileWriter("gameData.txt");
      PrintWriter pw = new PrintWriter(fw);
      String[] names = new String[100];
      int[] scores = new int[100];
      String gameName;
      int sufx;
      
      //Asks for name of the game
      System.out.println("File 'gameData.txt' has been created.");
      System.out.print("Enter the name of the game: ");
      gameName = userInput.nextLine();
      userInput.close();//close scanner
      
      //Print titles to file 
      pw.println("\t\t\t" + gameName.toUpperCase());//Print Game name to file
      pw.println("");
      pw.println( "\t\t\tHIGHSCORES");//Print HIGHSCORE title to file
      pw.println("");
      pw.println("RANK" + "\t\t\tNAMES" + "\t\t\tSCORE");//print subtitles 
      
      //Print empty scores and names to file
      for(int i = 0; i < names.length; i++)
      {
        sufx = (i+1) % 10;//Determines if a st, nd, rd or th is needed as a suffix.
        
        names[i] = "---";// Set each name to *** by default
        scores[i] = 0;//Set all scores to 0
        
        //Print Ranks w/ Suffixes to file
        if((i+1) == 11 || (i+1) == 12|| (i+1) ==13)//Exceptions to numbers ending in 1,2 or 3 having suffix st,nd,rd
          pw.println((i+1) +"th\t\t\t" + names[i] + "\t\t\t" + scores[i]);//Suffix = th for above exception^^
        else if (sufx == 1)
          pw.println((i+1) + "st\t\t\t" + names[i] + "\t\t\t" + scores[i]);//Suffix = st #%10 = 1
        else if (sufx == 2)
          pw.println((i+1) + "nd\t\t\t" + names[i] + "\t\t\t" + scores[i]);//Suffix = nd #%10 = 2
        else if (sufx == 3)
          pw.println((i+1) + "rd\t\t\t" + names[i] + "\t\t\t" + scores[i]);//Suffix = rd #%10 = 3
        else
          pw.println((i+1) + "th\t\t\t" + names[i] + "\t\t\t" + scores[i]);//Suffix = th #%10 = anything else
      }
      pw.close();//close printwriter
    }
    catch(IOException err)
    {
      System.out.println("Error 1: Could not write to file 'gameData.txt'");//Cannot write to file error message
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
      
      //Read lines from file and output lines from file
      readFile = bRead.readLine();
      System.out.println(readFile);
      while(readFile != null)
      {
        readFile = bRead.readLine();
        if(readFile != null)
          System.out.println(readFile);
      }
      bRead.close();// close buffer
    }
    catch(IOException err)
    {
      System.out.println("Error 2: Could not read from file.");//Eror message if reading file fails
    }
  }
  
  //~~~~PRINT TOP 10 SCORES~~~~
  public static void printTopTen()
  {
    try
    {
      FileReader fRead = new FileReader("gameData.txt");
      BufferedReader bRead = new BufferedReader(fRead);
      String line;
      
      try 
      {
        System.out.println("\n\t\t\t~~~~TOP 10 SCORES~~~~\n");
        Thread.sleep(1000);
      } catch (InterruptedException err)
      {
        System.out.println("Error producing a delay.");
      }
      
      for(int i = 0; i < 16; i++)
      {
        line = bRead.readLine();
        System.out.println(line);
      }
      bRead.close();
    }
    catch(IOException err)
    {
      System.out.println("Error reading from file");
    }
  }
  
  //~~~~ TRIMS STRINGS ~~~~
  public static String trimWord(String s)
  {
    return s.substring(s.indexOf('\t')).trim();//Trims the scoreboard from 1st\t\t\t***\t\t\t0000 to ***\t\t\t000000
  }
}
//END OF PROGRAM