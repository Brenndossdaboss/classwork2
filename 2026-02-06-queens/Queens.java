public class Queens{
  /**
   *@return true when the queen added correctly, false Otherwise
   *@precondition r and c are valid indices of the board array
   *@postcondition the board is only changed when the function returns true
   * in which case the queen is added and all it's threatened positions are incremented.
   * Only the squares below the current row should be marked as threatened.
   */
   private static boolean addQueen(int r, int c, int[][]board){
     if (r > 0){
       for (int i = r; i < int[][]board.length; i++){
         
       }
     }
   }

   /**Remove the queen that was added to r,c
   *@precondition r and c are valid indices of the board array and there is a queen at position r,c
   *@postcondition the board is modified to remove that queen and all it's
   *threatened positions are decremented
   */
   private static void removeQueen(int r, int c, int[][]board){

   }

   private static void modifyBoard(int r, int c, int[][]board, int change){

   }
}
