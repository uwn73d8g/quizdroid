package edu.washington.uwn73d8g.quizdroid

import android.R.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class Preferences : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        setSupportActionBar(findViewById(R.id.toolbar))

        val address = findViewById<EditText>(R.id.address)
        val submit = findViewById<Button>(R.id.submitAddress)
        val time = findViewById<Spinner>(R.id.time)

        val timeList = arrayOf("5 minutes", "15 minutes", "30 minutes", "60 minutes")
        val adapter = ArrayAdapter(this, layout.simple_spinner_item, timeList)
        adapter.setDropDownViewResource(layout.simple_spinner_dropdown_item)
        time.adapter = adapter

    }
}
