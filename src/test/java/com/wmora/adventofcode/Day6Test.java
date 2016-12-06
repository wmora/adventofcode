package com.wmora.adventofcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Day6Test {

    @Test
    public void testGetMessage() {
        List<String> messages = new ArrayList<>();
        messages.add("eedadn");
        messages.add("drvtee");
        messages.add("eandsr");
        messages.add("raavrd");
        messages.add("atevrs");
        messages.add("tsrnev");
        messages.add("sdttsa");
        messages.add("rasrtv");
        messages.add("nssdts");
        messages.add("ntnada");
        messages.add("svetve");
        messages.add("tesnvt");
        messages.add("vntsnd");
        messages.add("vrdear");
        messages.add("dvrsen");
        messages.add("enarar");

        assertEquals("easter", new Day6().getMessage(messages));
    }

}
