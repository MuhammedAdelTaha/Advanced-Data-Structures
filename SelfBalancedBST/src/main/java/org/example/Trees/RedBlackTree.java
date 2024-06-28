package org.example.Trees;

public class RedBlackTree<T extends Comparable<T>> implements IBinarySearchTree<T> {
    
    private class RB_Node {
        private enum Colour {
            red, black
        }

        private T data;
        private Colour colour = Colour.red;
        private RB_Node left = nil; 
        private RB_Node right = nil;
        private RB_Node parent = null;
    
        RB_Node(T data) {
            this.data = data;
        }

        RB_Node(Colour colour) {
            this.colour = colour;
        }
    }

    private RB_Node root;
    private RB_Node nil = new RB_Node(RedBlackTree.RB_Node.Colour.black);
    private int size;

    public T getRoot(){
        return root.data;
    }

    @Override
    public boolean insert(T element) {
        if (search(element))
            return false;

        insert(element, root);
        // log();
        return true;
    }

    @Override
    public boolean delete(T element) {
        if (!search(element))
            return false;

        delete(element, root);
        // log();
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

    private void insert(T element, RB_Node root) {
        if (size == 0) {
            RB_Node newNode = new RB_Node(element);
            newNode.colour = RedBlackTree.RB_Node.Colour.black;
            this.root = newNode;
            size++;
            return;
        }
        
        if (element.compareTo(root.data) > 0) {
            if (root.right == nil) {
                RB_Node newNode = new RB_Node(element);
                root.right = newNode;
                newNode.parent = root;
                size++;
                insertUpdate(newNode);
            }
            else {
                insert(element, root.right);
            }
        }
        else if (element.compareTo(root.data) < 0) {
            if (root.left == nil) {
                RB_Node newNode = new RB_Node(element);
                root.left = newNode;
                newNode.parent = root;
                size++;
                insertUpdate(newNode);
            }
            else {
                insert(element, root.left);
            }
        }
    }

    private void delete(T element, RB_Node root) {
        if (element.compareTo(root.data) > 0)
            delete(element, root.right);
        else if (element.compareTo(root.data) < 0)
            delete(element, root.left);
    
        else {
            //children are both nil
            if (root.right == nil && root.left == nil) {
                if (root == this.root) {
                    this.root = null;
                    size--;
                    return;
                }

                if (root.colour == RedBlackTree.RB_Node.Colour.black)
                    deleteUpdate(root); // resolve double black

                if (root == root.parent.left)
                    root.parent.left = nil;
                else
                    root.parent.right = nil;

                size--;
                return;
            }
            
            // has at least one child
            RB_Node replacementNode;
            if (root.left != nil) {
                replacementNode = root.left;
                while (replacementNode.right != nil)
                    replacementNode = replacementNode.right;

                root.data = replacementNode.data;
                delete(replacementNode.data, root.left);
                return;
            }
            else {
                replacementNode = root.right;
                while (replacementNode.left != nil)
                    replacementNode = replacementNode.left;

                root.data = replacementNode.data;
                delete(replacementNode.data, root.right);
                return;
            }
        }
    }

    private boolean search(T element, RB_Node root) {
        if (size == 0)
            return false;
        
        if (element.compareTo(root.data) > 0) {
            if (root.right == nil)
                return false;

            return search(element, root.right);
        }
        else if (element.compareTo(root.data) < 0) {
            if (root.left == nil)
                return false;

            return search(element, root.left);
        }

        return true;
    }

    private void insertUpdate(RB_Node node) {
        if (node == root || node.parent.colour == RedBlackTree.RB_Node.Colour.black)
            return;

        RB_Node uncle;
        if (node.parent == node.parent.parent.left) {
            uncle = node.parent.parent.right;
        }
        else {
            uncle = node.parent.parent.left;
        }

        //uncle is red
        if (uncle.colour == RedBlackTree.RB_Node.Colour.red) {
            node.parent.parent.colour = RedBlackTree.RB_Node.Colour.red;
            node.parent.colour = RedBlackTree.RB_Node.Colour.black;
            uncle.colour = RedBlackTree.RB_Node.Colour.black;
            root.colour = RedBlackTree.RB_Node.Colour.black;
            insertUpdate(node.parent.parent);
            return;
        }

        // uncle is black
        if (node.parent == node.parent.parent.left && node == node.parent.left) { // left left
            node.parent.colour = RedBlackTree.RB_Node.Colour.black;
            node.parent.parent.colour = RedBlackTree.RB_Node.Colour.red;
            rightRotate(node.parent.parent);
        }
        else if (node.parent == node.parent.parent.left && node == node.parent.right) { // left right
            leftRotate(node.parent);
            node.colour = RedBlackTree.RB_Node.Colour.black;
            node.parent.colour = RedBlackTree.RB_Node.Colour.red;
            rightRotate(node.parent);
        }
        else if (node.parent == node.parent.parent.right && node == node.parent.right) { // right right
            node.parent.colour = RedBlackTree.RB_Node.Colour.black;
            node.parent.parent.colour = RedBlackTree.RB_Node.Colour.red;
            leftRotate(node.parent.parent);
        }
        else if (node.parent == node.parent.parent.right && node == node.parent.left) { // right left
            rightRotate(node.parent);
            node.colour = RedBlackTree.RB_Node.Colour.black;
            node.parent.colour = RedBlackTree.RB_Node.Colour.red;
            leftRotate(node.parent);
        }
    }

    private void deleteUpdate(RB_Node node) {
        if (node == root)
            return;
        
        RB_Node sibling;
        if (node == node.parent.right)
            sibling = node.parent.left;
        else
            sibling = node.parent.right;

        // sibling is red
        if (sibling.colour == RedBlackTree.RB_Node.Colour.red) {
            if (node == node.parent.right)
                rightRotate(node.parent);
            else
                leftRotate(node.parent);
            
            sibling.colour = RedBlackTree.RB_Node.Colour.black;
            node.parent.colour = RedBlackTree.RB_Node.Colour.red;
            root.colour = RedBlackTree.RB_Node.Colour.black;

            deleteUpdate(node);
            return;
        }

        // sibling is black
        // both sibling's children are black
        if (sibling.left.colour == RedBlackTree.RB_Node.Colour.black && sibling.right.colour == RedBlackTree.RB_Node.Colour.black) {
            sibling.colour = RedBlackTree.RB_Node.Colour.red;

            if (node.parent.colour == RedBlackTree.RB_Node.Colour.red)
                node.parent.colour = RedBlackTree.RB_Node.Colour.black;
            else
                deleteUpdate(node.parent); // resolve parent double black
            return;
        }
        
        RB_Node nearChild, farChild;
        if (node == node.parent.right) {
            nearChild = sibling.right;
            farChild = sibling.left;
        }
        else {
            nearChild = sibling.left;
            farChild = sibling.right;
        }

        // far child is red and near child is either red or black
        if (farChild.colour == RedBlackTree.RB_Node.Colour.red) {
            sibling.colour = node.parent.colour;
            node.parent.colour = RedBlackTree.RB_Node.Colour.black;

            farChild.colour = RedBlackTree.RB_Node.Colour.black;

            if (node == node.parent.right)
                rightRotate(node.parent);
            else
                leftRotate(node.parent);
        }
        else { // near child is red and far is black
            nearChild.colour = RedBlackTree.RB_Node.Colour.black;
            sibling.colour = RedBlackTree.RB_Node.Colour.red;

            if (node == node.parent.right)
                leftRotate(sibling);
            else
                rightRotate(sibling);

            deleteUpdate(node);
        }
    }

    private void rightRotate(RB_Node node) {
        RB_Node child = node.left;

        node.left = child.right;
        child.right.parent = node;
        
        child.parent = node.parent;
        if (node != root) {
            if (node == node.parent.left)
                child.parent.left = child;
            else
                child.parent.right = child;
        }

        child.right = node;
        node.parent = child;

        if (node == root) {
            root = child;
            root.parent = null;
        }
    }

    private void leftRotate(RB_Node node) {
        RB_Node child = node.right;

        node.right = child.left;
        child.left.parent = node;
        
        child.parent = node.parent;
        if (node != root) {
            if (node == node.parent.left)
                child.parent.left = child;
            else
                child.parent.right = child;
        }
        
        child.left = node;
        node.parent = child;

        if (node == root) {
            root = child;
            root.parent = null;
        }
    }

    private int height(RB_Node node) {
        if (node == nil)
            return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    } 

    public void log() {
        log(root);
        System.out.println("---------------------------------------------------------");
    }

    private void log(RB_Node root) {
        if (root == null)
            return;

        System.out.println("Data: " + root.data);
        System.out.println("Colour: " + (root.colour == RedBlackTree.RB_Node.Colour.red ? "red\n\n" : "black\n\n"));

        if (root.left != null && root.left != nil) {
            System.out.println(root.data + "'s left: ");
            log(root.left);
        }
        if (root.right != null && root.right != nil) {
            System.out.println(root.data + "'s right: ");
            log(root.right);
        }
    }
}
