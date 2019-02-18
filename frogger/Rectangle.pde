// Rectangle class made by Damien Erik Cudmore, 
// Date: April 6, 2018
// Author: Mr. Linseman
// Desciption: This class defines a rectangle type

class Rectangle
{
  int x; // X cordinate
  int y; //Y cordinate
  int w; // Width of Rectangle
  int h; //Height of Rectangle

  Rectangle () //Defines Rectangle to zero if nothing has been defined
  {
    this.x = 0;
    this.y = 0;
    this.w = 0;
    this.h = 0;
  }

  //Object with 4 defined int's is made here and if an interger is lower then 0 then it will set int as 0
  Rectangle (int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  //Instance Method That Returns true if current calling rectangle
  // intersects another rectangle
  boolean intersects(Rectangle other) {
    int left = this.x;
    int right = this.x + this.w;
    int top = this.y;
    int bottom = this.y+this.h;

    int oleft = other.x;
    int oright = other.x + other.w;
    int otop = other.y;
    int obottom = other.y+other.h;

    return !(left >= oright ||
      right <= oleft ||
      top >= obottom ||
      bottom <= otop); // Returns true when they intersect
  }
}
