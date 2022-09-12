package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    // final score
    private val _score = MutableLiveData<Int>()
    private val _eventPlayAgain = MutableLiveData<Boolean>()

    // data encapsulation - backing property
    val score: LiveData<Int>
        get() = _score

    val eventPlayAgain : LiveData<Boolean>
    get() = _eventPlayAgain

    init {
        Log.i("ScoreViewModel", "Final Score is $finalScore")
        _score.value = finalScore
        _eventPlayAgain.value = false
    }


    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }
    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }
}