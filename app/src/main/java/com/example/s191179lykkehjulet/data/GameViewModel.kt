package com.example.s191179lykkehjulet.data

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.s191179lykkehjulet.model.*


/**
 * Source: https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-3
 * used for inspiration
 */

/**
 * ViewModel containing the app data and methods to process the data
 */

class GameViewModel : ViewModel() {
    init {
        Log.d("WordGame", "GameViewModel created!")
    }

    var _score = 0
    val score: Int
        get() = _score

    var _lives = 5
    val lives: Int
        get() = _lives

    //Not implemented
    //val currentHiddenWord = listCategory

    //Just to show a word quickly - doesnt actually work
    val currentHiddenWord = sportsgrene.random()
    val currentHiddenWordToList = currentHiddenWord.toList()


    private var PlayerGuessesList: MutableList<String> = mutableListOf()
    lateinit var listCategory: List<String>
    lateinit var CurrentWord: String
    lateinit var currentWordList: MutableList<String>
    var CorrectPlayerGuesses: MutableList<String> = arrayListOf()


    // not implemented
    private fun getNextWord(): String {
        CurrentWord = currentHiddenWord
        val hiddenLetters = HideLettersInWord()

        var items = ""
        for (item in hiddenLetters) {
            items += item
        }
        return items
    }

    // Hides the letters in word
    fun HideLettersInWord(): MutableList<String> {
        var hideCurrentWordList = ""
        for (index in 0..currentHiddenWordToList.size - 1) {
            if (!currentHiddenWordToList.get(index).equals(" ")) {
                hideCurrentWordList += "*"
            }
        }
        return hideCurrentWordList.split(" ").toMutableList()
    }

    //not implemented
    fun CheckLetter() {
        TODO()
    }



    fun restartData() {
        _score == 0
        PlayerGuessesList.clear()
        //getNextWord()
    }

    private fun increaseScore() {
        _score += 1000
    }

    private fun addLife() {
        _lives += 1
    }

    private fun subtractLife() {
        _lives -= 1
    }

    private fun bankruptcy() {
        _lives == 0
    }


    fun isPlayerGuessCorrect(playerGuess: String) {
        if (playerGuess in CorrectPlayerGuesses) {
            CorrectPlayerGuesses.add(playerGuess)
            increaseScore()
        } else subtractLife()
    }

    fun WheelOutcomes(outcome: String): String {
        val randomWheel = WheelList.random()

        when (outcome) {
            "ekstra liv" -> {addLife()}
            "mistet liv" -> {subtractLife()}
            "bankerot" -> {bankruptcy()}
            //"1000 point" -> {increaseScore()}
        }
        return randomWheel
    }

    fun getWord(category: String) {
        when(category) {
            "Sportsgrene" -> {listCategory = sportsgrene}
            "Instrumenter" -> {listCategory = instrumenter}
            "Historie" -> {listCategory = historie}
            "Lande" -> {listCategory = lande}
            "Dyr" -> {listCategory = dyr}
        }
    }

    fun gameWon(): Boolean {
        if (CorrectPlayerGuesses.containsAll(currentWordList)) {
            return true
       }
        return false
    }
}
