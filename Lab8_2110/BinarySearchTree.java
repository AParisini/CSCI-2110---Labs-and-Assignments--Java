
/**
 * Generic Binary Search Tree Class
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>>{
    // declare required fields
	private BinaryTree<T> tree;
	private int size;

    /**
    Constructor 1
    No arg constructor
    */
    public BinarySearchTree(){
		tree = new BinaryTree<T>();
		size=0;
	}

	public BinaryTree<T> getTree(){
		return tree;
	}

	public boolean isEmpty(){
		return tree.isEmpty();
	}

	public int size(){
		return size;
	}

	public BinaryTree<T> search(T key){
		BinaryTree<T> t = tree;

        if (isEmpty()) return null;

        while (t!=null){
			if (key.compareTo(t.getData())<0)
				t = t.getLeft();
			else if (key.compareTo(t.getData())>0)
				t = t.getRight();
			else // key is found
				return t;
		}
        return null;
	}

	public void insert(T item){
        //initialize new BT and sets left, right, parent and data to null
		BinaryTree<T> newNode = new BinaryTree<T>();
		newNode.setData(item);

		if (size==0){
            tree = newNode;
            size++;
            return;
        }

		BinaryTree<T> t = tree;
		boolean done = false;

        while (!done){
			int c = item.compareTo(t.getData());
			if (c==0){
				System.out.println("Duplicate key. Can't insert");
				return;
			}
            //need to go left
			else if (c<0){
                //place to insert found
				if (t.getLeft()==null){
					t.setLeft(newNode);
					newNode.setParent(t);
					size++;
					done = true;
				}
				else
                    //otherwise go left one branch
					t = t.getLeft();
			}
            //c>0; need to go right
			else{
                //place to insert found
				if (t.getRight()==null){
					t.setRight(newNode);
					newNode.setParent(t);
					size++;
					done=true;
				}
				else
					t = t.getRight();
			}	
		}
	}

	public BinaryTree<T> findPredecessor(BinaryTree<T> node){
		if (node==null)
            return null;

		if (node.getLeft()==null)
            return null;

		BinaryTree<T> pred = node.getLeft();

        while (pred.getRight()!=null)
			pred = pred.getRight();

        return pred;
	}

	public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach){
		if (deleteNode==null)
            return;

		BinaryTree<T> parent = deleteNode.getParent();

		if (parent == null)
            return;

        if (attach == null){
			if (parent.getLeft()==deleteNode)
				parent.setLeft(null);
			else
				parent.setRight(null);
			return;
		}

        if (deleteNode==parent.getRight()){
			parent.detachRight();
			deleteNode.setParent(null);
			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachRight(attach);
			attach.setParent(parent);
		}
		else{
			parent.detachLeft();
			deleteNode.setParent(null);

			//attach.setParent(parent);
			attach.setParent(null);
			parent.attachLeft(attach);
			attach.setParent(parent);
		}

		deleteNode.clear();
	}

	public void delete(T key){
		if (size==0){
            System.out.println("Can't delete. Empty tree");
            return;}

		BinaryTree<T> deleteNode = search(key);

        if (deleteNode==null){
            System.out.println("Key not found. Can't delete");
            return;
        }

		BinaryTree<T> hold = null;
		if (deleteNode.getLeft()==null && deleteNode.getRight()==null){
			deleteHere(deleteNode, null);
		}
		else if (deleteNode.getLeft()==null){
			hold = deleteNode.getRight();
			deleteHere(deleteNode, hold);
		}
        else if (deleteNode.getRight()==null){
			hold = deleteNode.getLeft();
			deleteHere(deleteNode, hold);
		}
		else{
			hold = findPredecessor(deleteNode);
			deleteNode.setData(hold.getData());
			deleteNode=hold;
			deleteHere(deleteNode, deleteNode.getLeft());
		}

		size--;
	}

	/**
	 * Finds max value of BST
	 * @return Max value of BST
	 */
    public T findMax(){

		BinaryTree<T> current = getTree().root();
		while(current.getRight() != null){
			current = current.getRight();
		}
		return current.getData();		
			
    }

	/**
	 * Finds min value of BST
	 * @return Min value of BST
	 */
    public T findMin(){
		BinaryTree<T> current = getTree().root();
		while(current.getLeft() != null){
			current = current.getLeft();
		}
		return current.getData();
    }

    //Helper method to search the tree of this class
    public BinaryTree<T> recursiveSearch(T key){
        return recursiveSearch(this.getTree(),key);
    }

	/**
	 * Recursive search of BST to find key - returns message if found or not found
	 * @param t BinaryTree
	 * @param key requested key to find
	 * @return returns binaryTree 
	 */
    public BinaryTree<T> recursiveSearch(BinaryTree<T> t, T key) {

		if(t == null || t.getData() == null){
			System.out.println("Key not Found");
			return t;
		}
		
		if(key.compareTo(t.getData()) ==  0){
			System.out.println("Found!");
			return t;
		}
		//Tell which way it should look
		if (key.compareTo(t.getData()) < 0){
				t = t.getLeft();
				 return recursiveSearch(t,key);
		}
		else if (key.compareTo(t.getData()) > 0){
			t = t.getRight();
			return recursiveSearch(t, key);
		}
		return null;

    }
}
