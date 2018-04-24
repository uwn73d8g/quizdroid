package edu.washington.uwn73d8g.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Marvel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel)

        var marvel: Button = findViewById(R.id.marvel)
        marvel.setOnClickListener {
//            val nextActivity = Intent(this, MarvelQuestion::class.java)
//            startActivity(nextActivity)
        }
    }
}
