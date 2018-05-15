package edu.washington.uwn73d8g.quizdroid

import android.app.Application
import android.app.PendingIntent.getActivity
import android.util.Log
import android.widget.Toast


class QuizApp : Application(){

    companion object {
        lateinit var instance : Repository
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = Repository()

        Log.i("QuizApp", "Loaded")
    }
}
