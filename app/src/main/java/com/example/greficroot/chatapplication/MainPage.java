package com.example.greficroot.chatapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.greficroot.chatapplication.LoginPage;

import static com.example.greficroot.chatapplication.LoginPage.urlToken;

public class MainPage extends AppCompatActivity {
    String url[] = new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Log.d("twitch",  urlToken);
        urlToken = urlToken.replace('=', '&').split("&")[2];
        Log.d("twitch",  urlToken);
    }
}
