package com.wmora.adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day2 {

    String getBathroomCode(List<String> instructions) {
        String code = "";
        String[][] keypad = new String[][]{
                new String[]{"1", "2", "3"},
                new String[]{"4", "5", "6"},
                new String[]{"7", "8", "9"}};

        int row = 1;
        int column = 1;

        for (String line : instructions) {
            for (int i = 0; i < line.length(); i++) {
                String direction = String.valueOf(line.charAt(i));

                if ("U".equals(direction) && row > 0) {
                    row--;
                } else if ("D".equals(direction) && row < keypad.length - 1) {
                    row++;
                } else if ("L".equals(direction) && column > 0) {
                    column--;
                } else if ("R".equals(direction) && column < keypad[column].length - 1) {
                    column++;
                }

            }
            code += keypad[row][column];
        }

        return code;
    }

    String getFancyBathroomCode(List<String> instructions) {
        String code = "";
        String[][] keypad = new String[][]{
                new String[]{"X", "X", "1", "X", "X"},
                new String[]{"X", "2", "3", "4", "X"},
                new String[]{"5", "6", "7", "8", "9"},
                new String[]{"X", "A", "B", "C", "X"},
                new String[]{"X", "X", "D", "X", "X"}};

        int row = 2;
        int column = 0;

        for (String line : instructions) {
            for (int i = 0; i < line.length(); i++) {
                String direction = String.valueOf(line.charAt(i));

                if ("U".equals(direction) && row > 0) {
                    if (!"X".equals(keypad[row - 1][column])) {
                        row--;
                    }
                } else if ("D".equals(direction) && row < keypad.length - 1) {
                    if (!"X".equals(keypad[row + 1][column])) {
                        row++;
                    }
                } else if ("L".equals(direction) && column > 0) {
                    if (!"X".equals(keypad[row][column - 1])) {
                        column--;
                    }
                } else if ("R".equals(direction) && column < keypad[column].length - 1) {
                    if (!"X".equals(keypad[row][column + 1])) {
                        column++;
                    }
                }

            }
            code += keypad[row][column];
        }

        return code;
    }

    public static void main(String[] args) {
        String input = "RDLRUUULRRDLRLLRLDDUDLULULDDULUDRRUURLRLLUULDURRULLRULDRRDLLULLRLLDRLDDRRRRLLRLURRRDRDULRDUULDDDULURUDDRRRUULUDRLLUUURLUDRUUUDRDUULLRLLUDDRURRDDDRDLUUURLRLLUDRURDUDUULDDLLRDURULLLURLDURLUUULDULDDULULLLRRUDLRUURDRDLLURLUDULDUUUURRLDLUDRULUDLDLLDRLDDDRRLLDUDLLRRDDDRLUDURLLLDRUDDLDDRRLUDRRDUDLRRLULDULURULDULUULDRLLDRUUDDRLLUDRULLRRRLRDLRLUDLRULDRDLRDRLRULUDUURRUUULLDDDDUDDLDDDDRRULRDLRDDULLDLDLLDLLDLLDRRDDDRDDLRRDDDRLLLLURRDLRRLDRURDDURDULDDRUURUDUDDDRDRDDRLRRLRULLDRLDLURLRLRUDURRRDLLLUDRLRDLLDDDLLUDRLDRRUUDUUDULDULLRDLUDUURLDDRUDR\n" +
                "URULDDLDDUDLLURLUUUUUULUDRRRDDUDURDRUURLLDRURLUULUDRDRLLDRLDULRULUURUURRLRRDRUUUDLLLLRUDDLRDLLDUDLLRRURURRRUDLRLRLLRULRLRLRDLRLLRRUDDRLRUDULDURDLDLLLRDRURURRULLLDLLRRDRLLDUUDLRUUDDURLLLDUUDLRDDURRDRRULLDRLRDULRRLLRLLLLUDDDRDRULRRULLRRUUDULRRRUDLLUUURDUDLLLURRDDUDLDLRLURDDRRRULRRUDRDRDULURULRUDULRRRLRUDLDDDDRUULURDRRDUDLULLRUDDRRRLUDLRURUURDLDURRDUUULUURRDULLURLRUUUUULULLDRURULDURDDRRUDLRLRRLLLLDDUURRULLURURRLLDRRDDUUDLLUURRDRLLLLRLUDUUUDLRLRRLDURDRURLRLRULURLDULLLRRUUUDLLRRDUUULULDLLDLRRRDUDDLRULLULLULLULRU\n" +
                "DURUUDULRRLULLLDDUDDLRRDURURRRDDRRURDRURDRLULDUDUDUULULDDUURDDULRDUDUDRRURDRDDRLDRDRLDULDDULRULLDULURLUUDUDULRDDRRLURLLRRDLLDLDURULUDUDULDRLLRRRUDRRDDDRRDRUUURLDLURDLRLLDUULLRULLDDDDRULRRLRDLDLRLUURUUULRDUURURLRUDRDDDRRLLRLLDLRULUULULRUDLUDULDLRDDDDDRURDRLRDULRRULRDURDDRRUDRUDLUDLDLRUDLDDRUUULULUULUUUDUULDRRLDUDRRDDLRUULURLRLULRURDDLLULLURLUDLULRLRRDDDDDRLURURURDRURRLLLLURLDDURLLURDULURUUDLURUURDLUUULLLLLRRDUDLLDLUUDURRRURRUUUDRULDDLURUDDRRRDRDULURURLLDULLRDDDRRLLRRRDRLUDURRDLLLLDDDDLUUURDDDDDDLURRURLLLUURRUDLRLRRRURULDRRLULD\n" +
                "LLUUURRDUUDRRLDLRUDUDRLRDLLRDLLDRUULLURLRRLLUDRLDDDLLLRRRUDULDLLLDRLURDRLRRLURUDULLRULLLURRRRRDDDLULURUDLDUDULRRLUDDURRLULRRRDDUULRURRUULUURDRLLLDDRDDLRRULRDRDRLRURULDULRRDRLDRLLDRDURUUULDLLLRDRRRLRDLLUDRDRLURUURDLRDURRLUDRUDLURDRURLRDLULDURDDURUUDRLULLRLRLDDUDLLUUUURLRLRDRLRRRURLRULDULLLLDLRRRULLUUDLDURUUUDLULULRUDDLLDLDLRLDDUDURDRLLRRLRRDDUDRRRURDLRLUUURDULDLURULUDULRRLDUDLDDDUUDRDUULLDDRLRLLRLLLLURDDRURLDDULLULURLRDUDRDDURLLLUDLLLLLUDRDRDLURRDLUDDLDLLDDLUDRRDDLULRUURDRULDDDLLRLDRULURLRURRDDDRLUUDUDRLRRUDDLRDLDULULDDUDURRRURULRDDDUUDULLULDDRDUDRRDRDRDLRRDURURRRRURULLLRRLR\n" +
                "URLULLLDRDDULRRLRLUULDRUUULDRRLLDDDLDUULLDRLULRRDRRDDDRRDLRRLLDDRDULLRRLLUDUDDLDRDRLRDLRDRDDUUDRLLRLULLULRDRDDLDDDRLURRLRRDLUDLDDDLRDLDLLULDDRRDRRRULRUUDUULDLRRURRLLDRDRRDDDURUDRURLUDDDDDDLLRLURULURUURDDUDRLDRDRLUUUULURRRRDRDULRDDDDRDLLULRURLLRDULLUUDULULLLLRDRLLRRRLLRUDUUUULDDRULUDDDRRRULUDURRLLDURRDULUDRUDDRUURURURLRDULURDDDLURRDLDDLRUDUUDULLURURDLDURRDRDDDLRRDLLULUDDDRDLDRDRRDRURRDUDRUURLRDDUUDLURRLDRRDLUDRDLURUDLLRRDUURDUDLUDRRL";

        Scanner scanner = new Scanner(input);
        List<String> instructions = new ArrayList<>();

        while (scanner.hasNext()) {
            instructions.add(scanner.next());
        }

        System.out.println(new Day2().getBathroomCode(instructions));
        System.out.println(new Day2().getFancyBathroomCode(instructions));
    }

}
