package com.wmora.adventofcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Day1Test {

    @Test
    public void testBlocksAway() {
        List<String> sequence = new ArrayList<>();
        sequence.add("R2");
        sequence.add("L3");

        Day1 day1 = new Day1();

        assertEquals(5, day1.blocksAwayFromEasterBunnyHq(sequence));

        sequence.clear();

        sequence.add("R2");
        sequence.add("R2");
        sequence.add("R2");

        assertEquals(2, day1.blocksAwayFromEasterBunnyHq(sequence));

        sequence.clear();

        sequence.add("R5");
        sequence.add("L5");
        sequence.add("R5");
        sequence.add("R3");

        assertEquals(12, day1.blocksAwayFromEasterBunnyHq(sequence));
    }

}
