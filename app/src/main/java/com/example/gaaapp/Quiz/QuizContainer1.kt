package com.example.gaaapp.Quiz
//AUTHOR:  PAUL SHANAHAN
//VERSION : 1
//DATE : 06/03/2021
import android.provider.BaseColumns


object QuizContainer1 {

    class QuizTable : BaseColumns {
        companion object {

            val QUESTION_TABLE_NAME = "quiz_question"
            val QUESTION_COLUMN = "question"
            val OPTION1_COLUMN = "option1"
            val OPTION2_COLUMN = "option2"
            val OPTION3_COLUMN = "option3"
            val OPTION4_COLUMN = "option4"
            val ANS_COLUMN = "ans"
        }


    }


}