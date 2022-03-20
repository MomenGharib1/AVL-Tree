package com.company;

import com.company.Application.Parser;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
      test tester = new test();
      tester.calcInsertionTime(1000);
      tester.clacDeletionTime(1000);
    }
}
