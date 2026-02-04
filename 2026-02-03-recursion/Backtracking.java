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
      


/* 
   public static boolean groupSum(int start, int[] nums, int target) {


   }
*/

  public static void main (String[] args){
    System.out.println(countNoDoubleLetterWords(2, "", "abc"));
    System.out.println(countNoDoubleLetterWords(3, "", "abcdefghijklmnopqrstuvwxyz"));


  }
}