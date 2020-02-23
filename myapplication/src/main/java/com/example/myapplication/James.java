package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class James extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_james);

        WebView webView= (WebView) findViewById(R.id.web_James);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://baike.baidu.com/item/勒布朗·詹姆斯/1989503?fromtitle=%E8%A9%B9%E5%A7%86%E6%96%AF&fromid=14189565&fr=aladdin");
    }
}