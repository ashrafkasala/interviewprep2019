package Healofy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class assignment {
    public static void main(String... args){
       doJob dj = new doJob();
   int NUM_JOBS_TO_CREATE = 4;
        // create a pool of threads, 10 max jobs will execute in parallel
        try {
            ExecutorService threadPool = Executors.newFixedThreadPool(2);
            // submit jobs to be executing by the pool
            for (int i = 0; i < NUM_JOBS_TO_CREATE; i++) {
                int count =0 ;
                threadPool.submit(new Runnable() {
                    public void run() {
                        // some code to run in parallel
                        // this could also be another class that implements Runnable
                        dj.processFile();
//                        System.out.println(count);

                    }
                });
                count++;
            }
            // once you've submitted your last job to the service it should be shut down
            threadPool.shutdown();
            // wait for the threads to finish if necessary
            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        }catch (Exception e){

        }
    }
}

class doJob implements Runnable{
    @Override
    public void run() {
        System.out.println("in do job run");
    }
    String[] files = {"1.csv"};
    int count = 0;
   synchronized void processFile(){
       System.out.println("in process file"+ count);
              String csvFile = "1.csv";
       String line = "";
       String cvsSplitBy = ",";
       HashMap<String,HashMap<String,Integer>> resMap = new HashMap<>();
       //generate hashmap

       try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

           while ((line = br.readLine()) != null) {

               // use comma as separator
               String[] input = line.split(cvsSplitBy);
//               r = new Ratings(input[0],input[1],input[2]);
//                personList.add(r);
           }

       } catch (IOException e) {
           e.printStackTrace();
       } catch (Exception ee){

       }

//       synchronized(this){
           count++;
//       }
    }
}