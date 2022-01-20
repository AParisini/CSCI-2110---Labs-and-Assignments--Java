import java.util.*;
import java.io.*;

public class HeapSort {
    public static <T> void main(String[] args)throws IOException{        
        
        //gathering Inputs from List.txt file
        
        Scanner in = new Scanner(System.in);                      
        File file = new File("List.txt"); 
        Scanner inputFile = new Scanner(file); 
        StringTokenizer token;   
        int counter = 0;

        Heap<String> list = new Heap<String>();        

        while (inputFile.hasNext()){ 
            String line = inputFile.nextLine(); 
            token = new StringTokenizer(line); 
            String name = token.nextToken(); 

            list.add(name);   
            counter++;        

        }   
        inputFile.close();         
        
        for (int i = 0; i < counter; i++) {            
            System.out.println(list.deleteMax());                          
        }

        in.close();
    }    
}
