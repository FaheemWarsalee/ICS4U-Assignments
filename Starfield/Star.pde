class Star
{
  float x, y;
  float z, pz;//used to modify the stars position

  Star()
  { 
    x = random(-width/2, width/2);
    y = random(-height/2, height/2);

    z = random(width/2);
    pz = z;
  }

  void show()
  {
    fill(255); //white fill colour
    noStroke(); //removes outline of circle

    float sx = map(x/z, 0, 1, 0, width/2);
    float sy = map(y/z, 0, 1, 0, height/2);

    float r = map(z, 0, width/2, 0, 30);

    ellipse(sx, sy, r, r);
  }

  void update()
  {
    z -= speed;

    if (z < 1)
    {
      z = width/2;
      x = random(-width/2, width/2);
      y = random(-height/2, height/2);
      pz = z;
    }
  }
}
