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

}
