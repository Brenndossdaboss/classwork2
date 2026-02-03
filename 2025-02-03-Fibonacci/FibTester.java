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
        return fibIter(n -1, f1 + f2, f1);
    }

    public static int fib(int n) {
        return fibIter(n, 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(41));
    }

}