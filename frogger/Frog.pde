class Frog extends Rectangle{
  PImage img;
  Log attached = null;
  
  Frog(int x, int y, int w, PImage img){
    super(x,y,w,w); //This utilizes the Rectangle class and associates
    // this template for the current Frog object
    this.img = img;
  }
  
  void show(){
    image(img,x,y,w,w);
  }
  
  void attach(Log log)
  {
    attached = log;
  }
  
  void update()
  {
   if(attached != null)
     frog.x += attached.speed;
  }
  
  
  //This changes the pixel l frog
  void move(int xdir, int ydir){
    x+=xdir*grid;
    y+=ydir*grid;
    if(x>(width-grid)){
      x=width-grid;
    }
    if(y>(height-grid)){
      y=height-grid;
    }
    if(x<0){
      x=0;
    }
    if(y<0){
      y=0;
    }
  }
  
  
}
