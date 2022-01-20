//Simple illustration of hashmap in java
//Creates a hashmap of student id numbers as keys and student names as records.

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class HashMapDemo
{
	public static void main(String[] args) throws IOException
	{		
		//File Read & Setup

		HashMap<String, String> userPassMap = new HashMap<String,String>();
		HashMap<String, String> nameUserMap = new HashMap<String,String>();
		int failCounter = 3;
		String name = "";
		String user = "";
		String password = "";
		Scanner keyboard = new Scanner(System.in);
		String filename = "username_password.txt";

		File file = new File(filename); 
        Scanner inputFile = new Scanner(file);

		
        StringTokenizer token; 
        while (inputFile.hasNext()){ 
            String line = inputFile.nextLine(); 
            token = new StringTokenizer(line, "\t"); 
            name = token.nextToken(); 
            user = token.nextToken(); 
            password = token.nextToken(); 

			userPassMap.put(user, password);
			nameUserMap.put(user, name); 
               
        }
		inputFile.close();    
		
		//Login System

		System.out.println("Login: ");
		String userInput = keyboard.next();

		System.out.println("Password: ");
		String passInput = keyboard.next();
		
		while(failCounter != 0){
			if(!(passInput.equals(userPassMap.get(userInput))) || !userPassMap.containsKey(userInput)){ 			

				failCounter--;

				if(failCounter == 0){
					System.out.println("Sorry. Incorrect login. Please contact the system administrator. ");
					break;
				}
				System.out.printf("Either the username or password is incorrect. You have %d more attempts. \n", failCounter);
				System.out.println("Login: ");
				userInput = keyboard.next();

				System.out.println("Password: ");
				passInput = keyboard.next();
			}
			else{
				System.out.println("Login successful");
				System.out.println("Welcome " + nameUserMap.get(userInput));
				break;
			}

		}

		keyboard.close();
	}
}
