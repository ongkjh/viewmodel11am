package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {


    /*// The current word
    var word = ""

    // current score
    var score = 0
*/
    // The current word
    private val _word = MutableLiveData<String>()

    // encapsulate data - backing property
    val word: LiveData<String>
        get() = _word

    // current score
    private val _score = MutableLiveData<Int>()

    // encapsulate data - backing property
    val score: LiveData<Int>
        get() = _score

    // eventGameFinished
    private val _eventGameFinished = MutableLiveData<Boolean>()

    // backing property for eventGameFinished
    val eventGameFinished: LiveData<Boolean>
        get() = _eventGameFinished

    // The list of words - the front of the list is the next word to guess
    lateinit var wordList: MutableList<String>


    init {
        Log.i("GameViewModel", "GameViewModel Created!")
        _word.value = ""
        _score.value = 0
        _eventGameFinished.value = false
        resetList()
        nextWord()
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (wordList.isEmpty()) {
            // when word from list is finished call onGameFinish
            onGameFinish()

        }else{
            //Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        _score.value = (score.value)?.minus(1)
//        score--
        nextWord()
    }

    fun onCorrect() {
        _score.value = (score.value)?.plus(1)
//        score++
        nextWord()
    }

    fun onGameFinish(){
        _eventGameFinished.value = true
    }

    fun onGameFinishComplete(){
        _eventGameFinished.value = false
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel Destroyed!")
    }
}