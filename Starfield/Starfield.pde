//Faheem's code adapted from from 
//Danial Shiffman
//10/29/2018

//Global Fields
float speed; //used to control the speed of all the stars
Star[] stars = new Star[300];

void setup()
{
 size(1600,1600);
 
 //fill stars array(create all objects)
 for(int i =0; i < stars.length ; i++)
 {
   stars[i] = new Star();  
 }
}

void draw()
{
  //link the value of the speed to the mouse position
  speed = map(mouseX,0,width,0,100);
  
  background(0);
  translate(width/2,height/2);//Adjust all starts to start appearing from the middle of the screen
  
  for(int i = 0; i < stars.length; i ++)
  {
   stars[i].update();
   stars[i].show();
  }
}
