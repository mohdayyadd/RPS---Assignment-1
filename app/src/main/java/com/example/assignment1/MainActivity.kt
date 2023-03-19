package com.example.assignment1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.PlayButton)
        val spinner: Spinner = findViewById(R.id.spinner1)
        val RandomResult: TextView = findViewById(R.id.AIResult)
        val Result : TextView = findViewById(R.id.ResultTextView)
        var flag: String = "Rock"
        var options = arrayOf("Rock", "Paper", "Scissors")
        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        button.setOnClickListener{view->
            var x: String = flag
            var y:String = options.random()
            RandomResult.text = y
            Result.text = RPS(x,y)


        }
    }
}
fun RPS(player1: String, player2: String): String {
    if (player1 == "Rock") {
        when (player2) {
            "Scissors" -> return "Player 1 Wins"
            "Paper" -> return "Player 2 Wins"
            else -> return "Draw"
        }
    }
    if (player1 == "Scissors") {
        when (player2) {
            "Rock" -> return "Player 2 Wins"
            "Paper" -> return "Player 1 Wins"
            else -> return "Draw"
        }
    }
    if (player1 == "Paper") {
        when (player2) {
            "Rock" -> return "Player 1 Wins"
            "Scissors" -> return "Player 2 Wins"
            else -> return "Draw"
        }
    }
    return "Invalid input"
}



