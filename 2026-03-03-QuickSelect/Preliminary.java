import java.util.*;

public class Preliminary {

  /**Modify the array as per the partition algorithm discussed in class
  *@param data is the array to partition
  *@param lo is the leftmost index of the array (inclusive)
  *@param hi is the rightmost index of the array (inclusive)
  *@return the index of the final position of the pivot element.
  *preconditions:
  * lo <= hi
  * array.length > 0
  * lo and hi are valid indices of the array
  *postconditions:
  * the values left of the index returned are <= p
  * the values right of the index returned are >= p
  * half of the values that equal p end up left of p, and half end up right of p
  * the values at indices < lo are not changed
  * the values at indices > hi are not changed
  */
  public static int partition(int[] data, int lo, int hi) {
    Random r = new Random();

    int pivotIndex = r.nextInt(lo + 1, hi);
    int pivot = data[pivotIndex];
    swap(data, pivotIndex, lo);

    int left = lo + 1;
    int right = hi;

    boolean equalGoesLeft = true;

    while (left <= right) {
      if (data[left] < pivot) {
        left++;
      } else if (data[right] > pivot) {
        right--;
      } else if (data[left] == pivot && data[right] == pivot) {
        swap(data, left, right);
        left++;
        right--;
      } else if (data[left] > pivot || (data[left] == pivot && !equalGoesLeft)) {
        swap(data, left, right);
        right--;
        if (data[left] == pivot) equalGoesLeft = !equalGoesLeft;
      } else {
        swap(data, left, right);
        left++;
        if (data[right] == pivot) equalGoesLeft = !equalGoesLeft;
      }
    }
   swap(data, lo, right);
   System.out.println("pivot: " + pivot);
   System.out.println("data: " + Arrays.toString(data));
  return right;
  }

  private static void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

  public static void main (String[] args){
    int[] ary1 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] ary2 = new int[]{990, 991, 992, 993, 994, 8, 7, 6, 5, 4, 3, 2, 1, 0, 995, 996, 997};
    int[] ary3 = new int[]{4, 4, 4, 4, 4, 1, 4, 4, 4};
    System.out.println("index: " + partition(ary1, 0, ary1.length - 1));
    System.out.println("index: " + partition(ary2, 0, ary2.length - 1));
    System.out.println("index: " + partition(ary3, 0, ary3.length - 1));


  }
}
