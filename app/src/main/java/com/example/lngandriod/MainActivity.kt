package com.example.lngandriod

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.Toast
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
        webView.addJavascriptInterface(WebAppInterface(this),"LngAndroid")
        val webSettings = webView.settings
//        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true // fix
        webSettings.javaScriptEnabled = true // Enable JavaScript
        webSettings.builtInZoomControls = true // Enable zoom controls
    }

    open class WebAppInterface(context: Context){
        private val mContext:Context = context

        @JavascriptInterface
        open fun openActivity(url:String) {
            Toast.makeText(mContext, "Opening Player Activity", Toast.LENGTH_SHORT).show();
            val intent = Intent(mContext,FullScreenPlayerActivity::class.java)
            intent.putExtra("Url",url)
            mContext.startActivity(intent)
        }

    }
}