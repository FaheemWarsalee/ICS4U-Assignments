class Car extends Rectangle {
  PImage carImg; 
  int speed;
  Car(int x,int y,int w,int h, int speed, PImage carImg) {
    super(x, y, w, h);
    this.speed = speed;
    this.carImg = carImg;
  }

void update(){
  x+=speed; //Moves car to the right
  if(speed > 0 && x>width){ //If car goes off screen on right side
    x=-w;
  }else if(speed <0 && x<-w) {
    x = width;
  }
  
}

  void show() {
    image(carImg, x, y, w, h);
  }
}
