/*
Program: IPO Exercise 8
Programmer: Faheem Warsalee
Course: ICS4U
Date: 9/5/2018

Brief Description: Write a program that will ask the user for the radius of a circle.  The program will then calculate the 
                                 circumference and area of the circle and output the results clearly. 
                                 Use a variable for words marked in bold.*/

class IPOEx8
{
  public static void main(String[] args)
  {
    int rad;
    double circ, area;
    
    System.out.println("Enter a radius: ");
    rad = In.getInt();
    
    circ = 2*Math.PI*rad;
    area = Math.PI*(Math.pow(rad,2));
    
    System.out.println("Circumference = " + (double)Math.round(circ*100)/100 + "\nArea = " + (double)Math.round(area*100)/100);
  }
}