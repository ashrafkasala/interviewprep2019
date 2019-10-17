package CompanyQues;

public class minCostPath {
    public static void main(String... args){
        int[][] a = {{1,2,8},{2,3,11},{2,8,4}};
        System.out.println(minCost(a));
    }
    static  int minCost(int[][] a){
        int r  =  a .length;
        int c = a[0].length;
        int res[][] = new int[r][c];

        for(int i=1;i<r;i++){
            a[i][0] += a[i-1][0];
        }
        for(int i=1;i<c;i++){
            a[0][i] += a[0][i-1];
        }

        for(int i =1;i<r;i++){
            for(int j=1;j<c;j++){
                a[i][j] = Math.min(a[i-1][j],a[i][j-1]) + a[i][j];
            }
        }
        return a[r-1][c-1];
    }
}
