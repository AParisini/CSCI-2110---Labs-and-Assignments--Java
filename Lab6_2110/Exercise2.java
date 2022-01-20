/**
 *  File: Exercise2
 *  Author: Andrew Parisini
 *  Date: October 26, 2021
 *  Purpose: CSCI 2110, Lab 6
 *
 *  Description: This class counts down in sequential order down to 0, where 0 == "Blast off!"
 *  
 */

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args){ 
         
        Scanner in = new Scanner(System.in);
        int n;
        

        System.out.println("Count Down");
        System.out.println("Enter a positive integer");
        n = in.nextInt();

        System.out.println(countDown(n));        

        in.close();            

    }

    /**
     * count down method
     * @param n chosen integer where count down starts
     * @return prints count down string
     */
    public static String countDown(int n){

        String result = "Blast Off!";

        if(n == 0){
            return result;
        }
        else{
            System.out.print(n + "    ");
            return countDown(n-1);
        }                   
    }      
}
