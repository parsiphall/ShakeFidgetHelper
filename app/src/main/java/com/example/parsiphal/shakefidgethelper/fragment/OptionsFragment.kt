package com.example.parsiphal.shakefidgethelper.fragment

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
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
import kotlinx.coroutines.*
import java.io.*
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.nio.channels.FileChannel
import java.util.*

const val FILE_URL = "https://drive.google.com/uc?export=download&id=1KOUpHO2vc3beh3VdV3HWqGQXvg4veEE8"

class OptionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        options_download_button.setOnClickListener {
            downloadDB()
        }
    }

    private fun importDB() = GlobalScope.launch {
        delay(5000)
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
            showToast(getString(R.string.DB_imported))
            newDB.delete()
        } catch (e: IOException) {
            e.printStackTrace()
            showToast(getString(R.string.error))
        } finally {
            source?.close()
            destination?.close()
        }
    }

    private fun downloadDB() = GlobalScope.launch {
        val request = DownloadManager.Request(Uri.parse(FILE_URL))
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, DB_NAME)
        val manager = context!!.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        Objects.requireNonNull(manager).enqueue(request)
        showToast(getString(R.string.DB_downloaded))
        importDB().join()
    }

    private fun showToast(message: String) = MainScope().launch {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
