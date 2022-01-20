/**
 * CSCI 2110 Lab3
 * #author: Andrew Parisini-Principi
 * #description: Point class for Exercise 1
 * Point functions
 */

public class Point<T>{ 

    private T x;
    private T y; 

    public Point(T x, T y){ 
        this.x = x;
        this.y = y; 
    }   

    public T getX(){
        return x;
    }

    public T getY(){
        return y;
    }

    public String toStringInt(){
        return String.format("XPOS: %d    YPOS: %d",  getX(), getY());
    }
    public String toStringDouble(){
        return String.format("XPOS: %.2f    YPOS: %.2f",  getX(), getY());
    }
    public String toStringText(){
        return String.format("XPOS: %s    YPOS: %s",  getX(), getY());
    }
}