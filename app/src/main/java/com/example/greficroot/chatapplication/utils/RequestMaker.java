package com.example.greficroot.chatapplication.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.greficroot.chatapplication.Activities.MainActivity;
import com.example.greficroot.chatapplication.Implementations.VolleyImplementation;
import com.example.greficroot.chatapplication.R;

import java.util.HashMap;
import java.util.Map;

public class RequestMaker implements VolleyImplementation.VolleyCallback {

    protected Context context;


    private String TOKEN;

    public RequestMaker(Context context, String token){
        this.context = context;
        this.TOKEN = token;

    }
    @Override
    public void onSuccess(String response) {
        
    }
    protected void sendRequest(String url) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                           onSuccess(response);
                        } catch (Exception e) {
                            Log.d("JSON", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String>  params = new HashMap<>();
                params.put("Authorization", "Bearer " + TOKEN);
                params.put("Client-ID", context.getString(R.string.client_id));
                return params;
            }
        };
        queue.add(stringRequest);
    }
}
