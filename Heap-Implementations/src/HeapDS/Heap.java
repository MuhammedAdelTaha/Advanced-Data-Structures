package HeapDS;

import java.util.ArrayList;

public class Heap <T extends Comparable<T>> implements HeapInterface<T>{
    //insert, delete, top, clear, size, height, contains, print
    protected ArrayList<T> heapList = new ArrayList<>();
    private double lg(int num){
        return Math.log(num) / Math.log(2);
    }
    protected void swap(int idx1, int idx2){
        T temp = heapList.get(idx1);
        heapList.set(idx1, heapList.get(idx2));
        heapList.set(idx2, temp);
    }
    public boolean isEmpty(){
        return heapList.isEmpty();
    }
    @Override
    public int size(){
        return heapList.size();
    }
    @Override
    public int height(){
        return (isEmpty() ? 0 : (int) Math.ceil(this.lg(size() + 1) - 1));
    }
    @Override
    public boolean contains(T element){
        return heapList.contains(element);
    }
    @Override
    public T top(){
        return (isEmpty() ? null : (heapList.get(0)));
    }
    @Override
    public void clear(){
        heapList.clear();
    }
    @Override
    public void print(){
        System.out.println(heapList);
    }
    @Override
    public void insert(T element) {}
    @Override
    public void delete() {}
}