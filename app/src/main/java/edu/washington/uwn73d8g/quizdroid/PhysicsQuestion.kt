package edu.washington.uwn73d8g.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class PhysicsQuestion : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_question)
        val questionNumber = intent.getIntExtra("questionNumber", 0)
        val cor = intent.getIntExtra("cor", 0)
        val start = intent.getIntExtra("begin", 0)
        val questions = intent.getStringArrayExtra("questions")
        var radio: RadioGroup = findViewById(R.id.RGroup)
        var q: TextView = findViewById(R.id.q)
        var r1: Button = findViewById(R.id.r1)
        var r2: Button = findViewById(R.id.r2)
        var r3: Button = findViewById(R.id.r3)
        var r4: Button = findViewById(R.id.r4)
        val submit: Button = findViewById(R.id.submit)
        submit.visibility = View.GONE
        radio.setOnCheckedChangeListener { _, _ ->
            submit.visibility = View.VISIBLE
        }
        q.text = questions[start]
        r1.text = questions[start + 1]
        r2.text = questions[start + 2]
        r3.text = questions[start + 3]
        r4.text = questions[start + 4]

        submit.setOnClickListener {
            val picked = radio.checkedRadioButtonId
            var pickedText = findViewById<RadioButton>(picked).text.toString()
            var correct = cor
            if (pickedText == questions[start+5]) {
                correct += 1
            }
            val nextActivity = Intent(this, Answer::class.java)
            nextActivity.putExtra("questionNumber", questionNumber)
            nextActivity.putExtra("picked", pickedText)
            nextActivity.putExtra("questions", questions)
            nextActivity.putExtra("right", questions[start+5])
            nextActivity.putExtra("num", correct)
            nextActivity.putExtra("begin", start + 6)
            startActivity(nextActivity)
        }
    }
}
