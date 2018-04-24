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

        var list: ListView = findViewById(R.id.list)
        var input = arrayOf("Physics", "Math", "Marvel Super Heroes")
        val physics = arrayOf("Nuclear sizes are expressed in a unit named", "Fermi", "angstrom", "newton", "tesla", "Fermi",
                "Light year is a unit of", "time", "distance", "light", "intensity of light", "distance")
        val math = arrayOf("In coordinate geometry, the equation of the x-axis is", "y=x", "x=0", "y=0", "y=1", "y=0",
                "Which of the following is the Highest Common Factor of 18, 24 and 36?", "6", "18", "36", "72", "6")
        val marvel = arrayOf("Which of the following is the Highest Common Factor of 18, 24 and 36?", "Green Goblin",
                "Joker","Red Skull", "Doctor Doom","Joker", "Black Panther is from what country", "Genosha", "Transia",
                "Latveria", "Wakanda", "Wakanda")
        val map = hashMapOf("Physics" to physics, "Math" to math, "Marvel Super Heroes" to marvel)
        val overview = arrayOf("This set of questions are physics questions.",
                "This set of questions are math questions.",
                "This set of questions are marvel questions.")
        var arrayAdapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, input)
        list.adapter = arrayAdapter
        list.setOnItemClickListener { _: AdapterView<*>, _: View?, position: Int, _: Long ->
                val nextActivity = Intent(this, SingleItem::class.java)
                nextActivity.putExtra("topic", input[position])
                nextActivity.putExtra("overview", overview[position])
                nextActivity.putExtra("questions", map[input[position]])
                startActivity(nextActivity)
        }
    }
}
