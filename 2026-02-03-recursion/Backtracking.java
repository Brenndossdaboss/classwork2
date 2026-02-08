public class Backtracking{
  /*
    *@param length how long the words must be
    *param word the variable to store the partial solution (Initial call should start at "")
    *param letters will contain the unique* letters allowed in the string.
    *      (*unique: You can assume there are no duplicates)
    *@return the number of words that have no adjacent matching letters
    *        using the letters provided. This is possibly zero if there
    *        is only one unique letter provided, but that is an edge case.
    *Repetition allowed except when letters are adjacent e.g. "abababa" is allowed.
    */
  public static long countNoDoubleLetterWords(int length, String word, String letters) {

    if (word.length() == length) {
        return 1;
    }
    long total = 0;

    for (int i = 0; i < letters.length(); i++) {
      char c = letters.charAt(i);

      if (word.equals("") || word.charAt(word.length() - 1) != c) {
          total += countNoDoubleLetterWords(length, word + c, letters);
      }
    }

    return total;
  }




  public static boolean groupSum(int start, int[] nums, int target) {

    if (target == 0) {
        return true;
    }

    if (start >= nums.length) {
        return false;
    }

    if (groupSum(start + 1, nums, target - nums[start])) {
        return true;
    }

    if (groupSum(start + 1, nums, target)) {
        return true;
    }

    return false;
}

  /*
  Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the
  two groups are the same. Every int must be in one group or the other.
  Write a recursive helper method that takes whatever arguments you like, and make the initial call to your
  recursive helper from splitArray(). (No loops needed.)
  */

  public static boolean splitArray(int[] nums) {
    return helper(0, nums, 0, 0);
  }

  public static boolean helper(int start, int[] nums, int sum1, int sum2) {
    if (start >= nums.length) {
      return sum1 == sum2;
    }
    
    return helper(start + 1, nums, sum1 + nums[start], sum2) 
        || helper(start + 1, nums, sum1, sum2 + nums[start]);
  }

  public static boolean groupSum6(int start, int[] nums, int target) {
  if (start >= nums.length) {
    return target == 0;
  }
  

  if (nums[start] == 6) {
    return groupSum6(start + 1, nums, target - 6);
  }

  return groupSum6(start + 1, nums, target - nums[start]) 
      || groupSum6(start + 1, nums, target);
}

  public static boolean groupNoAdj(int start, int[] nums, int target){
    if (target == 0) {
        return true;
    }

    if (start >= nums.length) {
        return false;
    }

    if (groupSum(start + 2, nums, target - nums[start])) {
        return true;
    }

    if (groupSum(start + 1, nums, target)) {
        return true;
    }

    return false;
    
  }


  public static void main (String[] args){
    System.out.println(countNoDoubleLetterWords(2, "", "abc"));
    System.out.println(countNoDoubleLetterWords(3, "", "abcdefghijklmnopqrstuvwxyz"));
    System.out.println(splitArray(new int[]{2,2}));
    System.out.println(splitArray(new int[]{2,3}));
    System.out.println(splitArray(new int[]{5,2,3}));
    System.out.println(groupSum(0, new int[]{5,6,2}, 8));
    System.out.println(groupSum(0, new int[]{5,6,2}, 9));
    System.out.println(groupSum(0, new int[]{5,6,2}, 7));

  }
}
