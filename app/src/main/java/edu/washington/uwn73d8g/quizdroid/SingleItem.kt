package edu.washington.uwn73d8g.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SingleItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_item2)

        var begin: Button = findViewById(R.id.begin)
        begin.setOnClickListener {
            val nextActivity = Intent(this, PhysicsQuestion::class.java)
            startActivity(nextActivity)
        }
    }


}
