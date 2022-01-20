/**
 * CSCI 2110 Lab3
 * #author: Andrew Parisini-Principi
 * #description: Point class for Exercise 1
 * Point Demo class, creates points as generics; prints out values as XPOS and YPOS
 */

import java.util.Scanner;

public class PointDemo{ 
    private static Scanner in;    
    public static void main(String[] args){
    in = new Scanner(System.in);  
    
    System.out.println("Format: (integer x,y; double x,y; string x,y");

    Point<Integer> point1 = new Point<Integer>(in.nextInt(), in.nextInt()); 
    Point<Double> point2 = new Point<Double>(in.nextDouble(), in.nextDouble()); 
    Point<String> point3 = new Point<String>(in.next(), in.nextLine()); 
   
    System.out.println(point1.toStringInt()); 
    System.out.println(point2.toStringDouble()); 
    System.out.println(point3.toStringText()); 

    in.close();
    } 
  }
