package com.example.greficroot.chatapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.greficroot.chatapplication.R;

import org.json.JSONArray;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {
    private JSONArray data;

    public static class myViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public myViewHolder(TextView view) {
            super(view);
            textView = view;
        }
    }
    public RecyclerAdapter(JSONArray data){
        this.data = data;
    }
    @NonNull
    @Override
    public RecyclerAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("ViewHolder", "Is created");
        TextView v = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.textview, viewGroup, false);
        myViewHolder holder = new myViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder viewHolder, int i) {

            viewHolder.textView.setText(JSONWrapper(i, "string"));

    }
    public String JSONWrapper(int i, String name){
        try {
            name = data.getJSONObject(i).getString("to_name");
            Log.d("JSONWRAPPER", name);
        }catch (Exception e){}
        return name;

    }

    @Override
    public int getItemCount() {
        return 51;
    }
}
