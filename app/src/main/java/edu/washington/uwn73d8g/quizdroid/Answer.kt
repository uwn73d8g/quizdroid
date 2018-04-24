package edu.washington.uwn73d8g.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Answer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        var next1: Button = this.findViewById(R.id.next)
        var given: TextView = findViewById(R.id.given)
        var actual: TextView = findViewById(R.id.actual)
        var correct: TextView = findViewById(R.id.correct)
        val questionNumber = intent.getIntExtra("questionNumber", 0)
        val num = intent.getIntExtra("num", 0)
        val begin = intent.getIntExtra("begin", 0)
        val questions = intent.getStringArrayExtra("questions")
        val pick = intent.getStringExtra("picked")
        val cor = intent.getStringExtra("right")
        val totalQuestions = questions.size/6

        given.append(pick)
        actual.append(cor)
        correct.append("$num out of $totalQuestions right")
        val last = questionNumber + 1 == totalQuestions

        if (last) {
            next1.text = "Finish"
        } else {
            next1.text = "Next"
        }

        next1.setOnClickListener {
            if (!last) {
                val nextActivity = Intent(this, PhysicsQuestion::class.java)
                nextActivity.putExtra("questions", questions)
                nextActivity.putExtra("begin", begin)
                nextActivity.putExtra("questionNumber", questionNumber+1)
                nextActivity.putExtra("num", num)
                startActivity(nextActivity)
            } else {
                val nextActivity = Intent(this, MainActivity::class.java)
                startActivity(nextActivity)
            }
        }
    }
}
