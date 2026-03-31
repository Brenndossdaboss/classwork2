import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static final int TREE = -2;
  private static final int FIRE = 10;
  private static final int OLD_FIRE = 9;
  private static final int ASH = 0;
  private static final int SPACE = -1;
  private Frontier frontier;


  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
    //placeholder for compilation purposes2
    /*
    for(int i = 0; i < map.length; i++){
        for(int j = 0; j < map[i].length; j++){
            if(map[i][j] == FIRE) return false;
        }
    }
    return true;
  */
    return frontier.size() == 0;
  }

  public void tick(){
    ticks++;
    int startSize = frontier.size();
    for (int k = 0; k < startSize; k++) {
      int[] pos = frontier.remove();  // oldest fire position [row, col]
      int i = pos[0];
      int j = pos[1];
 
      map[i][j] = ASH;
 
      if (i - 1 >= 0 && map[i-1][j] == TREE) {
        map[i-1][j] = FIRE;
        frontier.add(new int[]{i-1, j});
      }
      if (i + 1 < map.length && map[i+1][j] == TREE) {
        map[i+1][j] = FIRE;
        frontier.add(new int[]{i+1, j});
      }
      if (j - 1 >= 0 && map[i][j-1] == TREE) {
        map[i][j-1] = FIRE;
        frontier.add(new int[]{i, j-1});
      }
      if (j + 1 < map[i].length && map[i][j+1] == TREE) {
        map[i][j+1] = FIRE;
        frontier.add(new int[]{i, j+1});
      }
    }

  }

  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tickOld(){
    ticks++;
    for(int i = 0; i < map.length; i++){
        for(int j = 0; j < map[i].length; j++){
            if(map[i][j] == FIRE){
                map[i][j] = OLD_FIRE;
            }
        }
    }
    for(int i = 0; i < map.length; i++){
        for(int j = 0; j < map[i].length; j++){
            if(map[i][j] == OLD_FIRE){
                map[i][j] = ASH;
                if(i-1 >= 0 && map[i-1][j] == TREE){
                  map[i-1][j] = FIRE;
                }
                if(i+1 < map.length && map[i+1][j] == TREE){
                  map[i+1][j] = FIRE;
                }
                if(j-1 >= 0 && map[i][j-1] == TREE){
                  map[i][j-1] = FIRE;
                }
                if(j+1 < map[i].length && map[i][j+1] == TREE){
                  map[i][j+1] = FIRE;
                }
            }
        }
    }
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    frontier = new Frontier();
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }else{
           map[r][c]=SPACE;
         }
       }
     }
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        frontier.add(new int[]{i, 0});
      }
    }
  }

/*
 *Aftger the simulation is done, you can use this to determine if the fire
 *reached the right side of the map.
 */
  public boolean crossedEntireForest(){
    int lastCol = map[0].length - 1;
      for (int i = 0; i < map.length; i++) {
        if (map[i][lastCol] == ASH || map[i][lastCol] == FIRE) {
          return true;
        }
      }
    return false;
  }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }


  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


}
