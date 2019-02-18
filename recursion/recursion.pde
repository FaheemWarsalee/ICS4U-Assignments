/*recursion assignment - step 6 Fractals
 Faheem WARSALEE
 ICS4U
 11/25/2018
 A recursion function that draws an expanding arc with an expanding arc angle
 */

//Variables
float diam = 0;
float angle = 0;

/*setup
pre: none
post: none*/
void setup()
{
  size(1600, 1200);//Canvas size
}
/*Draw
pre: none
post: none*/
void draw()
{
  background(0);//BG colour (black)

  noFill();//removes coloiur from arc
  fractal(diam, angle);//fractal recursion
}


/*fractal - recursion
pre: none
post: keeps drawing arcs until a full circle arc is made.*/
void fractal(float diam, float angle)
{
  float x = width/2;
  float y = height/2;
  stroke(random(255),random(255),random(255));
  arc(x, y, diam, diam, 0, angle, PIE);//draws an arc
  if (x > width || angle > TWO_PI || diam > 3000)//Terminating condition diameter is greater than 3000 or the angle of the arc is 2Pi (circle)
    arc(x, y, diam, diam, 0, angle, PIE);//draw the original arc if terminating condition met
  else
  {
    fractal(diam+10, angle+PI/100); //Otherwise add PI/100 to the angle and 10pixels to the diameter
  }
}

//End of program
//Pi day was too hard 
