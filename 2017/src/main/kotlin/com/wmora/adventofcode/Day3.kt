package com.wmora.adventofcode

fun main(args: Array<String>) {
    println("Part 1: ${part1(277678)}")
    println("Part 2: ${part2(277678)}")
}

fun part1(input: Int): Int {
    return numberOfSteps(input)
}

fun numberOfSteps(input: Int): Int {
    if (input == 1) {
        return 1
    }

    val squareSideSize = (1..input step 2).firstOrNull { it * it >= input } ?: 1

    val maxLayerValue = Math.pow(squareSideSize.toDouble(), 2.0).toInt()
    val minLayerValue = Math.pow(squareSideSize.toDouble() - 2, 2.0) + 1

    val topRightEdge = minLayerValue + squareSideSize - 2
    val topLeftEdge = topRightEdge + squareSideSize - 1
    val bottomLeftEdge = topLeftEdge + squareSideSize - 1

    val edgeToCenterSteps = squareSideSize / 2

    val horizontalSteps: Int
    val verticalSteps: Int

    when (input.toDouble()) {
        in minLayerValue..topRightEdge -> {
            // right
            horizontalSteps = edgeToCenterSteps
            verticalSteps = (edgeToCenterSteps - (topRightEdge - input)).toInt()
        }
        in (topRightEdge + 1)..topLeftEdge -> {
            // top
            horizontalSteps = (edgeToCenterSteps - (topLeftEdge - input)).toInt()
            verticalSteps = edgeToCenterSteps
        }
        in (topLeftEdge + 1)..bottomLeftEdge -> {
            // left
            horizontalSteps = edgeToCenterSteps
            verticalSteps = (edgeToCenterSteps - (bottomLeftEdge - input)).toInt()
        }
        else -> {
            // bottom
            horizontalSteps = edgeToCenterSteps
            verticalSteps = edgeToCenterSteps - (maxLayerValue - input)
        }
    }

    return horizontalSteps + verticalSteps
}

fun part2(input: Int): Int {
    return sumOfAdjacent(input)
}

fun sumOfAdjacent(input: Int): Int {
    if (input == 1) {
        return 1
    }

    val grid = mutableListOf(mutableListOf(1))

    for (i in 1..input) {
        // create square

        for (row in grid) {
            row.add(0, 0)
            row.add(0)
        }
        grid.add(0, MutableList(grid[0].size, { 0 }))
        grid.add(MutableList(grid[0].size, { 0 }))

        val sideSize = grid.size

        // go up
        val startingPositionRight = sideSize - 2
        for (row in startingPositionRight downTo 0) {
            val bottom = if (row + 1 < grid.size) grid[row + 1][grid.size - 1] else 0
            val bottomLeft = if (row + 1 < grid.size) grid[row + 1][grid.size - 2] else 0
            val left = grid[row][grid.size - 2]
            val topLeft = if (row - 1 >= 0) grid[row - 1][grid.size - 2] else 0

            val sum = bottom + bottomLeft + left + topLeft

            if (sum > input) {
                return sum
            }

            grid[row][grid.size - 1] = sum
        }

        // go left
        val startingPositionTop = grid.size - 2
        for (column in startingPositionTop downTo 0) {
            val right = if (column + 1 < grid.size) grid[0][column + 1] else 0
            val bottomRight = if (column + 1 < grid.size) grid[1][column + 1] else 0
            val bottom = grid[1][column]
            val bottomLeft = if (column - 1 >= 0) grid[1][column - 1] else 0

            val sum = right + bottomRight + bottomLeft + bottom

            if (sum > input) {
                return sum
            }

            grid[0][column] = sum
        }

        // go down
        val startingPositionLeft = 1
        for (row in startingPositionLeft..(grid.size - 1)) {
            val top = if (row - 1 >= 0) grid[row - 1][0] else 0
            val topRight = if (row - 1 >= 0) grid[row - 1][1] else 0
            val right = grid[row][1]
            val bottomRight = if (row + 1 < grid.size) grid[row + 1][1] else 0

            val sum = right + bottomRight + top + topRight

            if (sum > input) {
                return sum
            }

            grid[row][0] = sum
        }

        // go right
        val startingPositionBottom = 1
        for (column in startingPositionBottom..(grid.size - 1)) {
            val left = if (column - 1 >= 0) grid[grid.size - 1][column - 1] else 0
            val topLeft = if (column - 1 >= 0) grid[grid.size - 2][column - 1] else 0
            val top = grid[grid.size - 2][column]
            val topRight = if (column + 1 < grid.size) grid[grid.size - 2][column + 1] else 0

            val sum = left + topLeft + top + topRight

            if (sum > input) {
                return sum
            }

            grid[grid.size - 1][column] = sum
        }
        
    }

    return 0
}
