package com.company;

public class AvlTree<AnyType extends Comparable<AnyType>> {

    public static class Node<AnyType> {
        private AnyType value;
        private int height;
        private Node<AnyType> LeftChild;
        private Node<AnyType> RightChild;

        public Node(AnyType value) {
            this.value = value;
        }
    }

    private Node<AnyType> root;

    public void insert_nodes(AnyType value) {
        root = insert_nodes(root, value);
    }

    private Node<AnyType> insert_nodes(Node<AnyType> root, AnyType value) {
        if (root == null) {
            return new Node<>(value);
        }
        if (value.compareTo(root.value) < 0) {
            root.LeftChild = insert_nodes(root.LeftChild, value);
        } else if (value.compareTo(root.value) > 0) {
            root.RightChild = insert_nodes(root.RightChild, value);
        } else {
            System.out.println("value already exists");
        }
        setHeight(root);
        return balance(root);
    }

    private int NodeHeight(Node<AnyType> node) {
        return (node == null ? -1 : node.height);
    }

    public int TreeHeight() {
        return (root==null) ? -1 : root.height;
    }

    private Node<AnyType> balance(Node<AnyType> root) {
        if (IsLeftHeavy(root)) {
            if (BalanceFactor(root.LeftChild) < 0)
                root.LeftChild = RotateLeft(root.LeftChild);
            return RotateRight(root);
        } else if (IsRightHeavy(root)) {
            if (BalanceFactor(root.RightChild) > 0)
                root.RightChild = RotateRight(root.RightChild);
            return RotateLeft(root);
        }
        return root;
    }

    private Node<AnyType> RotateLeft(Node<AnyType> root) {
        var NewRoot = root.RightChild;
        root.RightChild = NewRoot.LeftChild;
        NewRoot.LeftChild = root;
        setHeight(root);
        setHeight(NewRoot);
        return NewRoot;
    }

    private Node<AnyType> RotateRight(Node<AnyType> root) {
        var NewRoot = root.LeftChild;
        root.LeftChild = NewRoot.RightChild;
        NewRoot.RightChild = root;
        setHeight(root);
        setHeight(NewRoot);
        return NewRoot;
    }

    private void setHeight(Node<AnyType> node) {
        node.height = Math.max(NodeHeight(node.LeftChild), NodeHeight(node.RightChild)) + 1;
    }

    private boolean IsLeftHeavy(Node<AnyType> node) {
        return BalanceFactor(node) > 1;
    }

    private boolean IsRightHeavy(Node<AnyType> node) {
        return BalanceFactor(node) < -1;
    }

    private int BalanceFactor(Node<AnyType> node) {
        return (node == null ? 0 : NodeHeight(node.LeftChild) - NodeHeight(node.RightChild));
    }


    public boolean search(AnyType value) {
        var current = root;
        while (current != null) {
            var val = current.value;
            if (value.compareTo(current.value) < 0)
                current = current.LeftChild;
            else if (value.compareTo(current.value) > 0)
                current = current.RightChild;
            else
                return true;
        }
        return false;
    }

    public void remove(AnyType value){
        root =  remove(root, value);
    }
    
    private Node<AnyType> remove(Node<AnyType> root, AnyType value) {
        if (root == null){
            System.out.println("Error value " + value +" isn't in the tree");
            return root;
        }
        int x = value.compareTo(root.value);
        if(x < 0)
            root.LeftChild = remove(root.LeftChild, value);
        else if(x > 0)
            root.RightChild = remove(root.RightChild, value);
        else if(root.RightChild != null && root.LeftChild != null){
            var t = findMin(root.RightChild);
            root.value = t.value;
            root.RightChild = remove(root.RightChild, t.value);
        }
        else{
            root = (root.LeftChild != null) ? root.LeftChild : root.RightChild;
        }
        return balance(root);
    }

    private Node<AnyType> findMin(Node<AnyType> root){
        if(root.LeftChild == null)
                return root;
        return findMin(root.LeftChild);
    }

    private void printInorder(Node<AnyType> node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.LeftChild);

        /* then print the data of node */
        System.out.println(node.value + " ");

        /* now recur on right child */
        printInorder(node.RightChild);
    }

    public void printInorder() { printInorder(root); }

    public void clearTree(){
        root.RightChild = null;
        root.LeftChild = null;
        root = null;
    }

}
