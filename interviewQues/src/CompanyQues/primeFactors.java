package CompanyQues;

public class primeFactors {
    public static void main(String... args){
        int a =  100;
        primeFactors(a);
    }
    static  void primeFactors(int a){

        while(a%2 == 0){
            System.out.println("2 ");
            a=a/2;
        }

        for (int i =3;i<=a;i=i+2) {
            while (a % i == 0) {
                System.out.println(i + " ");
                a = a / i;
            }
        }

        if(a>2){
            System.out.println(a);
        }

    }
}
