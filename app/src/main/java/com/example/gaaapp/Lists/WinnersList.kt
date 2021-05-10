package com.example.gaaapp.Lists
//AUTHOR:  PAUL SHANAHAN
//VERSION : 1
//DATE : 06/03/2021
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.gaaapp.R


class WinnersList : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.winlist)

// LIST OUT ALL THE ARRAY OF COUNTIES AND SORTS THEM BY USER REQUEST
        val search = findViewById<SearchView>(R.id.searchview) as SearchView

        val list = findViewById<ListView>(R.id.listview)

        val teams = arrayOf("Tipperary ____ 5, ____   22", "Killkenny  ___ 0,  ____  30", "Cork ______8,______15", "Kerry______32_____0", "Dublin_____30_____3", "Galway_____9____5", "Waterford____4______1", "Clare_____4_____2", "Limerick_____5______1", "Sligo_____2_____0", "Roscommon_____3_______0", "Leitrim_____0______0", "Longford_____0_____0", "Laois_____1______1", "Louth_____0_____0", "Offaly_____4______4", "Westmeath_______0_______0", "Meath_____5______0", "Carlow_____0______0", "Wicklow_______0______0", "Derry______2______0", "Down____2_____0", "Cavan____1____0")

        val teamAdap: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, teams)

        list.adapter = teamAdap

        list.setOnItemClickListener() { adapterView, view, position, id ->


            //THIS WILL NABVIGATE THE FIRST POSITION ON THE LIST TO THIS URL
            if (position == 0) {

                val i = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://en.wikipedia.org/wiki/Tipperary_GAA")
                )
                startActivity(i)

            }
        }

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                teamAdap.filter.filter(newText)
                return false
            }
        })
    }
}



