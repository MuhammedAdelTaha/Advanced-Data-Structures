package org.example.Trees;

public class AVL_Tree<T extends Comparable<T>> implements IBinarySearchTree<T> {

    private AVL_Node<T> root;
    private int size = 0;

    public T getRoot(){
        return root.getData();
    }

    @Override
    public boolean insert(T element) {
        if (search(element))
            return false;

        root = insert(element, root);
        size++;
        return true;
    }

    @Override
    public boolean delete(T element) {
        if (!search(element))
            return false;

        root = delete(element, root);
        size--;
        return true;
    }

    @Override
    public boolean search(T element) {
        return search(element, root);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return height(root);
    }

    private AVL_Node<T> insert(T data, AVL_Node<T> node) {
        if (node == null)
            return new AVL_Node<>(data);

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, node.getRightChild()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private AVL_Node<T> delete(T data, AVL_Node<T> node) {
        if (node == null)
            return null;

        if (data.compareTo(node.getData()) < 0)
            node.setLeftChild(delete(data, node.getLeftChild()));
        else if (data.compareTo(node.getData()) > 0)
            node.setRightChild(delete(data, node.getRightChild()));
        else {
            // on child or no children
            if (node.getLeftChild() == null)
                return node.getRightChild();
            else if (node.getRightChild() == null)
                return node.getLeftChild();

            // Two children
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild((delete(node.getData(), node.getLeftChild())));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private AVL_Node<T> applyRotation(AVL_Node<T> node) {
        int balance = balanceFactor(node);

        if (balance > 1) {
            if (balanceFactor(node.getLeftChild()) < 0)
                node.setLeftChild(rotateLeft(node.getLeftChild()));

            return rotateRight(node);
        }

        if (balance < -1) {
            if (balanceFactor(node.getRightChild()) > 0)
                node.setRightChild(rotateRight(node.getRightChild()));

            return rotateLeft(node);
        }

        return node;
    }

    private AVL_Node<T> rotateRight(AVL_Node<T> node) {
        AVL_Node<T> leftChild = node.getLeftChild();

        node.setLeftChild(leftChild.getRightChild());
        leftChild.setRightChild(node);

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    private AVL_Node<T> rotateLeft(AVL_Node<T> node) {
        AVL_Node<T> rightChild = node.getRightChild();

        node.setRightChild(rightChild.getLeftChild());
        rightChild.setLeftChild(node);

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    private void updateHeight(AVL_Node<T> node) {
        int leftChildHeight = height(node.getLeftChild());
        int rightChildHeight = height(node.getRightChild());
        node.setHeight(Math.max(leftChildHeight, rightChildHeight) + 1);
    }

    private int balanceFactor(AVL_Node<T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private boolean search(T element, AVL_Node<T> root) {
        if (size == 0)
            return false;

        if (element.compareTo(root.getData()) > 0) {
            if (root.getRightChild() == null)
                return false;

            return search(element, root.getRightChild());
        } else if (element.compareTo(root.getData()) < 0) {
            if (root.getLeftChild() == null)
                return false;

            return search(element, root.getLeftChild());
        }

        return true;
    }

    private int height(AVL_Node<T> node) {
        return node != null ? node.getHeight() : 0;
    }

    private T getMax(AVL_Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }
}