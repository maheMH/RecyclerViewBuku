package com.summa.summabooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView webViewGoodreads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webViewGoodreads = (WebView) findViewById(R.id.webview_goodreads);

        //atribute buka via web
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String data = b.getString("review");
        webViewGoodreads.loadUrl("https://"+data);
        webViewGoodreads.getSettings().setJavaScriptEnabled(true);
        webViewGoodreads.setWebChromeClient(new WebChromeClient());
        webViewGoodreads.setWebViewClient(new WebViewClient());
    }
}
