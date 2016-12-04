package com.wmora.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Day4 {

    int sumOfSectorIds(List<String> rooms) {
        int sum = 0;

        for (String room : rooms) {
            if (isValidRoom(room)) {
                sum += roomSectorId(room);
            }
        }

        return sum;
    }

    private int roomSectorId(String room) {
        int sectorIdStartIndex = room.lastIndexOf("-") + 1;
        int sectorIdEndIndex = room.indexOf("[");
        return Integer.parseInt(room.substring(sectorIdStartIndex, sectorIdEndIndex));
    }

    private boolean isValidRoom(String room) {
        int checksumStartId = room.indexOf("[");
        String checksum = room.substring(checksumStartId + 1, room.length() - 1);

        int roomNameEndIndex = room.lastIndexOf("-");
        String roomName = room.substring(0, roomNameEndIndex);


        Map<String, Integer> occurrences = getAllCharacterOccurrencesMap(roomName);

        for (int i = 0; i < checksum.length(); i++) {
            String character = String.valueOf(checksum.charAt(i));

            if (!occurrences.containsKey(character) && occurrences.size() >= checksum.length()) {
                return false;
            }

            if (i > 0) {
                String previousCharacter = String.valueOf(checksum.charAt(i - 1));
                int previousCharacterOccurrences = occurrences.get(previousCharacter);
                int currentCharacterOccurrences = occurrences.get(character);
                if (previousCharacterOccurrences < currentCharacterOccurrences) {
                    return false;
                } else if (previousCharacterOccurrences == currentCharacterOccurrences) {
                    if (previousCharacter.compareTo(character) > 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private Map<String, Integer> getAllCharacterOccurrencesMap(String roomName) {
        Map<String, Integer> occurrences = new HashMap<>();

        for (int i = 0; i < roomName.length(); i++) {
            String character = String.valueOf(roomName.charAt(i));
            if (!"-".equals(character) && !occurrences.containsKey(character)) {
                occurrences.put(character, getOccurrences(character, roomName));
            }
        }
        return occurrences;
    }

    private int getOccurrences(String character, String string) {
        int occurrences = 0;
        int index = string.indexOf(character);

        while (index > -1) {
            occurrences++;
            index = string.indexOf(character, index + 1);
        }

        return occurrences;
    }

    int findSectorId(List<String> rooms, String roomName) {
        for (String room : rooms) {
            if (roomName.equals(getDecryptedName(room))) {
                return roomSectorId(room);
            }
        }
        return -1;
    }

    private String getDecryptedName(String room) {
        StringBuilder decryptedName = new StringBuilder();

        int sectorId = roomSectorId(room);
        int roomNameEndIndex = room.lastIndexOf("-");
        String roomName = room.substring(0, roomNameEndIndex);


        for (int i = 0; i < roomName.length(); i++) {
            String character = String.valueOf(roomName.charAt(i));
            if ("-".equals(character)) {
                decryptedName.append(" ");
            } else  {
                decryptedName.append(rotateCharacter(character, sectorId));
            }
        }

        return decryptedName.toString();
    }

    private String rotateCharacter(String character, int rotation) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int index = alphabet.indexOf(character);
        int rotatedIndex = index + rotation;

        while (rotatedIndex >= alphabet.length()) {
            rotatedIndex -= alphabet.length();
        }

        return String.valueOf(alphabet.charAt(rotatedIndex));
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> rooms = new ArrayList<>();

        Scanner scanner = new Scanner(new File("day4.txt"));
        while (scanner.hasNextLine()) {
            rooms.add(scanner.nextLine());
        }

        System.out.println(new Day4().sumOfSectorIds(rooms));
        System.out.println(new Day4().findSectorId(rooms, "northpole object storage"));
    }
}
