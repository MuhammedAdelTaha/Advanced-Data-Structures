package org.example.Trees;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ComparisonTest extends TestCase {

    public void testInsertTime(){
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/output_file.txt"))) {
            String str;
            AVL_Tree<String> avlTree = new AVL_Tree<>();
            RedBlackTree<String> redBlackTree = new RedBlackTree<>();
            ArrayList<String> arrayList = new ArrayList<>();
            long start, end, avlTime, redBlackTime;
            while ((str = buffer.readLine()) != null) {
                arrayList.add(str);
            }

            start = System.currentTimeMillis();
            for (String s : arrayList) {
                avlTree.insert(s);
            }
            end = System.currentTimeMillis();
            avlTime = end - start;

            start = System.currentTimeMillis();
            for (String s : arrayList) {
                redBlackTree.insert(s);
            }
            end = System.currentTimeMillis();
            redBlackTime = end - start;

            System.out.println(avlTime);System.out.println(redBlackTime);
            assertTrue(avlTime >= redBlackTime);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testDeletionTime(){
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/output_file.txt"))) {
            String str;
            AVL_Tree<String> avlTree = new AVL_Tree<>();
            RedBlackTree<String> redBlackTree = new RedBlackTree<>();
            ArrayList<String> arrayList = new ArrayList<>();
            long start, end, avlTime, redBlackTime;
            while ((str = buffer.readLine()) != null) {
                arrayList.add(str);
            }
            for (String s : arrayList) {
                avlTree.insert(s);
                redBlackTree.insert(s);
            }

            start = System.currentTimeMillis();
            for (String value : arrayList) {
                avlTree.delete(value);
            }
            end = System.currentTimeMillis();
            avlTime = end - start;

            start = System.currentTimeMillis();
            for (String s : arrayList) {
                redBlackTree.delete(s);
            }
            end = System.currentTimeMillis();
            redBlackTime = end - start;

            System.out.println(avlTime);System.out.println(redBlackTime);
            assertTrue(avlTime > redBlackTime);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSearchTime(){
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/output_file.txt"))) {
            String str;
            AVL_Tree<String> avlTree = new AVL_Tree<>();
            RedBlackTree<String> redBlackTree = new RedBlackTree<>();
            ArrayList<String> arrayList = new ArrayList<>();
            long start, end, avlTime, redBlackTime;
            while ((str = buffer.readLine()) != null) {
                arrayList.add(str);
            }
            for (String value : arrayList) {
                avlTree.insert(value);
                redBlackTree.insert(value);
            }

            start = System.currentTimeMillis();
            for (String s : arrayList) {
                avlTree.search(s);
            }
            end = System.currentTimeMillis();
            avlTime = end - start;

            start = System.currentTimeMillis();
            for (String s : arrayList) {
                redBlackTree.search(s);
            }
            end = System.currentTimeMillis();
            redBlackTime = end - start;

            System.out.println(avlTime);System.out.println(redBlackTime);
            assertTrue(avlTime > redBlackTime);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
