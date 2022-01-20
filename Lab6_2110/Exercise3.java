/**
 *  File: Exercise3
 *  Author: Andrew Parisini
 *  Date: October 26, 2021
 *  Purpose: CSCI 2110, Lab 6
 *
 *  Description: This class counts down in wither odd or even integers down to 0, where 0 == "Blast off!"
 *  
 */

import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args){ 
         
        Scanner in = new Scanner(System.in);
        int n; 

        System.out.println("Count Down Even or Odd");
        System.out.println("Enter a positive integer");
        n = in.nextInt();
        System.out.println();

        System.out.println(countDown(n));           

        in.close();  
    }   

    /**
     * counts down from starting integer (either odd or even)
     * @param n chosen integer from user
     * @return returns a print counting down to "Blast off!"
     */
    public static String countDown(int n){

        String result = "Blast Off!";  

               
        if(n % 2 == 0){
            if(n <= 0){
                return result;
            }
            else{
                System.out.print(n + "    ");
                return countDown(n-2);
            }      
        }
        else{
            if(n <= 0){
                return result;
            }
            else{
                System.out.print(n + "    ");
                return countDown(n-2);
            }             
        } 
    }

       
}
