import HeapDS.Heap;
import HeapDS.MaxHeap;
import HeapDS.MinHeap;

import java.util.ArrayList;

//Heap Sort algorithm takes O(lg(n)) time complexity
public class HeapSort<T extends Comparable<T>> {
    private void heapSort(ArrayList<T> elements, Heap<T> heapList){
        if(elements.isEmpty()) return;
        for(int i = 0; i < elements.size(); i++){
            heapList.insert(elements.get(i));
        }
        elements.clear();
        while(!heapList.isEmpty()){
            elements.add(heapList.top());
            heapList.delete();
        }
    }
    public void ascendingHeapSort(ArrayList<T> elements){
        heapSort(elements, new MinHeap<>());
    }
    public void descendingHeapSort(ArrayList<T> elements){
        heapSort(elements, new MaxHeap<>());
    }
}
