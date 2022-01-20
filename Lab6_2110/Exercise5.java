/**
 *  File: Exercise5
 *  Author: Andrew Parisini
 *  Date: October 26, 2021
 *  Purpose: CSCI 2110, Lab 6
 *
 *  Description: This class writes all integers into a "vertical wall"
 */

import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args){  


        Scanner in = new Scanner(System.in);
        int n;     

        System.out.println("Write Vertical");
        System.out.println("Enter a positive integer");
        n = in.nextInt();        

        writeVertical(n);
         
        in.close();    

    }

    /**
     * writes integers into the console wall fashion
     * @param n chosen integer from user
     */
    public static void writeVertical(int n){

        if(n < 10){
            System.out.println(n);
        }
        else{
            
            writeVertical(n/10);
            System.out.println(n%10);
        }
            
    }
}
