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

        val topicPos = intent.getIntExtra("topicPos", 0)
        val name = intent.getStringExtra("name")
        val transaction = fragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putInt("topicPos", topicPos)


        val fragment = OverviewFragment1()


        fragment.arguments = bundle
        transaction.replace(R.id.fragment, fragment)
        supportActionBar?.title = name
        transaction.commit()
    }
}