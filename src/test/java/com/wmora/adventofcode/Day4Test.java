package com.wmora.adventofcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Day4Test {

    @Test
    public void testSumOfSectorIds() {
        List<String> rooms = new ArrayList<>();
        rooms.add("aaaaa-bbb-z-y-x-123[abxyz]");
        rooms.add("a-b-c-d-e-f-g-h-987[abcde]");
        rooms.add("not-a-real-room-404[oarel]");
        rooms.add("totally-real-room-200[decoy]");

        assertEquals(1514, new Day4().sumOfSectorIds(rooms));
    }

    @Test
    public void testFindSectorId() {
        List<String> rooms = new ArrayList<>();
        rooms.add("qzmt-zixmtkozy-ivhz-343[]");

        assertEquals(343, new Day4().findSectorId(rooms, "very encrypted name"));
    }

}
