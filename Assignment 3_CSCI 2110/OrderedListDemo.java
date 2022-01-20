/**
 *  File: OrderedListDemo
 *  Author: Andrew Parisini
 *  Date: October 25, 2021
 *  Purpose: CSCI 2110, Assignment 3
 *
 *  Description: This class creates lists based on the called method, while also writing into correct txt files
 *  
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OrderedListDemo {

    public static void main(String[] args)throws IOException{

        OrderedList list1 = new OrderedList();       

        //Reading file
 
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the first filename to read from: "); 
        //  list1.txt  
        String filename = keyboard.nextLine(); 
 
        File file = new File(filename); 
        Scanner inputFile = new Scanner(file); 
        StringTokenizer token; 
        while (inputFile.hasNext()){ 
            String line = inputFile.nextLine(); 
            token = new StringTokenizer(line, ""); 
            String result = token.nextToken();         
            
            list1.insert(result);          

        }  

        OrderedList list2 = new OrderedList();       

        //Reading file 2        

        System.out.print("Enter the second filename to read from: "); 
        //  list2.txt
        filename = keyboard.nextLine(); 
 
        File file2 = new File(filename);
        Scanner inputFile2 = new Scanner(file2);           
        StringTokenizer token2;         
        while (inputFile2.hasNext()){ 
            String line = inputFile2.nextLine(); 
            token2 = new StringTokenizer(line, ""); 
            String result = token2.nextToken();         
            
            list2.insert(result);          

        }

        //Writes into correct files
        //IMPORTANT: System.out.prints were for console testing, commented out

        OrderedList list = new OrderedList();  
        FileWriter f0 = new FileWriter("merged.txt");
        
        //System.out.printf("\n \n");
        
        //System.out.printf("Merged: \n");
        list = merge(list1, list2);
        for (int i = 0; i < list.size(); i++) {

            if( i == list.size()-1){
                //System.out.print(list.get(i) +"");   
                f0.write(list.get(i) + "");
            }
            else{
                //System.out.print(list.get(i) +", ");   
                f0.write(list.get(i) + ", ");  
            }                   
        }

        //System.out.printf("\n \n");
        list.clear();
        f0.close();


        FileWriter f1 = new FileWriter("difference.txt");
        //System.out.printf("Difference: \n");

        list = difference(list1, list2);
        for (int i = 0; i < list.size(); i++) {

            if( i == list.size()-1){
                //System.out.print(list.get(i) +"");   
                f1.write(list.get(i) + "");
            }
            else{
                //System.out.print(list.get(i) +", ");   
                f1.write(list.get(i) + ", ");  
            }                       
        }

        //System.out.printf("\n \n");
        list.clear();
        f1.close();



        FileWriter f2 = new FileWriter("common.txt");
        //System.out.printf("Common: \n");

        list = common(list1, list2);

        for (int i = 0; i < list.size(); i++) {

            if( i == list.size()-1){
                //System.out.print(list.get(i) +"");   
                f2.write(list.get(i) + "");
            }
            else{
                //System.out.print(list.get(i) +", ");   
                f2.write(list.get(i) + ", ");  
            }                          
        }
        //System.out.printf("\n \n");
        list.clear();  
        f2.close();    


        System.out.println("The merge operations are complete and the results are in merged.txt, difference.txt and common.txt");

        inputFile.close();
        keyboard.close(); 

        
    }


        /**
         * Merges both lists into one, using the two step algorithim
         * @param <T> generic type list
         * @param list1 list 1 from list1 txt file
         * @param list2 list 2 from list2 txt file
         * @return returns list3
         */
        public  static  <T  extends  Comparable<T>>  OrderedList<T>  merge(OrderedList<T>  list1,  OrderedList<T> list2){ 

        OrderedList<T> list3 = new OrderedList();       
        
        int f1 = 0;
        int f2 = 0;  

        while(f1 < list1.size() && f2 < list2.size()){

            if(list1.get(f1).compareTo(list2.get(f2)) < list2.get(f2).compareTo(list1.get(f1))){
                list3.add(list1.get(f1));
                f1++;
            }
            else if(list2.get(f2).compareTo(list1.get(f1)) < list1.get(f1).compareTo(list2.get(f2))){
                list3.add(list2.get(f2));
                f2++;
                        }
            else{
                list3.add(list1.get(f1));                             
                f1++;
                f2++;
            }
        }

        //putting remaining items in list

        if(f1 == list1.size()){
            for (int i = f2; i < list2.size(); i++) {
                list3.add(list2.get(i));                
            }
        }

        if(f2 == list2.size()){
            for (int i = f1; i < list1.size(); i++) {
                list3.add(list1.get(i));                
            }
        }
        return list3;
    }
        
         
    /**
     * makmes a third list that is an ordered list with the items in list1 that are not in list2
     * @param <T> generic type list
     * @param list1 list 1 from the list1 txt file
     * @param list2 list 2 form the list2 txt file
     * @return returns list 3 with the differences
     */
    public static <T extends Comparable<T>> OrderedList<T> difference(OrderedList<T> list1, OrderedList<T> list2){ 

        OrderedList<T> list3 = new OrderedList();

        int f1 = 0;
        int f2 = 0;            
    
        while(f1 < list1.size() && f2 < list2.size()){

            if(list1.get(f1).compareTo(list2.get(f2)) < list2.get(f2).compareTo(list1.get(f1))){               
                list3.add(list1.get(f1));
                f1++;
            }
            else if(list2.get(f2).compareTo(list1.get(f1)) < list1.get(f1).compareTo(list2.get(f2))){              
                f2++;
            }
            else{                
                f1++;
                f2++;
            }
        }
        
        
        return list3;
               
         
    } 

    /**
     * Makes a third list that is an ordered list with the items that are common in list1 and list2
     * @param <T> generic type list
     * @param list1 list 1 from the list1 txt file
     * @param list2 list 2 form the list2 txt file
     * @return returns list 3 with the common elements
     */
    public  static  <T  extends  Comparable<T>>  OrderedList<T>  common(OrderedList<T>  list1, OrderedList<T> list2){ 

        OrderedList<T> list3 = new OrderedList();

        int f1 = 0;
        int f2 = 0;  
             
        while(f1 < list1.size() && f2 < list2.size()){

            if(list1.get(f1).compareTo(list2.get(f2)) < list2.get(f2).compareTo(list1.get(f1))){                
                f1++;
            } 
            else if(list2.get(f2).compareTo(list1.get(f1)) < list1.get(f1).compareTo(list2.get(f2))){                 
                f2++;
            }           
            else{
                list3.add(list1.get(f1));                
                f1++;
                f2++;
            }
        } 

        
        return list3;
    }
    
       
}

/*
        Enter the first filename to read from: list1.txt 
        Enter the second filename to read from: list2.txt 
        The merge operations are complete and the results are in merged.txt, 
        difference.txt and common.txt

*/
