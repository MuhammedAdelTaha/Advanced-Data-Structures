import java.util.ArrayList;
import java.util.Objects;

//heapify algorithm takes O(n) time complexity
public class Heapify<T extends Comparable<T>> {
    private void swap(ArrayList<T> elements, int idx1, int idx2){
        T temp = elements.get(idx1);
        elements.set(idx1, elements.get(idx2));
        elements.set(idx2, temp);
    }
    private ArrayList<T> heapify(ArrayList<T> elements, String type){
        if (elements.isEmpty()) return null;
        int size = elements.size();
        for (int i = elements.size() - 1; i >= 0; i--) {
            int parentIdx = i, leftChildIdx = i * 2 + 1, rightChildIdx = i * 2 + 2, compare;
            while (true) {
                if (leftChildIdx >= size) {
                    break;
                } else if (rightChildIdx >= size) {
                    compare = elements.get(leftChildIdx).hashCode();
                } else {
                    compare = (Objects.equals(type, "max") ?
                            Math.max(elements.get(leftChildIdx).hashCode(), elements.get(rightChildIdx).hashCode()) :
                            Math.min(elements.get(leftChildIdx).hashCode(), elements.get(rightChildIdx).hashCode()));
                }
                if(Objects.equals(type, "max")){
                    if (parentIdx == size - 1 || elements.get(parentIdx).hashCode() > compare) break;
                }
                else if(Objects.equals(type, "min")){
                    if (parentIdx == size - 1 || elements.get(parentIdx).hashCode() < compare) break;
                }

                if (compare == elements.get(leftChildIdx).hashCode()) {
                    swap(elements, parentIdx, leftChildIdx);
                    parentIdx = leftChildIdx;
                } else {
                    swap(elements, parentIdx, rightChildIdx);
                    parentIdx = rightChildIdx;
                }
                leftChildIdx = parentIdx * 2 + 1;
                rightChildIdx = parentIdx * 2 + 2;
            }
        }
        return elements;
    }
    public ArrayList<T> maxHeapify(ArrayList<T> elements) {
        return heapify(elements, "max");
    }
    public ArrayList<T> minHeapify(ArrayList<T> elements) {
        return heapify(elements, "min");
    }
}
