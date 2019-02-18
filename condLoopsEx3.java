/*
 Program: condLoopsEx3
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/8/2018
 
 Brief Description: (a) Write a program that acts like a cash register. The user can keep entering values, and you will add those values together, reporting the new total each time. 
 You will need some way to end your program. One good way to end your program would be to tell the user to enter a particular value when they are done 
 (for example, -1 should not be a valid price). This is called the "sentinel" value.
 (b) Modify your program so you also keep track of the total tax (in Ontario, that is 13%).
 (c) Nicely format your input and output, including two decimal places for all dollar amounts.*/

class condLoopsEx3
{
  public static void main(String[] args)
  {
    double userNum; 
    double sum = 0.00;
    
    do
    {
      do
      {
        System.out.print("Enter a price (Enter 0 to quit): ");
        userNum = In.getDouble();
      }while(userNum < 0);
      
      sum += userNum;
    }while(userNum !=0);
    
    System.out.println((double) Math.round((sum*1.13)*100)/100 + " is the total including tax.");
    
  }
}