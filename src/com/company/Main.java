package com.company;

import com.company.Application.Parser;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("=========================================================================================");
        System.out.println("                            WELCOME TO AVL TREE DICTIONARY");
        System.out.println("=========================================================================================");
        System.out.println("Guidelines:\n1- To insert word type 'Insert (theWordyouwantoInsert)' Ex:Insert (Omar Ahmed) \n2- To calculate the size type 'PrintSize' \n3- To Load txt file type 'Load txtfilePath' Ex: Load D:\\newfolder\\names.txt \n4- To LookUp word type 'LookUp (word)' Ex: LookUp (Ali) \n5- To remove word type 'Remove (word)' Ex: Remove (Omar) \n6- To Batch lookup txt file type 'BatchLookUp txtfilePath' Ex: BatchLookUp D:/newfolder/names.txt \n7- To Batch remove txt file type 'BatchRemove txtfilePath' Ex: BatchRemove D:/newfolder/names.txt \n");
        System.out.println("=========================================================================================");
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        AvlTree tree = new AvlTree();

        String in;
        while (!(in = sc.nextLine()).equals("Exit")) {
            parser.parse(in);
        }

    }
}
