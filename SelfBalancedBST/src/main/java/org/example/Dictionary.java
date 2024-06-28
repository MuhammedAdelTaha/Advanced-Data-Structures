package org.example;

import org.example.Trees.AVL_Tree;
import org.example.Trees.IBinarySearchTree;
import org.example.Trees.RedBlackTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Dictionary {
    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";
    String type;
    IBinarySearchTree< String > tree;
    private ArrayList<String> words = new ArrayList<>();

    public Dictionary(String type){
        this.type = type;
        if(Objects.equals(type, "AVL")){
            System.out.println(GREEN + "AVL based Dictionary..." + RESET);
            tree = new AVL_Tree< String >();
        }else if(Objects.equals(type , "RED-BLACK")){
            System.out.println(GREEN + "Red-Black based Dictionary..." + RESET);
            tree = new RedBlackTree< String >();
        }
    }

    public void insert(String str){
        boolean ok = tree.insert(str);
        if(ok){
            System.out.println(GREEN + str + " Inserted Successfully" + RESET);
        }else{
            System.out.println(RED + "Insertion Failed" + RESET);
        }
    }

    public void delete(String str){
        boolean ok = tree.delete(str);
        if(ok){
            System.out.println(GREEN + str + " Deleted Successfully" + RESET);
        }else{
            System.out.println(RED + "This word doesn't exist" + RESET);
        }
    }

    public void search(String str){
        boolean ok = tree.search(str);
        if(ok){
            System.out.println(GREEN + str + " Found" + RESET);
        }else{
            System.out.println(RED + str + " Not Found" + RESET);
        }
    }

    public ArrayList < String > batchInsert(String path){
        words.clear();
        parse(path);
        ArrayList < String > notInserted = new ArrayList<>();
        for (String s : words){
            if(tree.insert(s)) continue;
            notInserted.add(s);
        }
        return notInserted;
    }

    public ArrayList < String > batchDelete(String path){
        words.clear();
        parse(path);
        ArrayList < String > notDeleted = new ArrayList<>();
        for (String s : words){
            if(tree.delete(s)) continue;
            notDeleted.add(s);
        }
        return notDeleted;
    }

    public void size(){
        int x = tree.size();
        if(x == 0){
            System.out.println(RED + "The Dictionary is Empty" + RESET);
        }else{
            System.out.println(GREEN + "The Dictionary size = " + x + RESET);
        }
    }

    public void height(){
        int sz = tree.size();
        if(sz == 0){
            System.out.println(RED + "The Dictionary is Empty" + RESET);
        }else{
            int x = tree.height();
            System.out.println(GREEN + "The Dictionary Tree has height equals " + x + RESET);
        }
    }

    private void parse(String filePath){
        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            String str;
            while ((str = buffer.readLine()) != null) {
                this.words.add(str);
            }
        }
        catch (IOException e) {
            System.out.println(RED + "Please, enter a valid path..." + RESET);
        }
    }
}
