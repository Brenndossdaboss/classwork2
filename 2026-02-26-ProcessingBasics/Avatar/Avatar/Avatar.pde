//draw a face/creature/person/whatever at location x,y
void avatar(int x, int y){
  //place 2d Primatives relative to x and y.
  //
  //change colors and try out different processing commands.
  for (int i = 0; i < 30; i++){
    circle(x - 2*i, y - 4*i, i*2);
    circle(x + 2*i, y - 4*i, i*2);
   
   

  }
  
  circle(x, y, 60);
  circle(x-20, y, 10);
  circle(x+20, y, 10);
  arc(x, y+10, 40, 20, 0, PI); 

}

//setup will draw two of your avatars.
void setup(){
         size(800,800);
         background(255);
         avatar(400,400);
         //avatar(600,600);
}
