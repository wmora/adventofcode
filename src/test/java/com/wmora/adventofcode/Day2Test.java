package com.wmora.adventofcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Day2Test {

    @Test
    public void testBathroomCode() {
        List<String> instructions = new ArrayList<>();
        instructions.add("ULL");
        instructions.add("RRDDD");
        instructions.add("LURDL");
        instructions.add("UUUUD");

        Day2 day2 = new Day2();

        assertEquals("1985", day2.getBathroomCode(instructions));
    }

    @Test
    public void testFancyBathroomCode() {
        List<String> instructions = new ArrayList<>();
        instructions.add("ULL");
        instructions.add("RRDDD");
        instructions.add("LURDL");
        instructions.add("UUUUD");

        Day2 day2 = new Day2();

        assertEquals("5DB3", day2.getFancyBathroomCode(instructions));
    }
}
