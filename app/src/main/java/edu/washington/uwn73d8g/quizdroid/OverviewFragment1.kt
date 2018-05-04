package edu.washington.uwn73d8g.quizdroid

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class OverviewFragment1 : Fragment() {

    private lateinit var topic : Topic
    var topicPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            topicPos = arguments.getInt("topicPos")
            topic = QuizApp.instance.oneTopic(topicPos)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val result = inflater.inflate(R.layout.activity_overview_fragment1,container, false)

        val title = result.findViewById<TextView>(R.id.title)
        val description = result.findViewById<TextView>(R.id.overview)
        val num1 = result.findViewById<TextView>(R.id.num)
        val begin = result.findViewById<Button>(R.id.begin)

        title.text = topic.title
        description.text = topic.longDesc
        num1.text = "There are ${topic.questions.size} questions in total."

        begin.setOnClickListener ({
            val fragment = QuestionFragment1()
            val transaction = fragmentManager.beginTransaction()
            val bundle = Bundle()
            bundle.putInt("topicPos", topicPos)
            bundle.putInt("numCorrect", 0)
            bundle.putInt("currQuestion", 0)
            fragment.arguments = bundle
            transaction.replace(R.id.fragment, fragment)
            transaction.commit()
        })
        return result
    }
}
