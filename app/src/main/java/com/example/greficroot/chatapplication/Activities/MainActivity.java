package com.example.greficroot.chatapplication.Activities;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.greficroot.chatapplication.Activities.superclasses.BasicActivity;
import com.example.greficroot.chatapplication.NoSwipeViewPage;
import com.example.greficroot.chatapplication.R;
import com.example.greficroot.chatapplication.adapters.FragmentAdapter;
import com.example.greficroot.chatapplication.fragments.fr_followed;
import com.example.greficroot.chatapplication.fragments.fr_main;
import com.example.greficroot.chatapplication.fragments.fr_search;

import com.google.gson.Gson;
import org.json.*;
import com.example.greficroot.chatapplication.fragments.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;



public class MainActivity extends BasicActivity {
    private JSONObject userInfo;
    public JSONArray userFollows;
    private FragmentAdapter fragmentAdapter;
    private String Token;
    private NoSwipeViewPage viewPager;
    //private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Token = getIntent().getStringExtra("TOKEN");
        getUserInfo();
        viewPager = findViewById(R.id.container);
        viewPager.setSwipeAbility(true);
        setupFirstPage(viewPager);
    }

    protected void setupFirstPage(ViewPager viewPager){
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.setFirstPage(new fr_main(), "main_window0");
        viewPager.setAdapter(fragmentAdapter);
    }
    protected void setupSecondPage(ViewPager viewPager, Fragment fragment, String title){
        fragmentAdapter.setSecondPage(fragment, title);
        viewPager.setAdapter(fragmentAdapter);
    }

    public void setViewPager(int fragmentNumber){
        viewPager.setCurrentItem(fragmentNumber);
    }

    protected void getUserInfo(){
        sendRequest(getString(R.string.user_info_api), new VolleyCallback() {
            @Override
            public void onSuccess(String response) {
                try {
                    userInfo = new JSONObject(response).getJSONArray("data").getJSONObject(0);
                }catch (Exception e){ Log.d("JSON Exception", e.toString());}
            }
        });
    }
    protected void sendRequest(String url,final VolleyCallback callback) {
        RequestQueue queue = Volley.newRequestQueue(this);
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
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Authorization", "Bearer " + Token);
                params.put("Client-ID", getString(R.string.client_id));
                return params;
            }
        };
        queue.add(stringRequest);

    }

    protected String JSONExtractor(JSONObject obj, String name){
        try{
            name = obj.getString(name);
        }catch (Exception e){}
        Log.d("NAME", name);
        return name;
    }
    protected interface VolleyCallback{
        void onSuccess(String response);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id){
            case(R.id.find): setupSecondPage(viewPager, new fr_search(), "search");break;

            case(R.id.followed):
                sendRequest(getString(R.string.user_followed_api).replaceAll("USERID", JSONExtractor(userInfo, "id")), new VolleyCallback() {
                    @Override
                    public void onSuccess(String response) {
                        try{
                            JSONObject obj = new JSONObject(response);
                            userFollows = obj.getJSONArray("data");
                        }catch (Exception e){}
                    }
                });
                setupSecondPage(viewPager, new fr_followed(), "followed");
                break;
        }
        setViewPager(1);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
