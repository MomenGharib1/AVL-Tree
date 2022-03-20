package com.company;

public class test {
    public void calcInsertionTime(int n) {
        StringGenerator generator = new StringGenerator();
        AvlTree tree = new AvlTree();
        long begin = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            tree.insert_nodes(generator.Generate());
        }

        long end = System.currentTimeMillis();
        long time = end - begin;

        System.out.println(time);
    }

    public void clacDeletionTime(int n) {
        StringGenerator generator = new StringGenerator();
        String[] words = new String[n];
        AvlTree tree = new AvlTree();
        long begin = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            words[i] = generator.Generate();
            tree.insert_nodes(words[i]);
        }
        for (int i = 0; i < n; i++) {
            tree.remove(words[i]);
        }


        long end = System.currentTimeMillis();
        long time = end - begin;

        System.out.println(time);
    }
}
