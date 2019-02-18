class piDayTest
{
  public static void main(String[] args)
  {
    int pcs = 8;
    int ppl = 4;
    int max = pcs/ppl;
    int counter = 0;
    
    System.out.println(countWays(pcs,ppl, max,counter));
  }
  
  public static int countWays(int pcs, int ppl,int max, int counter) 
  {
      if(pcs <= 0|| ppl <= 0 || pcs >250)
        return 0;
      else if(pcs == ppl)
        return 1;
      else 
      {
        for(int j =1; j <= max; j++)
        {
        counter++;
        countWays(pcs-j, ppl-1,max-1,counter);
        }
      }
    return counter;
  } 
}
