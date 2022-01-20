/**
 *  File: Exercise4
 *  Author: Andrew Parisini
 *  Date: October 26, 2021
 *  Purpose: CSCI 2110, Lab 6
 *
 *  Description: This class prints out all multiples of chosen 2 integers
 *  
 */

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int n;
        int m;
        
        System.out.println("Multiples");
        System.out.println("Enter a positive integer");
        n = in.nextInt();  
        System.out.println("Enter a positive integer");
        m = in.nextInt();      
        System.out.println(multiples(n, m));   
        
        in.close();       

    }

    /**
     * prints out multiples of n and m
     * @param n integer 1
     * @param m integer to multipley intger 1 with
     * @return print of all multiples
     */
    public static int multiples(int n, int m){         

        if(m == 1){
            return n;
        }
        else{
            System.out.print( n*m +", ");
            return ( multiples(n, m - 1));
        }               
    }    
}
