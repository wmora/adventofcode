package com.wmora.adventofcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Day7Test {

    @Test
    public void testTlsSupportCount() {
        List<String> ips = new ArrayList<>();
        ips.add("abba[mnop]qrst");
        ips.add("abcd[bddb]xyyx");
        ips.add("aaaa[qwer]tyui");
        ips.add("ioxxoj[asdfgh]zxcvbn");

        assertEquals(2, new Day7().tlsSupportCount(ips));
    }

    @Test
    public void testSslSupportCount() {
        List<String> ips = new ArrayList<>();
        ips.add("aba[bab]xyz");
        ips.add("xyx[xyx]xyx");
        ips.add("aaa[kek]eke");
        ips.add("zazbz[bzb]cdb");

        assertEquals(3, new Day7().sslSupportCount(ips));
    }
}
