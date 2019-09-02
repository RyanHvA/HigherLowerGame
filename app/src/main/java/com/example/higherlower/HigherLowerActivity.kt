package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    private fun initViews() {
        buttonLower.setOnClickListener {
            onLowerClick()
        }
        buttonHigher.setOnClickListener {
            onHigherClick()
        }
        buttonEquals.setOnClickListener {
            onEqualClick()
        }

        updateUI()
    }

    private fun updateUI() {
        textLastThrow.text = getString(R.string.textlastthrow, lastThrow)

        when (currentThrow) {
            1 -> imageDice.setImageResource(R.drawable.dice1)
            2 -> imageDice.setImageResource(R.drawable.dice2)
            3 -> imageDice.setImageResource(R.drawable.dice3)
            4 -> imageDice.setImageResource(R.drawable.dice4)
            5 -> imageDice.setImageResource(R.drawable.dice5)
            6 -> imageDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {
        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
        rollDice()
    }

    private fun onLowerClick() {
        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
        rollDice()
    }

    private fun onEqualClick() {
        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
        rollDice()
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.textIncorrect), Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.textCorrect), Toast.LENGTH_SHORT).show()
    }



}
