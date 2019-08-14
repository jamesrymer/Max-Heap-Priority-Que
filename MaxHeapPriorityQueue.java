import java.util.ArrayList;
/*
 * Used to store and modify all the Patients and where they are in the priority queue.

 */
public class MaxHeapPriorityQueue {
	ArrayList<Patient> heap = new ArrayList<>();
	int heapSize;
	/*
	 * The constructer that initializes the global variables
	 * and structures the ArrayList as a max heap.
	 */
	MaxHeapPriorityQueue(ArrayList<Patient> array){
		heap = array;
		heapSize = array.size() - 1;
		BuildMaxHeap();
	}
	/*
	 * Used to structure the global variable heap as a Max Heap.
	 */
	void BuildMaxHeap() {
		for( int i = heap.size()/2; i > 0; i--) {
			MaxHeapify(i);
		}
	}
	/*
	 * Sorts the global variable heap from the lowest priority to the highst priority.
	 */
	void HeapSort() {
		BuildMaxHeap();
		for(int i = heapSize; i > 1; i--) {
			swap(1,i);
			heapSize--;
			MaxHeapify(1);
		}
		heapSize = heap.size()-1;
	}
	/*
	 * Used to restore the Max-Heap structure of the global variable heap.
	 */
	private void MaxHeapify(int i) {
		int l = 2 * i;
		int r = 2 * i + 1;
		int largest = i;
		if(l <= heapSize && heap.get(l).getPriority() > heap.get(largest).getPriority()) {
			largest = l; 
		}
		if(r <= heapSize && heap.get(r).getPriority() > heap.get(largest).getPriority()) {
			largest = r; 
		}
		if (largest != i) {
			swap(i,largest);
			
			MaxHeapify(largest);
		}
	}
	/*
	 * Takes the patient with the highst priority, returns it, removes it from the Max-Heap,
	 * and restores the max heap structure of the global variable heap.
	 */
	Patient HeapExtractMax() {
		BuildMaxHeap();
		if(heapSize < 1) {
			return null;
		}
		Patient max = heap.get(1);
		heap.set(1, heap.get(heapSize));
		heapSize--;
		heap.remove(heapSize + 1);
		MaxHeapify(1);
		return max;
	}
	/*
	 * Returns the Patient with the highst priority.
	 */
	Patient HeapMaximum() {
		BuildMaxHeap();
		return heap.get(1);
	}
	/*
	 * Increases the priority of a patient at a specified index of the heap.
	 */
	void HeapIncreaseKey(int i, Patient key){
		BuildMaxHeap();
		if(key.getPriority() < heap.get(i).getPriority()) {
			
		}
		//heap.add(key);
		heap.set(i, key);
		while(i > 1 && heap.get(i/2).getPriority() < heap.get(i).getPriority()) {
			swap(i, i/2);
			i = i/2;
		}
	}
	/*
	 * Inserts a new patient into the heap and restructures it into a max heap.
	 */
	void MaxHeapInsert(Patient key) {
		Patient temp = new Patient(-1,key.getName());
		heapSize++;
		heap.add(heapSize, temp);
		HeapIncreaseKey(heapSize,key);
	}
	/*
	 * Returns the size of the heap.
	 */
	int getSize() {
		return heap.size();
	}
	/*
	 * Returns a patient at a specified index of the heap.
	 */
	Patient getPatientAtIndex(int i) {
		return heap.get(i);
	}
	/*
	 * Takes two positions of the heap and swaps the elements at those positions. 
	 */
	private void swap(int pos1, int pos2) {
		Patient temp = heap.get(pos1);
		heap.set(pos1, heap.get(pos2));
		heap.set(pos2, temp);
	}
	/*
	 * Returns a string representation of the data in this class.
	 */
	public String toString() {
		String str = "";
		if(heap.size() <= 1) {
			return "There are no Patients in the heap.";
		}
		for (int i = 1; i < heap.size(); i++) {
			if(i%5 == 0)
				str += "\n";
			str += i + ": " + heap.get(i);
			if(i != heap.size()-1)
				str += ", ";
		}
		str += "\n";
		return str;
	}
}
