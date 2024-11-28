package com.example.hellowworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.random.Random
import androidx.lifecycle.ViewModel
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {

    //outside of lifecycle methods
    private val model: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("tag","inside onCreate") //e for error, d for debug, i for info, w for warning

        // check model
        findViewById<TextView>(R.id.textView).text = model.nextRandom().toString()
    }

}

// all the logic related to random number generation is here and it is safe between lifecycle stages
class MyViewModel: ViewModel() {
    private var random = 0

    fun nextRandom() : Int{
        if (random==0) random = Random.nextInt(10000)
       return random
    }

}