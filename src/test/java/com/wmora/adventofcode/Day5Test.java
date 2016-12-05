package com.wmora.adventofcode;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Day5Test {

    @Test
    public void testGetPassword() {
        String doorId = "abc";

        assertEquals("18f47a30", new Day5().getPassword(doorId));
    }

    @Test
    public void testGetStrongerPassword() {
        String doorId = "abc";

        assertEquals("05ace8e3", new Day5().getComplexPassword(doorId));
    }

}
