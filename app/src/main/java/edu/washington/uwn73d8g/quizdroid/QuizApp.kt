package edu.washington.uwn73d8g.quizdroid

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
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
        val physics1 = Quiz("Nuclear sizes are expressed in a unit named", arrayOf("Fermi", "angstrom", "newton", "tesla"), 1)
        val physics2 = Quiz("Light year is a unit of", arrayOf("time", "distance", "light", "intensity of light"), 2)
        val math1 = Quiz("In coordinate geometry, the equation of the x-axis is", arrayOf("y=x", "x=0", "y=0", "y=1"), 3)
        val math2 = Quiz("Which of the following is the Highest Common Factor of 18, 24 and 36?", arrayOf("6", "18", "36", "72"), 1)
        val marvel1 = Quiz("Which of the following is the Highest Common Factor of 18, 24 and 36?", arrayOf("Green Goblin",
                "Joker", "Red Skull", "Doctor Doom"), 2)
        val marvel2 = Quiz("Black Panther is from what country", arrayOf("Genosha", "Transia", "Latveria", "Wakanda"), 4)

        val p = arrayOf(physics1, physics2)
        val maths1 = arrayOf(math1, math2)
        val marvels1 = arrayOf(marvel1, marvel2)
        val physicsT = Topic("Physics", "This is physics.","This set of questions are physics questions.", p)
        val mathT = Topic("Math", "This is maths.", "This set of questions are math questions.", maths1)
        val marvelT = Topic("Marvel","This is marvel.", "This set of questions are marvel questions.", marvels1)
        topics = arrayOf(physicsT, mathT, marvelT)
    }

    override fun topics(): Array<Topic> {
        return topics
    }

    override fun oneTopic(num : Int) : Topic {
        return topics[num]
    }
}
data class Topic(val title : String, val shortDesc : String,val longDesc : String, val questions : Array<Quiz>)

data class Quiz(val question : String, val answers : Array<String>, val answerIndex : Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.createStringArray(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeStringArray(answers)
        parcel.writeInt(answerIndex)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Quiz> {
        override fun createFromParcel(parcel: Parcel): Quiz {
            return Quiz(parcel)
        }

        override fun newArray(size: Int): Array<Quiz?> {
            return arrayOfNulls(size)
        }
    }

}

interface TopicRepository {

    fun topics() : Array<Topic>
    fun oneTopic(num : Int) : Topic
}