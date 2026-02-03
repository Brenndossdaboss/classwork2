public class FibTester{

/*
   *@param n any non-negative value
   *@return the nth term of the fibonacci sequence.
   *fibIter(0,1,0)->0, fibIter(1,1,0)->1, fibIter(2,1,0)->1, etc.
   */

   public static int fibIter(int n, int f1, int f2){
     //DO NOT call fibIter more than once
        if (n == 0){
            return f2;
        }

        return fibIter(n -1, f1, f2);
    }
}