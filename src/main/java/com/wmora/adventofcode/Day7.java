package com.wmora.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day7 {

    int tlsSupportCount(List<String> ips) {
        int count = 0;

        for (String ip : ips) {
            if (supportsTls(ip)) {
                count++;
            }
        }

        return count;
    }

    private boolean supportsTls(String ip) {
        boolean hasAbba = false;

        boolean insideSquareBrackets = false;

        for (int i = 0; i < ip.length() - 3; i++) {
            if (ip.charAt(i) == '[') {
                insideSquareBrackets = true;
            } else if (ip.charAt(i) == ']') {
                insideSquareBrackets = false;
            } else if (hasAbba(ip.charAt(i), ip.charAt(i + 1), ip.charAt(i + 2), ip.charAt(i + 3))) {
                if (insideSquareBrackets) {
                    return false;
                }

                hasAbba = true;
            }
        }

        return hasAbba;
    }

    private boolean hasAbba(char a1, char a2, char a3, char a4) {
        return a1 != a2 && a1 == a4 && a2 == a3;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> ips = new ArrayList<>();

        Scanner scanner = new Scanner(new File("day7.txt"));

        while (scanner.hasNextLine()) {
            ips.add(scanner.nextLine());
        }

        System.out.println(new Day7().tlsSupportCount(ips));
    }

}
