/**
 * CSCI 2110 Lab3
 * #author: Andrew Parisini-Principi
 * #description: GenericStackDemo class for Exercise 2 
 * main method to run the GenericStack class; reads in inputs for two stacks, prints out both at end
 */

import java.util.Scanner; 

public class GenericStackDemo{
    private static Scanner in;
    public  static  void main(String[]  args){
        in = new Scanner(System.in);
        String textInput;        
        int numInput; 

        GenericStack<String> stack1 = new GenericStack<String>(); 
        GenericStack<Integer> stack2 = new GenericStack<Integer>();   
        
        
        System.out.println("String Stack --- 'quit' to end");
        textInput = in.nextLine(); 
              
        while(!textInput.equalsIgnoreCase("quit")){
            stack1.push(textInput);
            textInput = in.next();                      
        }        
        
        System.out.println("Integer Stack --- '-1' to end");
        numInput = in.nextInt();
        
        while(numInput != -1){
            stack2.push(numInput);
            numInput = in.nextInt();            
        }
               

        System.out.println("String Stack Contents");     
        for (int i = stack1.getSize(); stack1.getSize() > 0; i--) {
            System.out.println(stack1.pop());            
        }
        
        System.out.println();
        System.out.println();

        System.out.println("Integer Stack Contents");
        for (int i = stack2.getSize(); stack2.getSize() > 0; i--) {
            System.out.println(stack2.pop());            
        }
        in.close();
    }
}
