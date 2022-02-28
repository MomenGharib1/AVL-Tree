package com.company;

public class AvlTree {
    private static class Node {
        private final String word;
        private int height;
        private Node LeftChild;
        private Node RightChild;

        public Node(String word) {
            this.word = word;
        }
    }

    private Node root;

    public void insert_nodes(String word) {
        root = insert_nodes(root, word);
    }

    private Node insert_nodes(Node root, String word) {
        if (root == null) {
            return new Node(word);
        }
        if (word.compareTo(root.word) < 0) {
            root.LeftChild = insert_nodes(root.LeftChild, word);
        } else if (word.compareTo(root.word) > 0) {
            root.RightChild = insert_nodes(root.RightChild, word);
        } else {
            System.out.println("Word already exists");
        }
        setHeight(root);

        return balance(root);
    }

    private int NodeHeight(Node node) {
        return (node == null ? -1 : node.height);
    }

    public int TreeHeight() {
        return root.height;
    }

    private Node balance(Node root) {
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

    private Node RotateLeft(Node root) {
        var NewRoot = root.RightChild;
        root.RightChild = NewRoot.LeftChild;
        NewRoot.LeftChild = root;
        setHeight(NewRoot);
        setHeight(root);
        return NewRoot;
    }

    private Node RotateRight(Node root) {
        var NewRoot = root.LeftChild;
        root.LeftChild = NewRoot.RightChild;
        NewRoot.RightChild = root;
        setHeight(NewRoot);
        setHeight(root);
        return NewRoot;
    }

    private void setHeight(Node node) {
        node.height = Math.max(NodeHeight(root.LeftChild), NodeHeight(root.RightChild)) + 1;
    }

    private boolean IsLeftHeavy(Node node) {
        return BalanceFactor(node) > 1;
    }

    private boolean IsRightHeavy(Node node) {
        return BalanceFactor(node) < -1;
    }

    private int BalanceFactor(Node node) {
        return (node == null ? 0 : NodeHeight(node.LeftChild) - NodeHeight(node.RightChild));
    }

    public boolean search(String word) {
        var current = root;
        while (current != null) {
            if (word.compareTo(current.word) < 0)
                current = current.LeftChild;
            else if (word.compareTo(current.word) > 0)
                current = current.RightChild;
            else
                return true;
        }
        return false;
    }
}
