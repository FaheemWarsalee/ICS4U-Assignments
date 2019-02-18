class timer
{
  public static void main(String[] args)
  {
    for(int i = 10; i  >= 0; i --)
    {
      try
      {
        System.out.println(i);
        Thread.sleep(1000);
      }
      catch(Exception e)
      {
      }
    }
  }
}