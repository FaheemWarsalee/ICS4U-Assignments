import java.io.*;

class scannerTest
{
  public static void main(String[] args)
  {
    InputStreamReader inStream = new InputStreamReader(System.in);  
    BufferedReader bufRead = new BufferedReader(inStream);
    
    int userNum =0;
    int random;
    
    random  = (int)(10*Math.random()) + 1;
    
    try
    {
      System.out.println("What is 10*" + random);
      String userSNum = bufRead.readLine();
      
      userNum  = Integer.parseInt(userSNum);
     }
    catch (IOException err)
    {
      System.out.println("Error: Couldn't ReadLine");
    }
    catch(NumberFormatException err)
    {
      System.out.println("Couldn't parse data. Invalid Input.");
    }
    System.out.println(random*10 + " is the answer you answered: " + userNum) ;
  }
}