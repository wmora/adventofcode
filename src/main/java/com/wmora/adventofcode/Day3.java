package com.wmora.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Day3 {

    int validTriangles(List<List<Integer>> triangles) {
        int validTriangles = 0;

        for (List<Integer> triangle : triangles) {
            if (isValidTriangle(triangle)) {
                validTriangles++;
            }
        }

        return validTriangles;
    }

    private boolean isValidTriangle(List<Integer> triangle) {
        int a = triangle.get(0);
        int b = triangle.get(1);
        int c = triangle.get(2);

        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<List<Integer>> triangles = new ArrayList<>();

        Scanner scanner = new Scanner(new File("day3.txt"));
        while (scanner.hasNextLine()) {
            List<Integer> triangle = new ArrayList<>();
            Scanner lineScanner = new Scanner(scanner.nextLine());
            while (lineScanner.hasNextInt()) {
                triangle.add(lineScanner.nextInt());
            }
            triangles.add(triangle);
        }

        System.out.println(new Day3().validTriangles(triangles));

        triangles.clear();

        scanner = new Scanner(new File("day3.txt"));

        int insertionCount = 0;

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            Scanner lineScanner = new Scanner(nextLine);
            boolean shouldCreateTriangle = triangles.isEmpty() || insertionCount == 3;

            List<Integer> triangle1 = shouldCreateTriangle ? new ArrayList<>() : triangles.get(triangles.size() - 3);
            List<Integer> triangle2 = shouldCreateTriangle ? new ArrayList<>() : triangles.get(triangles.size() - 2);
            List<Integer> triangle3 = shouldCreateTriangle ? new ArrayList<>() : triangles.get(triangles.size() - 1 );

            triangle1.add(lineScanner.nextInt());
            triangle2.add(lineScanner.nextInt());
            triangle3.add(lineScanner.nextInt());

            if (shouldCreateTriangle) {
                triangles.add(triangle1);
                triangles.add(triangle2);
                triangles.add(triangle3);
            }

            if (insertionCount == 3) {
                insertionCount = 1;
            } else {
                insertionCount++;
            }
        }

        System.out.println(new Day3().validTriangles(triangles));
    }

}
