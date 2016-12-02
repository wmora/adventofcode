package com.wmora.adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day1 {

    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    int blocksAwayFromEasterBunnyHq(List<String> sequence) {
        int x = 0;
        int y = 0;

        Direction direction = Direction.NORTH;

        for (String step : sequence) {
            direction = getNewDirection(direction, step);
            int blocks = getStepBlocks(step);
            switch (direction) {
                case NORTH:
                    y += blocks;
                    break;
                case EAST:
                    x += blocks;
                    break;
                case WEST:
                    x -= blocks;
                    break;
                case SOUTH:
                    y -= blocks;
                    break;
            }
        }

        return Math.abs(x) + Math.abs(y);
    }

    private int getStepBlocks(String step) {
        return Integer.parseInt(step.substring(1));
    }

    private Direction getNewDirection(Direction from, String step) {
        final String LEFT = "L";

        String turn = String.valueOf(step.charAt(0));

        boolean isLeftTurn = LEFT.equals(turn);

        switch (from) {
            case EAST:
                return isLeftTurn ? Direction.NORTH : Direction.SOUTH;
            case NORTH:
                return isLeftTurn ? Direction.WEST : Direction.EAST;
            case SOUTH:
                return isLeftTurn ? Direction.EAST : Direction.WEST;
            case WEST:
                return isLeftTurn ? Direction.SOUTH : Direction.NORTH;
        }

        return null;
    }

    public static void main(String[] args) {
        String input = "R2, L3, R2, R4, L2, L1, R2, R4, R1, L4, L5, R5, R5, R2, R2, R1, L2, L3, L2, L1, R3, L5, R187, R1, R4, L1, R5, L3, L4, R50, L4, R2, R70, L3, L2, R4, R3, R194, L3, L4, L4, L3, L4, R4, R5, L1, L5, L4, R1, L2, R4, L5, L3, R4, L5, L5, R5, R3, R5, L2, L4, R4, L1, R3, R1, L1, L2, R2, R2, L3, R3, R2, R5, R2, R5, L3, R2, L5, R1, R2, R2, L4, L5, L1, L4, R4, R3, R1, R2, L1, L2, R4, R5, L2, R3, L4, L5, L5, L4, R4, L2, R1, R1, L2, L3, L2, R2, L4, R3, R2, L1, L3, L2, L4, L4, R2, L3, L3, R2, L4, L3, R4, R3, L2, L1, L4, R4, R2, L4, L4, L5, L1, R2, L5, L2, L3, R2, L2".replace(" ", "");
        Scanner scanner = new Scanner(input).useDelimiter(",");
        List<String> sequence = new ArrayList<>();

        while (scanner.hasNext()) {
            sequence.add(scanner.next());
        }

        System.out.println(new Day1().blocksAwayFromEasterBunnyHq(sequence));
    }

}
