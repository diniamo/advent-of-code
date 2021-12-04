package me.diniamo.years.twenty_twenty_one

import me.diniamo.Day

class Day4(year: Int) : Day<List<String>>(4, year) {
    private val spaceRegex = Regex("\\s+")
    private fun isBingoOver(boards: List<String>): String? {
        for(board in boards) {
            val splitBoard = board.split("\n").map { it.split(spaceRegex) }

            if(splitBoard[0][0].startsWith("!") && splitBoard[0][1].startsWith("!") && splitBoard[0][2].startsWith("!") && splitBoard[0][3].startsWith("!") && splitBoard[0][4].startsWith("!") ||
                splitBoard[1][0].startsWith("!") && splitBoard[1][1].startsWith("!") && splitBoard[1][2].startsWith("!") && splitBoard[1][3].startsWith("!") && splitBoard[1][4].startsWith("!") ||
                splitBoard[2][0].startsWith("!") && splitBoard[2][1].startsWith("!") && splitBoard[2][2].startsWith("!") && splitBoard[2][3].startsWith("!") && splitBoard[2][4].startsWith("!") ||
                splitBoard[3][0].startsWith("!") && splitBoard[3][1].startsWith("!") && splitBoard[3][2].startsWith("!") && splitBoard[3][3].startsWith("!") && splitBoard[3][4].startsWith("!") ||
                splitBoard[4][0].startsWith("!") && splitBoard[4][1].startsWith("!") && splitBoard[4][2].startsWith("!") && splitBoard[4][3].startsWith("!") && splitBoard[4][4].startsWith("!"))
                return board
            else if(splitBoard[0][0].startsWith("!") && splitBoard[1][0].startsWith("!") && splitBoard[2][0].startsWith("!") && splitBoard[3][0].startsWith("!") && splitBoard[4][0].startsWith("!") ||
                splitBoard[0][1].startsWith("!") && splitBoard[1][1].startsWith("!") && splitBoard[2][1].startsWith("!") && splitBoard[3][1].startsWith("!") && splitBoard[4][1].startsWith("!") ||
                splitBoard[0][2].startsWith("!") && splitBoard[1][2].startsWith("!") && splitBoard[2][2].startsWith("!") && splitBoard[3][2].startsWith("!") && splitBoard[4][2].startsWith("!") ||
                splitBoard[0][3].startsWith("!") && splitBoard[1][3].startsWith("!") && splitBoard[2][3].startsWith("!") && splitBoard[3][3].startsWith("!") && splitBoard[4][3].startsWith("!") ||
                splitBoard[0][4].startsWith("!") && splitBoard[1][4].startsWith("!") && splitBoard[2][4].startsWith("!") && splitBoard[3][4].startsWith("!") && splitBoard[4][4].startsWith("!"))
                return board
        }

        return null
    }

    override fun partOne(input: List<String>): Any {
        val numbers = input[0].split(",")
        var boards: List<String> = input.subList(1, input.size).toMutableList()

        var winnerBoard: String? = null
        var lastCall: String = "1"
        for(number in numbers) {
            if(winnerBoard != null)
                break

            boards = boards.map { it.replace("\\b$number\\b".toRegex(), "!$number") }

            lastCall = number
            winnerBoard = isBingoOver(boards)
        }

        var sumOfUnmarked = 0
        winnerBoard!!.split("\n").map { it.trim() }.map { it.split(spaceRegex) }.forEach {
            it.forEach { str ->
                if(!str.contains('!'))
                    sumOfUnmarked += str.toInt()
            }
        }

        return sumOfUnmarked * lastCall.toInt()
    }

    override fun partTwo(input: List<String>): Any {
        return "todo"
    }

    // Split on blank lines
    override fun adaptInput(input: List<String>): List<String> = input.joinToString("\n").split(Regex("\r?\n\\s*\r?\n"))
}