/*
Program: Circle - Object
Programmer: Faheem Warsalee
Course: ICS4U
Date: 11/13/2018

Brief Description: Circle object for puck assignment*/

class Circle
{
  //Fields
  private double r;
  
  /*Contructor
   * pre: none
   * post: Circle objet has been created with a radius of 1 (default)
   */
  Circle()
  {
    r = 1;
  }
  
  /*Contructor
   * pre: none
   * post: Circle objet has been created with a radius using constructor
   */
  Circle(double r)
  {
    this.r = r;
  }
  
  /*determines area of circle
   * pre: none
   * post: returns the area of a circle object.
   */public double area()
  {
    return Math.PI*(r*r);
  }
  
   /*Mutator for radius
   * pre: none
   * post: sets the radius of a circle to a new radius
   */
  public void setRadius(double newR)
  {
    this.r =  newR;
  }
  
  /*Accessor for radius
   * pre: none
   * post: returns the radius of the calling circle object
   */
  public double getRadius()
  {
    return r;
  }
  
   /*determines if 2 circles are eqaul
   * pre: object o has parts of a circle;
   * post: returns true if circles are equal and false otherwise
   */
  public boolean eqauls(Object o)
  {
    Circle testObj = (Circle) o;
    
    if( testObj.getRadius() == r)
      return true;
    else
      return false;
  }
  
   /*Returns a string representing the data of a circle
   * pre: none
   * post: returns the info a circle object.
   */
  public String toString()
  {
    return "The circle has a radius of " + r;
  }
  
}