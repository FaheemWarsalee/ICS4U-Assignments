/*
 Program: SelExC4
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/6/2018
 
 Brief Description: Write a program that makes change for amounts less than one dollar.  Input to the program should be a positive
 integer less than 100, representing an amount of money, in cents.  Output should be the original amount of money together with a set of 
 coins (quarters, dimes, nickels, pennies) that could make up that amount.
 Improvements:
 The program should produce change containing the minimum number of coins required.
 The output should be expressed in a natural form.  For example, don't refer to zero coins of a particular type, or the singular or plural forms for coins should be used correctly (i.e., "1 dime", not "1 dimes").*/

class SelExC4
{
  public static void main(String[] args)
  {
    //Variables
    int userEntry, quart, dimes, nick, pen, origEntry;
    
    //Input
    do
    {
      System.out.print("Enter a number of cents less than or equal TO 100: ");
      userEntry = In.getInt();
    }while (userEntry < 0 || userEntry >= 100);
    
    origEntry = userEntry;
    
    //Calculating #of each coin
    pen = userEntry % 5;
    userEntry -= pen;
    
    quart = userEntry / 25;
    userEntry = userEntry - (quart*25);
    
    dimes = userEntry / 10;
    userEntry = userEntry - (dimes*10);
    
    nick = userEntry/5;
    userEntry = userEntry - (nick*5);
    
    if(quart > 0 || dimes > 0 || nick > 0 || pen > 0)
    {
      if(quart == 1 && dimes >1 && nick > 1 && pen > 1)
        System.out.println(origEntry + " cents is also equal to " + quart + " quarter, " + dimes + " dimes, " + nick + " nickles, " +  pen + "  pennies.");
      if(quart > 1 && dimes == 1 && nick > 1 && pen > 1)
        System.out.println(origEntry + " cents is also equal to " + quart + " quarters, " + dimes + " dime, " + nick + " nickles, " +  pen + "  pennies.");
       if(quart > 1 && dimes >1 && nick == 1 && pen > 1)
        System.out.println(origEntry + " cents is also equal to " + quart + " quarters, " + dimes + " dimes, " + nick + " nickle, " +  pen + "  pennies.");
       if(quart > 1 && dimes >1 && nick > 1 && pen == 1)
        System.out.println(origEntry + " cents is also equal to " + quart + " quarters, " + dimes + " dimes, " + nick + " nickles, " +  pen + "  penny.");
      if(quart == 1 && dimes == 1 && nick == 1 && pen == 1)
        System.out.println(origEntry + " cents is also equal to " + quart + " quarter, " + dimes + " dime, " + nick + " nickle, " +  pen + " penny.");
    }
    System.out.println(origEntry + " cents is also equal to " + quart + " quarters, " + dimes + " dimes, " + nick + " nickles, " +  pen + "  pennies.");
  }
}
/*
 *       
 * 
 */