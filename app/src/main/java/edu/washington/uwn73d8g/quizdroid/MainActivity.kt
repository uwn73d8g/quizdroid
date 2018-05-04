package edu.washington.uwn73d8g.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val app = QuizApp()
        val topics = app.topics()

        val topicsList = listOf(topics[0].title, topics[1].title, topics[2].title)


        var list: ListView = findViewById(R.id.list)
        var arrayAdapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, topicsList)
        list.adapter = arrayAdapter
        list.setOnItemClickListener { _: AdapterView<*>, _: View?, position: Int, _: Long ->
            val nextActivity = Intent(this, SecondActivity::class.java)
            nextActivity.putExtra("topicPos", position)

            startActivity(nextActivity)
        }
    }
}