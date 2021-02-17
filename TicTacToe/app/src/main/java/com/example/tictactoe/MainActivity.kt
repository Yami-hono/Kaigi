package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.getTag

// 1 -> X
//0 -> O
class MainActivity : AppCompatActivity() {

   var activePlayer = 0
    var gameActive= true
    var gameState= arrayOf(5,5,5,5,5,5,5,5,5)
    //DECODE
    //0 - O
    //1 - X
    //5 - Null
    //var winPositions = Array(3,{ i->Array(3,{j->3})})
    var winPosi = arrayOf(arrayOf<Int>(0,1,2),arrayOf<Int>(3,4,5),
                            arrayOf<Int>(6,7,8),arrayOf<Int>(1,4,7),
                            arrayOf<Int>(2,5,8),arrayOf<Int>(0,3,6),
                            arrayOf<Int>(0,4,8),arrayOf<Int>(2,4,6))
    fun tap(view:View)
    {

        lateinit var img: ImageView
        lateinit var txtX: TextView
        lateinit var txtY: TextView
        img= view as ImageView
        txtX= findViewById(R.id.X)
        txtY= findViewById(R.id.O)
        txtX.setTextColor(Color.parseColor("#FFFFFF"))
        txtY.setTextColor(Color.parseColor("#FFFFFF"))
        var tappedImage = (img.getTag() as String).toInt()

        if(!gameActive)
            gameReset(view)
        if(gameState[tappedImage]==5) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f)
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.zero1)
                activePlayer = 1
                //txtY.setTextColor(16711681)
                txtX.setTextColor(Color.parseColor("#FF0000"))

            } else {
                img.setImageResource(R.drawable.cross1)
                activePlayer = 0
                //txtX.setTextColor(16711681)
                txtY.setTextColor(Color.parseColor("#0000FF"))
            }

            img.animate().translationYBy(1000f).setDuration(300)
        }
        var winStr: String?
        //winCheck
        for(winPos in winPosi)
        {
            if(gameState[winPos[0]] == gameState[winPos[1]] &&
                    gameState[winPos[2]] == gameState[winPos[1]] &&
                    gameState[winPos[0]] != 5) {
                        //someone won
                            gameActive=false
                if(gameState[winPos[0]] == 0) {
                    winStr = "O has Won"
                    txtY.setText("O has Won")
                    txtX.setText("X has Lost")
                    //txtY.setTextColor(Color.parseColor("#0000FF"))
                }

                else {
                    winStr = "X has won"
                    txtX.setText("X has Won")
                    txtY.setText("O has Lost")

                }
                txtX.setTextColor(Color.parseColor("#FF0000"))
                txtY.setTextColor(Color.parseColor("#0000FF"))


                //gameActive=false
                //update of status bar


            }


        }
        
    }
    fun gameReset(view:View)
    {
        gameActive=true
        activePlayer=0
        gameState= arrayOf(5,5,5,5,5,5,5,5,5)
        var img: ImageView
        lateinit var txtX: TextView
        lateinit var txtY: TextView
        txtX= findViewById(R.id.X)
        txtY= findViewById(R.id.O)
        img= findViewById(R.id.but1)
        img.setImageResource(0)
        img= findViewById(R.id.but2)
        img.setImageResource(0)
        img= findViewById(R.id.but3)
        img.setImageResource(0)
        img= findViewById(R.id.but4)
        img.setImageResource(0)
        img= findViewById(R.id.but5)
        img.setImageResource(0)
        img= findViewById(R.id.but6)
        img.setImageResource(0)
        img= findViewById(R.id.but7)
        img.setImageResource(0)
        img= findViewById(R.id.but8)
        img.setImageResource(0)
        img= findViewById(R.id.but9)
        img.setImageResource(0)
        txtX.setText("X")
        txtY.setText("O")
        txtX.setTextColor(Color.parseColor("#FFFFFF"))
        txtY.setTextColor(Color.parseColor("#0000FF"))


    }
    fun OnDragListener(view: View){
        gameReset(view)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


