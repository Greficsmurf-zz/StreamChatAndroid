
package com.example.greficroot.chatapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginPage extends AppCompatActivity {
    String api = "https://id.twitch.tv/oauth2/authorize?response_type=token&client_id=j8izzvzi8t8mpw2bl7oi8ks22sq2mx&redirect_uri=https://localhost=viewing_activity_read";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = api;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("twitch", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Twitch", "Failed");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
