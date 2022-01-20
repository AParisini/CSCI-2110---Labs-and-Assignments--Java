import java.util.ArrayList;
import java.util.Scanner;

import lab9.BinaryTree;

public class Exercise2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        BinaryTree<String> tree = new BinaryTree<String>();

        ArrayList<String> first = new ArrayList<String>();

        System.out.println("Enter name or done: ");

        String input = in.nextLine();           
        while(!input.equals("done")){                                  

            first.add(input);  
            System.out.println("Enter name or done: ");  
            input = in.nextLine();         
        }      

        tree.makeRoot(first.get(0));

        //Attaching

        for (int i = 1; i < first.size(); i++) { 
            
            insert(tree, first.get(i));
            
        }


        //Outputs

        System.out.printf("Height of the tree is: %d\n", BinaryTree.height(tree));

		System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.nodes(tree));

		System.out.println();

		System.out.print("Inorder:\t");
		BinaryTree.inorder(tree);
		System.out.println();

		System.out.print("Preorder:\t");
		BinaryTree.preorder(tree);
		System.out.println();

		System.out.print("Postorder:\t");
		BinaryTree.postorder(tree);
		System.out.println();

		System.out.print("Level order:\t");
		BinaryTree.levelOrder(tree);
		System.out.println();
		System.out.println();

        in.close();
    }
    


        
    public static void insert(BinaryTree<String> tree, String input){        
        
        if ( input.compareTo(tree.getData()) < 1) {  
            if (tree.getLeft() != null) {               
                insert(tree.getLeft(), input);      
            }else {
                tree.attachLeft(tree);  
                return;               
            }

        }else {                                        
            if (tree.getRight() != null) {              
                insert(tree.getRight(), input);                      
            }else {
                tree.attachRight(tree);   
                return;
            }
        }
    }
}
