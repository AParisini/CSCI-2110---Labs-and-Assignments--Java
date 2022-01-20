/**
 * Andrew Parisini
 * B00805414
 * 2021-11-17
 * CSCI 2110 
 * 
 * Exercise 1 - Builds an int binary search tree; finds max, min and finds requested key on input of '0'
 */

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args){
      
        Scanner in = new Scanner(System.in);                
                
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();        
        
        System.out.println("Enter int or '0': "); 
        int input = in.nextInt();
        tree.insert(input);             
        while (input != 0){     
                    
            tree.insert(input);
                        
            System.out.println("Enter int or '0':");                
            input = in.nextInt();       
                       
        }

        System.out.println("The max data value in the BST is: " +tree.findMax());
        System.out.println("The min data value in the BST is: " +tree.findMin());
        System.out.println("What key would you like to search for? ");
        Integer inputSearch = in.nextInt();

        tree.recursiveSearch(inputSearch); 
        
        in.close();
         
    }
    
}
