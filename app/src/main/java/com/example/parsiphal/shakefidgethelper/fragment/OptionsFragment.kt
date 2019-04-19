package com.example.parsiphal.shakefidgethelper.fragment

import android.os.Bundle
import android.os.Environment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.parsiphal.shakefidgethelper.DB
import com.example.parsiphal.shakefidgethelper.DB_NAME

import com.example.parsiphal.shakefidgethelper.R
import com.example.parsiphal.shakefidgethelper.date.DungeonTable
import kotlinx.android.synthetic.main.fragment_options.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.channels.FileChannel

class OptionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        options_import_button.setOnClickListener {
            GlobalScope.launch {
                importDB()
            }
        }
    }

    private fun importDB() {
        val sd =
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString())
        var source: FileChannel? = null
        var destination: FileChannel? = null
        val newDB = File(sd, "/$DB_NAME")
        val oldDB = File(context?.getDatabasePath(DB_NAME).toString())
        try {
            source = FileInputStream(newDB).channel
            destination = FileOutputStream(oldDB).channel
            destination!!.transferFrom(source, 0, source!!.size())
            MainScope().launch {
                Toast.makeText(context, "DB Imported!", Toast.LENGTH_LONG).show()
            }
        } catch (e: IOException) {
            e.printStackTrace()
            MainScope().launch {
                Toast.makeText(context, "Error!", Toast.LENGTH_LONG).show()
            }
        } finally {
            source?.close()
            destination?.close()
        }
    }
}
