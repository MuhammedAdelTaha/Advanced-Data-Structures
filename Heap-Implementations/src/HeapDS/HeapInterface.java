package HeapDS;

import java.util.ArrayList;

public interface HeapInterface <T extends Comparable<T>>{
    int size();
    int height();
    boolean contains(T element);
    T top();
    void clear();
    void print();
    //insertion takes O(lg(n)) time complexity
    void insert(T element);
    //deletion takes O(lg(n)) time complexity
    void delete();
}