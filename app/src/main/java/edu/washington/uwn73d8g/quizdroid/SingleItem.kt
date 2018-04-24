package edu.washington.uwn73d8g.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SingleItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_item2)

        val topic = intent.getStringExtra("topic")
        val overview = intent.getStringExtra("overview")
        val questions= intent.getStringArrayExtra("questions")
        val num = questions.size/6

        val title = findViewById<TextView>(R.id.title)
        val description = findViewById<TextView>(R.id.overview)
        val num1 = findViewById<TextView>(R.id.num)
        val begin = findViewById<Button>(R.id.begin)

        title.text = topic
        description.text = overview
        num1.text = "There are $num questions in total."

        begin.setOnClickListener {
            val nextActivity = Intent(this, PhysicsQuestion::class.java)
            nextActivity.putExtra("questions", questions)
            nextActivity.putExtra("begin", 0)
            startActivity(nextActivity)
        }
    }


}
