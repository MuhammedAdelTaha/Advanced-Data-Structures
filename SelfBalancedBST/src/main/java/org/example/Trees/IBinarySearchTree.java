package org.example.Trees;

public interface IBinarySearchTree<T extends Comparable<T>> {
    public boolean insert(T element);
    public boolean delete(T element);
    public boolean search(T element);
    public int size();
    public int height();
}