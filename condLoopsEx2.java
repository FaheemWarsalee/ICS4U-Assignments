/*
 Program: condLoopsEx2
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/8/2018
 
 Brief Description: (a) Write a program that asks the user to enter an integer value.  Count how many numbers the user enters.  End the program when the user enters zero.  Do not count zero.  Tell the user the result.
 (b) In addition to counting how many numbers were entered, also keep track of how many above zero and below zero.  Still end the program on zero, and then tell the user the result.
 (c) Instead of always using zero, ask the user what number they want to use as the terminating value.*/

class condLoopsEx2
{
  public static void main(String[] args)
  {
    int userNum; 
    int count = 0;
    int count1 = 0;
    
    do {
      System.out.print("Enter an integer number: ");
      userNum = In.getInt();
      
      if (userNum !=0)
      {
        if (userNum >= 1)
          count += 1;
        else
          count1 += 1;
      }
    }while(userNum != 0);
    
    System.out.println(count + " is how many POSITIVE numbers you entered");
    System.out.println(count1 + " is how many NEGATIVE numbers you entered");
    
  }
}