public class mergesort{

  /**Merge two sorted arrays into one sorted array
  *@param left is a sorted array
  *@param right is a sorted array
  *@return a sorted array that contains all of the elements of both left and right combined.
  */
  public static int[] merge(int [] left, int[] right){
    int[] total = new int[left.length + right.length];
    int leftC = 0;
    int rightC = 0;

    for (int i = 0; i < total.length; i++){
      if(left.length == leftC){
        total[i] = right[rightC];
        rightC++;
      }
      else if (right.length == rightC){
        total[i] = left[leftC];
        leftC++;

      }
      else if (left[leftC] > right[rightC]){
        total[i] = right[rightC];
        rightC++;
      }
      else{
        total[i] = left[leftC];
        leftC++;
      }
    }
    return total;
  }

}
