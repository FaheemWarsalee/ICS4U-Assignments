/**
 * Author: Mr. Linseman
 * Date: Arpil 6, 2018
 * File Name: Froggerv2.java
 * Description: This is the main game filw which
 * will define the Frogger game area and draw objects to screen
 **/
int grid = 50; //Sets the pixel size for a step
PImage img, carImg, car2Img, car3Img, grass, sand, logImg, road;
Frog frog; //Declaration of a Frog object
Car cars[]; //Declaration of a car object
Log logs[];

void setup() {
  size(800, 600); //Size of the canvas (window size)
  int index = 0; //To keep track of row of cars
  cars = new Car[12]; //12 cars for first 3 rows
  logs = new Log[8]; //3 logs
  img = loadImage("frogIMG.png"); 
  carImg = loadImage("carIMG.png");
  car2Img = loadImage("car2IMG.png");
  car3Img = loadImage("car3IMG.png");
  grass = loadImage("grass.png");
  sand = loadImage("sand.png");
  logImg = loadImage("logImg.png");
  road = loadImage("raod.png");
  resetGame();




  //1st Row of Cars - 3 Red Cars going right
  for (int i = 0; i<4; i++) {
    int x = i *200 + 150;
    cars[index] = new Car(x, height-grid*2, grid*2, grid, 2, carImg);
    index++;
  }

  //2nd Row of Cars - 3 White Cars going right
  for (int i = 0; i<4; i++) {
    int x = i *200 + 100;
    cars[index] = new Car(x, height-grid*3, grid, grid, -3, car2Img);
    index++;
  }

  //3rd Row of Cars - 3 Yellow Buses going slowly right
  for (int i = 0; i<4; i++) {
    int x = i *300 + 250;
    cars[index] = new Car(x, height-grid*4, grid*3, grid, 1, car3Img);
    index++;
  }
  index = 0;
  
  //6th Row of Logs - 3 Logs moving to the right
  for (int i = 0; i<4; i++) {
    int x = i *300 + 250;
    logs[index] = new Log(x, height-grid*7, grid*3, grid, 2, logImg);
    index++;
  }

  //7th Row of Logs - 3 Logs moving to the right
  for (int i = 0; i<4; i++) {
    int x = i *300 + 250;
    logs[index] = new Log(x, height-grid*8, grid*3, grid, -2, logImg);
    index++;
  }
}

void resetGame() {

  frog = new Frog(width/2-grid/2, height-grid, 50, img);
  background(255, 0, 0);
}

void draw () {
  background(66, 155, 244);
  image(grass, 0, height-grid*5, width, grid);
  image(sand, 0, height-grid*6, width, grid);
  for (int i = 0; i<= 4; i ++) {
    image(road, 0, height-grid*i, width, grid);
  }

  //for (int i = 0; i<6; i++) {
  //  cars[i].update(); //Moves car across screen
  //  cars[i].show();

  //}

  for (Car car : cars) {
    car.show();
    car.update();
    if (frog.intersects(car)) {

      resetGame();
    }
  }
  
  for (Log log : logs) {
    log.show();
    log.update();
  }


  if (frog.y < height-grid*6) {
    boolean safe = false;
    for (Log log : logs) {
      if (frog.intersects(log))
        safe = true;
        frog.attach(log);;    }
    if (!safe)
      resetGame();
  }

 frog.update();
 frog.show(); //Call to the instance method inside the frog class
}

void keyPressed() {
  if (key == 'w') {
    frog.move(0, -1);
  } else if (key == 's') {
    frog.move(0, 1);
  } else if (key == 'd') {
    frog.move(1, 0);
  } else if (key == 'a') {
    frog.move(-1, 0);
  }
}
