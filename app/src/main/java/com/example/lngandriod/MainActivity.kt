package com.example.lngandriod

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout: FrameLayout = findViewById(R.id.main_browse_fragment)
        val webView: WebView = findViewById(R.id.webview)

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
//                val layoutParams = view?.layoutParams
//                layoutParams?.height = layout.height
//                layoutParams?.width = layout.width
//                view?.layoutParams = layoutParams
            }
        }

        webView.setInitialScale(1) // fix
        webView.loadUrl("https://amalmohann-dgnl.github.io/lightning-poc/")
        val webSettings = webView.settings
//        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true // fix
        webSettings.javaScriptEnabled = true // Enable JavaScript
        webSettings.builtInZoomControls = true // Enable zoom controls
    }
}