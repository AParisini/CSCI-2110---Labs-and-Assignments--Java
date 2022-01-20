//Hash Table Experiment
//This is a simple demo program that
//creates an ArrayList of LinkedList of Integer objects
//It first displays the empty linked lists
//It then hashes some keys and displays the linked lists again
//It uses the generic LinkedList class and the generic Node class

//MODIFY THIS PROGRAM TO DO EXERCISE 1
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class HashTableExperiment
{
	public static void main(String[] args)
	{
		//prompt the user to enter the table size
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the hash table size: ");
		int tableSize = keyboard.nextInt();		
		
		//create an Arraylist of size n
		//The ArrayList holds a LinkedList object 
		//The LinkedList consists of nodes that hold integer objects
		ArrayList<LinkedList<Integer>> hashTable = new ArrayList<LinkedList<Integer>>();
		for (int i = 0; i < tableSize; i++)
		{
			hashTable.add(i, new LinkedList<Integer>());
		}
		
		System.out.print("Enter the number of keys: ");
		double numOfKeys = keyboard.nextInt();

		int counter = 0; //Keep track of all entries (will be minimized later for collison)

		//Generate random keys from 1 - 1000

		Random r = new Random();
		int low = 1;
		int high = 1000;

		for (int i = 0; i < numOfKeys; i++) {
			int result = r.nextInt(high-low) + low;	
			
			int index = result % tableSize;
			hashTable.get(index).add(result);
			counter++; 
		}

		
		//Display the arraylist of linked lists if # of keys is < 100
				
		if(numOfKeys < 100){
			System.out.println();
			System.out.println("After the keys are hashed");

			for (int i = 0; i < tableSize; i++)
			{
				System.out.print(i + ": ");
				hashTable.get(i).enumerate();
			}
		}	

		//For collisons : Take out all counters that sit at linkedlist(0)	
		
		for (int i = 0; i < hashTable.size(); i++) {
			if(hashTable.get(i).size() > 0){
				if(hashTable.get(i).getAt(0) > 0){
					counter--;
				}
			}						
		}	

		//Longest list count		
		int[][] list = new int[tableSize][1];
		
		for (int i = 0; i < tableSize; i++) {
			int maxLine = 0;
			for (int j = 0; j < hashTable.get(i).size(); j++) { 
				if(hashTable.get(i).getAt(j) != null){
					maxLine += 1;					
				}
			}	
			list[i][0] = maxLine;		
		}

		int max = 0;
		for (int i = 0; i < list.length; i++) {
			if(list[i][0] > max){
				max = list[i][0];
			}			
		}

		double load = (numOfKeys/tableSize);

		//Output
				
		System.out.println("Statistics: ");

		System.out.println("Table size: " + tableSize);
		System.out.println("Number of Keys: " + (int) numOfKeys);		
		System.out.printf("Load factor: %.2f \n", load);
		System.out.println("Number of collisions: " + counter);
		System.out.println("Longest list: "  + max);
		
		//File Writer for table creation -- Adding onto existing OR write it up yourself




		keyboard.close();

			
	}
}
			
		
