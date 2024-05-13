package com.example.quizapp

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var checkButton: Button
    private var correctAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val questions = QuestionBank.questions

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayoutVertical)
        val scrollView = ScrollView(this)
        linearLayout.addView(scrollView)

        val linearLayoutVertical = LinearLayout(this)
        linearLayoutVertical.orientation = LinearLayout.VERTICAL
        scrollView.addView(linearLayoutVertical)

        for ((index, question) in questions.withIndex()) {
            val questionLayout = LinearLayout(this)
            questionLayout.orientation = LinearLayout.VERTICAL
            questionLayout.setPadding(0, 20, 0, 0)

            val questionText = TextView(this)
            questionText.text = "${index + 1}. ${question.question}"
            questionText.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            questionLayout.addView(questionText)

            if (index == 0 && question.imageRes != null) {
                val imageView = ImageView(this)
                imageView.setImageResource(question.imageRes)
                imageView.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                questionLayout.addView(imageView)
            }

            val radioGroup = RadioGroup(this)
            radioGroup.orientation = RadioGroup.VERTICAL
            for ((i, option) in question.options.withIndex()) {
                val radioButton = RadioButton(this)
                radioButton.text = option
                radioGroup.addView(radioButton)
            }
            questionLayout.addView(radioGroup)

            linearLayoutVertical.addView(questionLayout)
        }

        checkButton = Button(this)
        checkButton.text = "Sprawdzam odpowiedzi"
        checkButton.setOnClickListener {
            correctAnswers = 0
            for (i in 0 until linearLayoutVertical.childCount) {
                val child = linearLayoutVertical.getChildAt(i)
                if (child is LinearLayout) {
                    val radioGroup = child.getChildAt(1)
                    if (radioGroup is RadioGroup) {
                        val checkedId = radioGroup.checkedRadioButtonId
                        if (checkedId != -1) {
                            val radioButton = radioGroup.findViewById<RadioButton>(checkedId)
                            val questionIndex = linearLayoutVertical.indexOfChild(child)
                            val question = questions[questionIndex]
                            if (radioButton.text == question.options[question.correctAnswer]) {
                                correctAnswers++
                            }
                        }
                    }
                }
            }
            resultTextView.text = "Wynik: $correctAnswers/${questions.size}"
            if (correctAnswers >= 3) {
                resultTextView.append("\nBrawo, wygrałeś.")
                resultTextView.setTextColor(Color.GREEN)
            } else {
                resultTextView.append("\nNiestety nie udało ci się wygrać.")
                resultTextView.setTextColor(Color.RED)
            }
        }
        linearLayoutVertical.addView(checkButton)

        resultTextView = TextView(this)
        resultTextView.text = "Wynik:"
        resultTextView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        resultTextView.gravity = Gravity.CENTER
        linearLayoutVertical.addView(resultTextView)
    }
}
