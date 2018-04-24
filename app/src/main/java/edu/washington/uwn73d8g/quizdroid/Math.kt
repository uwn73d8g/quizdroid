package edu.washington.uwn73d8g.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Math : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

        var math: Button = findViewById(R.id.math)
        math.setOnClickListener {
//            val nextActivity = Intent(this, MathQuestion::class.java)
//            startActivity(nextActivity)
        }
    }
}
