import java.io.*;

class fileMakingTest
{
 public static void main(String[] args)
 {
   try
   {
   FileReader fw = new FileReader("test.txt");
   }
   catch(IOException err)
   {
     System.out.println("error");
   }
 }
}