package org.example.Trees;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RedBlackTreeTest extends TestCase {

    public void testInsert1() {
        RedBlackTree<Double> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert(5.55555555);
        assertFalse(redBlackTree.insert(5.55555555));
    }
    public void testInsert2() {
        RedBlackTree<String> redBlackTree = new RedBlackTree<>();
        assertTrue(redBlackTree.insert("a"));
    }

    public void testDelete1() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/Dictionary.txt"))) {
            String str;
            RedBlackTree<String> redBlackTree = new RedBlackTree<>();
            while ((str = buffer.readLine()) != null) {
                redBlackTree.insert(str);
            }
            assertTrue(redBlackTree.delete("terminologies"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void testDelete2() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/output_file.txt"))) {
            String str;
            RedBlackTree<String> redBlackTree = new RedBlackTree<>();
            while ((str = buffer.readLine()) != null) {
                redBlackTree.insert(str);
            }
            assertTrue(redBlackTree.delete("eye-weariness"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSearch1() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/Dictionary.txt"))) {
            String str;
            RedBlackTree<String> redBlackTree = new RedBlackTree<>();
            while ((str = buffer.readLine()) != null) {
                redBlackTree.insert(str);
            }
            assertTrue(redBlackTree.search("greyish"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void testSearch2() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/output_file.txt"))) {
            String str;
            RedBlackTree<String> redBlackTree = new RedBlackTree<>();
            while ((str = buffer.readLine()) != null) {
                redBlackTree.insert(str);
            }
            assertTrue(redBlackTree.search("rolley"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSize1() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("files/Dictionary.txt"))) {
            String str;
            RedBlackTree<String> redBlackTree = new RedBlackTree<>();
            while ((str = buffer.readLine()) != null) {
                redBlackTree.insert(str);
            }
            assertEquals(97462, redBlackTree.size());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void testSize2() {
        RedBlackTree<String> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert("a");redBlackTree.insert("a");
        assertEquals(1, redBlackTree.size());
    }

    public void testHeight1() {
        RedBlackTree<String> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert("k");redBlackTree.insert("l");redBlackTree.insert("m");redBlackTree.insert("d");
        redBlackTree.insert("g");redBlackTree.insert("a");redBlackTree.insert("f");redBlackTree.insert("n");
        assertEquals(4, redBlackTree.height());
    }
    public void testHeight2() {
        RedBlackTree<Double> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert(1.0);redBlackTree.insert(1.55);redBlackTree.insert(-502.0);redBlackTree.insert(1000.0);
        redBlackTree.insert(-10.0);redBlackTree.insert(-20.0);redBlackTree.insert(-30.0);redBlackTree.insert(-1.0);
        assertEquals(4, redBlackTree.height());
    }

    public void testRoot1(){
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert(1);redBlackTree.insert(5);redBlackTree.insert(4);
        redBlackTree.insert(3);redBlackTree.insert(8);redBlackTree.insert(9);
        redBlackTree.delete(4);
        assertEquals(3, redBlackTree.getRoot().intValue());
    }
    public void testRoot2(){
        RedBlackTree<String> redBlackTree = new RedBlackTree<>();
        redBlackTree.insert("a");redBlackTree.insert("aa");redBlackTree.insert("aaa");
        redBlackTree.insert("f");redBlackTree.insert("z");redBlackTree.insert("zz");
        redBlackTree.delete("aa");
        assertEquals("f", redBlackTree.getRoot());
    }
}