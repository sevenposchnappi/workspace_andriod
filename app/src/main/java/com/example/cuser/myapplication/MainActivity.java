package com.example.cuser.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView wv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = (WebView) findViewById(R.id.webView1);
        String url = "http://10.120.39.19:8082/jQuery_web/panda.html";
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        wv.loadUrl(url);
//        wv.setWebViewClient(new MyWebViewClient());
        wv.addJavascriptInterface(new WebAppInterface(this),"Android");

    }


//    private class MyWebViewClient extends WebViewClient {
//        @SuppressWarnings("deprecation") //表示此寫法過時(deprecate)，寫這一行就不會出現黃色驚嘆號。
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            startActivity(intent);
//            return true;
//        }
//
//        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//            final Intent intent = new Intent("123" , request.getUrl());
//            startActivity(intent);
//            return true;
//        }
//
//
//    }
//    @Override
//    public boolean onKeyDown(int KeyCode, KeyEvent event) {
//        if ((KeyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
//            wv.goBack();
//            return true;
//        }
//        return super.onKeyDown(KeyCode,event);
//    }

    public class WebAppInterface{
        Context context;
        WebAppInterface(Context c){
            context = c;
        }
        @JavascriptInterface
        public void showToast(String msg){
            Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
        }

    }
}