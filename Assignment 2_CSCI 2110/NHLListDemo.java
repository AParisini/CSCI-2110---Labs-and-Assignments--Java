/**
 * CSCI 2110 Assignment 2 
 * Andrew Parisini
 * NHL List Demo; Reads file (nhlstats.txt), creates objects from file, and prints out specified stats
 */

import java.util.*; 
import java.io.*;
import java.util.Scanner;

public class NHLListDemo {
       
    public static void main(String[] args)throws IOException{       


        NHLStats playerRecordList = new NHLStats();

        //Reading file
 
        Scanner keyboard = new Scanner(System.in);      

        System.out.print("Enter the filename to read from: ");   //nhlstats.txt
        
        String filename = keyboard.nextLine(); 
 
        File file = new File(filename); 
        Scanner inputFile = new Scanner(file); 
        StringTokenizer token; 
        while (inputFile.hasNext()){ 
            String line = inputFile.nextLine(); 
            token = new StringTokenizer(line, "\t"); 
            String name = token.nextToken(); 
            String position = token.nextToken(); 
            String teamName = token.nextToken();
            String gamesPlayed = token.nextToken();
            String goalsScored = token.nextToken();
            String assists = token.nextToken();
            String penaltiesMinutes = token.nextToken();
            String shotsOnGoals = token.nextToken();
            String gameWinningGoals = token.nextToken();

            //Convert applicable Strings to Integers

            Integer gamesPlayedNum = Integer.valueOf(gamesPlayed);    
            Integer goalsScoredNum = Integer.valueOf(goalsScored); 
            Integer assistInteger = Integer.valueOf(assists);
            Integer penaltiesInteger = Integer.valueOf(penaltiesMinutes);
            Integer shotsOnGoalsInteger = Integer.valueOf(shotsOnGoals);
            Integer gameWinningGoalsInteger = Integer.valueOf(gameWinningGoals);

            //Create the player Record objects + add to list  

            PlayerRecord playerRecord = new PlayerRecord(name, position, teamName, gamesPlayedNum, goalsScoredNum, assistInteger, penaltiesInteger, shotsOnGoalsInteger, gameWinningGoalsInteger );
            playerRecordList.add(playerRecord);
            
            
        }   
        inputFile.close();
        keyboard.close();

        //Outputs     
        
        System.out.printf("\n \n");

        System.out.println("NHL Results Summary");

        System.out.printf("\n");

        System.out.println("Players with highest points and their teams: ");
        
        playerRecordList.maxGoalsAndAssists();  
        System.out.printf("\n");      

        System.out.println("Most aggressive players, their teams and their positions: ");  

        playerRecordList.maxPenaltyMinutes();
        System.out.printf("\n");

        System.out.println("Most valuable players and their teams: "); 

        playerRecordList.maxGameWinningGoals();
        System.out.printf("\n");

        System.out.println("Most promising players and their teams: "); 

        playerRecordList.maxMostShotsOnGoal();
        System.out.printf("\n");

        System.out.println("Teams that had the most number of penalty minutes: ");  
        
        playerRecordList.maxTeamMostPenaltyPoints();
        System.out.printf("\n");

        System.out.println("Teams that had the most number of game winning goals: ");

        playerRecordList.maxTeamMostGameWinningGoals();
        System.out.printf("\n");      
    
    }   

}
