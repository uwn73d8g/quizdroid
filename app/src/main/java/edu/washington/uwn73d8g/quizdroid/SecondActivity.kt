package edu.washington.uwn73d8g.quizdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView


class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.title = "Topic Overview"


        var fragmentManager = fragmentManager
        var fragment = OverviewFragment1()


        val topic = intent.getStringExtra("topic")
        val overview = intent.getStringExtra("overview")
        val questions= intent.getStringArrayExtra("questions")
        val num = questions.size/6


        val transaction = fragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putString("topic", topic)
        bundle.putString("topicDesc", overview)
        bundle.putStringArray("questions", questions)
        bundle.putInt("begin", num)
        fragment.arguments = bundle
        transaction.replace(R.id.fragment, fragment)
        supportActionBar?.title = topic
        transaction.commit()
    }
}