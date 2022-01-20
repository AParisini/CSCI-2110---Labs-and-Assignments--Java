/**
 *  File: Exercise6
 *  Author: Andrew Parisini
 *  Date: October 26, 2021
 *  Purpose: CSCI 2110, Lab 6
 *
 *  Description: This class sums up all squares
 *  
 */

import java.util.Scanner;

public class Exercise6 {

    public static void main(String[] args){       

        Scanner in = new Scanner(System.in);
        int n;     

        System.out.println("Squares");
        System.out.println("Enter a positive integer");
        n = in.nextInt();

        System.out.println(squares(n));  

        in.close();          

        //sum of all squares example 1 + 4 + 9 + 16       

    }

    /**
     * Squares method
     * @param n amount of squares to be calculated
     * @return sum of all squares
     */
    public static int squares(int n){        

        if( n==1 ){
            return 1;
        }
        else{
            return (n*n + squares(n-1));
        }        
    }    
}
