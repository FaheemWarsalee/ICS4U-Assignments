import java.io.*;
class FileParseInputDemo
{
 public static void main(String[] args)
 {
 try
 {
 FileReader fr = new FileReader("file");
 BufferedReader br = new BufferedReader(fr);
 String line;

 line = br.readLine(); // read first line
 String name = line; // store name

 line = br.readLine();
 int age = Integer.parseInt(line); // store age

 line = br.readLine();
 double bankBal = Double.parseDouble(line); // store balance

 br.close();
 }
 catch(IOException e){
 System.out.println("Error Reading from File");
 }
 catch(NumberFormatException err) {
 System.out.println("Error Converting Number");
 }
 }
}