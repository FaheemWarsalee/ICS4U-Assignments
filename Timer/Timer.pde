void setup()
{
  size(400, 400);
}

void draw() {

  for (int min = 1; min >= 0; min--)
  {
    for (int sec = 59; sec >= 0; sec--)
    {
      textSize(20);
      text(sec, width/2, height/2);
    }
  }
}

   //for (int min = 1; min >= 0; min--)
   //   {
   //     for (int sec = 59; sec >= 0; sec--)
   //     {
   //       try
   //       {
   //         if (sec >= 10)
   //         {
   //           fill(0);
   //           text(min + ":" + sec, 0, 0);
   //         } else
   //         {
   //           fill(0);
   //           text(min + ":0" + sec, 0,0);
   //         }
   //         Thread.sleep(1000);
   //         if (min==0 && sec==0)
   //           gameOver();
   //       }
   //       catch(Exception e) {
   //       }
   //     }
   //   }
