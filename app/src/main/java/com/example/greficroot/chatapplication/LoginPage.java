
package com.example.greficroot.chatapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

import static java.lang.Thread.sleep;


public class LoginPage extends AppCompatActivity {
    String api = "https://id.twitch.tv/oauth2/authorize?response_type=token&client_id=j8izzvzi8t8mpw2bl7oi8ks22sq2mx&redirect_uri=https://www.twitch.tv/&scope=chat:read chat:edit";
    WebView web;
    myClient client;
    WebResourceRequest request;
    static String urlToken = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = new myClient();
        web = findViewById(R.id.login);
        web.setWebViewClient(client);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(api);

    }
    public void destroyActivity(){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
        finish();
    }
    public class myClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView web, String url){
            urlToken = web.getUrl();
            if(urlToken.endsWith("bearer")) destroyActivity();
        }

    }
}

