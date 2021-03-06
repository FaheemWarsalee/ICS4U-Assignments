/*
Program: Disk - Object
Programmer: Faheem Warsalee
Course: ICS4U
Date: 11/13/2018

Brief Description: Disk calss for puck assigment (extend circle)*/

class Disk extends Circle
{
  private double thicc;
  
  
  /*Contructor
   * pre: none
   * post: returns a disk object that has defaulted to radius 1 and thicc 1
   */
  Disk()
  {
    super();
    this.thicc = 1;
  }
  
  /*Contructor
   * pre: none
   * post: disck object has been constructed and fields are set using constructor
   */
  Disk(double r, double thicc)
  {
    super(r);
    this.thicc = thicc;
  }
  
  /*changes thickness of disk
   * pre: none
   * post: thickness has been changed
   */ 
  public void setThickness(double newThicc)
  {
    this.thicc = newThicc;
  }
  
 /*
* Returns the thickness of the disk.
* pre: none
* post: The thickness of the disk has been returned.
*/
  public double getThickness()
  {
    return thicc;
  }
  
  /**
* Returns the volume of the disk.
* pre: none
* post: The volume of the disk has been returned.
*/
  public double volume()
  {
    return super.area() * thicc;
  }
  
  /*does one disk equal another disk object
   * pre: d is a disk object
   * post: true is returned if the radii and thickness of both Disk's are the same otherwise false is returned
   */
  public boolean equals(Object o)
  {
    Disk testObj = (Disk) o;
    
    if(testObj.getRadius() == super.getRadius() && testObj.getThickness() == thicc)
      return true;
    else
      return false;
  }
  
  /*Returns a string representing a disk 
   * pre: none
   * post : a string representing the disk has been returned
   */ 
  public String toString()
  {
    return "The disk has a radius of " + super.getRadius() + " and thickness " + thicc;
  }
}