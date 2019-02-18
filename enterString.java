import java.util.Scanner;
class enterString
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    String line;
    int castAscii;
    
    line = input.nextLine();
    castAscii = (int)(line.charAt(0));
    System.out.println("Enter = " + castAscii);
    input.close();
  }
}