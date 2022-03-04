package com.company;

public class Main {

    public static void main(String[] args) {
        AvlTree<String> tree = new AvlTree<>();
        tree.insert_nodes("a");
        tree.insert_nodes("f");
        tree.insert_nodes("g");
        tree.insert_nodes("b");
        tree.insert_nodes("q");
        tree.insert_nodes("r");
        tree.insert_nodes("c");
        tree.remove("c");
        tree.remove("q");
        tree.printInorder();
        System.out.println("Height: "+tree.TreeHeight());
    }
}
