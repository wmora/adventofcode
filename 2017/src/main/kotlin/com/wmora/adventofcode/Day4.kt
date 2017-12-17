package com.wmora.adventofcode

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(File("day4.txt"))
    val input = ArrayList<String>()

    while (scanner.hasNextLine()) {
        input.add(scanner.nextLine())
    }

    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    return numberOfValidPassphrases(input)
}

fun part2(input: List<String>): Int {
    return numberOfValidPassphrasesWithoutAnagrams(input)
}

fun numberOfValidPassphrases(input: List<String>): Int {
    return input.count { isValidPassphrase(it) }
}

fun isValidPassphrase(input: String): Boolean {
    val lineScanner = Scanner(input)
    val words = mutableSetOf<String>()

    while (lineScanner.hasNext()) {
        val word = lineScanner.next()

        if (words.contains(word)) {
            return false
        }

        words.add(word)
    }

    return true
}

fun numberOfValidPassphrasesWithoutAnagrams(input: List<String>): Int {
    return input.count { isValidPassphraseWithoutAnagrams(it) }
}

fun isValidPassphraseWithoutAnagrams(input: String): Boolean {
    val lineScanner = Scanner(input)
    val words = mutableSetOf<String>()

    while (lineScanner.hasNext()) {
        val word = lineScanner.next()

        val sortedWord = word.toCharArray().sorted().joinToString()

        if (words.contains(sortedWord)) {
            return false
        }

        words.add(sortedWord)
    }

    return true
}