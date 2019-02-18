/*
 Program: recursion
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 11/20/2018
 
 Brief Description: Recursive functions assignment*/
import java.util.Scanner;
class recursion
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    long userChoice;
    
    try{
      //asks user for which problem they want to try
      do
      {
        System.out.println("Which recursion would you like to test: ");
        System.out.println("1) \t '1'\n2a) \t '2'\n2b) \t '3'\n3a) \t '4'\n3b) \t '5'\n3c) \t '6'\n4) \t '7'\n5) \t '8'");
        userChoice = Long.parseLong(sc.nextLine());//parse input from string to longs
        
        if(userChoice < 1 || userChoice > 8)//inputs are erronious
          System.out.println("inputs must be integers from 1-8");
        
      }while(userChoice < 1 || userChoice > 8);
      
      //All recursion problems 
      if(userChoice == 1)//Step 1
      {
        System.out.print("Enter a number to be factorialed: ");
        userChoice = Long.parseLong(sc.nextLine());
        
        System.out.println("1. " + factorial(userChoice));
      }
      else if(userChoice == 2)//Step 2a
      {
        System.out.print("Enter a number to receive the first n terms of sequence 2a): ");
        userChoice = Long.parseLong(sc.nextLine());
        
        System.out.println("Terms of the sequence: ");
        for(long i = 1; i <= userChoice; i++)//prints all terms of the recusrion up to the user inpute
        {
          System.out.print(tnRecursionA(i));//prints each term of n
          
          if(i < userChoice)
            System.out.print(", ");//adds commas after every term except the last one
          else
            System.out.println("");
        }
      }
      else if(userChoice == 3)//Step 2b
      {
        System.out.print("Enter a number to receive the first n terms of sequence 2b): ");
        userChoice = Long.parseLong(sc.nextLine());
        
        System.out.println("Terms of the sequence: ");
        for(long i = 1; i <= userChoice; i++)
        {
          System.out.print(tnRecursionB(i));
          
          if(i < userChoice)
            System.out.print(", ");//adds commas after every term except the last one
          else
            System.out.println("");
        }
      }
      else if(userChoice == 4)//Step 3a
      {
        System.out.print("Enter a number for sequence 3a): ");
        userChoice = Long.parseLong(sc.nextLine());
        
        System.out.println("value of term in fibonnaci sequence: " + fibonacci(userChoice));
      }
      else if(userChoice == 5)//Step 3b
      {
        System.out.println("Enter a number for sequence 3b): ");
        userChoice = Long.parseLong(sc.nextLine());
        
        System.out.println("3b) " + step3b(userChoice));
      }
      else if(userChoice == 6)//Step 3c
      {
        System.out.print("Enter a number for sequence 3c): ");
        userChoice = Long.parseLong(sc.nextLine());
        
        System.out.println("3c) " + step3c(userChoice));
      }
      else if(userChoice == 7)//Step 4
      {
        System.out.print("Enter the term # for fractorials: ");
        userChoice = Long.parseLong(sc.nextLine());
        
        System.out.println("Fractorial of the term: " + fractorial(userChoice));
      }
      else if(userChoice == 8)//Step 5
      {
        long ppl, pcs;
        
        do{
          System.out.print("How many pieces of pie are there: ");
          pcs = Long.parseLong(sc.nextLine());
          
          System.out.print("How many people will eat pie: ");
          ppl = Long.parseLong(sc.nextLine());
          
          if(pcs < 1 || pcs >250 || ppl < 1 || ppl > pcs)
            System.out.println("invalid Parameters : pieces >= 1 and pieces < 250 and pieces > people");
          
        }while(pcs < 1 || pcs >250 || ppl < 1 || ppl > pcs);
        
        long max = pcs/ppl;
        long counter = 0;
        System.out.println("Number of possible pie distribution: " + piDay(pcs,ppl,max,counter));
      }
    }
    catch(NumberFormatException e)
    {
      System.out.println("Input must be an integer between 1-8");
    }
    catch(StackOverflowError e)
    {
      System.out.println("Number too big");
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    
    sc.close();
  }
  
  /*factorial method - step 1
   * pre: none
   * post: returns the product of the first n integers
   */
  public static long factorial(long n)
  {
    if(n < 0)
      throw new RuntimeException("Invalid parameters");
    else if(n == 0)
      return 1;
    else
      return n*factorial(n-1);
  }
  
  /*recursion tn - step 2a
   * pre: none
   * post: returns the value of the first n  terms of the sequence
   */
  public static long tnRecursionA(long n)
  {
    if(n <= 0)
      throw new RuntimeException("Invalid parameters");
    else if(n == 1)
    {
      return 3l;
    }
    else
    {
      return tnRecursionA(n-1)-factorial(n);
    }
  }
  
  /*recursion rn - step 2b
   * pre: none
   * post: returns the first n terms of the sequence
   */
  public static long tnRecursionB(long n)
  {
    if( n <=0)
      throw new RuntimeException("Invalid parameters");
    else if(n == 1)
      return -4l;
    else if(n == 2)
      return -7l;
    else
      return 2*tnRecursionB(n-1) + 3*tnRecursionB(n-2);
  }
  
  /*fibonacci sequence - step 3a
   * pre: none
   * post: returns the nth value of the fibonacci sequence
   */
  public static long fibonacci(long n)
  {
    if(n <= 0)
      throw new RuntimeException("Invalid parameters");
    else if(n ==1 || n ==2)
      return 1;
    else 
      return fibonacci(n-1) + fibonacci(n-2);
  }
  
  /*1,4,8,13,19,26.... sequence - step 3b
   * pre: none
   * post: returns the nth value of the sequence
   */
  public static long step3b(long n )//change name of method and determine the sequence.
  {
    if( n <= 0)
      throw new RuntimeException("Invalid parameters");
    else if(n ==1)
      return 1;
    else 
      return step3b(n-1)+(n+1);
  }
  
  /*1,2,2,4,8,11,33,37,148.... sequecne - step3c
   * pre: none
   * post: returns the value of the nth term of the sequecne
   */
  public static long step3c(long n)
  {
    if(n <= 0)
      throw new RuntimeException("Invalid parameters");
    else if(n==1)
      return 1;
    else 
    {
      if(n%2 == 0)
        return step3c(n-1) + (n/2);
      else
        return step3c(n-1) * ((n-1)/2);
    }
  }
  
  /*GCD method - step 4
   * pre: none
   * post: returns the gcd of 2 numbers 
   */
  public static long gcd(long m, long n)
  {
    if(n == 0)
      return m;
    return(gcd(n,m%n));
  }
  
  /* Fractorial - step 4
   * pre: none
   * post: returns the lowest number that can be divided into 1 - the given number (n)
   */ 
  public static long fractorial(long n)
  {
    if(n <= 0)
      throw new RuntimeException("Invalid parameters");
    else if(n == 1)
      return 1;
    else 
      return (fractorial(n-1)*n)/gcd(n,fractorial(n-1));
  }
  
  /* Pi day - step 5
   * pre: ppl > 0, pcs > 0 && pcs <=250
   * post:returns all the # of ways pieces of pi can be given out.
   */ 
  public static long piDay(long pcs, long ppl,long max,long counter)
  {
   if(ppl ==1)
    {
      //System.out.println("people = " + ppl); //test hecking when #of ppl is 1
      return 1;
    }
    else if(pcs ==ppl)
      return 1;
    else
    {
      for(long i = 1; i <= max; i++)
      {
        //System.out.println("  i= " + i +  " ppl = " + (ppl-1)  + " pcs = " + (pcs-i) + " counter = " + counter ); //where is all data 
        counter += piDay((pcs-i),(ppl-1),i,counter);
        //System.out.println("Counter = " +counter); //current counter
      }
      return counter;
    }
  }
}

//End of program
//Pi day was too hard