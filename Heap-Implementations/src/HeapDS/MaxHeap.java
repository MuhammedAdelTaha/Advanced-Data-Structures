package HeapDS;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> implements HeapInterface<T>{
    public void insert(T element){
        heapList.add(element);
        int childIdx = size() - 1, parentIdx = (int) Math.floor((childIdx - 1) / 2);
        while((heapList.get(parentIdx).hashCode() < heapList.get(childIdx).hashCode()) && (childIdx != 0)){
            swap(childIdx, parentIdx);
            childIdx = parentIdx;
            parentIdx = (int) Math.floor((childIdx - 1) / 2);
        }
    }
    public void delete(){
        if(isEmpty()) return;
        swap(0, size() - 1);
        heapList.remove(size() - 1);
        int parentIdx = 0, leftChildIdx = 1, rightChildIdx = 2, max;
        while(true){
            if(leftChildIdx >= size()){
                break;
            }
            else if(rightChildIdx >= size()){
                max = heapList.get(leftChildIdx).hashCode();
            }
            else{
                max = Math.max(heapList.get(leftChildIdx).hashCode(), heapList.get(rightChildIdx).hashCode());
            }
            if(parentIdx == size() - 1 || heapList.get(parentIdx).hashCode() > max) break;

            if(max == heapList.get(leftChildIdx).hashCode()){
                swap(parentIdx, leftChildIdx);
                parentIdx = leftChildIdx;
            }
            else {
                swap(parentIdx, rightChildIdx);
                parentIdx = rightChildIdx;
            }
            leftChildIdx = parentIdx * 2 + 1;
            rightChildIdx= parentIdx * 2 + 2;
        }
    }
}