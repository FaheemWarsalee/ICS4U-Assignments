/*
Program: Puck - Object
Programmer: Faheem Warsalee
Course: ICS4U
Date: 11/13/2018

Brief Description: Puck class for puck assigment (extends disk)*/

class Puck extends Disk
{
  private double weight;
  private boolean standard, youth = false;
  
  /*Contructor 1
   * pre: none
   * post: Puck obejct has been created usinf default fields
   */
  Puck()
  {
    super(1.5,1); //uses constructor for Disk object for radius and thickness
    this.weight = 1;
    this.setDivision(this.weight);
  }
  
  /*Contructor 2
   * pre: none
   * post: puck object has been created using a defined weight but default everything else 
   */
  Puck(double weight)
  {
    super(1.5,1);
    this.weight = weight;
    this.setDivision(this.weight);
  }
  
  /*Contructor
   * pre: none
   * post: Puck object has been created using 3 parameters. (nothing is default)
   */
  Puck(double weight, double r, double thicc)
  {
    super(r,thicc);
    this.weight = weight;
    this.setDivision(this.weight);
  }
  
  /*Aceesor for weight
   * pre: none
   * post: returns the weight of a puck object
   */
  public double getWeight()
  {
    return weight;
  }
  
  /*instance method for division
   * pre: none
   * post: determines divisoin based off of weght of puck
   */
  public void setDivision(double weight)
  {
    this.weight = weight;
    
    if(this.weight >= 4 && this.weight <=4.5)
    {
      youth = true;
      standard = false;
    }
    else if(this.weight >= 5 && this.weight <= 5.5)
    {
      youth = false;
      standard = true;
    }
    else 
    {
      youth = false;
      standard = false;
    }
  }
  
  /*Acessor for division
   * pre: none
   * post: returns the division of the puck
   */
  public String getDivision()
  {
    if(youth)
      return "puck is youth division.";
    else if(standard)
      return "puck is standard division.";
    else
      return "puck is a non-regulation puck.";
  }
  
  /*determines if 2 pucks are the same
   * pre: o is an object that has puck fields
   * post: returns true if 2 pucks are the same and false if they are different
   */
  public boolean equals(Object o)
  {
    Puck testObj = (Puck) o;
    
    return (testObj.getRadius() == super.getRadius() && testObj.getThickness() == super.getThickness() && testObj.getWeight() == weight && testObj.getDivision() == this.getDivision());
  }
  
  /*returns a string representing a pucks fields
   * pre: none
   * post: returns the fields of a puck 
   */
  public String toString()
  {
    return "The puck has a radius of " + super.getRadius() + "in, a thickness of " + super.getThickness() + "in, a weight of " + this.weight + "oz and " + this.getDivision();
  }
}