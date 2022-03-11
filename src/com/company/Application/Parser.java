package com.company.Application;
import com.company.AvlTree;

import java.io.*;
import java.util.regex.Pattern;

public class Parser {
    private AvlTree<String> tree;
    private Pattern LoadPattern = Pattern.compile("^Load\\s+[_|-|a-zA-z0-9:\\/]+\\.txt");
    private Pattern InsertPattern = Pattern.compile("^Insert\\s\\([a-zA-z0-9\\s+]+\\)");
    private Pattern LookUpPattern = Pattern.compile("^LookUp\\s\\([a-zA-z0-9\\s+]+\\)");
    private Pattern RemovePattern = Pattern.compile("^Remove\\s\\([a-zA-z0-9\\s+]+\\)");
    private Pattern batchLookupPattern = Pattern.compile("^BatchLookUp\\s+[_|-|a-zA-z0-9:\\/]+\\.txt");
    private Pattern batchRemovePattern = Pattern.compile("^BatchRemove\\s+[_|-|a-zA-z0-9:\\/]+\\.txt");
    private Pattern PrintSizePattern = Pattern.compile("PrintSize");


    public Parser() {
        this.tree = new AvlTree<>();
    }

    public void parse(String command) throws IOException {
        if (LoadPattern.matcher(command).find()) {
            tree = Load(command);
            tree.printInorder();
        } else if(InsertPattern.matcher(command).find()) {
            tree = Insert(command);
        } else if (LookUpPattern.matcher(command).find()) {
            LookUp(command);
        } else if (RemovePattern.matcher(command).find()) {
            tree = Remove(command);
            tree.printInorder();
        } else if (batchLookupPattern.matcher(command).find()) {
            BatchLookUp(command);
        } else if (batchRemovePattern.matcher(command).find()) {
            tree = BatchRemove(command);
            tree.printInorder();
        } else if (PrintSizePattern.matcher(command).find()) {
            PrintSize();
        }

        System.out.println("------------------------------------------");
    }

    private AvlTree<String> Load(String command) throws IOException {
        String path = command.split("[ ]+")[1];
        File file = FileHandler.loadFile(path);
        String st, st1;
        tree = new AvlTree();
        if (file != null) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                st1 = st.replaceAll("\\s+", "");
                tree.insert_nodes(st1);
            }
        }
        return tree;
    }

    private AvlTree<String> Insert(String command){
        String word = command.split("[\\(]")[1].split("\\)")[0];
        word = word.replaceAll("\\s+", "");
        if(tree.search(word)) {
            System.out.println("value already exists");
            return tree;
        }
        tree.insert_nodes(word);
        tree.printInorder();
        return tree;
    }

    private void PrintSize() {
        System.out.println(tree.getSize());
    }

    private void LookUp(String command) {
        String word = command.split("[\\(]")[1].split("\\)")[0];
        word = word.replaceAll("\\s+", "");
        boolean found = tree.search(word);
        if (found)
            System.out.println(word + ": Yes.");
        else
            System.out.println(word + ": No.");
    }

    private AvlTree<String> Remove(String command) {
        String word = command.split("[\\(]")[1].split("\\)")[0];
        word = word.replaceAll("\\s+", "");
        tree.remove(word);
        return tree;
    }

    private void BatchLookUp(String command) throws IOException {
        String path = command.split("[ ]+")[1];
        File file = FileHandler.loadFile(path);
        String st, st1;
        int count = 0;
        boolean found;
        if (file != null) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                st1 = st.replaceAll("\\s+", "");
                found = tree.search(st1);
                if (found) {
                    System.out.println(st1 + " : Yes.");
                    count++;
                } else
                    System.out.println(st1 + " :No.");
            }
            System.out.println("Total Num of words found = " + count);
        }
    }

    private AvlTree<String> BatchRemove(String command) throws IOException {
        String path = command.split("[ ]+")[1];
        File file = FileHandler.loadFile(path);
        String st, st1;
        if (file != null) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                st1 = st.replaceAll("\\s+", "");
                tree.remove(st1);
            }
        }
        return tree;
    }

}