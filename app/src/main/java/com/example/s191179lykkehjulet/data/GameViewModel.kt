package com.example.s191179lykkehjulet.data

import android.text.Spannable
import android.text.SpannableString
import android.text.style.TtsSpan
import android.util.Log
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.s191179lykkehjulet.R
import com.example.s191179lykkehjulet.adapter.CategoryAdapter
import com.example.s191179lykkehjulet.model.Category
import com.example.s191179lykkehjulet.model.sportsgrene

/**
 * ViewModel containing the app data and methods to process the data
 */

class GameViewModel : ViewModel() {
    init {
        Log.d("WordGame", "GameViewModel created!")
    }

    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    private val _lives = MutableLiveData(0)
    val lives: LiveData<Int>
        get() = _lives




    private val _currentHiddenWord = MutableLiveData<String>()

    var secret: String = ""





    private var PlayerGuessesList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    val currentHiddenWord = sportsgrene.random()




    /*
     * Updates currentWord and currentHiddenWord with the next word
     * lacks proper logic so that not only sportsgrene is chosen
     */

    //private fun getNextWord() {
        //currentWord = sportsgrene.random()
        //val tempWord = currentWord.toCharArray()

    //}

    fun reinitializeData() {
        _score.value = 0
        PlayerGuessesList.clear()
        //getNextWord()
    }

    private fun increaseScore() {
        _score.value = _score.value?.plus(10)
    }

    fun isPlayerGuessCorrect(playerGuess: String): Boolean {
        if (playerGuess.equals(currentHiddenWord.toString(), true)) {
            increaseScore()
            return true
        }
        return false
    }

}