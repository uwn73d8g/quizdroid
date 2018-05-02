package edu.washington.uwn73d8g.quizdroid

import android.app.Fragment
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class AnswerFragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val result = inflater.inflate(R.layout.activity_answer_fragment1, container, false)
        var next1: Button = result.findViewById(R.id.next)
        var given: TextView = result.findViewById(R.id.given)
        var actual: TextView = result.findViewById(R.id.actual)
        var correct: TextView = result.findViewById(R.id.correct)
        val questionNumber = arguments!!.getInt("questionNumber", 0)
        val num = arguments!!.getInt("num", 0)
        val begin = arguments!!.getInt("begin", 0)
        val questions = arguments!!.getStringArray("questions")
        val pick = arguments!!.getString("picked")
        val cor = arguments!!.getString("right")
        val totalQuestions = questions.size / 6

        given.append(pick)
        actual.append(cor)
        correct.append("$num out of $totalQuestions right")
        val last = questionNumber + 1 == totalQuestions

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
                bundle.putStringArray("questions", questions)
                bundle.putInt("begin", begin)
                bundle.putInt("questionNumber", questionNumber + 1)
                bundle.putInt("num", num)
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
