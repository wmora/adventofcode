package com.wmora.adventofcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Day3Test {

    @Test
    public void testTriangles() {
        List<Integer> triangle = new ArrayList<>();
        triangle.add(5);
        triangle.add(10);
        triangle.add(25);

        List<List<Integer>> triangles = new ArrayList<>();
        triangles.add(triangle);

        Day3 day3 = new Day3();

        assertEquals(0, day3.validTriangles(triangles));
    }

}
