/*
 Program: CountLoopsEx3e
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/5/2018
 
 Brief Description: (a) Write a program which will ask the user how many symbols to output, and then output that many lines of symbols (one symbol on
 each line). To start, use the '*' symbol. (Turing Solution)
 (b) Write a program which will ask the user how many symbols to output, and then it will output that many symbols on one line.  To start, use the '*' symbol.
 For example,  if the user enters 5, the output would be:
 *****
 (c) Output the user's number as well as the symbols, all on the same line.  For example, if the user entered a value of 10, the output would be:
 10 **********
 (d) Modify your program to allow the user to choose a symbol as well.
 Number of symbols? 7
 Symbol to use? @
 7 @@@@@@@
 (e) Allow the user the specify the total number of symbols and how many to print on each line.
 For example, if the user entered 10 symbols with 4 per line, the output might be:
 $$$$
 $$$$
 $$
 (the last line only has two symbols because we only print 10 total)*/

class countLoopsEx3E
{
  public static void main(String[] args)
  {
    int putNum, symbsLine, fullLines, modLine;
    char symb;
    
    //Inputs
    System.out.print("Enter Symbol");
    symb = In.getChar();
    
    System.out.print("Number of Symbols: ");
    putNum = In.getInt();
    
    System.out.print("How many symbols per line: ");
    symbsLine = In.getInt();
    
    //Outputs and Processing
    fullLines = putNum / symbsLine;
    modLine = putNum % symbsLine;

    for (int i = 0;i<fullLines;i++){
      for (int j = 0; j<symbsLine; j++)  
        System.out.print(symb);
      System.out.println("");
    }
    
    for (int i = 0; i < modLine ; i++)
          System.out.print(symb);
    System.out.println("");
  }
}