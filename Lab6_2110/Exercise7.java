/**
 *  File: Exercise7
 *  Author: Andrew Parisini
 *  Date: October 26, 2021
 *  Purpose: CSCI 2110, Lab 6
 *
 *  Description: This class plays the game Towers of Hanoi, outputs:  n, moves, execution time (ms) *  
 */


import java.util.Scanner;

public class Exercise7 {
    public static long count; //Global variable to keep count (keeps from making new variables each run)
    
    public static void main(String[] args){   

        long startTime, endTime, executionTime; 
        startTime = System.currentTimeMillis();


        Scanner in = new Scanner(System.in);
        int n;     
        

        System.out.println("Towers of Hanoi");
        System.out.println("Enter the number of discs");
        n = in.nextInt();        

        System.out.println("Number of moves: " + solve(n, 1, 3, 2));         
        System.out.println("n: " + n);                   
        
        endTime = System.currentTimeMillis(); 
        executionTime = endTime - startTime;
        System.out.println("time: " +executionTime+ " ms");   
        in.close();       

    }

    /**
     * Recursive method for the classic game "Towers of Hanoi" with 3 pegs
     * @param n number of discs
     * @param start starting peg
     * @param end ending peg
     * @param tmp temporary peg (middle one)
     * @return returns the total moves
     */
    public static long solve(int n, int start, int end, int tmp){ 
        
        count = 0;
         
        if(n > 0){
            count++;
            
            count += solve(n-1, start, tmp, end);                     
            // System.out.println("Move disc " +n+ " from " +start+ " to peg " +to);    Commented out for ease of console out reading                  
            count += solve(n-1, tmp, end, start);                
                                        
        }
        
        return count;    
                      
    }    
}
