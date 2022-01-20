/**
 * CSCI 2110 Lab3
 * #author: Andrew Parisini-Principi
 * #description: GenericStack class for Exercise 2 
 * Stack functions
 */


import java.util.ArrayList; 

public class GenericStack<T> { 
    private ArrayList<T> stack;

    public GenericStack(){
        stack = new ArrayList<>();
    }
    
    public int getSize(){
        return stack.size();
    }

    public T peek(){
        return stack.get(stack.size()-1);
    }

    public T pop(){
        T returnItem = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return returnItem;     
    }
    public void push(T entry){
        stack.add(entry);
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }    
}
