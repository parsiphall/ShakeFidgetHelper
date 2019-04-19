package com.example.parsiphal.shakefidgethelper.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parsiphal.shakefidgethelper.DB
import com.example.parsiphal.shakefidgethelper.R
import com.example.parsiphal.shakefidgethelper.date.DungeonTable
import kotlinx.android.synthetic.main.fragment_dungeon_detail.*
import kotlinx.android.synthetic.main.fragment_dungeon_detail.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class DungeonDetailFragment: Fragment() {

    private var items: List<DungeonTable> = ArrayList()
    private lateinit var adapter: DungeonDetailAdapter
    private var dungeonNumber = 0
    private lateinit var dungeonName: CharSequence

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            dungeonNumber = bundle.getInt("DUNGEON_NUMBER")
            dungeonName = bundle.getCharSequence("DUNGEON_NAME")!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_dungeon_detail, container, false)
        adapter = DungeonDetailAdapter(items, context)
        root.dungeon_recycler.layoutManager = LinearLayoutManager(context)
        root.dungeon_recycler.adapter = adapter
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dungeon_name.text = dungeonName
        GlobalScope.launch {
            getDataList()
        }
    }

    private fun getDataList() {
        items = DB.getDao().getMonstersInfo(dungeonNumber)
        MainScope().launch {
            adapter.dataChanged(items)
        }
    }
}