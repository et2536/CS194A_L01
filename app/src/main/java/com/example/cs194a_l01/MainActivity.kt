package com.example.cs194a_l01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNewNumbersToButtons()
        // what happens if select the Left button
        btnLeft.setOnClickListener {
            checkAnswer(true)
            assignNewNumbersToButtons()
        }
        // what happens if select the Right button
        btnRight.setOnClickListener {
            checkAnswer(false)
            assignNewNumbersToButtons()
        }
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftNum: Int = btnLeft.text.toString().toInt()
        val rightNum: Int = btnRight.text.toString().toInt()
        val isAnswerCorrect: Boolean = if (isLeftButtonSelected) leftNum > rightNum else leftNum < rightNum
        if (isAnswerCorrect){
            // correct answer
            // change the background color
            backGroundView.setBackgroundColor(Color.GREEN)
            // show a toast
            Toast.makeText(this,"Correct!",Toast.LENGTH_SHORT).show()
        } else {
            // correct answer
            //change the background color
            backGroundView.setBackgroundColor(Color.RED)
            // show a toast
            Toast.makeText(this,"Incorrect!",Toast.LENGTH_SHORT).show()
        }

    }

    private fun assignNewNumbersToButtons() {
        val leftNum: Int = Random.nextInt(0..9)
        var rightNum: Int = leftNum
        while (rightNum == leftNum){
            rightNum = Random.nextInt(0..9)
        }
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()
    }
}

