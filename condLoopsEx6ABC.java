/*
 Program: condLoopsEx6ABC
 Programmer: Faheem Warsalee
 Course: ICS4U
 Date: 9/8/2018
 
 Brief Description: (a) Write a program to simulate a person running the 100m dash. Unfortunately, your runner isn't very consistent with their speed, and for each second of the race, they may cover from 5 to 15 metres. 
 Report their current position each second, and the race ends when they cross the finish line.
 (b) Add three additional runners (total four runners), each with their own speed which changes each second. End the race until one runner wins.
 (c) Modify the program to keep running the race until ALL runners are finished. Once a runner crosses the finish line, they should stop running. If two runners cross the line in the same second, the further runner wins.*/

class condLoopsEx6ABC
{
  public static void main(String[] args)
  {
    int[] distRun ={0,0,0,0};
    
    try{
      do{
        
        for(int i = 0; i < 4; i++)
          distRun[i] = updateDist(distRun[i]);
        
        for(int i =0; i <4; i++){
          System.out.println("Runner " + (i+1) + ": " + distRun[i]);
          Thread.sleep(1000);
        }
      }while(noWinners(distRun));
    }
    catch(Exception ex)
    {
      System.out.println("ERROR");
    }

  }
  public static int updateDist(int currDist)
  {
    int speed = 0;
    speed = (int) (11*Math.random()) +5;
    currDist += speed;
    
    return currDist;
  }
  
  public static boolean noWinners(int[] distRun)
  {
    for(int i = 0; i <4 ; i++)
    {
      if(distRun[i] > 100)
        return false;
    }
    return true;
    
  }
}