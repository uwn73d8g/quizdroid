package edu.washington.uwn73d8g.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ArrayAdapter
import android.content.Intent
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val app = QuizApp
        val topics = app.instance.getTopics()

        val listView = findViewById<ListView>(R.id.list)

        val topicsList = listOf(topics[0].title, topics[1].title, topics[2].title)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, topicsList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("topicPos", position)
            }
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.preferences, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this, Preferences::class.java)
        startActivity(intent)
        return true
    }
}