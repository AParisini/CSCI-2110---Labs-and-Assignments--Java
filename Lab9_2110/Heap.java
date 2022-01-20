import java.util.ArrayList;
import java.util.Collections;

public class Heap<T extends Comparable<T>>{
	private ArrayList<T> heapList;
	public Heap(){
		heapList = new ArrayList<T>();
	}
	public int size(){
		return heapList.size();
	}
	public boolean isEmpty(){
		return (size()==0);
	}
	public void clear(){
		heapList.clear();
	}

	public void enumerate(){
		System.out.println(heapList);
	}

	public void add(T item)
	{
		heapList.add(item);
		
		int index = heapList.size()-1;
		int pindex = (index-1)/2;
		T parent = heapList.get(pindex);

		while (index >0 && item.compareTo(parent)>0)
		{
			heapList.set(index, parent);
			heapList.set(pindex, item);
			index = pindex;
			pindex = (index-1)/2;
			parent = heapList.get(pindex);
		}
	}
	/**
	 * Linear search of finding minimum key
	 * O(n)
	 * @return item with minimum
	 */
	public T findMin(){
		T min = heapList.get(0);
		
		for (int i = 0; i < heapList.size(); i++) {
			if(min.compareTo(heapList.get(i)) > 0){
				min = heapList.get(i);
			}
		}
		return min;				
	}	

	/**
	 * Replaces key1 with key2
	 * Process first finds if its found, if it is, creates a temp Heap to store new values, and then heaplist gets replaced, using add to sort as it goes
	 * O(n) 
	 * @param key1 User key to be replaced
	 * @param key2 New key
	 */
	public void replace (T key1, T key2){
		
		boolean found = false;

		for (int i = 0; i < heapList.size(); i++) {
			if((heapList.get(i).compareTo(key1) == 0)){
				heapList.set(i, key2);
				found = true;
				break;
			}						
		}

		if(found == false){
			System.out.println("Key " + key1 + " not Found");
				return;
		}

		//Makes a copy of heapList with key replaced

		ArrayList<T> copy = new ArrayList<T>();
		for (int i = 0; i < heapList.size(); i++) {
			copy.add(heapList.get(i));			
		}

		heapList.clear();

		//Readds to heapList, making use of add algorithim in add()

		for (int i = 0; i < copy.size(); i++) {
			add(copy.get(i));			
		}

		System.out.println("The new heap is: ");
        enumerate();
		
		
	}

	public T deleteMax(){
		if (isEmpty()){
			System.out.println("Heap is empty");
			return null;
		}
		else {
			T ret = heapList.get(0); //item to be removed is in root
			T item = heapList.remove(heapList.size()-1); //remove the last item
			if (heapList.size()==0)
				return ret;

			heapList.set(0, item); //set the root with the last item
			int index, lIndex, rIndex, maxIndex;
			T maxChild;
			boolean found = false;
			index = 0;
			lIndex = index*2 +1;
			rIndex = index*2 +2;

			while (!found)
			{
				//case 1: Node has two children
				if (lIndex<size()&&rIndex<size())
				{
					if (heapList.get(lIndex).compareTo(heapList.get(rIndex))>0)
					{
						maxChild = heapList.get(lIndex);
						maxIndex = lIndex;
					}
					else
					{
						maxChild = heapList.get(rIndex);
						maxIndex = rIndex;
					}
				
					if (item.compareTo(maxChild)<0)
					{
						heapList.set(maxIndex, item);
						heapList.set(index, maxChild);
						index = maxIndex;
					}
					else
						found = true;
				}
				else if (lIndex<size())
				{
					if (item.compareTo(heapList.get(lIndex))<0)
					{
                        T temp = heapList.get(lIndex);
						heapList.set(lIndex, item);
						heapList.set(index, temp);
						index = lIndex;
					}
					else	
						found = true;
				}
		
				else
						found = true;

				lIndex = index*2+1;
				rIndex = index*2+2;
			}
			return ret;
		}
	}

	/**
	 * Helper method to swap two indexes of an ArrayList
	 * @param indexA
	 * @param indexB
	 */
	public void swap (int indexA , int indexB){
		
		Collections.swap(heapList, indexA, indexB);

	}	

	public void siftDown(int smallest){

		int currentIndex = smallest;

		int left = 2*currentIndex + 1;
		int right = 2*currentIndex + 2;

		if(left < heapList.size() && (heapList.get(smallest).compareTo(heapList.get(left)) > 0)){
			smallest = left;
		}
		if(right < heapList.size() && (heapList.get(smallest).compareTo(heapList.get(right)) > 0)){
			smallest = right;
		}
		if( smallest != currentIndex){
			swap(currentIndex, smallest);
			siftDown(smallest);			
		}

	}
}
