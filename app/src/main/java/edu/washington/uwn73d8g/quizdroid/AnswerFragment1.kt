package edu.washington.uwn73d8g.quizdroid

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class AnswerFragment1 : Fragment() {
    private lateinit var topic : Topic
    var topicPos = 0
    var numCorrect = 0
    var currQuestion = 0
    var selectedAns = ""
    var correctAns = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            topicPos = arguments.getInt("topicPos")
            topic = QuizApp.instance.getTopic(topicPos)
            numCorrect = arguments.getInt("numCorrect")
            currQuestion = arguments.getInt("currQuestion")
            selectedAns = arguments.getString("selectedAns")
            correctAns = arguments.getString("correctAns")
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val result = inflater.inflate(R.layout.activity_answer_fragment1, container, false)
        var next1: Button = result.findViewById(R.id.next)
        var given: TextView = result.findViewById(R.id.given)
        var actual: TextView = result.findViewById(R.id.actual)
        var correct: TextView = result.findViewById(R.id.correct)


        given.append(selectedAns)
        actual.append(correctAns)
        correct.append("$numCorrect out of $currQuestion right")
        val last = currQuestion == topic.questions.size

        if (last) {
            next1.text = "Finish"
        } else {
            next1.text = "Next"
        }

        next1.setOnClickListener { v->
            if (!last) {
                val fragment = QuestionFragment1()
                val transaction = fragmentManager?.beginTransaction()
                val bundle = Bundle()
                bundle.putInt("topicPos", topicPos)
                bundle.putInt("numCorrect", numCorrect)
                bundle.putInt("currQuestion", currQuestion)
                fragment.arguments = bundle
                transaction!!.replace(R.id.fragment, fragment)
                transaction.commit()
            } else {
                val nextActivity = Intent(v.context, MainActivity::class.java)
                startActivity(nextActivity)
            }
        }
        return result
    }
}
