package com.company;

public class Main {

    public static void main(String[] args) {
        AvlTree Avl = new AvlTree();
        Avl.insert_nodes("1");
        Avl.insert_nodes("3");
        Avl.insert_nodes("2");

        System.out.println(Avl.TreeHeight());
    }
}
