package com.example.gaaapp.Fragments
//AUTHOR:  PAUL SHANAHAN
//VERSION : 1
//DATE : 06/03/2021
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.gaaapp.R


class HurlingFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hurling, container, false)
    }


}