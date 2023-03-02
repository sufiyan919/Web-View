package com.example.webview

import android.app.Activity
import android.os.Build

import android.os.Bundle

import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*  val wedData: String =  "<html><body><h1>Hello, Javatpoint!</h1></body></html>"
          val mimeType: String = "text/html"
          val utfType: String = "UTF-8"
          webView.loadData(wedData,mimeType,utfType)*/

        /* val myWebUrl: String = "file:///android_asset/index.html"
         webView.loadUrl(myWebUrl)*/

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.javatpoint.com/")
    }
    class MyWebViewClient internal constructor(private val activity: Activity) : WebViewClient() {

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString();
            view?.loadUrl(url)
            return true
        }

        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }
    }
}