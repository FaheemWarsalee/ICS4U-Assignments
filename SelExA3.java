/*
Program: SelExA3
Programmer: Faheem Warsalee
Course: ICS4U
Date: 9/6/2018

Brief Description: Ask the user to answer 3 math problems and either tell them they are right (IF), or show them the correct answer (ELSE). 
Make this program more interesting by using random numbers.*/

class SelExA3
{
  public static void main(String[] args)
  {
    problems();
  }
  
  public static void problems()
  {
    int x = 0;
    System.out.println("What is 10/2 equal to?" );
    if(userAns(x) == 5)
    {
      System.out.println("You are right");
    }
    else
    {
      System.out.println("you are wrong");
    }
    
    System.out.println("What is 5*5 equal to?" );
    if(userAns(x) == 25)
    {
      System.out.println("You are right");
    }
    else
    {
      System.out.println("you are wrong");
    }
    
    System.out.println("What is 100*100 equal to?" );
    if(userAns(x) == 100000)
    {
      System.out.println("You are right");
    }
    else
    {
      System.out.println("you are wrong");
    }
  }
  
  public static int userAns(int ans)
  {
    ans = In.getInt();
    
    return ans;
  }
}