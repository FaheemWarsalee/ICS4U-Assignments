/*
Program: IPO Exercise 6
Programmer: Faheem Warsalee
Course: ICS4U
Date: 9/5/2018

Brief Description: Ask 5 simple math problems. After the user enters their answer, display the problem and the correct answer. 
                                 The correct answer should be calculated by your program.  
                                  Extend: Research random numbers for a way to make your program much more interesting.*/

class IPOEx6
{
  public static void main(String[] args)
  {
    for(int i = 1; i <= 5; i++)
    {
    question();
    }
  }
  
  public static void question()
  {
    int n1, n2;
    int ans, userAns;
    
    n1 = (int) (100*Math.random()) + 1;
    n2 = (int) (100*Math.random()) + 1;
    
    ans = n1 + n2;
    System.out.print("what is " + n1 + " + " + n2);
    userAns = In.getInt();
    
    if (ans == userAns)
    {
      System.out.println("You good.");
    }
    else
    {
      System.out.println("You wrong.");
    }
  }
}