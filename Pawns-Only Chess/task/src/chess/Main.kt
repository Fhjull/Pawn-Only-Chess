package chess

import kotlin.math.absoluteValue

fun main() {
    println("Pawns-Only Chess")
    println("First Player's name:")
    val whitePlayersName = readLine()!!
    println("Second Player's name:")
    val blackPlayersName = readLine()!!
    var nextPlayer = whitePlayersName
    loop@ while (true) {
        println(Board)
        if (
            if (nextPlayer == whitePlayersName) {
                Board.winConditions(true)
            } else {
                Board.winConditions(false)
            }
        ) {
            break@loop
        }
        println("$nextPlayer's turn:")
        var move = readLine()!!
        if (move == "exit") break@loop
        while (if (nextPlayer == whitePlayersName) !Board.movePawn(move, true)
            else !Board.movePawn(move, false)
        ) {
            println("$nextPlayer's turn:")
            move = readLine()!!
            if (move == "exit") break@loop
        }
        nextPlayer = if (nextPlayer == whitePlayersName) blackPlayersName else whitePlayersName
    }
    println("Bye!")
}


object Board {
    private val board = Array(8) { Array(8) { Pawn.EMPTY } }

    init {
        for (i in 0..7) {
            board[1][i] = Pawn.BLACK
            board[6][i] = Pawn.WHITE
        }
    }

    enum class Pawn(private val color: String) {
        WHITE("W"),
        BLACK("B"),
        ENPASSANT(" "),
        EMPTY(" ");

        override fun toString(): String {
            return this.color
        }
    }


    fun movePawn(coordinates: String, turnOfWhite: Boolean): Boolean {
        val regex = "[a-h][1-8][a-h][1-8]".toRegex()
        val char1 = coordinates[0].code - 97
        val char2 = coordinates[2].code - 97
        val row1 = 8 - coordinates[1].digitToInt()
        val row2 = 8 - coordinates[3].digitToInt()
        if (board[row1][char1] != if (turnOfWhite) Pawn.WHITE else Pawn.BLACK) {
            println(
                "No " + if (turnOfWhite) {
                    "white"
                } else {
                    "black"
                } + " pawn at ${coordinates[0]}${coordinates[1]}"
            )
            return false
        } else if (
            !coordinates.matches(regex) ||
            (char1 - char2).absoluteValue > 1 ||
            (coordinates[0] != coordinates[2] && board[row2][char2] != if (turnOfWhite) {
                Pawn.BLACK
            } else {
                Pawn.WHITE
            } &&
                    board[row2][char2] != Pawn.ENPASSANT
                    ) ||
            coordinates[1] == coordinates[3] ||
            coordinates[1] == '1' ||
            coordinates[1] == '8' ||
            if (turnOfWhite) {
                row1 - row2 < 1
            } else {
                row2 - row1 < 1
            } ||
            if (turnOfWhite) {
                (row1 - row2 > 1 && coordinates[1] != '2')
            } else {
                (row2 - row1 > 1 && coordinates[1] != '7')
            } ||
            if (turnOfWhite) {
                (row1 - row2 > 2 && coordinates[1] == '2')
            } else {
                (row2 - row1 > 2 && coordinates[1] == '7')
            } ||
            (coordinates[0] == coordinates[2] && board[row2][char2] == if (turnOfWhite) Pawn.BLACK else Pawn.WHITE)
        ) {
            println("Invalid Input")
            return false
        }

        board[row1][char1] = Pawn.EMPTY
        if (board[row2][char2] == Pawn.ENPASSANT) {
            board[row1][char2] = Pawn.EMPTY
        }
        board[row2][char2] = if (turnOfWhite) Pawn.WHITE else Pawn.BLACK
        for (row in board.indices) {
            for (char in board[row].indices) {
                if (board[row][char] == Pawn.ENPASSANT) board[row][char] = Pawn.EMPTY
            }
        }
        if ((row1 - row2).absoluteValue == 2) {
            board[(row1 + row2) / 2][char1] = Pawn.ENPASSANT
        }
        return true
    }

    fun winConditions(turnOfWhite: Boolean): Boolean {
        val whiteOnLastRank = board[0].contains(Pawn.WHITE)
        var allBlackCaptured = true
        for (row in board) {
            if (row.contains(Pawn.BLACK)) allBlackCaptured = false
        }
        val blackOnLastRank = board[7].contains(Pawn.BLACK)
        var allWhiteCaptured = true
        for (row in board) {
            if (row.contains(Pawn.WHITE)) allWhiteCaptured = false
        }
        if (whiteOnLastRank || allBlackCaptured) {
            println("White wins!")
            return true
        }
        if (blackOnLastRank || allWhiteCaptured) {
            println("Black wins!")
            return true
        }
        var stalemate = true
        for (row in 1..6) {
            for (char in 0..7) {
                if (turnOfWhite) {
                    if (board[row][char] == Pawn.WHITE) {
                        if (
                            board[row - 1][char] == Pawn.EMPTY ||
                            if (char == 0) {
                                false
                            } else {
                                board[row - 1][char - 1] == Pawn.BLACK
                            } ||
                            if (char == 7) {
                                false
                            } else {
                                board[row - 1][char + 1] == Pawn.BLACK
                            }
                        ) {
                            stalemate = false
                        }
                    }
                } else {
                    if (board[row][char] == Pawn.BLACK) {
                        if (
                            board[row + 1][char] == Pawn.EMPTY ||
                            if (char == 0) {
                                false
                            } else {
                                board[row + 1][char - 1] == Pawn.WHITE
                            } ||
                            if (char == 7) {
                                false
                            } else {
                                board[row + 1][char + 1] == Pawn.WHITE
                            }
                        ) {
                            stalemate = false
                        }
                    }
                }
            }
        }
        if (stalemate) {
            println("Stalemate!")
            return true
        }
        return false
    }

    override fun toString(): String {
        return buildString {
            append("  +---+---+---+---+---+---+---+---+\n")
            repeat(8) {
                append("${8 - it} | ${board[it].joinToString(" | ")} |\n")
                append("  +---+---+---+---+---+---+---+---+\n")
            }
            append("    a   b   c   d   e   f   g   h\n")
        }
    }
}