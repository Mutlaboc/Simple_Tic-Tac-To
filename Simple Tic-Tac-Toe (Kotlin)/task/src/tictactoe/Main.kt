package tictactoe

import java.lang.NullPointerException
import kotlin.math.abs

fun main() {
    // write your code here
    var firstPlayer = true
    val text = "         "
    var finish = false
    println("---------")
    println("| ${text[0]} ${text[1]} ${text[2]} |")
    println("| ${text[3]} ${text[4]} ${text[5]} |")
    println("| ${text[6]} ${text[7]} ${text[8]} |")
    println("---------")

    val rowFirst = text.substring(0, 2)
    val rowSecond = text.substring(3, 5)
    val rowThird = text.substring(6, 8)
    var newText = text.toMutableList()

    var winsX = false
    var treeInRowCount = 0
    fun gameStatus() {
        val frequencyMap: MutableMap<Char, Int> = HashMap()
        for (s in newText) {
            var count = frequencyMap[s]
            if (count == null) count = 0
            frequencyMap[s] = (count + 1)
        }
        val playerOneX = if (frequencyMap['X'] != null) frequencyMap['X'] else 0
        val playerTwoX = if (frequencyMap['O'] != null) frequencyMap['O'] else 0
        val space = if (frequencyMap[' '] != null) frequencyMap[' '] else 0
        if (abs((playerOneX!! - playerTwoX!!)) >= 2) {
            println("Impossible")

            return
        }
        if (newText[0] == newText[1] && newText[1] == newText[2] && newText[0] != ' ') {
            if (newText[0] == 'X') winsX = true
//        println("Ряд 1")
            treeInRowCount++
        }

        if (newText[3] == newText[4] && newText[4] == newText[5] && newText[5] != ' ') {
            if (newText[3] == 'X') winsX = true
//        println("Ряд 2")
            treeInRowCount++
        }
        if (newText[6] == newText[7] && newText[7] == newText[8] && newText[8] != ' ') {
            if (newText[6] == 'X') winsX = true
//        println("Ряд 3")
            treeInRowCount++
        }
        if (newText[0] == newText[4] && newText[4] == newText[8] && newText[8] != ' ') {
            if (newText[0] == 'X') winsX = true
//        println("Диагональ 1")
            treeInRowCount++
        }
        if (newText[2] == newText[4] && newText[4] == newText[6] && newText[6] != ' ') {
            if (newText[2] == 'X') winsX = true
            //println("Диагональ 2")
            treeInRowCount++
        }
        if (newText[0] == newText[3] && newText[3] == newText[6] && newText[6] != ' ') {
            if (newText[0] == 'X') winsX = true
            //println("Столб 1")
            treeInRowCount++
        }
        if (newText[1] == newText[4] && newText[4] == newText[7] && newText[7] != ' ') {
            if (newText[1] == 'X') winsX = true
            //println("Столб 2")
            treeInRowCount++
        }
        if (newText[2] == newText[5] && newText[5] == newText[8] && newText[8] != ' ') {
            if (newText[2] == 'X') winsX = true
            //println("столб 3")
            treeInRowCount++
        }
        if (treeInRowCount == 1) {
            finish = true
            if (winsX) println("X wins") else println("O wins")
        }

        if (treeInRowCount > 1) {
            finish = true
            println("Impossible")
        println("Одновременные ряды")
            return
        }
        if (treeInRowCount == 0 && space == 0) {
            finish = true
            println("Draw")
            return
        }

        if (space != null) {
            if (treeInRowCount == 0 && space > 0) {
                println("Game not finished")
                return
            }
        }
    }

    var firstNumber: Int = 0
    var secondNumber: Int = 0
    fun move() {

            try {
                var (a, b) = readln().split(' ').map(String::toInt)
                firstNumber = a
                secondNumber = b
            } catch (ex: NumberFormatException) {
                println("You should enter numbers!")
            }
            catch (ex: NullPointerException){
                println("You should enter numbers!")
            }
            if (firstNumber in 1..3 && secondNumber in 1..3) {
                if (newText[(3 * (firstNumber - 1)) + secondNumber - 1] == ' ') {

                    if (firstPlayer) {
                        newText[(3 * (firstNumber - 1)) + secondNumber - 1] = 'X'
                        firstPlayer = false
                        println("---------")
                        println("| ${newText[0]} ${newText[1]} ${newText[2]} |")
                        println("| ${newText[3]} ${newText[4]} ${newText[5]} |")
                        println("| ${newText[6]} ${newText[7]} ${newText[8]} |")
                        println("---------")
                        gameStatus()
                    }
                    else {
                        newText[(3 * (firstNumber - 1)) + secondNumber - 1] = 'O'
                        firstPlayer = true
                        println("---------")
                        println("| ${newText[0]} ${newText[1]} ${newText[2]} |")
                        println("| ${newText[3]} ${newText[4]} ${newText[5]} |")
                        println("| ${newText[6]} ${newText[7]} ${newText[8]} |")
                        println("---------")
                        gameStatus()
                    }


                } else println("This cell is occupied! Choose another one!")

            } else println("Coordinates should be from 1 to 3!")

        if (finish) return
            move()

        }


        move()


    }

