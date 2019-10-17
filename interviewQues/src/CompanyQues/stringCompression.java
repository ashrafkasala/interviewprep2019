package CompanyQues;

public class stringCompression {
    public static void main(String... args){
        String s ="AAABCCDDD";
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i=0;
        int count = 1;
        char curr = '0';
        char next = '0';
        String res = "";
        while(i<len-1){
             curr = chars[i];
             next = chars[i+1];
            if(curr == next){
                count++;
            } else {
                if(count == 1){
                    res= res.concat(String.valueOf(curr));
                } else {
                    res= res.concat(curr+String.valueOf(count));
                }
                count = 1;
            }
i++;

        }
        if(curr == next){
            res= res.concat(curr+String.valueOf(count));
        } else {
            res= res.concat(String.valueOf(next));
        }
        System.out.println("ergerwg  "+res);


        //// next code
        char prev = chars[0];
        char cur =chars[1];
        String res2 = "";
        int k = 1;
        int cout = 1;
        while(k < len){
            cur = chars[k];
            if(cur == prev){
                cout++;
            } else {
                if(cout==1) {
                    res2 = res2.concat(String.valueOf(prev));
                }else {
                    res2 = res2.concat(String.valueOf(prev)+cout);
                }
                cout =1;
            }
            k++;
            prev =cur;
        }
        System.out.println(res2);
    }
}
