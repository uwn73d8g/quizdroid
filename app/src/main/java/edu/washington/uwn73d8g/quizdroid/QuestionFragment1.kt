package edu.washington.uwn73d8g.quizdroid

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

class QuestionFragment1 : Fragment() {
    lateinit var topic : Topic
    var topicPos = 0
    var numCorrect = 0
    var currQuestion = 0
    var ansIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            topicPos = arguments.getInt("topicPos")
            topic = QuizApp.instance.getTopic(topicPos)
            numCorrect = arguments.getInt("numCorrect")
            currQuestion = arguments.getInt("currQuestion")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val result = inflater?.inflate(R.layout.activity_question_fragment1, container,false)

        var radio: RadioGroup? = result?.findViewById(R.id.RGroup)
        var q: TextView? = result?.findViewById(R.id.q)
        var r1: Button? = result?.findViewById(R.id.r1)
        var r2: Button? = result?.findViewById(R.id.r2)
        var r3: Button? = result?.findViewById(R.id.r3)
        var r4: Button? = result?.findViewById(R.id.r4)
        val submit: Button? = result?.findViewById(R.id.submit)
        submit?.visibility = View.GONE
        radio?.setOnCheckedChangeListener { _, _ ->
            submit?.visibility = View.VISIBLE
        }
        val quiz = topic.questions[currQuestion]
        q?.text = quiz.question
        r1?.text = quiz.answers[ansIndex]
        r2?.text = quiz.answers[ansIndex + 1]
        r3?.text = quiz.answers[ansIndex + 2]
        r4?.text = quiz.answers[ansIndex + 3]


        submit?.setOnClickListener {
            val picked: Int? = radio?.checkedRadioButtonId
            var pickedText = result?.findViewById<TextView>(picked!!)?.text.toString()
            val answer = quiz.answers[quiz.answerIndex]
            val newCorrect = if (pickedText  == answer) numCorrect + 1 else numCorrect
            val fragment = AnswerFragment1()
            val transaction = fragmentManager?.beginTransaction()
            val bundle = Bundle()
            bundle.putInt("topicPos", topicPos)
            bundle.putInt("numCorrect", newCorrect)
            bundle.putInt("currQuestion", currQuestion + 1)
            bundle.putString("selectedAns", pickedText)
            bundle.putString("correctAns", answer)

            fragment.arguments = bundle
            transaction!!.replace(R.id.fragment, fragment)
            transaction.commit()
        }
        return result
    }
}
