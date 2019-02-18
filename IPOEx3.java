/*
Program: IPO Exercise 3/4
Programmer: Faheem Warsalee
Course: ICS4U
Date: 9/5/2018

Brief Description: Write a program that asks the user to input marks for 4 courses, and the displays the average mark. 
                                 Warning: Use brackets for order of operations!*/

class IPOEx3
{
  public static void main(String[] args)
  {
    double a, b, c , d;
    double avg;
    
    System.out.print("Enter a course mark: ");
    a = In.getDouble();
    
    System.out.print("Enter a course mark: ");
    b = In.getDouble();
    
    System.out.print("Enter a course mark: ");
    c = In.getDouble();
    
    System.out.print("Enter a course mark: ");
    d = In.getDouble();
    
    avg = ((a+b+c+d)/4);
    avg =  (double )Math.round(avg*100)/100;
    
    System.out.println("Your average is: " + avg);
  }
}