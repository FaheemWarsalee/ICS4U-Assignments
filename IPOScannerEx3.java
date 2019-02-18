/*
 Program:IPOScannerEx3
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/14/2018
 
 Brief Description: Ask 5 simple math problems. After the user enters their answer, display the problem and the correct answer. The correct answer should be calculated by your program.
 */

import java.util.Scanner;

class IPOScannerEx3
{
  public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in);
    
    String[] sUserAns = new String[5];
    int[] userAns = new int[5];
    int[] ans = new int[5];
    
    System.out.print("What is 5 + 25 = ");
    sUserAns[0] = userInput.next();
    userAns[0] = Integer.parseInt(sUserAns[0]);
    ans[0] = 5 +25;
    
    if(userAns[0] == ans[0])
      System.out.println("You are correct!");
    else 
      System.out.println("You are wrong ;( The correct answer is " );
    
     System.out.print("What is 5 * 25 = ");
    sUserAns[1] = userInput.next();
    userAns[1] = Integer.parseInt(sUserAns[1]);
    ans[1] = 5*25;
    
     if(userAns[1] == ans[1])
      System.out.println("You are correct!");
    else 
      System.out.println("You are wrong ;( The correct answer is: " + ans[1] );
    
     System.out.print("What is 25-5 = ");
    sUserAns[2] = userInput.next();
    userAns[2] = Integer.parseInt(sUserAns[2]);
    ans[2] = 25-5;
    
     if(userAns[2] == ans[2])
      System.out.println("You are correct!");
    else 
      System.out.println("You are wrong ;( The answer is " + ans[2]  );
    
     System.out.print("What is 25/5 = ");
    sUserAns[3] = userInput.next();
    userAns[3] = Integer.parseInt(sUserAns[3]);
    ans[3] = 25/5;
    
     if(userAns[3] == ans[3])
      System.out.println("You are correct!");
    else 
      System.out.println("You are wrong ;( The correct answer is: " + ans[3] );
    
     System.out.print("What is (5+25)/5 = ");
    sUserAns[4] = userInput.next();
    userAns[4] = Integer.parseInt(sUserAns[4]);
    ans[4] = 30/5;
    
     if(userAns[4] == ans[4])
      System.out.println("You are correct!");
    else 
      System.out.println("You are wrong ;( The correct answer is: " + ans[4]  );
    
    userInput.close();
  }
}