package edu.washington.uwn73d8g.quizdroid

import android.app.PendingIntent.getActivity
import android.widget.Toast

interface TopicRepository {
    fun getTopics() : List<Topic>
    fun getTopic(num : Int) : Topic
}

data class Topic(val title : String, val shortDesc : String, val longDesc : String, val questions : ArrayList<Quiz>)

data class Quiz(val question : String, val answers : Array<String>, val answerIndex : Int)
