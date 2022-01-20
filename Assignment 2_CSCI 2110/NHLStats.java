/**
 * CSCI 2110 Assignment 2 
 * Andrew Parisini
 * NHL Stats Class; Performs functions as specified from the 5 requested functions from NHL Demo
 * makes use of Linked List and List functions
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class NHLStats {

    private List<PlayerRecord> playerRecordList;

    public NHLStats(){
        playerRecordList = new List<PlayerRecord>();
    }

    public void add(PlayerRecord record){
        playerRecordList.add(record);
    }

    public boolean isEmpty(){
        return playerRecordList.isEmpty();
    }

    public boolean contains(PlayerRecord record){
        return playerRecordList.contains(record);
    }
    
    public PlayerRecord first(){
        return playerRecordList.first();
    }

    public PlayerRecord next(){
        return playerRecordList.next();
    }

    public void enumerate(){
        playerRecordList.enumerate();
    }

    /**
     * First Iteration finds the max sum of goals and assists from all players
     * Second Iteration prints out all players whos sum matches max sum
     * Prints out player + team     
     */
    public void maxGoalsAndAssists(){
        
        int max = 0;       

        PlayerRecord current = playerRecordList.first();
        while(current != null){
            if((current.getGoalsScored() + current.getAssist()) > max){
                max = current.getGoalsScored() + current.getAssist();
            } 
            current = playerRecordList.next();           
        }
        
        current = playerRecordList.first();
        while(current != null){
            if((current.getAssist() + current.getGoalsScored()) == max){
                System.out.println(current.getName() +"   " + current.getTeamName());
            }
            current = playerRecordList.next();
        }
    }

    /**
     * First Iteration finds the max penalty minutes from all players
     * Second Iteration prints out all players whos penalty minutes matches max penalty minutes
     * Prints out player + team    
     */
    public void maxPenaltyMinutes(){

        int max = 0;       

        PlayerRecord current = playerRecordList.first();
        while(current != null){
            if(current.getPenaltiesMinutes() > max){
                max = current.getPenaltiesMinutes();
            } 
            current = playerRecordList.next();           
        }

        current = playerRecordList.first();
        while(current != null){
            if(current.getPenaltiesMinutes() == max){
                System.out.println(current.getName() +"   " + current.getTeamName());
            }
            current = playerRecordList.next();
        }
    }

    /**
     * First Iteration finds the max game winning goals from all players
     * Second Iteration prints out all players whos game winning goals matches game winning goals
     * Prints out player + team    
     */
    public void maxGameWinningGoals(){

        int max = 0;        

        PlayerRecord current = playerRecordList.first();
        while(current != null){
            if(current.getGameWinningGoals() > max){
                max = current.getGameWinningGoals();
            } 
            current = playerRecordList.next();           
        }

        current = playerRecordList.first();
        while(current != null){
            if(current.getGameWinningGoals() == max){
                System.out.println(current.getName() +"   " + current.getTeamName());
            }
            current = playerRecordList.next();
        }
    }

    /**
     * First Iteration finds the max shots on goal from all players
     * Second Iteration prints out all players whos shots on goal matches max shot on goal
     * Prints out player + team    
     */
    public void maxMostShotsOnGoal(){

        int max = 0;       

        PlayerRecord current = playerRecordList.first();
        while(current != null){
            if(current.getShotsOnGoals() > max){
                max = current.getShotsOnGoals();
            } 
            current = playerRecordList.next();           
        }

        current = playerRecordList.first();
        while(current != null){
            if(current.getShotsOnGoals() == max){
                System.out.println(current.getName() +"   " + current.getTeamName());
            }
            current = playerRecordList.next();
        }
    }    

    /**
     * First Iteration puts all teams on a hashmap to avoid duplicates
     * Second Iteration finds the max value from all keys, and prints out the team(s) with the highest value
     * Prints out team   
     */
    public void maxTeamMostPenaltyPoints(){

        int max = 0;

        HashMap<String,Integer> teamsList = new HashMap<String,Integer>();

        
        PlayerRecord current = playerRecordList.first();
        while(current != null){
            if (teamsList.containsKey(current.getTeamName())) {
                
                // OPERATION : teamslist.put(key, teamsList.get(key) + adding value))
                teamsList.put(current.getTeamName(), teamsList.get(current.getTeamName()) + current.getPenaltiesMinutes());
            } else { 
                teamsList.put(current.getTeamName(), current.getPenaltiesMinutes() );
            }     
            current = playerRecordList.next();           
        }
        
        max = (Collections.max(teamsList.values()));
        for(Entry<String, Integer> entry : teamsList.entrySet()){
            if(entry.getValue() == max){
                System.out.println(entry.getKey());
            }
        }   

    }    
    /**
     * First Iteration puts all teams on a hashmap to avoid duplicates
     * Second Iteration finds the max value from all keys, and prints out the team(s) with the highest value
     * Prints out team   
     */
    public void maxTeamMostGameWinningGoals(){

        int max = 0;
        HashMap<String,Integer> teamsList = new HashMap<String,Integer>();

        PlayerRecord current = playerRecordList.first();
        while(current != null){
            if (teamsList.containsKey(current.getTeamName())) {

                // OPERATION : teamslist.put(key, teamsList.get(key) + adding value))
                teamsList.put(current.getTeamName(), teamsList.get(current.getTeamName()) + current.getGameWinningGoals());
            } else { 
                teamsList.put(current.getTeamName(), current.getGameWinningGoals() );
            }     
            current = playerRecordList.next();           
        }

        max = (Collections.max(teamsList.values()));
        for(Entry<String, Integer> entry : teamsList.entrySet()){
            if(entry.getValue() == max){
                System.out.println(entry.getKey());
            }
        }   

    }
}
