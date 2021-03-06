package com.wmora.adventofcode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Day5 {

    String getPassword(String doorId) {
        String password = "";

        long currentIndex = 0;

        while (password.length() < 8) {
            String hash = getHexadecimalMd5Hash(doorId + currentIndex);

            if (hash.startsWith("00000")) {
                password += hash.charAt(5);
            }

            currentIndex++;
        }


        return password;
    }

    String getComplexPassword(String doorId) {
        int passwordSize = 8;
        String[] password = new String[passwordSize];

        long currentIndex = 0;
        int charactersFound = 0;

        while (charactersFound < passwordSize) {
            String hash = getHexadecimalMd5Hash(doorId + currentIndex);

            if (hash.startsWith("00000")) {
                try {
                    int position = Integer.parseInt(String.valueOf(hash.charAt(5)));
                    if (position < passwordSize && password[position] == null) {
                        password[position] = String.valueOf(hash.charAt(6));
                        charactersFound++;
                    }
                } catch (NumberFormatException ignored) {

                }

            }

            currentIndex++;
        }


        return String.join("", password);
    }

    private String getHexadecimalMd5Hash(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hash = messageDigest.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte h : hash) {
                String hex = Integer.toHexString(0xFF & h);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Day5().getPassword("wtnhxymk"));
        System.out.println(new Day5().getComplexPassword("wtnhxymk"));
    }
}
