package edu.washington.uwn73d8g.quizdroid

import android.app.Application
import android.util.Log

class QuizApp : Application(), TopicRepository {

    companion object {
        lateinit var instance : QuizApp
            private set

        lateinit var topics : Array<Topic>
    }



    override fun onCreate() {
        super.onCreate()
        instance = this

        Log.i("QuizApp", "fired")
        topics = arrayOf("Physics" as Topic, "Math" as Topic, "Marvel Super Heroes" as Topic)


    }

    override fun topics(): Array<Topic> {
        return topics
    }

    override fun oneTopic(num : Int) : Topic {
        return topics[num]
    }
}

data class Topic(val title : String, val shortDesc : String, val longDesc : String, val questions : List<Quiz>)

data class Quiz(val question : String, val answers : Array<Topic>, val answerIndex : Int)

interface TopicRepository {
    fun topics() : Array<Topic>
    fun oneTopic(num : Int) : Topic
}
