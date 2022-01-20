/**
 * Andrew Parisini
 * B00805414
 * 2021-10-22
 * CSCI 2110 
 * 
 * Student Demo reads the file "StudentRecordList.txt" makes an object of each student
 * HARDCODED as specified; Runs several commands and prints results
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentListDemo {
    public static void main(String[] args)throws IOException{       


        StudentList studentList = new StudentList();        

        //Reading file
 
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the filename to read from: "); 
        //StudentRecordList.txt
        String filename = keyboard.nextLine(); 
 
        File file = new File(filename); 
        Scanner inputFile = new Scanner(file); 
        StringTokenizer token; 
        while (inputFile.hasNext()){ 
            String line = inputFile.nextLine(); 
            token = new StringTokenizer(line, " "); 
            String studentID = token.nextToken(); 
            String firstName = token.nextToken(); 
            String lastName = token.nextToken();
            String email = token.nextToken();
            String major = token.nextToken();
            String faculty = token.nextToken();            

            //Convert applicable Strings to Integers

            Integer studentIDInteger = Integer.valueOf(studentID);
        

            Student student = new Student(studentIDInteger, firstName, lastName, email, major, faculty);
            studentList.addRecord(student);
            
        }   
        inputFile.close();
        keyboard.close();

         //Outputs     
        
        System.out.printf("\n");
         
        System.out.println("The Student List contains the following entries: ");

        studentList.print();  
        System.out.printf("\n");
        
        System.out.println("These students are majoring in Music: ");

        studentList.displayMajors("Music");
        System.out.printf("\n");

        System.out.println("These students are majoring in Science: ");

        studentList.displayFaculty("Science");
        System.out.println("\n");

        System.out.println("Find the record for the student with ID '200128': ");

        studentList.searchID(200128);
        System.out.println("\n");
        
        System.out.println("Find the record for the student with the name 'Mike Williams': ");

        studentList.displayName("Williams");
        System.out.println("\n");

        System.out.println("Find the record for the student with the email 'apage@email.com': ");

        studentList.displayEmail("apage@email.com");
        System.out.println("\n");

        System.out.println("Remove 5 students from the record: ");
        System.out.println("\n");

        //Find 5 students (first 5 from list) and remove from list ID starting at 200120 
        //print list afterwards

        int count = 5;
        for (int i = 0; i < count; i++) {
            studentList.deleteRecord(200120 + i);           
            
        }
        studentList.print();

        





 
             
     
     




    }   

    
    
}
