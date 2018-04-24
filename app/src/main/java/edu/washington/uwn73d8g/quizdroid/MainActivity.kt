package edu.washington.uwn73d8g.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.content.Intent
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list: ListView = findViewById(R.id.list)
        var input = arrayOf("Physics", "Math", "Marvel Super Heroes")
        var arrayAdapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, input)
        list.adapter = arrayAdapter
        list.setOnItemClickListener { parent: AdapterView<*>, view: View?, position: Int, id: Long ->
            val item = parent.getItemAtPosition(position).toString()
            if (item == "Physics") {
                val nextActivity = Intent(this, SingleItem::class.java)
                startActivity(nextActivity)
            } else if (item == "Math") {
                val nextActivity = Intent(this, Math::class.java)
                startActivity(nextActivity)
            } else if (item == "Marvel Super Heroes") {
                val nextActivity = Intent(this, Marvel::class.java)
                startActivity(nextActivity)
            }
        }

    }
}
