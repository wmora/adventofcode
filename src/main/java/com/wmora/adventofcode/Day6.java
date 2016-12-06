package com.wmora.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Day6 {

    String getMessage(List<String> messages) {
        String output = "";

        int columns = messages.get(0).length();

        for (int i = 0; i < columns; i++) {
            Map<String, Integer> occurrences = new HashMap<>();
            for (String message : messages) {
                String character = String.valueOf(message.charAt(i));
                Integer count = occurrences.get(character);
                if (count == null) {
                    count = 0;
                }
                count++;
                occurrences.put(character, count);
            }
            Map.Entry<String, Integer> mostRepeatedEntry = null;
            for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
                if (mostRepeatedEntry == null || mostRepeatedEntry.getValue() < entry.getValue()) {
                    mostRepeatedEntry = entry;
                }
            }
            output += mostRepeatedEntry.getKey();
        }

        return output;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> messages = new ArrayList<>();

        Scanner scanner = new Scanner(new File("day6.txt"));
        while (scanner.hasNextLine()) {
            messages.add(scanner.nextLine());
        }
        System.out.println(new Day6().getMessage(messages));
    }
}
