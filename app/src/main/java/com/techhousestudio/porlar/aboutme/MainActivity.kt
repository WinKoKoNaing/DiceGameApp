package com.techhousestudio.porlar.aboutme

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    var random = 0
    var player1PointCount = 0
    var player2PointCount = 0
    private val diceArray =
        intArrayOf(
            R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4,
            R.drawable.dice_5, R.drawable.dice_6
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlayer1.setOnClickListener(this)
        btnPlayer2.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        random = (0..5).random()

        when (v?.id) {
            R.id.btnPlayer1 -> {
                ivDice.setBackgroundResource(diceArray[random])
                random++
                tvPlayer1.text = random.toString()
                val player1: Int = tvPlayer1.text.toString().toInt()
                val player2: Int = tvPlayer2.text.toString().toInt()
                if ((player1 + player2) == 7) {
                    player1PointCount++
                    tvPlayer1Score.text = "Point $player1PointCount"
                }


            }
            R.id.btnPlayer2 -> {
                ivDice.setBackgroundResource(diceArray[random])
                random++
                tvPlayer2.text = random.toString()
                val player1: Int = tvPlayer1.text.toString().toInt()
                val player2: Int = tvPlayer2.text.toString().toInt()
                if ((player1 + player2) == 7) {
                    player2PointCount++
                    tvPlayer2Score.text = "Point $player2PointCount"
                }
            }
        }

        if (player1PointCount == 5) {

            Toast.makeText(this, "Player1 Win", Toast.LENGTH_SHORT).show()
        } else if (player2PointCount == 5) {
            Toast.makeText(this, "Player2 Win", Toast.LENGTH_SHORT).show()
        }


    }
}
