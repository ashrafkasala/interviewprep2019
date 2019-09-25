package InterviewQues.DP;

public class FibonocciTabulation {
    static int[] table= new int[100];
    public static int fib(int n){
       table[0] = 0 ;
       table[1] = 1;
       for(int i=2;i<=n;i++) {
           table[i] = table[i-2]+table[i-1];
       }
       return table[n];
    }
    public static void main(String... args){
        System.out.println(fib(40));
    }
}
