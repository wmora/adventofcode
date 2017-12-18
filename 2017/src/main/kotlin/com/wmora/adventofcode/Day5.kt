package com.wmora.adventofcode

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(File("day5.txt"))
    val input = ArrayList<Int>()

    while (scanner.hasNextLine()) {
        input.add(Scanner(scanner.nextLine()).nextInt())
    }

    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<Int>): Int {
    val input = input.toMutableList()
    var steps = 0
    var currentIndex = 0

    while (currentIndex < input.size) {
        val previousIndex = currentIndex
        currentIndex += input[previousIndex]
        input[previousIndex]++
        steps++
    }

    return steps
}

fun part2(input: List<Int>): Int {
    val input = input.toMutableList()
    var steps = 0
    var currentIndex = 0

    while (currentIndex < input.size) {
        val previousIndex = currentIndex
        currentIndex += input[previousIndex]
        if (input[previousIndex] >= 3) {
            input[previousIndex]--
        } else {
            input[previousIndex]++
        }
        steps++
    }

    return steps
}