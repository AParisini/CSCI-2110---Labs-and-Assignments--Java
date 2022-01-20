import java.util.*;
import java.io.*;

public class Huffman {    
    public static void main(String[] args)throws IOException{

        
        //STEP 1-4
        //gathering Inputs from LettersProbability.txt file
        
        Scanner in = new Scanner(System.in);                      
        File file = new File("LettersProbability.txt"); 
        Scanner inputFile = new Scanner(file); 
        StringTokenizer token;   
          
        
        //BinaryTree<Pair> tree = new BinaryTree<Pair>();
        BinaryTree<Pair> huffTree = new BinaryTree<Pair>();   
        Queue<BinaryTree<Pair>> S = new LinkedList<>();
        Queue<BinaryTree<Pair>> T = new LinkedList<>();            

        while (inputFile.hasNext()){ 

            String line = inputFile.nextLine(); 
            token = new StringTokenizer(line, "\t"); 
            String value = token.nextToken();
            String probability = token.nextToken();
            char character = value.charAt(0);
            Double prob = Double.valueOf(probability);

            Pair pair = new Pair(character, prob);
            BinaryTree<Pair> tree = new BinaryTree<Pair>();
            tree.setData(pair);
            
            
            S.add(tree); 
            
            line = inputFile.nextLine();      
        }


        huffTree = huffmTree(T, S);      

        //Encode
        System.out.println("Here’s the encoded line:");
        String[] strArrayCoded = new String[26];
        strArrayCoded = findEncoding(huffTree);
        for (int i = 0; i < strArrayCoded.length; i++) {
            System.out.print(strArrayCoded[i]);            
        }

        inputFile.close();
             
        
        //STEP 5 -- USER INPUT

        StringBuilder sb = new StringBuilder();
        
        System.out.println("Enter a line of text (uppercase letters only): ");
        String input = in.nextLine();   
        
        
        for (int index = 0; index < input.length(); index++) {
           int ascii = input.charAt(index);
            int asciiMatching = ascii -65;
            if(input.charAt(index) == ' '){
                sb.append(" ");
            }
            else{
                sb.append(strArrayCoded[asciiMatching]);
            }
        }


        //Decode
        while (sb != null){
            sb.substring(decode(strArrayCoded, sb));              
        }               
          

        //Output
        System.out.println("The decoded line is:"); 
        System.out.println(sb);
                        
           
        in.close();
}

       
    /**
     * 
     * @param encoded
     * @param huff
     */
    public static int decode (String[] encoded, StringBuilder sb){

       for (int i = 0; i < 26; i++) {
           String result = sb.substring(0,i);   
           
           for (int j = 0; j < encoded.length; j++) {

            if(encoded[j].equals(result)){                
                return result.length();
            }           
               
           }
       }
       return sb.length();   
        
    }  


    public static BinaryTree<Pair> findSmallestBT(Queue<BinaryTree<Pair>> S, Queue<BinaryTree<Pair>> T){
        
        BinaryTree<Pair> smallest = new BinaryTree<>();
        if(T.peek() == null){
            smallest = S.poll();
        }
        else{
            
            //Find the smallest of two
            double x = S.peek().getData().getProb();
            double y = T.peek().getData().getProb();                
            if(x < y){
                smallest = S.poll();
            }
            else{
                smallest = T.poll();
            } 
        }           
            
    return smallest;
    }

    /**
     * 
     * @param T
     * @param S
     * @return
     */
    public static BinaryTree<Pair> huffmTree( Queue<BinaryTree<Pair>> T, Queue<BinaryTree<Pair>> S){

        BinaryTree<Pair> A = new BinaryTree<>();
        BinaryTree<Pair> B = new BinaryTree<>();

        while(S.peek() != null ){ 

            if(T.peek() == null){
                A = S.poll();
                B = S.poll();           
            }
            else if (T.peek() != null){    
    
                A = findSmallestBT(S, T);

                if(T.peek() != null){
                    B = findSmallestBT(S, T);
                }

            }

            BinaryTree<Pair> P = new BinaryTree<Pair>();
            double AValue = A.getData().getProb();
            double BValue = B.getData().getProb();                  
            double totalAB = AValue + BValue; 
            char x = 'X';     // Dummy name for Tree Node      
            
            Pair X = new Pair( x, totalAB);            
            
            P.setData(X);            
            P.attachLeft(A);
            P.attachRight(B);

            T.add(P);
        }

        while(T.size() > 1){

            A = T.poll();
            B = T.poll();

            BinaryTree<Pair> P = new BinaryTree<Pair>();
            double AValue = A.getData().getProb();
            double BValue = B.getData().getProb();
            
            double totalAB = AValue + BValue; 
            char x = 'X';     // Dummy name for Tree Node      
            
            Pair X = new Pair( x, totalAB);            
            
            P.setData(X);
            P.attachLeft(A);
            P.attachRight(B);

            T.add(P);
        }        

        return T.poll();
    }


    private static String[] findEncoding(BinaryTree<Pair> bt){  
        String[] result = new String[26];
        findEncoding(bt, result, "");
        return result; 
    }  
    private static void findEncoding(BinaryTree<Pair> bt, String[] a, String prefix){    
    // test is node/tree is a leaf 
        if (bt.getLeft()==null && bt.getRight()==null){
            a[bt.getData().getValue() - 65] = prefix;     
        } 
    // recursive calls 
        else{  
            findEncoding(bt.getLeft(), a, prefix+"0");
            findEncoding(bt.getRight(), a, prefix+"1"); 
        }
    }   
}
