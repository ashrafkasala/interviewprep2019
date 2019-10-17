package CompanyQues;

import java.util.Arrays;

public class numberOfPaths {
    public static void main(String... args){
        int[][] a = {{1,2,8,2,2},{1,1,2,3,11},{5,5,2,8,4}};
        System.out.println(noOFPatths(a));


        int[] arr = {1,3,2};
        for(int ele : arr){
            if(ele%2==0){
                ele--;
            }
        }
        System.out.println(Arrays.toString(arr));

        int at[][] = {{1,2,3}};
        int d[] = new int[]{0,1};
//        int gg[3] ={1,1,1};

    }
    static  int noOFPatths(int[][] a){
        int r  =  a .length;
        int c = a[0].length;
        int res[][] = new int[r][c];

        for(int i=0;i<r;i++){
            a[i][0] = 1;
        }
        for(int i=1;i<c;i++){
            a[0][i] = 1;
        }

        for(int i =1;i<r;i++){
            for(int j=1;j<c;j++){
                a[i][j] = a[i-1][j]+a[i][j-1];
            }
        }
        return a[r-1][c-1];
    }
}
