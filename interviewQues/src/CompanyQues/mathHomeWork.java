package CompanyQues;

import java.util.ArrayList;
import java.util.List;

public class mathHomeWork {
  static int  findMin(int threshold,List<Integer> happy){
      int res= 0;
      int min = happy.get(0);
      int max = min;
              int maxIndex = 0;
              int minIndex = 0;
      for(int i=1;i<happy.size();i++){
           maxIndex = i;
           max=happy.get(i);
          if(max - min >= threshold ){
              break;
          }
      }
      res = (maxIndex-minIndex+1)/2 +1;
      return res;
    }
    public static void main (String... args){
        List<Integer> happy = new ArrayList<>();
        int threshold =4;
        happy.add(1);
        happy.add(2);
        happy.add(3);
        happy.add(5);
        System.out.println(findMin(threshold,happy));
    }
}
