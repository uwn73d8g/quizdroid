package edu.washington.uwn73d8g.quizdroid

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class QuestionFragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val result = inflater?.inflate(R.layout.activity_question_fragment1, container,false)

        val questionNumber = arguments!!.getInt("questionNumber", 0)
        val cor = arguments!!.getInt("cor", 0)
        val start = arguments!!.getInt("begin", 0)
        val questions = arguments!!.getStringArray("questions")
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
        q?.text = questions[start]
        r1?.text = questions[start + 1]
        r2?.text = questions[start + 2]
        r3?.text = questions[start + 3]
        r4?.text = questions[start + 4]

        submit?.setOnClickListener {
            val picked: Int? = radio?.checkedRadioButtonId
            var pickedText = result?.findViewById<TextView>(picked!!)?.text.toString()
            var correct = cor
            if (pickedText == questions[start+5]) {
                correct += 1
            }
            val fragment = AnswerFragment1()
            val transaction = fragmentManager?.beginTransaction()
            val bundle = Bundle()
            bundle.putInt("questionNumber", questionNumber)
            bundle.putString("picked", pickedText)
            bundle.putStringArray("questions", questions)
            bundle.putString("right", questions[start+5])
            bundle.putInt("num", correct)
            bundle.putInt("begin", start + 6)

            fragment.arguments = bundle
            transaction!!.replace(R.id.fragment, fragment)
            transaction.commit()
        }
        return result
    }
}
