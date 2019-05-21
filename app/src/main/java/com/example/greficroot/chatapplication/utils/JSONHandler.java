package com.example.greficroot.chatapplication.utils;

import org.json.JSONObject;

public class JSONHandler  {
    private JSONObject obj;
    public JSONHandler(JSONObject object){
        this.obj = object;
    }

    protected String JSONExtractor(JSONObject obj, String name){
        try{
            name = obj.getString(name);
        }catch (Exception e){}
        return name;
    }
}
