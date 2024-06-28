package org.example.Trees;

public class AVL_Node<T extends Comparable<T>>{
    private T data;
    private AVL_Node<T> leftChild,rightChild;
    private int height = 1;

    public AVL_Node(T data) {
        this.data = data;
    }
    public AVL_Node(int i) {
        this.data = (T)data;
    }

    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AVL_Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVL_Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public AVL_Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVL_Node<T> rightChild) {
        this.rightChild = rightChild;
    }
}