package com.company;

import com.company.Application.Parser;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
      AvlTree tree = new AvlTree<>();
      StringGenerator generator = new StringGenerator();
      for(int i = 0; i<10; i++){
          tree.insert_nodes(generator.Generate());
      }
      tree.printInorder();
    }
}
