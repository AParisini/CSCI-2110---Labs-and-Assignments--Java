/**
 *  File: Exercise1
 *  Author: Andrew Parisini
 *  Date: October 26, 2021
 *  Purpose: CSCI 2110, Lab 6
 *
 *  Description: This class prints the following in order: factorial of n, fibonacci of n, and power of chosen numbers
 *  
 */

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args){ 

        
        Scanner in = new Scanner(System.in);
        int n;
        int x;

        System.out.println("Factorial of a number");
        System.out.println("Enter a positive integer");
        n = in.nextInt();

        System.out.println(factorial(n));        

        //System.out.println(factorial(n));        

        System.out.println("Fibonacci numbers");
        int k = in.nextInt();
        System.out.println("The first "+k+" numbers in the fibonacci series are ");
        
        
        for (int i = 0; i < k; i++) {
            System.out.print(fib(i) +", ");            
        }
        System.out.println();
        

        System.out.println("Power of a number");
        System.out.println("Enter a positive integer x: ");
        x = in.nextInt();
        System.out.println("Enter another positive integer: ");
        n = in.nextInt();

        System.out.println( x +" to the power of " + n + " is " + power(x, n));

        in.close();

        

    }

    /**
     * Calculates factorial of a chosen integer
     * @param n chosen integer
     * @return returns factorial
     */
    public static int factorial(int n){

        if(n == 0){
            return 1;
        }
        else{            
            return n * factorial(n-1);
        } 
                  
    }

    /**
     * calculates all fibonacci numbers of chosen integer
     * @param n chosen integer
     * @return returns series
     */
    public static int fib(int n){

        if(n == 0){            
            return 0;
        }
        else if(n == 1){            
            return 1;
        }
        else{
            return fib(n-1) + fib(n-2);
        }
    }

    /**
     * calculates power of two chosen integers
     * @param x chosen base integer
     * @param n chosen power integer
     * @return returns calculated integer
     */
    public static int power(int x, int n){

        if(n == 0){
            return 1;
        }
        else{
            return power(x,n-1)*x;
        }        
    }






    
}
