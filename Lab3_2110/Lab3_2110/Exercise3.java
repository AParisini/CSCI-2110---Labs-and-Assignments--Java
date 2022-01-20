/**
 * CSCI 2110 Lab3
 * #author: Andrew Parisini-Principi
 * #description: Exercise3 class for Exercise 3 
 * main method to run the StudentRecord & GenericStack class; 
 * reads in inputs, full names and student IDs, stack1 holds objects, stack 2 works stack 1 objects to print out only last names
 */


import java.util.*; 
import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Exercise3 {
    private static StudentRecord studentRecord; 
    public static void main(String[] args)throws IOException{
        

        GenericStack<StudentRecord> stack1 = new GenericStack<StudentRecord>();  
 
        Scanner keyboard = new Scanner(System.in); 
        System.out.print("Enter the filename to read from: "); 
        String filename = keyboard.nextLine(); 
 
        File file = new File(filename); 
        Scanner inputFile = new Scanner(file); 
        StringTokenizer token; 
        while (inputFile.hasNext()){ 
            String line = inputFile.nextLine(); 
            token = new StringTokenizer(line, " "); 
            String firstName = token.nextToken(); 
            String lastName = token.nextToken(); 
            String IDString = token.nextToken(); 
            //convert String IDString to an Integer Object IDNum 
            Integer IDNum = Integer.valueOf(IDString);      
         
            studentRecord = new StudentRecord(firstName, lastName, IDNum);
            stack1.push(studentRecord);     
        }   
        inputFile.close();

        //Create a new stack to hold stack1 last names
        GenericStack<String> stack2 = new GenericStack<String>();    
        
        //pushing lastname into stack2; then popping/printing 
        int counter = 0;
        for (int i = stack1.getSize(); stack1.getSize() > 0; i--) {
            stack2.push(stack1.pop().getLastName());  
            counter++;         
                          
        }
        for (int i = 0; i < counter; i++) {
            System.out.println(stack2.pop());
            
        }       
            
        keyboard.close();
    }
}
