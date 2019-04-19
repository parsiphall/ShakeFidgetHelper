package com.example.parsiphal.shakefidgethelper.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.parsiphal.shakefidgethelper.MainActivity

import com.example.parsiphal.shakefidgethelper.R
import kotlinx.android.synthetic.main.fragment_dungeon.*

class DungeonFragment : Fragment(), View.OnClickListener {

    lateinit var callBackActivity: MainActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callBackActivity = context as MainActivity
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dungeon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dungeon_button1.setOnClickListener(this)
        dungeon_button2.setOnClickListener(this)
        dungeon_button3.setOnClickListener(this)
        dungeon_button4.setOnClickListener(this)
        dungeon_button5.setOnClickListener(this)
        dungeon_button6.setOnClickListener(this)
        dungeon_button7.setOnClickListener(this)
        dungeon_button8.setOnClickListener(this)
        dungeon_button9.setOnClickListener(this)
        dungeon_button10.setOnClickListener(this)
        dungeon_button11.setOnClickListener(this)
        dungeon_button12.setOnClickListener(this)
        dungeon_button13.setOnClickListener(this)
        dungeon_button14.setOnClickListener(this)
        dungeon_button15.setOnClickListener(this)
        dungeon_button16.setOnClickListener(this)
        dungeon_button17.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val bundle = Bundle()
        bundle.putInt("DUNGEON_NUMBER",
                when (v?.id) {
                    R.id.dungeon_button1 -> 1
                    R.id.dungeon_button2 -> 2
                    R.id.dungeon_button3 -> 3
                    R.id.dungeon_button4 -> 4
                    R.id.dungeon_button5 -> 5
                    R.id.dungeon_button6 -> 6
                    R.id.dungeon_button7 -> 7
                    R.id.dungeon_button8 -> 8
                    R.id.dungeon_button9 -> 9
                    R.id.dungeon_button10 -> 10
                    R.id.dungeon_button11 -> 11
                    R.id.dungeon_button12 -> 12
                    R.id.dungeon_button13 -> 13
                    R.id.dungeon_button14 -> 14
                    R.id.dungeon_button15 -> 15
                    R.id.dungeon_button16 -> 16
                    R.id.dungeon_button17 -> 17
                    else -> 0
                })
        bundle.putCharSequence("DUNGEON_NAME", (v as Button).text)
        callBackActivity.fragmentPlaceWithArgs(DungeonDetailFragment(), bundle)
    }
}
