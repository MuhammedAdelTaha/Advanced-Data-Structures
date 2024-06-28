import HeapDS.Heap;
import HeapDS.MaxHeap;

import java.util.ArrayList;

public class Main<T> {

    public static void main(String[] args) {
        Heap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(50);
        maxHeap.insert(30);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(8);
        maxHeap.insert(16);
        maxHeap.insert(520);
        maxHeap.insert(300);
        maxHeap.insert(2021);
        maxHeap.insert(115);
        maxHeap.insert(0);
        maxHeap.insert(18);
        maxHeap.insert(156);
        maxHeap.print();
        for(int i = 0; i < 15; i++){
            maxHeap.delete();
            maxHeap.print();
        }

        System.out.println("-------------------------------------------------------------------------------------");

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(50); arrayList.add(50); arrayList.add(20); arrayList.add(15);
        arrayList.add(10); arrayList.add(8); arrayList.add(16); arrayList.add(520); arrayList.add(300);
        arrayList.add(2021); arrayList.add(115); arrayList.add(0); arrayList.add(18); arrayList.add(156);

        //heapify
        Heapify<Integer> heapify = new Heapify<>();
        System.out.println(heapify.maxHeapify(arrayList));
        System.out.println(heapify.minHeapify(arrayList));

        System.out.println("-------------------------------------------------------------------------------------");

        //heap sort
        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.ascendingHeapSort(arrayList);
        System.out.println(arrayList);
        heapSort.descendingHeapSort(arrayList);
        System.out.println(arrayList);
    }
}