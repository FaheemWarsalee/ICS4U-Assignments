class Rectangle//Step #1
{
  //Declaring private data fields
  private int left, bottom, rectWidth, rectHeight, right, top, startX, startY;
  private float r, g, b, r2, g2, b2;


  /*sets all fields to 0 if no parameters are sent
   *pre: none
   *post: none
   */
  Rectangle()
  {
    left = 0;
    bottom = 0;
    rectWidth = 0;
    rectHeight = 0;

    top = 0;
    right = 0;
  }

  /*sets fields to the indicated number in the parameters sent
   *pre: none
   *post: none
   */
  Rectangle(int left, int bottom, int rectWidth, int rectHeight, int startX, int startY)//Step #3
  {
    this.set(left, bottom, rectWidth, rectHeight, startX, startY);
  }

  /*sets lengths to 0 if negative and the parameter if postive also sets left bottom coordinate.
   *pre: none
   *post: none
   */
  public void set(int left, int bottom, int rectWidth, int rectHeight, int startX, int startY)//Step #4
  {
    //Sets class left and bottom to parameter left and bottom
    this.left = left;
    this.bottom = bottom;

    if (rectWidth < 0)
    {
      this.rectWidth = 0;//sets calss rectWidth to 0 when the parameter rectWidth is negative
      System.out.println("Entered rectWidth was negative; rectWidth was automatically set to 0");
    } else if (rectHeight < 0)
    {
      this.rectHeight =0;//sets class rectHeight to 0 when the parameter rectHeight is negative
      System.out.println("Entered rectHeight was negative; rectHeight was automatically set to 0");
    } else
    {
      this.rectWidth = rectWidth;//Sets calss rectWidth and rectHeight to parameter rectWidth and rectHeight (lengths are > 0)
      this.rectHeight = rectHeight;
    }

    this.right = this.left + this.rectWidth;
    this.top = this.bottom + this.rectHeight;
    this.startX = startX;
    this.startY = startY;

    r = random(0, 255);
    g = random(0, 255);
    b = random(0, 255);

    r2 = random(0, 255);
    g2 = random(0, 255);
    b2 = random(0, 255);
  }

  /*displays rectangle.
   *pre: lengths are greater than 0
   *post: none
   */
  void display()
  {
    //sets attributes of rectangles to display them
    stroke(r2, g2, b2);
    strokeWeight(5);
    fill(r, g, b);
    rect(startX, startY, rectWidth, rectHeight);//The rectangle made when called upon.
  }

  /*sets moves the rectangle that calls upon it to the final position
   *pre: none
   *post: none
   */
  void move()
  {
    if (startY > bottom)//moves y down when starting position is above the final
      startY--;//moves one pixel every frame closer to the final positon
    else if (startY < bottom)//moves y up if starting position is below the final
      startY++;

    if (startX > left)//moves x left is starting is greater than the ending pos
      startX--;
    else if (startX < left)//moves x right if starting is less than the ending pos
      startX++;
  }

  /*determines if the rectangles are in their final place to create the intersecting rectangle
   *pre: lengths are > 0
   *post: whether or not rectangles are in their final position
   */
  boolean placeIntersect()
  {
    return this.startX == this.left && this.startY == this.bottom;
  }

  /*makes the intersectign rectangle change colours
   *pre: none
   *post: none
   */
  void effect()
  {
    fill(r, g, b); //Multi-Colour Fill
    stroke(r2, g2, b2);
    if (frameCount%5 == 0) {//Every five frames it changes colours (the stroke and fill of the intersecting rectangle)
      r = random(0, 255);
      g = random(0, 255);
      b = random(0, 255);
      r2 = random(0, 255);
      g2 = random(0, 255);
      b2 = random(0, 255);
    }
  }
}
