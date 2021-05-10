package com.example.gaaapp.Lists
//AUTHOR:  PAUL SHANAHAN
//VERSION : 1
//DATE : 06/03/2021
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.gaaapp.R

import kotlinx.android.synthetic.main.gaalistview.*


class MainGaaList : AppCompatActivity() {


    //this array will be printed out in the list view
    val counties = arrayOf<String>(
            "TIPPERARY",
            "CORK",
            "KERRY",
            "CLARE",
            "WATERFORD",
            "LIMERICK",
            "GALWAY",
            "LEITRIM",
            "SLIGO",
            "MAYO",


    )




    //will be beside the first array
    val description = arrayOf<String>(
        "LAST WINNERS - 2019",
        "LAST WINNERS - 2005",
        "LAST WINNERS - 2014",
        "LAST WINNERS - 2013",
        "LAST WINNERS - 1959",
        "LAST WINNERS - 2020",
        "LAST WINNERS - 2017",
        "LAST WINNERS - 2019",
        "LAST WINNERS - NEVER",
        "LAST WINNERS - NEVER",
        "LAST WINNERS - 1951",

    )

    //an array of images for the list view
    val imageId = arrayOf<Int>(
            R.drawable.tipp, R.drawable.cork, R.drawable.kerry,
            R.drawable.clare, R.drawable.waterford, R.drawable.limerick,
            R.drawable.galway, R.drawable.leitrim, R.drawable.sligo,
            R.drawable.mayo

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gaalistview)

        val search = findViewById<SearchView>(R.id.searchView) as SearchView
        val myListAdapter = ListViewAdapter(this, counties, description, imageId)

        listView.adapter = myListAdapter













        listView.setOnItemClickListener() { adapterView, view, position, id ->


            //if statement for when the position is clicked the https appears
            if (position == 0) {
                //val intent = Intent(this@MainWorldCup, MainQuizPage::class.java)
                // startActivity(intent)
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Tipperary_GAA")
                )
                startActivity(i)

            }
            if (position == 1) {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Cork_GAA")
                )
                startActivity(i)

            }
            if (position == 2) {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Kerry_GAA")
                )
                startActivity(i)

            }
            if (position == 3) {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Clare_GAA")
                )
                startActivity(i)

            }
            if (position == 4) {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Waterford_GAA")
                )
                startActivity(i)

            }
            if (position == 5) {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Limerick_GAA")
                )
                startActivity(i)

            }
            if (position == 6) {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Galway_GAA")
                )
                startActivity(i)

            }
            if (position == 7) {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Leitrim_GAA")
                )
                startActivity(i)

            }
            if (position == 8) {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Sligo_GAA")
                )
                startActivity(i)

            }
            if (position == 9) {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://en.wikipedia.org/wiki/Mayo_GAA")
                )
                startActivity(i)

            }



        }


    }



   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }*/

}




