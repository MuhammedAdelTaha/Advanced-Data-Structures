package org.example;

import junit.framework.TestCase;

import java.util.ArrayList;

public class DictionaryTest extends TestCase {

    public void testBatchInsert1() {
        Dictionary dictionary = new Dictionary("AVL");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Rolette"); expected.add("Rolfe"); expected.add("roly-poly");
        expected.add("Rolla"); expected.add("Rolland");
        assertEquals(expected, dictionary.batchInsert("files/Batch_Insert"));
    }

    public void testBatchInsert2() {
        Dictionary dictionary = new Dictionary("RED-BLACK");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Rolette"); expected.add("Rolfe"); expected.add("roly-poly");
        expected.add("Rolla"); expected.add("Rolland");
        assertEquals(expected, dictionary.batchInsert("files/Batch_Insert"));
    }

    public void testBatchDelete1() {
        Dictionary dictionary = new Dictionary("AVL");
        assertEquals(1000000, dictionary.batchDelete("files/output_file.txt").size());
    }

    public void testBatchDelete2() {
        Dictionary dictionary = new Dictionary("RED-BLACK");
        assertEquals(97462, dictionary.batchDelete("files/Dictionary.txt").size());
    }
}