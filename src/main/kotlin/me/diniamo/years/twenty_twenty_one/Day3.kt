package me.diniamo.years.twenty_twenty_one

import me.diniamo.Day

class Day3(year: Int) : Day<List<String>>(3, year) {
    override fun partOne(input: List<String>): Any {
        val gammaBuilder = StringBuilder()
        val epsilonBuilder = StringBuilder()

        input.forEach {
            val zeroCount = it.count { c -> c == '0' }
            val oneCount = it.count { c -> c == '1' }

            if(oneCount > zeroCount) {
                gammaBuilder.append('1')
                epsilonBuilder.append('0')
            } else {
                gammaBuilder.append('0')
                epsilonBuilder.append('1')
            }
        }

        return gammaBuilder.toString().toInt(2) * epsilonBuilder.toString().toInt(2)
    }

    override fun partTwo(input: List<String>): Any {
        return "TODO"
    }

    override fun adaptInput(input: List<String>): List<String> {
        val newList = mutableListOf<String>()
        val strBuilder = StringBuilder()

        for(j in 0 until input[0].length) {
            for(str in input) {
                strBuilder.append(str[j])
            }

            newList.add(strBuilder.toString())
            strBuilder.clear()
        }

        return newList.toList()
    }
}