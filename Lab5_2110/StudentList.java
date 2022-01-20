/**
 * Andrew Parisini
 * B00805414
 * 2021-10-22
 * CSCI 2110 
 * 
 * Student List functions
 * parameters have been hardcoded as specified form lab
 * 
 */

public class StudentList {

    private List<Student> list;

    public StudentList(){
        list = new List<Student>();
    }
    
    /**
     * adds the student to the linked list
     * @param s student object
     */
    public void addRecord(Student s){
        list.add(s);
    }

    /**
     * deletes the student object whose ID matched the parameter
     * @param ID Student ID that was chosen to be removed
     */
    public void deleteRecord(int ID){

        Student current = list.first();
        while(current != null){
            if(current.getIntStudentID() == ID){
                list.remove(current);
                break;
            } 
            current = list.next();           
        }     
    }

    /**
     * displays all students who have the specified major
     * @param major major as specified from main method (HARDCODED)
     */
    public void displayMajors(String major){
        
        Student current = list.first();
        while(current != null){
            if(current.getMajor().equals(major)){
                System.out.println(current.toString());
            } 
            current = list.next();           
        }
    }
    
    /**
     * displays the studnets under the specified faculty
     * @param faculty faculty that was specified from the main method (HARDCODED)
     */
    public void displayFaculty(String faculty){
        
        Student current = list.first();
        while(current != null){
            if(current.getFaculty().equals(faculty)){
                System.out.println(current.toString());
            } 
            current = list.next();           
        }
    }

    /**
     * displays the students whose last names match
     * @param lastName last anme specified from main method (HARDCODED)
     */
    public void displayName(String lastName){
        
        Student current = list.first();
        while(current != null){
            if(current.getLastName().equals(lastName)){
                System.out.println(current.toString());
            } 
            current = list.next();           
        }
    }

    /**
     * returns the student who has the matching ID number
     * @param ID Student ID as specified from main method (HARDCODED)
     * @return returns student object, null if there is no match or incoming int is null
     */
    public Student searchID(int ID){      
        
        Student current = list.first();
        while(current != null){
            if(current.getIntStudentID() ==  ID){
                System.out.println(current.toString());
                return current;
            } 
            current = list.next();           
        }
        return null;
    }    

    /**
     * prints out anyn students wiht the specified email
     * @param email email as specified from main method (HARDCODED)
     */
    public void displayEmail(String email){      
        
        Student current = list.first();
        while(current != null){
            if(current.getEmail().equals(email)){
                System.out.println(current.toString());
            } 
            current = list.next();           
        }        
    }

    /**
     * prints the entire linked list of students
     */
    public void print(){
        Student current = list.first();
        while(current != null){
            System.out.println(current.toString());
            current = list.next();           
        }
    }   
    
}
