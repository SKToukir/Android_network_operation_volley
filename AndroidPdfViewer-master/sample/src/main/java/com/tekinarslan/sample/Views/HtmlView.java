package com.tekinarslan.sample.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Toast;

import com.artifex.mupdfdemo.ReaderView;
import com.tekinarslan.sample.R;

import java.io.File;

public class HtmlView extends Activity {

    WebView webView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html_view);

        //intent = getIntent();
        //String htmlFilePath = intent.getStringExtra("html_path");

        //String url = "file:///" + Environment.getExternalStorageDirectory().toString() + File.separator + "HtmlFiles/" + htmlFilePath;

        //Toast.makeText(this, url, Toast.LENGTH_LONG).show();

//        webView = (WebView) findViewById(R.id.htmlWebView);
//        WebSettings webSetting = webView.getSettings();
//        webSetting.setBuiltInZoomControls(true);
//        webSetting.setJavaScriptEnabled(true);
//        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl(url);

    }


}


