/**
 * Andrew Parisini
 * B00805414
 * 2021-10-22
 * CSCI 2110 
 * 
 * Geography Quiz, reads the file "CountryCapitals.txt" , puts all lines in a single linked list,
 * plays the quiz, shows final stats at end 
 * 
 */

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GeographyQuiz {
    public static void main(String[] args)throws IOException{

        LinkedList<String> worldMap = new LinkedList<>();       

        //Reading file
 
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the filename to read from: "); 
        //CountryCapitals.txt
        String filename = keyboard.nextLine(); 
 
        File file = new File(filename); 
        Scanner inputFile = new Scanner(file); 
        StringTokenizer token; 
        while (inputFile.hasNext()){ 
            String line = inputFile.nextLine(); 
            token = new StringTokenizer(line, ""); 
            String result = token.nextToken();         
            
            worldMap.add(result);          

        }  

        inputFile.close();


        //Quiz 

        int count = 0;
        int correct = 0;
        String input = "";

        int max = worldMap.size();
        int min = 1;
        Random random = new Random();         

        System.out.println("Welcome to the Country-Capital Quiz");
        System.out.println("Play?");

        String command = keyboard.nextLine();
        while(!command.equalsIgnoreCase("no")){ 

            int randomNum = random.nextInt( (max - min) + min );
            String question = worldMap.getAt(randomNum);
            String answer;

            if(randomNum % 2 == 1){

                System.out.printf("What is the capital of %s? \n",  question);
                answer = worldMap.getAt(randomNum - 1);
                input = keyboard.nextLine();
                if(input.equalsIgnoreCase(answer)){
                    System.out.println("Correct.");
                    correct++;
                    count++;
                }
                else{
                    System.out.printf("Incorrect. The correct answer is %s \n", answer);
                    count++;
                }
                
            }
            if(randomNum % 2 == 0){

                System.out.printf("What country has %s as the capital? \n",  question);
                input = keyboard.nextLine();
                answer = worldMap.getAt(randomNum + 1);
                if(input.equalsIgnoreCase(answer)){
                    System.out.println("Correct.");
                    correct++;
                    count++;
                }
                else{
                    System.out.printf("Incorrect. The correct answer is %s \n", answer);
                    count++;
                }
                
            }
            System.out.println("Play?");
            command = keyboard.nextLine();
        }       

        double finalScore =  (double) correct/count;

        System.out.println("Final Stats: ");
        
        System.out.printf("Questions played: %d; Correct answers: %d; Score: %.2f%% ", count, correct, finalScore);                 
                
        keyboard.close(); 
      
    
    }
}