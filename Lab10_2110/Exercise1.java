/**
 * Exercise 1 Lab 10
 * CSCI 2110
 * Andrew Parisini-Principi
 * User inputs a integer or string array after prompts, then sorts the array to user specification (Max or Min)
 */

import java.util.Scanner;

public class Exercise1 {
    static int counter = 0;	 //global variable to keep count of all swaps
    static Scanner in = new Scanner(System.in);
    public static <T> void main(String[] args){ 
        
        //Setup
        String maxOrMin = "";

        //Input
		      
        System.out.println("Enter how many items are in the list?");
        int num = in.nextInt();
        System.out.println("Are we sorting Strings or Integers?");
        String type = in.next();

        //Sort and Print

        //Integer

        if(type.equalsIgnoreCase("Integers")){
            System.out.println("Enter values");
            Integer[] intArray = new Integer[num];
            
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = in.nextInt(); 
            }

            System.out.println("Do you want to sort Min or Max?");
            maxOrMin = in.next();            

            if(maxOrMin.equalsIgnoreCase("Max")){
                intArray = bubbleSortMax(intArray);
            }   
            else if(maxOrMin.equals("Min")){
                intArray = bubbleSortMin(intArray);
            }        

            System.out.println("Sorting complete. Total Swaps: " + counter);
            for (int i = 0; i < intArray.length; i++) {
                System.out.print( intArray[i] + " ");                
            }            
        }

        //String

        if(type.equalsIgnoreCase("Strings")){
            System.out.println("Enter values");
            String[] strArray = new String[num];
            for (int i = 0; i < strArray.length; i++) {
                strArray[i] = in.next();              
            }

            System.out.println("Do you want to sort Min or Max?");
            maxOrMin = in.next();  
            
            if(maxOrMin.equalsIgnoreCase("Max")){
                strArray = bubbleSortMax(strArray);
            }   
            else if(maxOrMin.equals("Min")){
                strArray = bubbleSortMin(strArray);
            }  

            System.out.println("Sorting complete. Total Swaps: " + counter);
            for (int i = 0; i < strArray.length; i++) {
                System.out.print(strArray[i] + " ");                
            }
        }     

        in.close();
    }
    
    //Helper sort methods


    /**
     * Sorts out array Minimum bubble sort
     * @param <T> 
     * @param list array to be sorted
     * @return returns minimum oriented array
     */
    public static <T extends Comparable<T>> T[] bubbleSortMin (T[] list){   

        T temp;               

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < (list.length - i - 1); j++) {
                if( list[j].compareTo(list[j+1]) > 0){
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;  
                    counter++;
                 }
            }    
        }
                
        return list;
    }


    /**
     * Sorts out array Maximum bubble sort
     * @param <T> 
     * @param list array to be sorted
     * @return returns maximum oriented array
     */
    public static <T extends Comparable<T>> T[] bubbleSortMax (T[] list){

        T temp;

        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < list.length; j++) {
                if( list[j-1].compareTo(list[j]) < 0){
        
                    temp = list[j-1];
                    list[j-1] = list[j];
                    list[j] = temp;  
                    counter++;                        
                }
            }    
        }
        return list;
    }
}

