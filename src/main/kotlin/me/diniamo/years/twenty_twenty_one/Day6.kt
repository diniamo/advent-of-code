package me.diniamo.years.twenty_twenty_one

import me.diniamo.Day

class Day6(year: Int) : Day<List<Int>>(6, year) {
    private fun countLanternFish(start: List<Int>, amountOfDays: Int): Int {
        val current = start.toMutableList()

        for(unused in 1..amountOfDays) {
            current.toList().forEachIndexed { i, v ->
                when(v) {
                    0 -> {
                        current[i] = 6
                        current.add(8)
                    }
                    else -> current[i] -= 1
                }
            }
        }

        return current.size
    }

    override fun partOne(input: List<Int>): Any = countLanternFish(input, 80)
    override fun partTwo(input: List<Int>): Any = countLanternFish(input, 256)

    override fun adaptInput(input: List<String>): List<Int> = input[0].split(',').map { it.toInt() }
}