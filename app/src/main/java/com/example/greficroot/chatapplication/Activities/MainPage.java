package com.example.greficroot.chatapplication.Activities;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.greficroot.chatapplication.R;

import org.json.*;




public class MainPage extends AppCompatActivity {
    private String Token;
    private ListView DrawerList;
    private ArrayAdapter<String> DrawerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        //ImageView image = findViewById(R.id.imageView);
        //image.setImageBitmap(bitmap.decodeSampledBitmapFromResource(getResources(), R.drawable.nature_photo,300, 100));

        Token = getIntent().getStringExtra("TOKEN");
        Log.d("TOKEN", Token);


    }
    protected void setDrawerAdapter(){
        //DrawerList = findViewById(R.id.navList);
        String[] array = {"first", "second", "third", "forth", "fifth"};
        DrawerAdapter = new ArrayAdapter<String>(this, R.layout.textview, array);
        DrawerList.setAdapter(DrawerAdapter);
    }

    protected void sendRequest(String url,final VolleyCallback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            callback.onSuccess(response);
                        } catch (Exception e) {
                            Log.d("JSON", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }
    protected interface VolleyCallback{
        void onSuccess(String response);
    }

}

