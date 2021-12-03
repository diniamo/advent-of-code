package me.diniamo.years.twenty_twenty_one

import me.diniamo.Day

class Day3(year: Int) : Day<List<String>>(3, year) {
    override fun partOne(input: List<String>): Any {
        // Calculate gamma rate
        val gammaRate = StringBuilder().also { builder ->
            input.forEach {
                val zeroCount = it.count { c -> c == '0' }
                val oneCount = it.count { c -> c == '1' }

                builder.append(if(oneCount > zeroCount) '1' else '0')
            }
        }.toString().toInt(2)

        // Calculate epsilonRate
        val epsilonRate = StringBuilder().also { builder ->
            input.forEach {
                val zeroCount = it.count { c -> c == '0' }
                val oneCount = it.count { c -> c == '1' }

                builder.append(if(oneCount < zeroCount) '1' else '0')
            }
        }.toString().toInt(2)

        return gammaRate * epsilonRate
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