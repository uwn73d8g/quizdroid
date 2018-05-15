package edu.washington.uwn73d8g.quizdroid

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ArrayAdapter
import android.content.Intent
import android.media.audiofx.BassBoost
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.content.DialogInterface
import android.R.string.cancel
import android.app.Activity
import android.app.PendingIntent.getActivity
import android.support.v7.app.AlertDialog
import android.util.Log
import android.os.Build




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
//        if (isConnected) {
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
//        } else {
//            Toast.makeText(applicationContext, "You are offline!", Toast.LENGTH_LONG).show()
//            if (isAirplaneModeOn(baseContext)) { // in airplane mode
//                val builder = AlertDialog.Builder(this, R.style.Theme_AppCompat_Light)
//                builder.setMessage("Do you want to turn airplane mode off?")
//                        .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
//                            startActivityForResult(Intent(android.provider.Settings.ACTION_SETTINGS), 0)
//                        })
//                        .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id ->
//                            // User cancelled the dialog
//                        })
//                        .show()
//            }
//            if (activeNetwork != null && activeNetwork.isConnectedOrConnecting) { // no signal
//                Toast.makeText(applicationContext, "no signal", Toast.LENGTH_LONG).show()
//            }
//        }

    }

//    fun isAirplaneModeOn(context: Context): Boolean {
//        return Settings.Global.getInt(context.contentResolver,
//                    Settings.Global.AIRPLANE_MODE_ON, 0) != 0
//    }


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