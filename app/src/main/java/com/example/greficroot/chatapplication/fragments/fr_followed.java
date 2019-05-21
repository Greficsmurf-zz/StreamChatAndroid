package com.example.greficroot.chatapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greficroot.chatapplication.Activities.MainActivity;
import com.example.greficroot.chatapplication.R;
import com.example.greficroot.chatapplication.adapters.RecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONObject;



public class fr_followed extends Fragment {

    private View view;
    private RecyclerAdapter rAdapter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fr_followed, container, false);
            recycler = view.findViewById(R.id.myRecycler);
            layoutManager = new LinearLayoutManager(view.getContext());
            recycler.setLayoutManager(layoutManager);
            rAdapter = new RecyclerAdapter(((MainActivity)getActivity()).userFollows);
            recycler.setAdapter(rAdapter);
            Log.d("USERFILLWO", "");

            return view;
    }



}
