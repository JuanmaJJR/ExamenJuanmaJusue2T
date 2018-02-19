package com.example.juanjusue.examenjuanmajusue2t.DataHolder;

import com.example.juanjusue.examenjuanmajusue2t.FireBase.FireBaseAdmin;

import org.json.JSONObject;

import com.example.juanjusue.examenjuanmajusue2t.FireBase.FireBaseAdmin;

/**
 * Created by juan.jusue on 19/02/2018.
 */


public class DataHolder {


    public static  DataHolder instance = new DataHolder();
    public static JSONObject jsonObjectTwitter;
    public FireBaseAdmin fireBaseAdmin;
    public DataHolder(){
        fireBaseAdmin = new FireBaseAdmin();
    }
}
