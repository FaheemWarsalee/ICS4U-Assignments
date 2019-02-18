int value = 0;
float r, g, b;
int posX, posY;
boolean isPressed = true;
boolean isClick = false;

void setup()
{
  r = random(0, 255);
  g = random(0, 255);
  b = random(0, 255);
  size(1200, 1000);
}

void draw()
{
  background(255, 255, 255);
  fill(r, g, b);

  rect(posX, posY, value, value);
}

void mouseClicked()
{
  posX = mouseX;
  println(posX);
  posY = mouseY;
  println(posY);
  
}

void mouseDragged()
{
  if (isPressed)
    value += 5;
}

void mouseReleased() 
{
  isPressed = false;
}
