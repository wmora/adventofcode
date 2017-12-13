package com.wmora.adventofcode

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val scanner = Scanner(File("day2.txt"))
    val input = ArrayList<ArrayList<Int>>()

    while (scanner.hasNextLine()) {
        val lineScanner = Scanner(scanner.nextLine())
        val lineArray = ArrayList<Int>()

        while (lineScanner.hasNextInt()) {
            lineArray.add(lineScanner.nextInt())
        }

        input.add(lineArray)
    }

    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: ArrayList<ArrayList<Int>>): Int {
    return input.sumBy { minMaxDifference(it) }
}

fun minMaxDifference(input: ArrayList<Int>): Int {
    var min = input[0]
    var max = input[0]

    for (number in input) {
        min = Math.min(min, number)
        max = Math.max(max, number)
    }

    return max - min
}

fun part2(input: ArrayList<ArrayList<Int>>): Int {
    return input.sumBy { evenlyDivisionResult(it) }
}

fun evenlyDivisionResult(input: ArrayList<Int>): Int {
    for (dividend in input) {
        input.filter { it != dividend && dividend % it == 0 }
                .forEach { return dividend / it }
    }
    return 0
}
