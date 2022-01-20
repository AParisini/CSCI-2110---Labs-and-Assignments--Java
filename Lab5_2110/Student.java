/**
 * Andrew Parisini
 * B00805414
 * 2021-10-22
 * CSCI 2110 
 * 
 * Student Object constructor with getters and setters
 * 
 */

public class Student {

    private Integer intStudentID;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String faculty;

    public Student(Integer intStudentID, String firstName, String lastName, String email, String major, String faculty){

        this.intStudentID = intStudentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.faculty = faculty;

    }

    public void setIntStudentID(Integer intStudentID){
        this.intStudentID = intStudentID;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public void setFaculty(String faculty){
        this.faculty = faculty;
    }

    public int getIntStudentID(){
        return intStudentID;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getMajor(){
        return major;
    }

    public String getFaculty(){
        return faculty;
    }   

    public String toString(){
        String result = String.format( intStudentID +"   "+  firstName +" "+ lastName +"   "+ email +"   "+ major +"   "+ faculty + "\n");
        return result;
    }     
    
}
