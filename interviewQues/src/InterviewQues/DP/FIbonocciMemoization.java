package InterviewQues.DP;

public class FIbonocciMemoization {
    static int[] lookup= new int[100];
    public static int fib(int n){
        if(lookup[n] == 0){
            if(n <=1)
                lookup[n] = n;
            else
                lookup[n] = fib(n-2)+fib(n-1);
        }
        return lookup[n];
    }
    public static void main(String... args){
        System.out.println(fib(40));
    }
}
