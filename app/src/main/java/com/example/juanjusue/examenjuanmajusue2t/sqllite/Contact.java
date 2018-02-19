package com.example.juanjusue.examenjuanmajusue2t.sqllite;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;



import java.util.HashMap;
import java.util.Map;

/**
 * Created by JuanmaJR on 18/02/2018.
 */

@IgnoreExtraProperties
public class Contact {

    //private variables
    int _id;
    String _name;
    double lat,lon;
    // Marker perfilMarker;

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name,double lat,double lon){
        this._id = id;
        this._name = name;
        this.lat=lat;
        this.lon=lon;
    }


    // constructor
    public Contact(String name,double lat,double lon){
        this._name = name;
        this.lat=lat;
        this.lon=lon;

    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Nombre", _name);
        result.put("lat", lat);
        result.put("lon", lon);


        return result;
    }



    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number


    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {

        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }


}
