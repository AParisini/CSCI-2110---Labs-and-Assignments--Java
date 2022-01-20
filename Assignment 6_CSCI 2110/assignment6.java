import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class assignment6{

    public static void main(String[] args) throws IOException{		
		
        Scanner input = new Scanner(System.in);	      

        File file = new File("input.txt"); 
        Scanner inputFile = new Scanner(file);     
        
        String number = inputFile.nextLine();
        int num = Integer.parseInt(number);
        inputFile.useDelimiter("\t");

                
        int[][] adj = new int[num][num]; //Setting up adjancecy graph
        while (inputFile.hasNext()){ 
            
            String v0s = inputFile.next();  
            String v1s = inputFile.nextLine();       
            
            int v0 = (v0s.charAt(0) - 65); 
            int v1 = (v1s.charAt(1) - 65);

            adj[v0][v1] = 1;               
        }

        inputFile.close();          
		input.close();     

        /*
        //OPTIONAL CODE FOR PRINTING OUT TEST CODE -- NO LETTERS

        for (int i = 0; i < num ; i++){
            for (int j = 0; j < num ; j++) {
                System.out.print(adj[i][j] + " ");                
            }
            System.out.println();            
        }
        */

        //Topological Sort

        Queue<Integer> topNum = new LinkedList<Integer>();

        ArrayList<Integer> top = new ArrayList<>();
        int[] inDegree = new int[num];
        int[] visited = new int[num];

        for (int i = 0; i < num; i++) {
            inDegree[i] = visited[i] = 0;            
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(adj[i][j] != 0){
                    inDegree[j] = inDegree[j] + 1;
                }                
            }            
        }
        
        for (int i = 0; i < num; i++) {
            if(inDegree[i] == 0){
                topNum.add(i);
                visited[i] = 1; 
            }            
        }

        while(topNum.peek() != null){
            int vertex = topNum.peek();
            topNum.poll();
            top.add(vertex);
            for (int j = 0; j < num; j++) {
                if(adj[vertex][j] == 1 && visited[j] == 0){
                    inDegree[j] = inDegree[j] - 1;
                    if(inDegree[j] == 0){
                        topNum.add(j);
                        visited[j] = 1;
                    }
                }                
            }
        }        

        System.out.println("Topological order: \n");

        for (int i : top) {            
            System.out.print(i + " ");
        }
    
    }
    
    
}