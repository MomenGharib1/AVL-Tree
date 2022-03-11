package com.company;

import com.company.Application.Parser;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("=========================================================================================");
        System.out.println("                            WELCOME TO AVL TREE DICTIONARY");
        System.out.println("=========================================================================================");
        System.out.println("Guidlines:\n1- To insert word type 'Insert (theWordyouwantoInsert)' Ex:Insert (Omar Ahmed) \n" +
                "2- To Load txt file type 'Load txtfilePath' Ex: Load D:/newfolder/names.txt NOTE:path must be with forward slash /\n" +
                "3- To LookUp word type 'LookUp (word)' Ex: LookUp (Ali) \n" +
                "4- To remove word type 'Remove (word)' Ex: Remove (Omar) \n" +
                "5- To Batch lookup txt file type 'BatchLookUp txtfilePath' Ex: BatchLookUp D:/newfolder/names.txt \n" +
                "6- To Batch remove txt file type 'BatchRemove txtfilePath' Ex: BatchRemove D:/newfolder/names.txt \n" +
                "7- To print size of tree(Number of nodes) type 'PrintSize' Ex: PrintSize \n");
        System.out.println("=========================================================================================");

        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);
        String in;
        while(!((in = sc.nextLine())=="Exit")){
            parser.parse(in);
        }
    }
}
