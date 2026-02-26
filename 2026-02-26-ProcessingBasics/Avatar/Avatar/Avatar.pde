//draw a face/creature/person/whatever at location x,y
void avatar(int x, int y){
  //place 2d Primatives relative to x and y.
  //
  //change colors and try out different processing commands.
  for (int i = 0; i < 50; i++){
    circle(x + 2*i, y + 4*i, i*3);
    circle(x - 2*i, y - 4*i, i*3);
    circle(x + 2*i, y - 4*i, i*3);
    circle(x - 2*i, y + 4*i, i*3);
   
   

  }
  
  circle(x, y, 60);
}

//setup will draw two of your avatars.
void setup(){
         size(800,800);
         background(255);
         avatar(400,400);
         //avatar(600,600);
}
