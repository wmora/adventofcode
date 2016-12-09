package com.wmora.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day8 {

    private static final int WIDTH = 50;
    private static final int HEIGHT = 6;

    private boolean screen[][] = new boolean[HEIGHT][WIDTH];

    int litPixelsCount(List<String> instructions) {
        for (String instruction : instructions) {
            apply(instruction);
        }

        int litPixelCount = 0;

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (screen[i][j]) {
                    litPixelCount++;
                }
            }
        }

        return litPixelCount;
    }

    private void apply(String instruction) {
        if (instruction.startsWith("rect")) {
            applyRect(instruction);
        } else if (instruction.startsWith("rotate row")) {
            applyRotateRow(instruction);
        } else if (instruction.startsWith("rotate column")) {
            applyRotateColumn(instruction);
        }

        System.out.println(instruction);

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(screen[i][j] ? "#" : ".");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void applyRect(String instruction) {
        int startIndex = instruction.indexOf(" ");
        String measurements = instruction.substring(startIndex + 1);
        int dividerIndex = measurements.indexOf("x");
        int width = Integer.parseInt(measurements.substring(0, dividerIndex));
        int height = Integer.parseInt(measurements.substring(dividerIndex + 1));
        rect(width, height);
    }

    private void applyRotateRow(String instruction) {
        int lastSpaceIndex = instruction.lastIndexOf(" ");
        int rotation = Integer.parseInt(instruction.substring(lastSpaceIndex + 1));
        int rowStartIndex = instruction.indexOf("=");
        int rowEndIndex = instruction.indexOf(" ", rowStartIndex);
        int row = Integer.parseInt(instruction.substring(rowStartIndex + 1, rowEndIndex));
        
        rotateRow(row, rotation);
    }

    private void applyRotateColumn(String instruction) {
        int lastSpaceIndex = instruction.lastIndexOf(" ");
        int rotation = Integer.parseInt(instruction.substring(lastSpaceIndex + 1));
        int columnStartIndex = instruction.indexOf("=");
        int columnEndIndex = instruction.indexOf(" ", columnStartIndex);
        int column = Integer.parseInt(instruction.substring(columnStartIndex + 1, columnEndIndex));

        rotateColumn(column, rotation);
    }

    private void rect(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                screen[i][j] = true;
            }
        }
    }

    private void rotateRow(int row, int rotation) {
        boolean[] temp = new boolean[rotation];
        int j = 0;
        for (int i = WIDTH - rotation; i < WIDTH; i++) {
            temp[j] = screen[row][i];
            j++;
        }
        for (int i = WIDTH - 1; i >= 0; i--) {
            if (i - rotation >= 0) {
                screen[row][i] = screen[row][i - rotation];
            } else {
                screen[row][i] = temp[i];
            }
        }
    }

    private void rotateColumn(int column, int rotation) {
        boolean[] temp = new boolean[rotation];
        int j = 0;
        for (int i = HEIGHT - rotation; i < HEIGHT; i++) {
            temp[j] = screen[i][column];
            j++;
        }
        for (int i = HEIGHT - 1; i >= 0; i--) {
            if (i - rotation >= 0) {
                screen[i][column] = screen[i - rotation][column];
            } else {
                screen[i][column] = temp[i];
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> instructions = new ArrayList<>();

        Scanner scanner = new Scanner(new File("day8.txt"));

        while (scanner.hasNextLine()) {
            instructions.add(scanner.nextLine());
        }

        System.out.println(new Day8().litPixelsCount(instructions));
    }
}
