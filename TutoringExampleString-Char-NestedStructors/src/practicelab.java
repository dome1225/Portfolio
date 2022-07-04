
/**
 * s - Write a description here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// Standard import for the Scanner class
import java.util.*;
public class practicelab {
    public static void main (String [] args) {
        
        Scanner in = new Scanner (System.in);
        final double dieselPrice=1.079, regularPrice=1.129;
        double dieselTotal=0,regularTotal=0, total=0, regularLitres=0,dieselLitres=0;
        double saleLitres;
        int saleType=0;
        double saleTotal=0;
        
        System.out.print("Enter type of sale(1=Regular, 2=Diesel, 0=exit): ");
        saleType=in.nextInt();
        while(saleType !=0){
            System.out.print("How many Litres? ");
            saleLitres=in.nextDouble();
            switch(saleType){
                case 1:
                    //regular gas
                    regularLitres +=saleLitres;
                    saleTotal=saleLitres*regularPrice;
                    saleTotal=Math.round(saleTotal*100.00)/100.0;
                    regularTotal +=saleTotal;
                    System.out.println("Regular Gas\nLitress Sold= " +saleLitres);
                    System.out.printf("Sale total $%.2f%n",saleTotal);
                    break;
                case 2:
                    //Diesel
                    dieselLitres +=saleLitres;
                    saleTotal=saleLitres*dieselPrice;
                    saleTotal=Math.round(saleTotal*100.00)/100.0;
                    dieselTotal +=saleTotal;
                    System.out.println("Diesel Gas\nLitress Sold= " +saleLitres);
                    System.out.printf("Sale total $%.2f%n",saleTotal);
                    break;
            }
            
            total+=saleTotal;
            System.out.print("Enter type of sale(1=Regular, 2=Diesel, 0=exit): ");
            saleType=in.nextInt();
        
    }
    //print out totals for the gas station 
    System.out.println("\nStation Totals");
    System.out.printf("%10s%10s%10s%n","Type","Litres","Total");
    System.out.printf("%10s%10.1f%10.2f%n","Regular",regularLitres,regularTotal);
    System.out.printf("%10s%10.1f%10.2f%n","Diesel",dieselLitres,dieselTotal);
    System.out.printf("%10s%10.1f%10.2f%n","Totals",regularLitres+dieselLitres,total);}
}
