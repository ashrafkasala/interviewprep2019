package CompanyQues;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SimpleClass {
    private int x= 10;
    private int y= 20;
    public SimpleClass(int x, int y){
        this(x);
        this.y = y;
    }
    public SimpleClass(int x){
        this.x=x;
    }

    public static void main(String[] args) {
        SimpleClass s = new SimpleClass(30,40);
        System.out.println(s.x +"        "+s.y);
        List<String> an = Arrays.asList("a","ccc");
//        an.forEach(System.out.println);
    }
}
