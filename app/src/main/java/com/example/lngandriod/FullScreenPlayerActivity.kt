package com.example.lngandriod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class FullScreenPlayerActivity : AppCompatActivity() {
    var data:String?=null
    var text:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_player)
        data = intent.getStringExtra("Url")
        setViews()
        getData()
    }

    private fun setViews() {
        text = findViewById(R.id.webview)
    }

    private fun getData() {
        text?.text = data
        data?.let { Log.e("CalledUrl", it) }
    }


}