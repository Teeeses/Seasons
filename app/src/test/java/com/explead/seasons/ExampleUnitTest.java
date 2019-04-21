package com.explead.seasons;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void test1() throws Exception {
        assertEquals(getArrayFromString(""), new ArrayList<Integer>());
    }

    @Test
    public void test2() throws Exception {
        assertEquals(getArrayFromString("1"), new ArrayList<>(Arrays.asList(1)));
    }

    @Test
    public void test3() throws Exception {
        assertEquals(getArrayFromString("2|3"), new ArrayList<>(Arrays.asList(2, 3)));
    }

    @Test
    public void test4() throws Exception {
        assertEquals(getArrayFromString("2|6|23|56"), new ArrayList<>(Arrays.asList(2, 6, 23, 56)));
    }

    private ArrayList<Integer> getArrayFromString(String str) {
        String replaceStr = str.replaceAll("[^0-9]+", " ");
        ArrayList<Integer> array = new ArrayList<>();
        String[] list = replaceStr.trim().split(" ");
        for (String item : list) {
            array.add(Integer.parseInt(item));
        }
        return array;
    }
}