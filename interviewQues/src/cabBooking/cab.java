package cabBooking;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Ashraf Kasala
 */


class Ratings {
    String driverName;
    int driverRating;
    String customerName;
    int customerRating;

    Ratings(String driverName, int dirverRating, String customerName,  int customerRating) {
        this.driverName=driverName;
        this.customerName=customerName;
        this.driverRating=dirverRating;
        this.customerRating=customerRating;
    }

}

class DriverSort implements Comparator<Ratings> {

    public int compare(Ratings r1, Ratings r2) {
        return r1.driverName.compareTo(r2.driverName);
    }
}


class CustomerSort implements Comparator<Ratings> {

    public int compare(Ratings r1, Ratings r2) {
        return r1.customerName.compareTo(r2.customerName);
    }
}


class Customer {
    String customerName;
    float customerAvgRating;

    Customer (String cName, float cAvgRagting) {
        this.customerName=cName;
        this.customerAvgRating=cAvgRagting;
    }
}

class Driver {
    String driverName;
    float driverAvgRating;
    boolean online;

    Driver (String dName, float dAvgRating, boolean online) {
        this.driverName = dName;
        this.driverAvgRating = dAvgRating;
        this.online = online;
    }
}

public class cab {

    float avgCustomerRating(String cName, ArrayList<Customer> cList) {

        float acr=-1;
        for( Customer c : cList) {
            if(c.customerName.equals(cName))
                acr = c.customerAvgRating;
            //System.out.println( c.customerName+ " " + c.customerAvgRating);
        }
        return acr;
    }
   // added extra feature to set drive offline and online
    void setDriveroffline(String dName, ArrayList<Driver> dList) {
        for(Driver d : dList) {
            if(d.driverName.equals(dName))
                d.online=false;
        }
    }


    void setDriveronline(String dName, ArrayList<Driver> dList) {
        for(Driver d : dList) {
            if(d.driverName.equals(dName))
                d.online=true;
        }
    }

    boolean checkElegibility(String cName,String dName, ArrayList<Ratings> pList ) {

        boolean flag=false;
        for(Ratings r3 : pList) {
            if(cName.equals(r3.customerName) && dName == r3.driverName && r3.driverRating!=1 && r3.customerRating!=1 )
                flag = true;
        }
        return flag;
    }

    void eligibleDriverNames(String cName, ArrayList<Customer> cList,
                             ArrayList<Driver> dList, ArrayList<Ratings> pList) {


        System.out.println("Avergae Cab Options based on rules defined:");
        float acr = 0;
        int count = 0;
        acr = avgCustomerRating(cName, cList);

        for (Driver d : dList) {
            if (acr <= d.driverAvgRating) {
                if (checkElegibility(cName, d.driverName, pList) && d.online) {
                    System.out.println(d.driverName + " " + d.driverAvgRating);
                    count++;
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("name of customer");
        String customerNamemain = sc.next();
        ArrayList<Ratings> personList = new ArrayList<Ratings>();

        ArrayList<Driver> driverList = new ArrayList<Driver>();

        ArrayList<Customer> customerList = new ArrayList<Customer>();
//
//        String csvFile = "cabinput(csv).csv";
//        String line = "";
//        String cvsSplitBy = ",";
//        Ratings r;
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//
//            while ((line = br.readLine()) != null) {
//
//                // use comma as separator
//                String[] input = line.split(cvsSplitBy);
//                r = new Ratings(input[0],Integer.parseInt(input[1]),input[2],Integer.parseInt(input[3]));
//                personList.add(r);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
       //Input Hardcoded
        Ratings r = new Ratings("Raghu",4,"Amar",5);
        personList.add(r);
        r = new Ratings("Raghu",5,"Akbar",4);
        personList.add(r);
        r = new Ratings("Raghu",1,"Anthony",2);
        personList.add(r);
        r = new Ratings("Ram",5,"Amar",1);
        personList.add(r);
        r = new Ratings("Ram",5,"Akbar",5);
        personList.add(r);
        r = new Ratings("Ram",4,"Anthony",5);
        personList.add(r);
        r = new Ratings("Rajan",3,"Amar",2);
        personList.add(r);
        r = new Ratings("Rajan",4,"Akbar",5);
        personList.add(r);
        r = new Ratings("Rajan",3,"Anthony",3);
        personList.add(r);

        DriverSort dSort = new DriverSort();
        Collections.sort(personList, dSort);

        int count =0;
        int size =personList.size();
        while( count < size) {
            float avgDriverRating=0;
            int driverRidesCount=0;
            String tempName= personList.get(count).driverName;
            while (count < size && personList.get(count).driverName == tempName ) {
                avgDriverRating = avgDriverRating + personList.get(count).driverRating;
                count ++;
                driverRidesCount++;
            }
            avgDriverRating=avgDriverRating/driverRidesCount;

            Driver d = new Driver(tempName,avgDriverRating,true);
            driverList.add(d);
        }

        CustomerSort cSort = new CustomerSort();
        Collections.sort(personList, cSort);

       /* for( Ratings r1 : personList) {
            System.out.println(r1.customerName + " " + r1.customerRating + " " + r1.driverName + " " + r1.driverRating);
        }*/

        count =0;
        while(count < size ) {
            float avgCustomerRating=0;
            int customerRidesCount=0;
            String tempName= personList.get(count).customerName;
            while ( count < size && personList.get(count).customerName == tempName ) {
                avgCustomerRating = avgCustomerRating + personList.get(count).customerRating;
                count ++;
                customerRidesCount++;
            }
            avgCustomerRating=avgCustomerRating/customerRidesCount;
            Customer c = new Customer(tempName,avgCustomerRating);
            customerList.add(c);
        }

       /* for( Driver d : driverList) {
            System.out.println(d.driverName + " " + d.driverAvgRating);
        }*/

        //System.out.println("Agerage Rating of a customer is");
       /* for( Customer c : customerList) {
            System.out.println( c.customerName+ " " + c.customerAvgRating);
        } */
        cab ashrafCab = new cab();
        System.out.println("Avaerage Rating of Customer: "+ashrafCab.avgCustomerRating(customerNamemain,customerList));
         //added extra feature to check avaiable online drivers
        //ash.setDriveroffline("d1",driverList);
        //ash.setDriveroffline("d3",driverList);
//        System.out.println(customerNamemain);
        ashrafCab.eligibleDriverNames(customerNamemain,customerList,driverList,personList);
    }
}
