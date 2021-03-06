/*
Program: countLoopsEx4
Programmer: Faheem Warsalee
Course: ICS4U
Date: 9/6/2018
Brief Description: a) Output the numbers from 1 to 10 both numerically (i.e., �1�, �2�, etc.) and graphically (using the character of your choice). 
For example, output might look something like this:
1  *
2  **
3  ***
4  ****
Extension: 
(b) Allow the user to specify the start and end numbers of the range.
(c) Allow the user to specify the symbol to be used in building the graphical component (e.g., *, +, x, #, @)
(d) Modify your program to print the pattern horizontally instead of vertically.  For example, the output might look like:
*/

class countLoopsEx4
{
  public static void main(String[] args)
  {
    int start, end;
    char chr;
    
    System.out.print("Indicate starting #: ");
    start = In.getInt();
    
    System.out.print("Indicate ending #: ");
    end = In.getInt();
    
    System.out.print("Indicate symbol: ");
    chr = In.getChar();
    
    for (int i = start; i <= end ; i++)
    {
      System.out.print(i);
      System.out.print(" ");
      
      for(int j = 1; j <= i; j++)
      {
        System.out.print(chr);
      }
      System.out.println(" ");
    }
   }
}