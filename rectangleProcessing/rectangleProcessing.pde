//imports
import java.io.*;

//Declaring data fields
Rectangle r, s, t;

int[] rect1 = new int[4];
int[] rect2 = new int[4];
int[] rect3 = new int[4];
String intersect;

/*stes up a canvas, reads from file and creates rectangles according to the file
 *pre: none
 *post: none
 */
void setup()
{
  size(1200, 1000);
  //creeating rectangle objects
  r = new Rectangle();
  s = new Rectangle();
  t = new Rectangle();

  //reading from file and extracting info from file
  try
  {
    BufferedReader br = createReader("rectangleClass.txt");
    String readFile;

    readFile = br.readLine();//gets rid of the title Rectangle Class: line from the text file.
    while (readFile != null)//Read until there is nothing left in the file ie:null
    {
      if (readFile.contains("Intersection"))
      {
        String line = trimLine(trimLine(readFile)); 
        rect3[0] = Integer.parseInt(line.substring(line.indexOf('(')+1, line.indexOf(",")));//gets the first number in the ordered pair 
        rect3[1] = Integer.parseInt(line.substring(line.indexOf(',')+1, line.indexOf(")")));//gets the secondn number in the ordered pair
        line = trimLine(line);//trims the file agaim
        rect3[2] = Integer.parseInt(line.substring(0, line.indexOf(' ')));//gets the width of the intersecting rectangle 
        line = trimLine(line);
        rect3[3] = Integer.parseInt(line);//gets the height of the intersecting ectanlge.
      } else if (readFile.contains("A")) // Reading for the first rectangle
      { 
        String[] lines = readFile.split("\t"); // Splitting the two sections of info using the tab
        if (readFile.contains("X")) //reads from line containing x and y coordinates of rectangles
        {
          rect1[0] = Integer.parseInt(trimLine(lines[0]));//sets x and y of rect 1 from file into an array for rectangles 1 info
          rect1[1] = Integer.parseInt(trimLine(lines[1]));
        } else if (readFile.contains("Width")) //reads from line that has width and height
        {
          rect1[2] = Integer.parseInt(trimLine(lines[0]));//width and height of rectangle info from file is set into an array for rect 1
          rect1[3] = Integer.parseInt(trimLine(lines[1]));
        }
        readFile = trimLine(readFile).split("\t")[0];//splits info seperated from the tabs
      } else if (readFile.contains("B")) // Reading for the second rectangle
      { 
        String[] lines = readFile.split("\t"); // Splitting the two sections of info
        if (readFile.contains("X")) //Sets x and y from the file to an array
        {
          rect2[0] = (Integer.parseInt(trimLine(lines[0])));
          rect2[1] = (Integer.parseInt(trimLine(lines[1])));
        } else if (readFile.contains("Width")) //sets width and height from the file into the array
        {
          rect2[2] = (Integer.parseInt(trimLine(lines[0])));
          rect2[3] = (Integer.parseInt(trimLine(lines[1])));
        }
      }
      readFile = br.readLine();
    }
    br.close();
  }
  catch(FileNotFoundException e)//Catching execeptions
  {
    System.out.println("Could not find file : 'rectangleClass.txt'");//File doesnt exist in working directoryy
  }
  catch(IOException e)
  {
    System.out.println("Unable to read file. ");//file cannot be read
  }
  catch(Exception e)
  {
    System.out.println("An error occured while trying to read the file.");//all other excpetions that lead to errors
  }

  //Setting rectangles to retrieved data from file.
  r.set(rect1[0], rect1[1], rect1[2], rect1[3], (-1*rect1[2]), (int)random(0, 1000));
  s.set(rect2[0], rect2[1], rect2[2], rect2[3], width, (int)random(0, 1000));
  t.set(rect3[0], rect3[1], rect3[2], rect3[3], rect3[0], rect3[1]);
}

/*Draws the rectangles on the canvas and animates them
 *pre: none
 *post: none
 */
void draw()
{
  background(255, 255, 255);
  r.display();
  s.display();
  r.move();
  s.move();

  if (r.placeIntersect() && s.placeIntersect())
  {
    t.display();
    t.effect();//only when the rectangles fullt intersect and the new rectangle is made does it change colours
  }
}

/*trims the string from the line to get rid of the titles:
 *pre: line is a string from the text file
 *post: strings from the text file without the titles and the ':'
 */
String trimLine(String line)
{
  return line.substring(line.indexOf(':')+1).trim();
}
