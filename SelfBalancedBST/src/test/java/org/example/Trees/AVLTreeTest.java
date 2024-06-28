package org.example.Trees;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AVLTreeTest extends TestCase {

    public void testInsert1() {
        AVL_Tree<Double> avlTree = new AVL_Tree<>();
        avlTree.insert(5.55555555);
        assertFalse(avlTree.insert(5.55555555));
    }
    public void testInsert2() {
        AVL_Tree<String> avlTree = new AVL_Tree<>();
        assertTrue(avlTree.insert("a"));
    }

    public void testDelete1() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/Dictionary.txt"))) {
            String str;
            AVL_Tree<String> avlTree = new AVL_Tree<>();
            while ((str = buffer.readLine()) != null) {
                avlTree.insert(str);
            }
            assertTrue(avlTree.delete("recklessness's"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void testDelete2() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/output_file.txt"))) {
            String str;
            AVL_Tree<String> avlTree = new AVL_Tree<>();
            while ((str = buffer.readLine()) != null) {
                avlTree.insert(str);
            }
            assertTrue(avlTree.delete("morgenaudiensen"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSearch1() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/Dictionary.txt"))) {
            String str;
            AVL_Tree<String> avlTree = new AVL_Tree<>();
            while ((str = buffer.readLine()) != null) {
                avlTree.insert(str);
            }
            assertTrue(avlTree.search("thriven"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void testSearch2() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/output_file.txt"))) {
            String str;
            AVL_Tree<String> avlTree = new AVL_Tree<>();
            while ((str = buffer.readLine()) != null) {
                avlTree.insert(str);
            }
            assertTrue(avlTree.search("ecclesiologically"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSize1() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/Dictionary.txt"))) {
            String str;
            AVL_Tree<String> avlTree = new AVL_Tree<>();
            while ((str = buffer.readLine()) != null) {
                avlTree.insert(str);
            }
            assertEquals(97462, avlTree.size());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void testSize2() {
        AVL_Tree<String> avlTree = new AVL_Tree<>();
        avlTree.insert("a");avlTree.insert("a");
        assertEquals(1, avlTree.size());
    }

    public void testHeight1() {
        AVL_Tree<String> avlTree = new AVL_Tree<>();
        avlTree.insert("k");avlTree.insert("l");avlTree.insert("m");avlTree.insert("d");
        avlTree.insert("g");avlTree.insert("a");avlTree.insert("f");avlTree.insert("n");
        assertEquals(4, avlTree.height());
    }
    public void testHeight2() {
        AVL_Tree<Double> avlTree = new AVL_Tree<>();
        avlTree.insert(1.0);avlTree.insert(1.55);avlTree.insert(-502.0);avlTree.insert(1000.0);
        avlTree.insert(-10.0);avlTree.insert(-20.0);avlTree.insert(-30.0);avlTree.insert(-1.0);
        assertEquals(4, avlTree.height());
    }

    public void testRoot1(){
        AVL_Tree<Integer> avlTree = new AVL_Tree<>();
        avlTree.insert(1);avlTree.insert(5);avlTree.insert(4);
        avlTree.insert(3);avlTree.insert(8);avlTree.insert(9);
        avlTree.delete(4);
        assertEquals(3, avlTree.getRoot().intValue());
    }
    public void testRoot2(){
        AVL_Tree<String> avlTree = new AVL_Tree<>();
        avlTree.insert("a");avlTree.insert("aa");avlTree.insert("aaa");
        avlTree.insert("f");avlTree.insert("z");avlTree.insert("zz");
        avlTree.delete("f");
        assertEquals("aaa", avlTree.getRoot());
    }
}