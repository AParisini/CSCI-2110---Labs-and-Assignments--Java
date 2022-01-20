/**
 * CSCI 2110 Assignment 2 
 * Andrew Parisini
 * Player Record Class; Creates object and holds its setters and getters
 * Used in NHL Stats Class
 */

public class PlayerRecord {

    private String name;
    private String position;
    private String teamName;
    private Integer gamesPlayed;
    private Integer goalsScored;
    private Integer assists;
    private Integer penaltiesMinutes;
    private Integer shotsOnGoals;
    private Integer gameWinningGoals;


    public PlayerRecord(String name, String position , String teamName, int gamesPlayed, int goalsScored, int assists, int penaltiesMinutes, int shotsOnGoals , int gameWinningGoals){

        this.name = name;
        this.position = position;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.penaltiesMinutes = penaltiesMinutes;
        this.shotsOnGoals = shotsOnGoals;
        this.gameWinningGoals = gameWinningGoals;

    }

    public void setName(String name){
        this.name = name;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    public void setGamesPlayed(int gamesPlayed){
        this.gamesPlayed = gamesPlayed;
    }
    public void setGoalsScored(int goalsScoredNum){
        this.goalsScored = goalsScoredNum;
    }
    public void setAssists(int assistInteger){
        this.assists = assistInteger;
    }
    public void setPenaltiesMinutes(int penaltiesMinutes){
        this.penaltiesMinutes = penaltiesMinutes;
    }
    public void setShotsOnGoals(int shotsOnGoalsInteger){
        this.shotsOnGoals = shotsOnGoalsInteger;
    }
    public void setGameWinningGoals(int gameWinningGoalsInteger){
        this.gameWinningGoals = gameWinningGoalsInteger;
    }

    public String getName(){
        return name;
    }
    public String getPosition(){
        return position;
    }
    public String getTeamName(){
        return teamName;
    }
    public int getGamesPlayed(){
        return gamesPlayed;
    }
    public int getGoalsScored(){
        return goalsScored;
    }
    public int getAssist(){
        return assists;
    }
    public int getPenaltiesMinutes(){
        return penaltiesMinutes;
    }
    public int getShotsOnGoals(){
        return shotsOnGoals;
    }
    public int getGameWinningGoals(){
        return gameWinningGoals;
    }  
}
