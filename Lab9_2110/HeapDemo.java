import java.util.*;
import java.io.*;
public class HeapDemo {
    public static void main(String[] args)throws IOException{

        Scanner in = new Scanner(System.in); 
        Heap<Integer> list = new Heap<Integer>();   

        System.out.println("Enter a series of positive integers (end with -1): ");         

        int input = in.nextInt();
        while(input > 0){
            list.add(input);
            input = in.nextInt();            
        }
        System.out.println("The heap is: ");
        list.enumerate();

        System.out.println("The minimum key is: ");
        System.out.println(list.findMin()); 
        
        System.out.println("Enter a key to be replaced: ");
        int key1 = in.nextInt();
        System.out.println("Enter the new key: ");
        int key2 = in.nextInt();

        list.replace(key1, key2);       
                
        in.close();

    }
}
