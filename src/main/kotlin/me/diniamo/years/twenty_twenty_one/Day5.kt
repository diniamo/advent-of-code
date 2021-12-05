package me.diniamo.years.twenty_twenty_one

import me.diniamo.Day
import java.lang.Integer.max

class Day5(year: Int) : Day<List<Pair<Pair<Int, Int>, Pair<Int, Int>>>>(5, year) {
    private fun generateOcean(input: List<Pair<Pair<Int, Int>, Pair<Int, Int>>>): Array<Array<Int>> {
        val maxX = max(input.maxOf { it.first.first }, input.maxOf { it.second.first }) + 1
        val maxY = max(input.maxOf { it.first.second }, input.maxOf { it.second.second }) + 1

        val ocean = Array(maxY) { Array(maxX) { 0 } }  // To access a point: ocean[y][x]

        println(input)
        for(p in input) {
            for(x in (p.first.first rangeOrDownTo p.second.first).also { println(it) }) {
                for(y in (p.first.second rangeOrDownTo p.second.second).also { println(it) }) {
                    ocean[y][x]++
                    println("$x, $y")
                    ocean.forEach { println(it.contentToString().replace('0', '.')) }
                    println()
                }
            }
        }

        return ocean
    }

    override fun partOne(input: List<Pair<Pair<Int, Int>, Pair<Int, Int>>>): Any {
        val ocean = generateOcean(
            input.filter { it.first.first == it.second.first || it.first.second == it.second.second }.also { println(it) }
        )
        return ocean.sumOf { it.count { int -> int > 1 } }
    }

    override fun partTwo(input: List<Pair<Pair<Int, Int>, Pair<Int, Int>>>): Any {
        return "TODO"
    }

    override fun adaptInput(input: List<String>): List<Pair<Pair<Int, Int>, Pair<Int, Int>>> = input.map { str ->
        str.split(" -> ").let {
            Pair(it[0].splitToPairInt(","), it[1].splitToPairInt(","))
        }
    }

    private fun String.splitToPairInt(delimiter: String, ignoreCase: Boolean = false):Pair<Int, Int> = this.split(delimiter, ignoreCase = ignoreCase).let { Pair(it[0].toInt(), it[1].toInt()) }
    private infix fun Int.rangeOrDownTo(other: Int): IntRange = if(other >= this) this..other else other..this
}