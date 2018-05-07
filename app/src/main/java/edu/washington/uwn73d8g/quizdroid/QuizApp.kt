package edu.washington.uwn73d8g.quizdroid

import android.app.Application
import android.util.Log



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
