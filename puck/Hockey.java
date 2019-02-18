/*
Program: Hockey - Client Code
Programmer: Faheem Warsalee
Course: ICS4U
Date: 11/13/2018

Brief Description: Client code for puck assignment*/

class Hockey
{
  public static void main(String[] args)
  {
    Puck p = new Puck(4.3,2,1);
    Puck q = new Puck(5.5);
    Puck r = new Puck();
    
    System.out.println(p);//Print before set division & test toStirng
    System.out.println(q);
    System.out.println(r);
    
    p.setDivision(5.3);//Test set division
    q.setDivision(1);
    r.setDivision(4.2);
    
    System.out.println("\n" + p.getWeight());//Test getWeight;
    
    System.out.println("\n" + p.equals(q));//tests equals
    
    System.out.println("\n"+p);//print after setDivison and test toString
    System.out.println(q);
    System.out.println(r);
    
  }
}