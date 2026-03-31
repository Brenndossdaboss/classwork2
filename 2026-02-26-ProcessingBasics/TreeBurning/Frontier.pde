import java.util.*;

public class Frontier{

  private Deque<int[]> frontier;
  private int size;

  public Frontier(){
    size = 0;
    frontier = new ArrayDeque<>();
  }

  public int size(){
    return size;
  }

  public void add(int[] location){
    frontier.addLast(location);
    size++;
  }

  public int[] remove(){
    size--;
    return frontier.removeFirst();
  }


}
