/**
 * CSCI 2110 Lab3
 * #author: Andrew Parisini-Principi
 * #description: StudentRecord class for Exercise 3
 * StudentRecord functions
 */

public class StudentRecord {
    
    private String firstName;
    private String lastName;
    private Integer bannerID;

    public StudentRecord(String firstName, String lastName, int bannerID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.bannerID = bannerID;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastname(String lastname){
        this.lastName = lastname;
    }
    public void setBannerID(int bannerID){
        this.bannerID = bannerID;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getBannerID(){
        return bannerID;
    }


    
}
