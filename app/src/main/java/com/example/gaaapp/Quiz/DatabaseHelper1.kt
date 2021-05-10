package com.example.gaaapp
//AUTHOR:  PAUL SHANAHAN
//VERSION : 1
//DATE : 06/03/2021
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.gaaapp.Quiz.Question1
import com.example.gaaapp.Quiz.QuizContainer1.QuizTable.Companion.ANS_COLUMN
import com.example.gaaapp.Quiz.QuizContainer1.QuizTable.Companion.OPTION1_COLUMN
import com.example.gaaapp.Quiz.QuizContainer1.QuizTable.Companion.OPTION2_COLUMN
import com.example.gaaapp.Quiz.QuizContainer1.QuizTable.Companion.OPTION3_COLUMN
import com.example.gaaapp.Quiz.QuizContainer1.QuizTable.Companion.OPTION4_COLUMN
import com.example.gaaapp.Quiz.QuizContainer1.QuizTable.Companion.QUESTION_COLUMN
import com.example.gaaapp.Quiz.QuizContainer1.QuizTable.Companion.QUESTION_TABLE_NAME

import java.util.ArrayList




class DatabaseHelper1(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private var db: SQLiteDatabase? = null

    val questionSet: List<Question1>
        get() {
             // calling the Question1 class i made
            val questionSetsList = ArrayList<Question1>()

            db = readableDatabase


                //using c as the cursor to get string options
            val c = db!!.rawQuery("SELECT * FROM $QUESTION_TABLE_NAME", null)

            if (c.moveToFirst()) {
                do {
                    val question = Question1()
                    question.setmQuestion(c.getString(c.getColumnIndex(QUESTION_COLUMN)))
                    question.setmOption1(c.getString(c.getColumnIndex(OPTION1_COLUMN)))
                    question.setmOption2(c.getString(c.getColumnIndex(OPTION2_COLUMN)))
                    question.setmOption3(c.getString(c.getColumnIndex(OPTION3_COLUMN)))
                    question.setmOption4(c.getString(c.getColumnIndex(OPTION4_COLUMN)))
                    question.setmRightAns(c.getInt(c.getColumnIndex(ANS_COLUMN)))
                    questionSetsList.add(question)
                } while (c.moveToNext())

            }
            c.close()
            return questionSetsList
        }

    override fun onCreate(db: SQLiteDatabase) {
        this.db = db

        val QB_TABLE = "CREATE TABLE " +
                QUESTION_TABLE_NAME + " ( " +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QUESTION_COLUMN + " TEXT, " +
                OPTION1_COLUMN + " TEXT, " +
                OPTION2_COLUMN + " TEXT, " +
                OPTION3_COLUMN + " TEXT, " +
                OPTION4_COLUMN + " TEXT, " +
                ANS_COLUMN + " INTEGER " +
                " )"

        db.execSQL(QB_TABLE)

        GenerateQuestionFunction()


    }

    private fun GenerateQuestionFunction() {
        val q1 = Question1("Who managed Dublin to All Ireland Success in 2011?", "Jim Gavin", "Pat Gilroy", "Paul Caffrey","Pat O'Neill", 2)
        addQuestion(q1)
        val q2 = Question1("What County do the club Liam Mellows Play in?", "Sligo", "Mayo", "Galway", "Westmeath", 3)
        addQuestion(q2)
        val q3 = Question1("Which County plays their Home games at Dr Cullen Park?", "Carlow", "Wicklow", "Louth","Wexford", 1)
        addQuestion(q3)
        val q4 = Question1("Who did Cork beat in the All Ireland Football final in 2010?", "Kerry", "Donegal", "Dublin", "Down", 4)
        addQuestion(q4)
        val q5 = Question1("Which was the first county to win the All Ireland after losing the Munster Final?", "Tipperary", "Cork", "Limerick", "Clare", 2)
        addQuestion(q5)
        val q6 = Question1("How Many Counties won the All Ireland Senior Hurling Championship in the 90s?", "4", "5", "6", "7", 3)
        addQuestion(q6)
        val q7 = Question1("Which Armagh Player was sent off in the 2003 All Ireland Football final?", "Kieran Mcgeeney", "Oisin Mconville", "Diarmuid Marsden", "Francie Bellew", 3)
        addQuestion(q7)
        val q8 = Question1("How many All Ireland finals did not feature Killkenny in the 2000s?", "2", "3", "4", "1", 1)
        addQuestion(q8)
        val q9 = Question1("Which company sponsored the All Ireland Hurling Championship from 1995 to 2008?", "Centra", "AIB", "Guinness", "Ulster Bank", 3)
        addQuestion(q9)
        val q10 = Question1("In which year did Cork last complete the double in Hurling and football?", "1991", "1990", "1992", "1989", 2)
        addQuestion(q10)
    }

    private fun addQuestion(qb: Question1) {
        val contentValues = ContentValues()
        contentValues.put(QUESTION_COLUMN, qb.getmQuestion())
        contentValues.put(OPTION1_COLUMN, qb.getmOption1())
        contentValues.put(OPTION2_COLUMN, qb.getmOption2())
        contentValues.put(OPTION3_COLUMN, qb.getmOption3())
        contentValues.put(OPTION4_COLUMN, qb.getmOption4())
        contentValues.put(ANS_COLUMN, qb.getmRightAns())
        db!!.insert(QUESTION_TABLE_NAME, null, contentValues)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    companion object {

        private val DATABASE_NAME = "QuizApp5.db"
        private val DATABASE_VERSION = 1
    }

}