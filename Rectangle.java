//imports
import java.util.Scanner;

class Rectangle//Step #1
{
  //rectangle fields
  private int left, bottom, width, height,right, top; 
  
  /*constructor sets all fields to 0.
   *pre: none
   *post: none
   */
  Rectangle()//Step #2
  {
    //defaults fields to 0
    left = 0;
    bottom = 0;
    width = 0;
    height = 0;
    
    top = 0;
    right = 0;
  }
  
  /*constructor sets all field to the sent parameters
   *pre: none
   *post: none
   */
  Rectangle(int left, int bottom ,int width, int height)//Step #3
  {
    this.set(left,bottom,width,height);
  }
  
  /*gets user inputs for the rectangles
   *pre: the parameter is always 1 or 2 because it identifies the which rectangle is being made (rectangle 1 info or rectangle 2 info)
   *post: none
   */
  public void set(int whichRect)
  {
    Scanner sc = new Scanner(System.in);
    
    //Inputs
    //Get left X-Coordinate
    System.out.print("Enter the left x-coordinate of rectangle " + whichRect + ": ");
    String leftString = sc.nextLine();
    try
    {
      this.left = Integer.parseInt(leftString);//Parse String to int
    }
    catch(NumberFormatException e)
    {
      System.out.println("could not parse string to int. left defaulted to 0");
    }
    
    //Get BottomY-Coordinate
    System.out.print("Enter bottom y-coordinate of rectangle " + whichRect + ": ");
    String bottomString = sc.nextLine();
    try
    {
      this.bottom= Integer.parseInt(bottomString);//Parse String to int
    }
    catch(NumberFormatException e)
    {
      System.out.println("could not parse string to int. bottom defaulted to 0");
    }
    
    //Get Rectangle width
    System.out.print("Enter width of the rectangle " + whichRect + ": ");
    String widthString = sc.nextLine();
    try
    {
      this.width= Integer.parseInt(widthString);//Parse String to int
    }
    catch(NumberFormatException e)
    {
      System.out.println("could not parse string to int. width defaulted to 0");
    }
    
    //Get Rectangle Height
    System.out.print("Enter height of the rectangle" + whichRect + ": ");
    String heightString = sc.nextLine();
    try
    {
      this.height= Integer.parseInt(heightString);//Parse String to int
    }
    catch(NumberFormatException e)
    {
      System.out.println("could not parse string to int. height defaulted to 0");
    }
    sc.close();
    
    this.set(this.left, this.bottom, this.width, this.height);
  }
  
  /*sets lengths to 0 if negative and the parameter if postive also sets left bottom coordinate.
   *pre: none
   *post: none
   */
  public void set(int left, int bottom, int width, int height)//Step #4
  {
    //Sets class left and bottom to parameter left and bottom
    this.left = left;
    this.bottom = bottom;
    
    if(width < 0)
    {
      this.width = 0;//sets calss width to 0 when the parameter width is negative
      System.out.println("Entered width was negative; width was automatically set to 0");
    }
    else if(height < 0)
    {
      this.height =0;//sets class height to 0 when the parameter height is negative
      System.out.println("Entered height was negative; height was automatically set to 0");
    }
    else
    {
      this.width = width;//Sets calss width and height to parameter width and height (lengths are > 0)
      this.height = height;
    }
    
    this.right = this.left + this.width;
    this.top = this.bottom + this.height;
  }
  
  /*overides .println() to output objects directly
   *pre: none 
   *post: formats output of the 4 private fields
   */
  public String toString()//Step  #5
  {
    return "base: (" + left + "," +bottom + ") w :" + width + " h: " + height;
  }
  
  /*calaculates area of a rectangle
   *pre: lengths are positive
   *post: area of the rectangle that calls on the method is return
   */
  public int area()//Step #6
  {
    return this.width*this.height;
  }
  
  /*
   *pre: lengths are positive
   *post: returns a perimeter of the rectangle that calls on the method
   */
  public int perimeter()//Step #7
  {
    if(width == 0 || height == 0)
      return width+height;
    else
      return this.width*2+this.height*2;
  }
  
  /*determines where/if 2 rectangles intersect to create a new rectangle
   *pre: lengths are > 0
   *post: returns rectangle that is formed when 2 rectangles intersect
   */
  public static Rectangle intersection(Rectangle r, Rectangle s)//Step #8
  {
    Rectangle t = new Rectangle ();
    
    if(r.contains(s))//If s is inside r
    {
      t = s;//intersecting rectangle is the rectangle inside
    }
    else if(s.contains(r))//if r is inside s
    {
      t = r;//intersecting rectangle is the rectangle inside
    }
    else if(!notIntersects(r,s))
    {
      t.left = Math.max(r.left,s.left);
      t.bottom = Math.max(r.bottom,s.bottom);
      t.width = Math.min(r.right,s.right) -t.left;
      t.height = Math.min(r.top,s.top) - t.bottom;
      
      t.top = t.bottom + t.height;
      t.right = t.left + t.width;
    }
    return t;//returns new rectangle
  }
  
  /* calculates total perimeter of the shape made fro m2 intersecting rectangles
   *pre: lengths > 0 
   *post: returns the total perimeter of the shape of 2 rectangles intersecting
   */
  public static int totalPerimeter (Rectangle r, Rectangle s)//step #9
  {
    int totalPerim =0;
    
    if(notIntersects(r,s))
      return  r.perimeter() + s.perimeter();
    else if(intersection(r,s).width == 0 || intersection(r,s).height == 0)
      return (r.perimeter() + s.perimeter()) - intersection(r,s).perimeter()*2;
    else if(r.contains(s))
      return r.perimeter();
    else if(s.contains(r))
      return s.perimeter();
    else if(!notIntersects(r,s))
      return  (r.perimeter()  + s.perimeter()) - intersection(r,s).perimeter();
    
    return totalPerim;
  }
  
  /*checks to see if a rectangle is contained inside the calling rectangle.
   *pre: none
   *post: wether or not rectangles are inside one another
   */
  public boolean contains(Rectangle s)
  {
    return s.left > this.left && s.right < this.right && s.top < this.top && s.bottom > this.bottom;
  }
  
  /*checks to see if the rectangles do not intersect
   *pre: none
   *post: returns whetehr or not the rectangles DONT intersect
   */
  public static boolean notIntersects(Rectangle r, Rectangle s)
  {
    return r.left > s.right || r.right < s.left || r.top < s.bottom || r.bottom > s.top;
  }
  
  /*getter method gets the left private variale
   *pre: none
   *post: the left value of the calling object
   */
  public int getLeft()
  {
    return this.left;
  }
  
  /*gets the bottom variable that is pricate
   *pre: none
   *post: returns the value of the calling objets botto m variable
   */
  public int getBottom()
  {
    return this.bottom;
  }
  
  /*allows acces to the private field width
   *pre: lengths > 0
   *post: width variable of the calling object
   */
  public int getWidth()
  {
    return this.width;
  }
  
  /*allows access to the private field height
   *pre: length > 0
   *post: the contents of the private field height.
   */
  public int getHeight()
  {
    return this.height;
  }
}